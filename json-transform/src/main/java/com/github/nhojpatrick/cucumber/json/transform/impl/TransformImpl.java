package com.github.nhojpatrick.cucumber.json.transform.impl;

import com.github.nhojpatrick.cucumber.core.exceptions.IllegalKeyException;
import com.github.nhojpatrick.cucumber.core.exceptions.IllegalOperationException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.IllegalPathOperationException;
import com.github.nhojpatrick.cucumber.json.core.exceptions.InvalidPathException;
import com.github.nhojpatrick.cucumber.json.core.transform.Transform;
import com.github.nhojpatrick.cucumber.json.core.transform.Transformation;
import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;
import com.github.nhojpatrick.cucumber.json.transform.validation.PathValidatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.github.nhojpatrick.cucumber.json.core.transform.utils.ListTypeUtil.isTypedList;
import static com.github.nhojpatrick.cucumber.json.core.transform.utils.MapTypeUtil.isTypedMap;
import static java.util.Objects.isNull;

public class TransformImpl
        implements Transform {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransformImpl.class);

    public TransformImpl() {
    }

    @Override
    public Map<String, Object> transform(final String path,
                                         final Map<String, Object> input,
                                         final Transformation transformation)
            throws IllegalKeyException,
            IllegalOperationException,
            InvalidPathException {

        LOGGER.debug("Before path='{}' transformation={} input={}", path, transformation, input);

        final List<PathElement> pathElements = PathValidatorFactory.getFactory()
                .get()
                .parsePath(path);

        final Map<String, Object> output = transform(0, input, "", pathElements, transformation);

        LOGGER.debug("After path='{}' transformation={} output={}", path, transformation, output);

        return output;
    }

    private Map<String, Object> transform(final int depth,
                                          final Map<String, Object> input,
                                          final String previousPath,
                                          final List<PathElement> pathElements,
                                          final Transformation transformation)
            throws IllegalKeyException,
            IllegalOperationException {

        LOGGER.debug("Before depth={} path='{}' transformation={} input={}",
                depth,
                pathElements,
                transformation,
                input
        );

        final PathElement pathElement = pathElements.get(0);

        if (isNull(input)
                && !transformation.isParentPathAutoCreated()) {
            throw new IllegalPathOperationException("FIXME 0");
        }

        Map<String, Object> output = isNull(input)
                ? new LinkedHashMap<>()
                : input;

        if (pathElements.size() == 1) {
            LOGGER.debug("Execute Before depth={} path='{}' input={}", depth, pathElements, output);
            output = transformation.perform(pathElement, output, previousPath);
            LOGGER.debug("Execute After depth={} path='{}' output={}", depth, pathElements, output);

        } else if (pathElements.size() > 1) {

            if (output.containsKey(pathElement.getElement())
                    && isNull(output.get(pathElement.getElement()))) {

                if (pathElement.isArray()) {
                    throw new IllegalPathOperationException(String.format(
                            "AutoConvert 'null' value to array disabled, at path '%s'.",
                            pathElement.getPath(previousPath, false)
                    ));

                } else {
                    throw new IllegalPathOperationException(String.format(
                            "AutoConvert 'null' value to object disabled, at path '%s'.",
                            pathElement.getPath(previousPath)
                    ));
                }
            }

            Object innerRaw = output.get(pathElement.getElement());

            if (isNull(innerRaw)) {
                if (!transformation.isParentPathAutoCreated()) {
                    throw new IllegalPathOperationException(String.format(
                            "Path '%s' does not existing and automatic creation disabled by transformation.",
                            pathElement.getPath(previousPath, false)
                    ));
                }

                if (pathElement.isArray()) {
                    innerRaw = new ArrayList<LinkedHashMap<String, Object>>();

                } else {
                    innerRaw = new LinkedHashMap<String, Object>();
                }
            }

            final boolean isTypedMap = isTypedMap(innerRaw, String.class, Object.class);
            final boolean isTypedListMap = isTypedList(innerRaw, Map.class);
            final boolean isTypedListObject = isTypedList(innerRaw, Object.class);

            if (isTypedMap
                    && pathElement.isArray()) {
                throw new IllegalPathOperationException(String.format(
                        "Unable to convert object to array, at path '%s'.",
                        pathElement.getPath(previousPath, false)
                ));
            }

            if (isTypedListObject
                    && pathElement.isAttribute()) {
                throw new IllegalPathOperationException(String.format(
                        "Unable to convert array to object, at path '%s'.",
                        pathElement.getPath(previousPath)
                ));
            }

            if (isTypedListMap) {
                final List<Map> listMap = (List<Map>) innerRaw;

                if (listMap.isEmpty()
                        && !transformation.isParentPathAutoCreated()) {
                    throw new IllegalPathOperationException(String.format(
                            "Path '%s', as array is empty, automatic creation disabled by transformation.",
                            pathElement.getPath(previousPath, false)
                    ));

                } else if (pathElement.getArrayIndex() >= listMap.size()
                        && !transformation.isParentPathAutoCreated()) {
                    throw new IllegalPathOperationException(String.format(
                            "Path '%s', beyond index of '%s', automatic creation disabled by transformation.",
                            pathElement.getPath(previousPath, true),
                            listMap.size() - 1
                    ));
                }

                for (int i = listMap.size(); i <= pathElement.getArrayIndex(); i++) {
                    listMap.add(new LinkedHashMap<String, Object>());
                }

                final Map mapRaw = listMap.get(pathElement.getArrayIndex());
                if (isTypedMap(mapRaw, String.class, Object.class)) {
                    final Map<String, Object> map = (Map<String, Object>) mapRaw;

                    final Map<String, Object> mapUpdated = transform(depth + 1,
                            map,
                            pathElement.getPath(previousPath),
                            pathElements.subList(1, pathElements.size()),
                            transformation);

                    listMap.set(pathElement.getArrayIndex(), mapUpdated);

                    output.put(pathElement.getElement(), listMap);
                }

            } else if (isTypedListObject) {
                throw new IllegalPathOperationException(String.format(
                        "Unable to convert primative array to object array, at path '%s'.",
                        pathElement.getPath(previousPath, false)
                ));

            } else {

                if (!isTypedMap) {
                    if (pathElement.isAttribute()) {
                        throw new IllegalPathOperationException(String.format(
                                "Unable to convert primative to object, at path '%s'.",
                                pathElement.getPath(previousPath, false)
                        ));

                    } else {
                        throw new IllegalPathOperationException(String.format(
                                "Unable to convert primative to array, at path '%s'.",
                                pathElement.getPath(previousPath, false)
                        ));
                    }
                }

                final Map<String, Object> innerInput = (Map<String, Object>) innerRaw;

                final Map<String, Object> innerOutput = transform(depth + 1,
                        innerInput,
                        pathElement.getPath(previousPath),
                        pathElements.subList(1, pathElements.size()),
                        transformation
                );

                output.put(pathElement.getElement(), innerOutput);
            }
        }

        LOGGER.debug("After depth={} path='{}' transformation={} output={}",
                depth,
                pathElements,
                transformation,
                output
        );

        return output;
    }

}
