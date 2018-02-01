package com.xception.schoolevents.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateHelper {

    public static final String DATE_SERVER_PATTERN = "yyyy-MM-dd";

    /**
     * Convert a date string from server to a date
     * @param sDate a date string from server
     * @return a date
     */
    public static Date getDate(String sDate) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_SERVER_PATTERN, Locale.getDefault());
        Date date = null;
        try {
            date = format.parse(sDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * Get month from a date
     * @param date date which contains the month
     * @return the month of the date as integer
     */
    public static int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH);
    }

    /**
     * Get year from a date
     * @param date date which contains the year
     * @return the year  of the date as integer
     */
    public static int getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }
}
