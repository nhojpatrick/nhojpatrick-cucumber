package com.github.nhojpatrick.cucumber.json.core.transform.utils;

import com.github.nhojpatrick.cucumber.core.exceptions.NullGenericsValueException;
import org.junit.jupiter.api.DynamicTest;
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
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListTypeUtilTest {

    @TestFactory
    public Collection<DynamicTest> exceptions() {

        return Arrays.asList(

                DynamicTest.dynamicTest("List -> <null>", () -> {
                    final Executable testMethod = () -> isTypedList(new ArrayList(), null);
                    final NullGenericsValueException expectedThrown = assertThrows(NullGenericsValueException.class, testMethod);
                    assertThat(expectedThrown.getMessage(), is(equalTo("Null Generics Value Type.")));
                }),

                DynamicTest.dynamicTest("Object -> <null>", () -> {
                    final Executable testMethod = () -> isTypedList(new Object(), null);
                    final NullGenericsValueException expectedThrown = assertThrows(NullGenericsValueException.class, testMethod);
                    assertThat(expectedThrown.getMessage(), is(equalTo("Null Generics Value Type.")));
                })

        );
    }

    @TestFactory
    public Collection<DynamicTest> isTypedList_Object() {

        return Arrays.asList(

                DynamicTest.dynamicTest("Null Integer -> <Object>", () -> {
                    final Integer obj = null;
                    final boolean actual = isTypedList(obj, Object.class);
                    assertThat(actual, is(equalTo(false)));
                }),

                DynamicTest.dynamicTest("Null Object -> <Object>", () -> {
                    final Object obj = null;
                    final boolean actual = isTypedList(obj, Object.class);
                    assertThat(actual, is(equalTo(false)));
                }),

                DynamicTest.dynamicTest("Null String -> <Object>", () -> {
                    final String obj = null;
                    final boolean actual = isTypedList(obj, Object.class);
                    assertThat(actual, is(equalTo(false)));
                }),

                DynamicTest.dynamicTest("Default Integer -> <Object>", () -> {
                    final Integer obj = 1234;
                    final boolean actual = isTypedList(obj, Object.class);
                    assertThat(actual, is(equalTo(false)));
                }),

                DynamicTest.dynamicTest("Default Object -> <Object>", () -> {
                    final Object obj = new Object();
                    final boolean actual = isTypedList(obj, Object.class);
                    assertThat(actual, is(equalTo(false)));
                }),

                DynamicTest.dynamicTest("Default String -> <Object>", () -> {
                    final String obj = "qwertyuiop";
                    final boolean actual = isTypedList(obj, Object.class);
                    assertThat(actual, is(equalTo(false)));
                }),

                DynamicTest.dynamicTest("List ArrayList<> -> <Object>", () -> {
                    final Object obj = new ArrayList<>();
                    final boolean actual = isTypedList(obj, Object.class);
                    assertThat(actual, is(equalTo(true)));
                }),

                DynamicTest.dynamicTest("List Stack<> -> <Object>", () -> {
                    final Object obj = new Stack<>();
                    final boolean actual = isTypedList(obj, Object.class);
                    assertThat(actual, is(equalTo(true)));
                })

        );
    }

    @TestFactory
    public Collection<DynamicTest> isTypedList_Map() {

        return Arrays.asList(

                DynamicTest.dynamicTest("List Null -> <Object>", () -> {

                    final List list = null;

                    final boolean actual = isTypedList(list, Object.class);

                    assertThat(actual, is(equalTo(false)));
                }),

                DynamicTest.dynamicTest("List Empty -> <Object>", () -> {

                    final List list = new ArrayList<>();

                    final boolean actual = isTypedList(list, Object.class);

                    assertThat(actual, is(equalTo(true)));
                }),

                DynamicTest.dynamicTest("List Integers -> <Integer>", () -> {

                    final List list = new ArrayList<>();
                    list.add(1);
                    list.add(2);

                    final boolean actual = isTypedList(list, Integer.class);

                    assertThat(actual, is(equalTo(true)));
                }),

                DynamicTest.dynamicTest("List Integers -> <Object>", () -> {

                    final List list = new ArrayList<>();
                    list.add(1);
                    list.add(2);

                    final boolean actual = isTypedList(list, Object.class);

                    assertThat(actual, is(equalTo(true)));
                }),

                DynamicTest.dynamicTest("List Integers -> <String>", () -> {

                    final List list = new ArrayList<>();
                    list.add(1);
                    list.add(2);

                    final boolean actual = isTypedList(list, String.class);

                    assertThat(actual, is(equalTo(false)));
                }),

                DynamicTest.dynamicTest("List Mixed -> <Integer>", () -> {

                    final List list = new ArrayList<>();
                    list.add(1);
                    list.add("value2");

                    final boolean actual = isTypedList(list, Integer.class);

                    assertThat(actual, is(equalTo(false)));
                }),

                DynamicTest.dynamicTest("List Mixed -> <Object>", () -> {

                    final List list = new ArrayList<>();
                    list.add(1);
                    list.add("value2");

                    final boolean actual = isTypedList(list, Object.class);

                    assertThat(actual, is(equalTo(true)));
                }),

                DynamicTest.dynamicTest("List Mixed -> <String>", () -> {

                    final List list = new ArrayList<>();
                    list.add(1);
                    list.add("value2");

                    final boolean actual = isTypedList(list, String.class);

                    assertThat(actual, is(equalTo(false)));
                }),

                DynamicTest.dynamicTest("List Strings -> <Integer>", () -> {

                    final List list = new ArrayList<>();
                    list.add("value1");
                    list.add("value2");

                    final boolean actual = isTypedList(list, Integer.class);

                    assertThat(actual, is(equalTo(false)));
                }),

                DynamicTest.dynamicTest("List Strings -> <Object>", () -> {

                    final List list = new ArrayList<>();
                    list.add("value1");
                    list.add("value2");

                    final boolean actual = isTypedList(list, Object.class);

                    assertThat(actual, is(equalTo(true)));
                }),

                DynamicTest.dynamicTest("List Strings -> <String>", () -> {

                    final List list = new ArrayList<>();
                    list.add("value1");
                    list.add("value2");

                    final boolean actual = isTypedList(list, String.class);

                    assertThat(actual, is(equalTo(true)));
                })

        );
    }

}
