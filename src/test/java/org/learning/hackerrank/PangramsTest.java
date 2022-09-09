package org.learning.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.learning.AbstractParentTest;

public class PangramsTest extends AbstractParentTest {

    Pangrams object = new Pangrams();

    @ParameterizedTest
    @CsvFileSource(resources = "/org/learning/hackerrank/Pangrams.csv",
            numLinesToSkip = 1,
            delimiter = delimiter)
    public void test(String input, String expected){
        String result = object.pangrams(input);
        Assertions.assertTrue(expected.equalsIgnoreCase(result));
    }

}
