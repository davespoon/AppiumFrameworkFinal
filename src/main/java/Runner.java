
import api.android.Android;
import core.ADB;
import core.MyLogger;
import core.UiObject;
import core.UiSelector;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Level;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Runner {
    static String appPath = "C:\\Users\\admin\\AppData\\Local\\Programs\\appium-desktop\\resources\\app\\" +
            "node_modules\\appium\\node_modules\\appium-unlock\\bin\\unlock_apk-debug.apk";

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        MyLogger.log.setLevel(Level.DEBUG);
        AndroidDriver driver = null;
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "4df182e438a98f79");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("app", appPath);
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

            Android.driver = driver;

            ADB adb = new ADB("4df182e438a98f79");
            adb.openAppsActivity("org.zwanoo.android.speedtest",
                    "com.ookla.speedtest.softfacade.MainActivity");

            //UiObject testAgainButton = new UiSelector().resourceId("org.zwanoo.android.speedtest:id/o2_button_button").makeUiObject();
            UiObject ping = new UiSelector().resourceId("org.zwanoo.android.speedtest:id/pingSpeed").makeUiObject();
            UiObject download = new UiSelector().resourceId("org.zwanoo.android.speedtest:id/downloadSpeed").makeUiObject();
            UiObject upload = new UiSelector().resourceId("org.zwanoo.android.speedtest:id/uploadSpeed").makeUiObject();

            //testAgainButton.waitToAppear(5).tap().waitToDisappear(5).waitToAppear(120);

            MyLogger.log.info("Ping: " + ping.getText());
            MyLogger.log.info("Download: " + download.getText());
            MyLogger.log.info("Upload: " + upload.getText());


        } finally {
            if (driver == null) driver.quit();
        }
    }
}
