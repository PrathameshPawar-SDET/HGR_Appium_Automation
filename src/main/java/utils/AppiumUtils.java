package utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class AppiumUtils {

    public String getScreenshotPath(String testCaseName, AndroidDriver driver) throws IOException {
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";
        FileUtils.copyFile(source, new File(destination));
        return destination;
    }
}