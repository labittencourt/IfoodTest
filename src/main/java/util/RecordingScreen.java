package util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.testScenario;

public class RecordingScreen {
    public static void gerarRecordingScreen() throws IOException {

        ConfigProperties properties = ConfigProperties.getInstance();
        String environment = properties.getEnvironment();
        String filename = testScenario.get().getName().replace(".", "") +".mp4";

        File dir = new File("target/recordingscreen/"+ environment);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        if (environment.equals("android")) {
            String encodedVideo = ((AndroidDriver) getDriver()).stopRecordingScreen();
            byte[] decodedVideo = Base64.getDecoder().decode(encodedVideo);

            FileOutputStream outputStream = new FileOutputStream(dir + "/" + filename);
            outputStream.write(decodedVideo);
            outputStream.close();

        } else if (environment.equals("ios")) {
            String encodedVideo = ((IOSDriver) getDriver()).stopRecordingScreen();
            byte[] decodedVideo = Base64.getDecoder().decode(encodedVideo);

            FileOutputStream outputStream = new FileOutputStream(dir + "/" + filename);
            outputStream.write(decodedVideo);
            outputStream.close();
        }
    }
}
