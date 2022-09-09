package org.learning.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.learning.AbstractParentTest;

public class TimeConversionTest extends AbstractParentTest {

    TimeConversion timeConversion = new TimeConversion();

    @ParameterizedTest
    @CsvFileSource(resources = "/org/learning/hackerrank/TimeConversion.csv",
            numLinesToSkip = 1,
            delimiter = delimiter)
    public void testTimeConversion(String input, String expected){
        String timeIn24Format = timeConversion.timeConversion(input);
        Assertions.assertEquals(expected, timeIn24Format);
    }
}



