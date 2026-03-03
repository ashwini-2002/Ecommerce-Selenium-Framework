package utils;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static String capture(WebDriver driver, String testName) throws IOException {

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path = "screenshots/" + testName + ".png";
        FileUtils.copyFile(src, new File(path));
        return path;
    }
}