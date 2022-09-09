package org.learning;

import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AbstractParentTest {
    public final char delimiter = '#';

    public List<Integer> getListOfIntegers(String csv){
        String[] split = csv.split(",");
        return Stream.of(split).map(Integer::valueOf).collect(Collectors.toList());
    }
    public int[] getArrayOfIntegers(String csv){
        if(csv == null || csv.equalsIgnoreCase("null") || StringUtils.isBlank(csv))
            return null;
        String[] split = csv.split(",");
        int[] nums = new int[split.length];
        int i = 0;
        for (String s: split) {
            nums[i++] = Integer.parseInt(s);
        }
        return nums;
    }

    public List<String> getListOfStrings(String csv){
        String[] split = csv.split(",");
        return Stream.of(split).map(String::valueOf).collect(Collectors.toList());
    }

    /**
     * csv = "11 2 4,4 5 6,10 8 -12"
     * Converts to Following matrix
     * 11 2 4
     * 4 5 6
     * 10 8 -12
     * @param csv
     * @return
     */
    public List<List<Integer>> getMatrixOfIntegers(String csv){
        List<List<Integer>> lstRows = new ArrayList<>();
        String[] rows = csv.split(",");
        for (String row: rows) {
            String[] cells = row.split(" ");
            List<Integer> lstRow = Stream.of(cells).map(Integer::valueOf).collect(Collectors.toList());
            lstRows.add(lstRow);
        }
        return lstRows;
    }
}
