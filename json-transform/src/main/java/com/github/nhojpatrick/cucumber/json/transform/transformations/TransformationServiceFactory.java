package com.github.nhojpatrick.cucumber.json.transform.transformations;

import com.github.nhojpatrick.cucumber.json.core.transform.TransformationService;
import org.apache.commons.lang3.text.WordUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.Objects.isNull;

public class TransformationServiceFactory {

    private static final TransformationServiceFactory FACTORY = new TransformationServiceFactory();

    public static TransformationServiceFactory getFactory() {
        return FACTORY;
    }

    private final Map<String, TransformationService> transformations;

    TransformationServiceFactory() {

        final ServiceLoader<TransformationService> transformationServices =
                ServiceLoader.load(TransformationService.class);
        // Java9+ START
        // Java9+ REPLACEMENT this.transformations = transformationServices.stream()
        final Iterator<TransformationService> transformationServiceIterator = transformationServices.iterator();
        final Iterable<TransformationService> transformationServiceIterable = () -> transformationServiceIterator;
        final Stream<TransformationService> transformationServiceStream =
                StreamSupport.stream(transformationServiceIterable.spliterator(), false);
        this.transformations = transformationServiceStream
                // Java9+ END
                .collect(Collectors.toMap(p -> WordUtils.capitalizeFully(p.getAction())
                                .replaceAll(" ", "_"),
                        p -> p));
    }

    public Optional<TransformationService> resolve(String action) {

        if (isNull(action)) {
            return Optional.empty();
        }

        action = WordUtils.capitalizeFully(action)
                .replaceAll(" ", "_");

        return Optional.ofNullable(this.transformations.get(action));
    }

}
