package utils;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Lydia BARAUKOVA
 * Class for printing out stuff without using System.out.println
 */
public class Log {

    private static Logger logger;

    static {
        logger = Logger.getLogger(Log.class.getName());
        logger.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new MyFormatter());
        logger.addHandler(handler);
        activateLogger();
    }

    public static void print(String msg) { logger.severe(msg + "\n"); }

    public static void activateLogger() { logger.setLevel(Level.ALL); }

    public static void deactivateLogger() { logger.setLevel(Level.OFF); }
}
