package org.learning.programs.twosum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.learning.AbstractParentTest;
import org.learning.hackerrank.CountingSort;
import org.learning.programs.TwoSum;

import java.util.List;

public class TwoSumTest extends AbstractParentTest {

    TwoSum object = new TwoSum();

    @ParameterizedTest
    @CsvFileSource(resources = "/org/learning/programs/twosum/twosum.csv",
            numLinesToSkip = 1,
            delimiter = delimiter)
    public void test(String input, String target, String expected){
        int[] lstInput = getArrayOfIntegers(input);
        Integer targetValue = Integer.parseInt(target);
        int[] lstExpected = getArrayOfIntegers(expected);

        int[] result = object.solution(lstInput, targetValue);

        if(lstExpected == null){
            Assertions.assertTrue(result == null);
        }else{
            Assertions.assertTrue(lstExpected.length == result.length);
            for (int i = 0; i < lstExpected.length; i++) {
                Assertions.assertTrue(lstExpected[i] == result[i]);
            }
        }

    }

}
