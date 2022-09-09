package org.learning.hackerrank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConversion {

    public String timeConversion(String s) {
        SimpleDateFormat s1=new SimpleDateFormat("hh:mm:ssa");
        SimpleDateFormat s2=new SimpleDateFormat("HH:mm:ss");
        Date date1= null;
        try {
            date1 = s1.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String time = s2.format(date1);
        return time;
    }


}


