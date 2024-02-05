package org.itsci.it10306214;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

  private static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

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

}
