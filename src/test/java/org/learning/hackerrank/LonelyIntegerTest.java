package org.learning.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.learning.AbstractParentTest;

import java.util.List;

public class LonelyIntegerTest extends AbstractParentTest {

    LonelyInteger object = new LonelyInteger();

    @ParameterizedTest
    @CsvFileSource(resources = "/org/learning/hackerrank/LonelyInteger.csv",
            numLinesToSkip = 1,
            delimiter = delimiter)
    public void testTimeConversion(String input, int expected){
        List<Integer> lstInput = getListOfIntegers(input);
        int integer = object.lonelyinteger(lstInput);
        Assertions.assertTrue(integer == expected);
    }

}
