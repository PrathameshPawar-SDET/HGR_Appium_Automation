package base;

import io.appium.java_client.android.options.UiAutomator2Options;
import java.io.InputStream;
import java.util.Properties;
import java.time.Duration;

public class CapabilitiesManager {
    public UiAutomator2Options getCaps() throws Exception {
        Properties props = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            props.load(input);
        }

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName(props.getProperty("platformName"))
                .setAutomationName(props.getProperty("automationName"))
                .setDeviceName(props.getProperty("deviceName"))
                .setUdid(props.getProperty("udid"))
                .setApp(System.getProperty("user.dir") + "/" + props.getProperty("appPath"))
                .setNewCommandTimeout(Duration.ofSeconds(Long.parseLong(props.getProperty("newCommandTimeout"))));

        // Optional capabilities
        if (props.getProperty("appPackage") != null) {
            options.setAppPackage(props.getProperty("appPackage"));
        }
        if (props.getProperty("appActivity") != null) {
            options.setAppActivity(props.getProperty("appActivity"));
        }

        // Optional boolean capabilities
        if (props.getProperty("ensureWebviewsHavePages") != null) {
            options.setCapability("ensureWebviewsHavePages", Boolean.parseBoolean(props.getProperty("ensureWebviewsHavePages")));
        }
        if (props.getProperty("nativeWebScreenshot") != null) {
            options.setCapability("nativeWebScreenshot", Boolean.parseBoolean(props.getProperty("nativeWebScreenshot")));
        }

        return options;
    }
}
