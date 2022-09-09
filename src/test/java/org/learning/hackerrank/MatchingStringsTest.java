package org.learning.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.learning.AbstractParentTest;

import java.util.List;

public class MatchingStringsTest extends AbstractParentTest {

    MatchingStrings object = new MatchingStrings();

    @ParameterizedTest
    @CsvFileSource(resources = "/org/learning/hackerrank/MatchingStrings.csv",
            numLinesToSkip = 1,
            delimiter = delimiter)
    public void testTimeConversion(String strings, String queries, String results){
        List<String> lstStrings = getListOfStrings(strings);
        List<String> lstQueries = getListOfStrings(queries);
        List<String> lstExpected = getListOfStrings(results);
        List<Integer> integers = object.matchingStrings(lstStrings, lstQueries);

        Assertions.assertTrue(lstExpected.size() == integers.size());
        for (int i = 0; i < lstExpected.size(); i++) {
            Assertions.assertTrue(Integer.valueOf(lstExpected.get(i)) == integers.get(i));
        }
    }
}
