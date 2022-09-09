package org.learning.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.learning.AbstractParentTest;

public class FlippingBitsTest extends AbstractParentTest {

    FlippingBits object = new FlippingBits();

    @ParameterizedTest
    @CsvFileSource(resources = "/org/learning/hackerrank/FlippingBits.csv",
            numLinesToSkip = 1,
            delimiter = delimiter)
    public void test(long input, long expected){
        long result = object.flippingBits(input);
        Assertions.assertTrue(result == expected);
    }

}
