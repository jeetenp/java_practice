package org.learning.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.learning.AbstractParentTest;

import java.util.List;

public class DiagonalDifferenceTest extends AbstractParentTest {

    DiagonalDifference object = new DiagonalDifference();

    @ParameterizedTest
    @CsvFileSource(resources = "/org/learning/hackerrank/DiagonalDifference.csv",
            numLinesToSkip = 1,
            delimiter = delimiter)
    public void test(String input, int expected){
        List<List<Integer>> arr = getMatrixOfIntegers(input);
        long result = object.diagonalDifference(arr);
        Assertions.assertTrue(result == expected);
    }

}
