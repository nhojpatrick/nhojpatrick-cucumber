package com.github.nhojpatrick.cucumber.json.core.validation.impl;

import com.github.nhojpatrick.cucumber.json.core.exceptions.InvalidPathException;
import com.github.nhojpatrick.cucumber.json.core.validation.PathElement;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PathValidatorImplTest {

    private static List<PathElement> setupExpected(final String... elements) {

        final List<PathElement> expected = new ArrayList<>();

        for (final String elementRaw : elements) {
            final Pattern pattern = Pattern.compile("(.*)\\[(\\d+)\\]");
            final Matcher matcher = pattern.matcher(elementRaw);
            if (matcher.find()) {
                final String element = matcher.group(1);
                final int arrayIndex = Integer.parseInt(matcher.group(2));
                final PathElement pathElement = new PathArrayElementImpl(elementRaw, element, arrayIndex);
                expected.add(pathElement);

            } else {
                final PathElement pathElement = new PathAttributeElementImpl(elementRaw);
                expected.add(pathElement);
            }
        }

        return expected;
    }

    @TestFactory
    public Collection<DynamicTest> invalidPaths() {

        final PathValidatorImpl classUnderTest = new PathValidatorImpl();

        return Arrays.asList(

                DynamicTest.dynamicTest("path - Null", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath(null);
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path is Null.")));
                }),

                DynamicTest.dynamicTest("path - Empty String", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path is Empty.")));
                }),

                DynamicTest.dynamicTest("path - Whitespace String", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("          ");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path is Whitespace only '          '.")));
                }),

                DynamicTest.dynamicTest("path - Whitespace Leading", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("          path");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path has Leading or Trailing Whitespace '          path'.")));
                }),

                DynamicTest.dynamicTest("path - Whitespace Leading and Trailing", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("          path          ");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path has Leading or Trailing Whitespace '          path          '.")));
                }),

                DynamicTest.dynamicTest("path - Whitespace Trailing", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("path          ");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path has Leading or Trailing Whitespace 'path          '.")));
                }),

                DynamicTest.dynamicTest("path - Whitespace Within", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("start end");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path contains Whitespace 'start end'.")));
                }),

                DynamicTest.dynamicTest("path - Dot Leading", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath(".path");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path has Leading or Trailing Dot '.path'.")));
                }),

                DynamicTest.dynamicTest("path - Dot Leading and Trailing", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath(".path.");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path has Leading or Trailing Dot '.path.'.")));
                }),

                DynamicTest.dynamicTest("path - Dot Trailing", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("path.");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path has Leading or Trailing Dot 'path.'.")));
                }),

                DynamicTest.dynamicTest("path - Double Dots", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("start..end");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path has Sequential Dots 'start..end'.")));
                }),

                DynamicTest.dynamicTest("path - Triple Dots", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("start...end");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path has Sequential Dots 'start...end'.")));
                }),

                DynamicTest.dynamicTest("path - Triple Dots1", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("start...end");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path has Sequential Dots 'start...end'.")));
                })

        );
    }

    @TestFactory
    public Collection<DynamicTest> invalidSplits() {

        final PathValidatorImpl classUnderTest = new PathValidatorImpl();

        return Arrays.asList(

                DynamicTest.dynamicTest("split - [ Missing (path))", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("]");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path ']' Split has missing [ ']'.")));
                }),

                DynamicTest.dynamicTest("split - [ Missing (path.split))", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("abc.]");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path 'abc.]' Split has missing [ ']'.")));
                }),

                DynamicTest.dynamicTest("split - ] Missing (path))", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("[");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path '[' Split has missing ] '['.")));
                }),

                DynamicTest.dynamicTest("split - ] Missing (path.split))", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("abc.[");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path 'abc.[' Split has missing ] '['.")));
                }),

                DynamicTest.dynamicTest("split - [ Leading (path))", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("[]");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path '[]' Split has Leading [ '[]'.")));
                }),

                DynamicTest.dynamicTest("split - [ Leading (path.split)", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("abc.[]");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path 'abc.[]' Split has Leading [ '[]'.")));
                }),

                DynamicTest.dynamicTest("split - ] Missing Trailing (path)", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("abc[]d");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path 'abc[]d' Split missing Trailing ] 'abc[]d'.")));
                }),

                DynamicTest.dynamicTest("split - ] Missing Trailing (path.split)", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("abc.def[]g");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path 'abc.def[]g' Split missing Trailing ] 'def[]g'.")));
                }),

                DynamicTest.dynamicTest("split - [ Double (path)", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("a[b[]");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path 'a[b[]' Split has multiple [ 'a[b[]'.")));
                }),

                DynamicTest.dynamicTest("split - [ Double (path.split)", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("abc.d[e[]");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path 'abc.d[e[]' Split has multiple [ 'd[e[]'.")));
                }),

                DynamicTest.dynamicTest("split - [ Double sequential (path)", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("a[[]");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path 'a[[]' Split has multiple [ 'a[[]'.")));
                }),

                DynamicTest.dynamicTest("split - [ Double sequential (path.split)", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("abc.d[[]");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path 'abc.d[[]' Split has multiple [ 'd[[]'.")));
                }),

                DynamicTest.dynamicTest("split - [ Triple (path)", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("a[b[c[]");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path 'a[b[c[]' Split has multiple [ 'a[b[c[]'.")));
                }),

                DynamicTest.dynamicTest("split - [ Triple (path.split)", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("abc.d[e[f[]");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path 'abc.d[e[f[]' Split has multiple [ 'd[e[f[]'.")));
                }),

                DynamicTest.dynamicTest("split - [ Triple sequential (path)", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("a[[[]");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path 'a[[[]' Split has multiple [ 'a[[[]'.")));
                }),

                DynamicTest.dynamicTest("split - [ Triple sequential (path.split)", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("abc.d[[[]");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path 'abc.d[[[]' Split has multiple [ 'd[[[]'.")));
                }),

                DynamicTest.dynamicTest("split - ] Double (path)", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("a[]b]");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path 'a[]b]' Split has multiple ] 'a[]b]'.")));
                }),

                DynamicTest.dynamicTest("split - ] Double (path.split)", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("abc.d[]e]");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path 'abc.d[]e]' Split has multiple ] 'd[]e]'.")));
                }),

                DynamicTest.dynamicTest("split - ] Double sequential (path)", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("a[]]");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path 'a[]]' Split has multiple ] 'a[]]'.")));
                }),

                DynamicTest.dynamicTest("split - ] Double sequential (path.split)", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("abc.d[]]");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path 'abc.d[]]' Split has multiple ] 'd[]]'.")));
                }),

                DynamicTest.dynamicTest("split - ] Triple (path)", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("a[]b]c]");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path 'a[]b]c]' Split has multiple ] 'a[]b]c]'.")));
                }),

                DynamicTest.dynamicTest("split - ] Triple (path.split)", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("abc.d[]e]f]");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path 'abc.d[]e]f]' Split has multiple ] 'd[]e]f]'.")));
                }),

                DynamicTest.dynamicTest("split - ] Triple sequential (path)", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("a[]]]");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path 'a[]]]' Split has multiple ] 'a[]]]'.")));
                }),

                DynamicTest.dynamicTest("split - ] Triple sequential (path.split)", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("abc.d[]]]");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path 'abc.d[]]]' Split has multiple ] 'd[]]]'.")));
                }),

                DynamicTest.dynamicTest("split - [] Empty (path)", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("a[]");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path 'a[]' Split has invalid index [] 'a[]'.")));
                }),

                DynamicTest.dynamicTest("split - [] Empty (path.split)", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("abc.d[]");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path 'abc.d[]' Split has invalid index [] 'd[]'.")));
                }),

                DynamicTest.dynamicTest("split - [] Alpha (path)", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("a[bc]");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path 'a[bc]' Split has invalid index [] 'a[bc]'.")));
                }),

                DynamicTest.dynamicTest("split - [] Alpha (path.split)", () -> {
                    final Executable testMethod = () -> classUnderTest.parsePath("abc.d[ef]");
                    final InvalidPathException thrown = assertThrows(InvalidPathException.class, testMethod);
                    assertThat(thrown.getMessage(), is(equalTo("Path 'abc.d[ef]' Split has invalid index [] 'd[ef]'.")));
                })

        );
    }

    @TestFactory
    public Collection<DynamicTest> valid() {

        final PathValidatorImpl classUnderTest = new PathValidatorImpl();

        return Arrays.asList(

                DynamicTest.dynamicTest("path - abc", () -> {
                    final List<PathElement> expected = setupExpected("abc");
                    final List<PathElement> actual = classUnderTest.parsePath("abc");
                    assertThat(actual, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest("path - abc.def", () -> {
                    final List<PathElement> expected = setupExpected("abc", "def");
                    final List<PathElement> actual = classUnderTest.parsePath("abc.def");
                    assertThat(actual, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest("path - abc.def.ghi", () -> {
                    final List<PathElement> expected = setupExpected("abc", "def", "ghi");
                    final List<PathElement> actual = classUnderTest.parsePath("abc.def.ghi");
                    assertThat(actual, is(equalTo(expected)));
                })

        );
    }

    @TestFactory
    public Collection<DynamicTest> validArrays() {

        final PathValidatorImpl classUnderTest = new PathValidatorImpl();

        return Arrays.asList(

                DynamicTest.dynamicTest("path - abc[0]", () -> {
                    final List<PathElement> expected = setupExpected("abc[0]");
                    final List<PathElement> actual = classUnderTest.parsePath("abc[0]");
                    assertThat(actual, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest("path - abc.def[1]", () -> {
                    final List<PathElement> expected = setupExpected("abc", "def[1]");
                    final List<PathElement> actual = classUnderTest.parsePath("abc.def[1]");
                    assertThat(actual, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest("path - abc[2].def", () -> {
                    final List<PathElement> expected = setupExpected("abc[2]", "def");
                    final List<PathElement> actual = classUnderTest.parsePath("abc[2].def");
                    assertThat(actual, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest("path - abc[3].def[4]", () -> {
                    final List<PathElement> expected = setupExpected("abc[3]", "def[4]");
                    final List<PathElement> actual = classUnderTest.parsePath("abc[3].def[4]");
                    assertThat(actual, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest("path - abc.def.ghi[5]", () -> {
                    final List<PathElement> expected = setupExpected("abc", "def", "ghi[5]");
                    final List<PathElement> actual = classUnderTest.parsePath("abc.def.ghi[5]");
                    assertThat(actual, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest("path - abc.def[6].ghi", () -> {
                    final List<PathElement> expected = setupExpected("abc", "def[6]", "ghi");
                    final List<PathElement> actual = classUnderTest.parsePath("abc.def[6].ghi");
                    assertThat(actual, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest("path - abc.def[7].ghi[8]", () -> {
                    final List<PathElement> expected = setupExpected("abc", "def[7]", "ghi[8]");
                    final List<PathElement> actual = classUnderTest.parsePath("abc.def[7].ghi[8]");
                    assertThat(actual, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest("path - abc[9].def.ghi", () -> {
                    final List<PathElement> expected = setupExpected("abc[9]", "def", "ghi");
                    final List<PathElement> actual = classUnderTest.parsePath("abc[9].def.ghi");
                    assertThat(actual, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest("path - abc[10].def.ghi[11]", () -> {
                    final List<PathElement> expected = setupExpected("abc[10]", "def", "ghi[11]");
                    final List<PathElement> actual = classUnderTest.parsePath("abc[10].def.ghi[11]");
                    assertThat(actual, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest("path - abc[12].def[13].ghi", () -> {
                    final List<PathElement> expected = setupExpected("abc[12]", "def[13]", "ghi");
                    final List<PathElement> actual = classUnderTest.parsePath("abc[12].def[13].ghi");
                    assertThat(actual, is(equalTo(expected)));
                }),

                DynamicTest.dynamicTest("path - abc[14].def[15].ghi[16]", () -> {
                    final List<PathElement> expected = setupExpected("abc[14]", "def[15]", "ghi[16]");
                    final List<PathElement> actual = classUnderTest.parsePath("abc[14].def[15].ghi[16]");
                    assertThat(actual, is(equalTo(expected)));
                })

        );
    }

}
