package log;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final String logFile = "target/logged.log";

    private static void log(String level, String message) {
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logMessage = String.format("[%s] %s: %s", timeStamp, level, message);

        // Log to file
        try (FileWriter writer = new FileWriter(logFile, true)) {
            writer.write(logMessage + System.lineSeparator());
        } catch (IOException e) {
            System.err.println("Could not write to log file: " + e.getMessage());
        }

        // Log to console
        System.out.println(logMessage);
    }

    public static void info(String message) {
        log("INFO", message);
    }

    public static void infoWithPage(String message,String page) {
        log("INFO", message+" in "+page+"!");
    }

    public static void debug(String message) {
        log("DEBUG", message);
    }

    public static void warn(String message) {
        log("WARN", message);
    }

    public static void error(String message) {
        log("ERROR", message);
    }

    public static void errorWithPage(String message,String page) {
        log("ERROR", message+" in "+page+"!");
    }
}
