package org.learning.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.learning.AbstractParentTest;

import java.util.List;

public class SubarrayDivision1Test extends AbstractParentTest {

    SubarrayDivision1 object = new SubarrayDivision1();

    @ParameterizedTest
    @CsvFileSource(resources = "/org/learning/hackerrank/SubarrayDivision1.csv", numLinesToSkip = 1,
            delimiter = delimiter)
    public void test(String inputArr, int d, int m, int expected){
        List<Integer> lstInput = getListOfIntegers(inputArr);
        int result = object.birthday(lstInput, d, m);
        Assertions.assertTrue(result == expected);
    }
}