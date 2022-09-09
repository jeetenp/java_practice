package org.learning.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.learning.AbstractParentTest;

import java.util.List;

public class CountingSortTest extends AbstractParentTest {

    CountingSort object = new CountingSort();

    @ParameterizedTest
    @CsvFileSource(resources = "/org/learning/hackerrank/CountingSort.csv",
            numLinesToSkip = 1,
            delimiter = delimiter)
    public void test(String input, String expected){
        List<Integer> lstInput = getListOfIntegers(input);
        List<Integer> lstExpected = getListOfIntegers(expected);

        List<Integer> result = object.countingSort(lstInput);

        Assertions.assertTrue(lstExpected.size() == result.size());
        for (int i = 0; i < lstExpected.size(); i++) {
            Assertions.assertTrue(lstExpected.get(i) == result.get(i));
        }
    }

}
