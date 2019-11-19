package com.github.nhojpatrick.cucumber.json.core.validation.impl;

import com.github.nhojpatrick.cucumber.json.core.exceptions.InvalidPathException;
import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;
import com.github.nhojpatrick.cucumber.json.core.validation.PathValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PathValidatorImpl
        implements PathValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(PathValidatorImpl.class);

    public PathValidatorImpl() {
    }

    @Override
    public List<PathElement> parsePath(final String path)
            throws InvalidPathException {

        LOGGER.debug("parsePath.entry path='{}'", path);

        if (Objects.isNull(path)) {
            throw new InvalidPathException("Path is Null.");
        }

        if (path.isEmpty()) {
            throw new InvalidPathException("Path is Empty.");
        }

        final String pathTrimmed = path.trim();

        if (pathTrimmed.isEmpty()) {
            throw new InvalidPathException("Path is Whitespace only '%s'.", path);
        }

        if (!pathTrimmed.equals(path)) {
            throw new InvalidPathException("Path has Leading or Trailing Whitespace '%s'.", path);
        }

        if (path.contains(" ")) {
            throw new InvalidPathException("Path contains Whitespace '%s'.", path);
        }

        if (path.startsWith(".")
                || path.endsWith(".")) {
            throw new InvalidPathException("Path has Leading or Trailing Dot '%s'.", path);
        }

        if (path.contains("..")) {
            throw new InvalidPathException("Path has Sequential Dots '%s'.", path);
        }

        final String[] splits = path.split("\\.");
        final List<PathElement> pathElements = new ArrayList<>();
        for (final String split : splits) {
            final PathElement pathElement = checkSplit(path, split);
            pathElements.add(pathElement);
        }

        LOGGER.debug("parsePath.exit splits='{}'", pathElements);

        return pathElements;
    }

    private PathElement checkSplit(final String path, final String split)
            throws InvalidPathException {

        LOGGER.debug("path='{}' split='{}'", path, split);

        if (!split.contains("[")
                && !split.contains("]")) {
            return new PathElementImpl(split);
        }

        if (!split.contains("[")) {
            throw new InvalidPathException("Path '%s' Split has missing [ '%s'.", path, split);
        }

        if (!split.contains("]")) {
            throw new InvalidPathException("Path '%s' Split has missing ] '%s'.", path, split);
        }

        if (split.startsWith("[")) {
            throw new InvalidPathException("Path '%s' Split has Leading [ '%s'.", path, split);
        }

        if (!split.endsWith("]")) {
            throw new InvalidPathException("Path '%s' Split missing Trailing ] '%s'.", path, split);
        }

        final Pattern patternBracketOpening = Pattern.compile("\\[.*\\[");
        final Matcher matcherBracketOpening = patternBracketOpening.matcher(split);
        LOGGER.debug("path='{}' split='{}' {}", path, split, patternBracketOpening);
        if (matcherBracketOpening.find()) {
            throw new InvalidPathException("Path '%s' Split has multiple [ '%s'.", path, split);
        }

        final Pattern patternBracketClosing = Pattern.compile("\\].*\\]");
        final Matcher matcherBracketClosing = patternBracketClosing.matcher(split);
        LOGGER.debug("path='{}' split='{}' {}", path, split, patternBracketClosing);
        if (matcherBracketClosing.find()) {
            throw new InvalidPathException("Path '%s' Split has multiple ] '%s'.", path, split);
        }

        final Pattern patternBracketIndex = Pattern.compile("(.*)\\[(\\d+)\\]");
        final Matcher matcherBracketIndex = patternBracketIndex.matcher(split);
        LOGGER.debug("path='{}' split='{}' {}", path, split, matcherBracketIndex);
        if (!matcherBracketIndex.find()) {
            throw new InvalidPathException("Path '%s' Split has invalid index [] '%s'.", path, split);
        }
        final String element = matcherBracketIndex.group(1);
        final int arrayIndex = Integer.parseInt(matcherBracketIndex.group(2));

        return new PathArrayElementImpl(split, element, arrayIndex);
    }

}
