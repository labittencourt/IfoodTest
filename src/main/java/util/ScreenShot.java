package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.testScenario;

public class ScreenShot {
    public static void gerarScreenShot() {

        ConfigProperties properties = ConfigProperties.getInstance();
        String environment = properties.getEnvironment();
        String filename = testScenario.get().getName().replace(".", "") +".png";

        try {
            File imagem = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(imagem, new File("target/screenshots/"+ environment +"/"+ filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
