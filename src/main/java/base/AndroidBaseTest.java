package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.*;
import utils.AppiumUtils;

import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class AndroidBaseTest extends AppiumUtils {
    public AndroidDriver driver;

    @BeforeClass
    public void configureAppium() throws Exception {
        Properties props = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            props.load(input);
        }

        CapabilitiesManager capsManager = new CapabilitiesManager();
        UiAutomator2Options options = capsManager.getCaps();

        driver = new AndroidDriver(new URL(props.getProperty("appiumServerURL")), options);

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(Long.parseLong(props.getProperty("implicitWait")))
        );
    }

//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
