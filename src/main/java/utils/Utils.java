package utils;

import java.text.DecimalFormat;

/**
 * @author Lydia BARAUKOVA
 */
public class Utils {
    public static String formatDouble(Double d) {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(2);
        return decimalFormat.format(d);
    }
}
