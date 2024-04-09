package com.github.nhojpatrick.cucumber.json.transform.factory;

import com.github.nhojpatrick.cucumber.json.core.transform.Transform;
import com.github.nhojpatrick.cucumber.json.transform.impl.TransformImpl;

import java.util.function.Supplier;

public class TransformFactory
        implements Supplier<Transform> {

    private static final TransformFactory FACTORY = new TransformFactory();

    public static synchronized TransformFactory getFactory() {
        return FACTORY;
    }

    private TransformFactory() {
    }

    @Override
    public Transform get() {
        return new TransformImpl();
    }

}
