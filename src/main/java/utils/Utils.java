package utils;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Lydia BARAUKOVA
 */
public class Utils {
    public static String formatDouble(Double d) {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(2);
        return decimalFormat.format(d);
    }

    public static boolean sameDay(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        return cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) &&
                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
    }
}
