package Utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggUtils {
    private static final Logger log =
            Logger.getLogger(LoggUtils.class.getName());

    public static void info(String message) {
        log.info(message);
    }
    public static void warn(String message) {
        log.warning(message);
    }
    public static void error(String message) {
        log.severe(message);
    }
    public static void fatal(String message) {
        log.severe(message);
    }
    public static void log(Level level, String message) {
        log.log(level, message);
    }
}
