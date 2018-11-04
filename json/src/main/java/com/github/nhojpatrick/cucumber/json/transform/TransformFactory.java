package com.github.nhojpatrick.cucumber.json.transform;

import java.util.function.Supplier;

public class TransformFactory
        implements Supplier<Transform> {

    public static Transform getInstance() {
        final TransformFactory factory = new TransformFactory();
        final Transform transform = factory.get();
        return transform;
    }

    public TransformFactory() {
    }

    public Transform get() {
        final Transform transform = new TransformImpl();
        return transform;
    }

}
