package com.github.nhojpatrick.cucumber.json.map.impl;

import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.github.nhojpatrick.cucumber.core.exceptions.NullObjectException;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.github.nhojpatrick.hamcrest.lang.IsThrowable.throwable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConvertMapToJsonTest {

    public static Map<String, Object> shuffle(final Map<String, Object> input) {

        final List<String> inputKeys = new ArrayList<>(input.keySet());
        Collections.shuffle(inputKeys);

        final Map<String, Object> output = new LinkedHashMap<>();
        inputKeys.forEach(p -> output.put(p, input.get(p)));
        return output;
    }

    private static class ClassThatJacksonCannotSerialize {

        private final ClassThatJacksonCannotSerialize self = this;

        @Override
        public String toString() {
            return self.getClass().getName();
        }

    }

    @TestFactory
    public Collection<DynamicTest> exceptions() {

        return Arrays.asList(

                DynamicTest.dynamicTest("JsonProcessingException", () -> {
                    final Map<String, Object> input = new HashMap<>();
                    input.put("issue", new ClassThatJacksonCannotSerialize());
                    final Executable testMethod = () -> new ConvertMapToJson()
                            .apply(input);
                    final RuntimeException thrown = assertThrows(RuntimeException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer found for class com.github.nhojpatrick.cucumber.json.map.impl.ConvertMapToJsonTest$ClassThatJacksonCannotSerialize and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS) (through reference chain: java.util.TreeMap[\"issue\"])"))),
                            () -> assertThat(thrown.getCause(), is(throwable(InvalidDefinitionException.class, "No serializer found for class com.github.nhojpatrick.cucumber.json.map.impl.ConvertMapToJsonTest$ClassThatJacksonCannotSerialize and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS) (through reference chain: java.util.TreeMap[\"issue\"])")))
                    );
                }),

                DynamicTest.dynamicTest("Null Input", () -> {
                    final Executable testMethod = () -> new ConvertMapToJson()
                            .apply(null);
                    final RuntimeException thrown = assertThrows(RuntimeException.class, testMethod);
                    assertAll("Checking Exception",
                            () -> assertThat(thrown.getMessage(), is(equalTo("com.github.nhojpatrick.cucumber.core.exceptions.NullObjectException: Null object."))),
                            () -> assertThat(thrown.getCause(), is(throwable(NullObjectException.class, "Null object.")))
                    );
                })
        );
    }

}
