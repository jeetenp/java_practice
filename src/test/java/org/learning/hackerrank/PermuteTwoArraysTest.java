package org.learning.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.learning.AbstractParentTest;

import java.util.List;

public class PermuteTwoArraysTest extends AbstractParentTest {

    PermutingTwoArrays object = new PermutingTwoArrays();

    @ParameterizedTest
    @CsvFileSource(resources = "/org/learning/hackerrank/PermuteTwoArrays.csv",
            numLinesToSkip = 1,
            delimiter = delimiter)
    public void test(int k, String inputArr1, String inputArr2, String expected){
        List<Integer> lstInput1 = getListOfIntegers(inputArr1);
        List<Integer> lstInput2 = getListOfIntegers(inputArr2);
        String result = object.twoArrays(k, lstInput1, lstInput2);
        Assertions.assertTrue(expected.equalsIgnoreCase(result));
    }

}
