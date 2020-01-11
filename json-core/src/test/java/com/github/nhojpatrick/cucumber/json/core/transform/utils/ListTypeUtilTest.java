package com.github.nhojpatrick.cucumber.json.core.transform.utils;

import com.github.nhojpatrick.cucumber.core.exceptions.NullGenericsValueException;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

import static com.github.nhojpatrick.cucumber.json.core.transform.utils.ListTypeUtil.isTypedList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class ListTypeUtilTest {

    @Test
    public void checkIs_StaticUtilityClass() {
        final Executable testMethod = () -> {
            new ListTypeUtil();
        };
        final AssertionError thrown = assertThrows(AssertionError.class, testMethod);
        assertAll(
                () -> assertThat(thrown.getMessage(), is(equalTo("Static utility class - cannot be instantiated."))),
                () -> assertThat(thrown.getCause(), is(nullValue()))
        );
    }

    @TestFactory
    public Collection<DynamicTest> exceptions() {

        return Arrays.asList(

                dynamicTest("List -> <null>", () -> {
                    final Executable testMethod = () -> isTypedList(new ArrayList(), null);
                    final NullGenericsValueException thrown = assertThrows(NullGenericsValueException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Null Generics Value Type.")));
                }),

                dynamicTest("Object -> <null>", () -> {
                    final Executable testMethod = () -> isTypedList(new Object(), null);
                    final NullGenericsValueException thrown = assertThrows(NullGenericsValueException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Null Generics Value Type.")));
                })

        );
    }

    @TestFactory
    public Collection<DynamicTest> isTypedList_Object() {

        return Arrays.asList(

                dynamicTest("Null Integer -> <Object>", () -> {
                    final Integer obj = null;
                    final boolean actual = isTypedList(obj, Object.class);
                    assertThat(actual, is(equalTo(false)));
                }),

                dynamicTest("Null Object -> <Object>", () -> {
                    final Object obj = null;
                    final boolean actual = isTypedList(obj, Object.class);
                    assertThat(actual, is(equalTo(false)));
                }),

                dynamicTest("Null String -> <Object>", () -> {
                    final String obj = null;
                    final boolean actual = isTypedList(obj, Object.class);
                    assertThat(actual, is(equalTo(false)));
                }),

                dynamicTest("Default Integer -> <Object>", () -> {
                    final Integer obj = 1234;
                    final boolean actual = isTypedList(obj, Object.class);
                    assertThat(actual, is(equalTo(false)));
                }),

                dynamicTest("Default Object -> <Object>", () -> {
                    final Object obj = new Object();
                    final boolean actual = isTypedList(obj, Object.class);
                    assertThat(actual, is(equalTo(false)));
                }),

                dynamicTest("Default String -> <Object>", () -> {
                    final String obj = "qwertyuiop";
                    final boolean actual = isTypedList(obj, Object.class);
                    assertThat(actual, is(equalTo(false)));
                }),

                dynamicTest("List ArrayList<> -> <Object>", () -> {
                    final Object obj = new ArrayList<>();
                    final boolean actual = isTypedList(obj, Object.class);
                    assertThat(actual, is(equalTo(true)));
                }),

                dynamicTest("List Stack<> -> <Object>", () -> {
                    final Object obj = new Stack<>();
                    final boolean actual = isTypedList(obj, Object.class);
                    assertThat(actual, is(equalTo(true)));
                })

        );
    }

    @TestFactory
    public Collection<DynamicTest> isTypedList_Map() {

        return Arrays.asList(

                dynamicTest("List Null -> <Object>", () -> {

                    final List list = null;

                    final boolean actual = isTypedList(list, Object.class);

                    assertThat(actual, is(equalTo(false)));
                }),

                dynamicTest("List Empty -> <Object>", () -> {

                    final List list = new ArrayList<>();

                    final boolean actual = isTypedList(list, Object.class);

                    assertThat(actual, is(equalTo(true)));
                }),

                dynamicTest("List Integers -> <Integer>", () -> {

                    final List list = new ArrayList<>();
                    list.add(1);
                    list.add(2);

                    final boolean actual = isTypedList(list, Integer.class);

                    assertThat(actual, is(equalTo(true)));
                }),

                dynamicTest("List Integers -> <Object>", () -> {

                    final List list = new ArrayList<>();
                    list.add(1);
                    list.add(2);

                    final boolean actual = isTypedList(list, Object.class);

                    assertThat(actual, is(equalTo(true)));
                }),

                dynamicTest("List Integers -> <String>", () -> {

                    final List list = new ArrayList<>();
                    list.add(1);
                    list.add(2);

                    final boolean actual = isTypedList(list, String.class);

                    assertThat(actual, is(equalTo(false)));
                }),

                dynamicTest("List Mixed -> <Integer>", () -> {

                    final List list = new ArrayList<>();
                    list.add(1);
                    list.add("value2");

                    final boolean actual = isTypedList(list, Integer.class);

                    assertThat(actual, is(equalTo(false)));
                }),

                dynamicTest("List Mixed -> <Object>", () -> {

                    final List list = new ArrayList<>();
                    list.add(1);
                    list.add("value2");

                    final boolean actual = isTypedList(list, Object.class);

                    assertThat(actual, is(equalTo(true)));
                }),

                dynamicTest("List Mixed -> <String>", () -> {

                    final List list = new ArrayList<>();
                    list.add(1);
                    list.add("value2");

                    final boolean actual = isTypedList(list, String.class);

                    assertThat(actual, is(equalTo(false)));
                }),

                dynamicTest("List Strings -> <Integer>", () -> {

                    final List list = new ArrayList<>();
                    list.add("value1");
                    list.add("value2");

                    final boolean actual = isTypedList(list, Integer.class);

                    assertThat(actual, is(equalTo(false)));
                }),

                dynamicTest("List Strings -> <Object>", () -> {

                    final List list = new ArrayList<>();
                    list.add("value1");
                    list.add("value2");

                    final boolean actual = isTypedList(list, Object.class);

                    assertThat(actual, is(equalTo(true)));
                }),

                dynamicTest("List Strings -> <String>", () -> {

                    final List list = new ArrayList<>();
                    list.add("value1");
                    list.add("value2");

                    final boolean actual = isTypedList(list, String.class);

                    assertThat(actual, is(equalTo(true)));
                })

        );
    }

}
