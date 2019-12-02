package com.github.nhojpatrick.cucumber.json.steps.transform.transformations;

import com.github.nhojpatrick.cucumber.json.core.transform.TransformationService;

import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class TransformationServiceFactory {


    public static TransformationServiceFactory getInstance() {

        return new TransformationServiceFactory();
    }

    private final Map<String, TransformationService> transformations;

    public TransformationServiceFactory() {

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
                .collect(Collectors.toMap(p -> p.getAction(), p -> p));
    }

    public Optional<TransformationService> resolve(final String action) {

        return Optional.ofNullable(this.transformations.get(action));
    }

}
