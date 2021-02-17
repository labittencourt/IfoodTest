package util;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.testScenario;

public class ReportUtil {
    public static synchronized void appendMsgToReport(String msg) {
        testScenario.get().write("- " + msg);
        System.out.print("- " + msg + "\n");
    }

    public static synchronized void appendToReport(String msg) {
        testScenario.get().embed(TakeScreenShot.getImageBytes(getDriver()), "image/png");
        testScenario.get().write("- " + msg);
        System.out.print("- " + msg + "\n");
    }

    public static synchronized void appendImgToReport() {
        testScenario.get().embed(TakeScreenShot.getImageBytes(getDriver()), "image/png");
    }
}
