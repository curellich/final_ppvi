package ar.edu.fie.undef.sensorlisterner.utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils {

    //Get the difference in minutes between two dates
    public static long getDifferenceInMinutes(Date date1, Date date2) {
        long diff = date2.getTime() - date1.getTime();
        return TimeUnit.MILLISECONDS.toMinutes(diff);
    }

    //Get the difference in seconds between two dates
    public static long getDifferenceInSeconds(Date date1, Date date2) {
        long diff = date2.getTime() - date1.getTime();
        return TimeUnit.MILLISECONDS.toSeconds(diff);
    }

    //Get the difference in milliseconds between two dates
    public static long getDifferenceInMilliseconds(Date date1, Date date2) {
        return date2.getTime() - date1.getTime();
    }
}
