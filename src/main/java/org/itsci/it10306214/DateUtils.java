package org.itsci.it10306214;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

  private static String pattern = "dd-MM-yyyy";
  private static DateFormat dateFormat = new SimpleDateFormat(pattern);

  public static Date StringToDate(String dateString) {
    Date date = null;
    try {
      // Parse the string to a Date object
      date = dateFormat.parse(dateString);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return date;
  }

  public static Date StringToDate(String dateString, String pattern) {
    DateFormat dateFormat = new SimpleDateFormat(pattern);
    Date date = null;
    try {
      // Parse the string to a Date object
      date = dateFormat.parse(dateString);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return date;
  }

  public static String DateToString(Date date) {
    String dateStr = "";
    try {
      // Format the Date object to a string
      dateStr = dateFormat.format(date);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return dateStr;
  }

}
