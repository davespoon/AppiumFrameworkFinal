import core.ADB;
import core.MyLogger;
import org.apache.log4j.Level;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {

    public static void main(String[] args) throws IOException {
        MyLogger.log.setLevel(Level.ERROR);
        MyLogger.log.debug("Test debug");
        MyLogger.log.error("Test error");
        MyLogger.log.info("Test info");
        MyLogger.log.warn("Test warning");
    }
}
