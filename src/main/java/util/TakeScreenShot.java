package util;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static core.DriverFactory.getDriver;

public class TakeScreenShot {
    /**
     * Create a file with a screenshot from the browser or app
     * @return The path to the file of the screenshot
     */
    public static String imageFile(String path) {
        if(path == null) {
            path = System.getProperty("user.dir") + "\\target\\image\\";
        }
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            path += new SimpleDateFormat("ddMMyyyyHHmmss").format(Calendar.getInstance().getTime()) + ".png";
            FileUtils.copyFile(srcFile, new File(path));
        } catch (IOException e) {
            ReportUtil.appendMsgToReport(e.getMessage());
        }
        return path;
    }

    public synchronized static byte[] getImageBytes(AppiumDriver<?> driver){
        return  ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
