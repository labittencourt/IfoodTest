package core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ConfigProperties;
import util.ReportUtil;

import java.time.Duration;

import static constantes.Constantes.TIME_OUT;
import static core.DriverFactory.getDriver;
import static org.testng.Assert.fail;

public class BaseScreen {
    private ConfigProperties properties = ConfigProperties.getInstance();
    private String environment = properties.getEnvironment();

    protected void abrirNotificacoes() {
        if (environment.equals("android")) {
            ((AndroidDriver) getDriver()).openNotifications();
        }
    }

    protected void fecharNotificacoes() {
        if (environment.equals("android")) {
            ((AndroidDriver) getDriver()).pressKey(new KeyEvent(AndroidKey.BACK));
        }
    }

    protected void ocultarTeclado() {
        getDriver().hideKeyboard();
    }

    protected void biometria() {
        if (environment.equals("android")) {
            ((AndroidDriver) getDriver()).fingerPrint(1);
        }
    }

    protected void esperar(long tempo){
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void scrollHeader() {
        scroll(0.9, 0.6);
    }

    protected void scrollToElement(MobileElement element, MobileElement element2) {
        new TouchAction(getDriver())
                .press(PointOption.point(element2.getLocation()))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(element.getLocation()))
                .release()
                .perform();
    }

    protected void scrollDown() {
        scroll(0.9, 0.2);
    }

    protected void scrollUp() {
        scroll(0.2, 0.9);
    }

    protected void swipeLeft() {
        swipe(0.2, 0.9);
    }

    protected void swipeRight() {
        swipe(0.9, 0.2);
    }

    private void scroll(double inicio, double fim) {
        Dimension size = getDriver().manage().window().getSize();

        int x = size.width / 2;

        int start_y = (int) (size.height * inicio);
        int end_y = (int) (size.height * fim);

        new TouchAction(getDriver())
                .press(PointOption.point(x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1300)))
                .moveTo(PointOption.point(x, end_y))
                .release()
                .perform();
    }

    private void swipe(double inicio, double fim) {
        Dimension size = getDriver().manage().window().getSize();

        int y = size.height / 2;

        int start_x = (int) (size.width * inicio);
        int end_x = (int) (size.width * fim);

        new TouchAction(getDriver())
                .press(PointOption.point(start_x, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(end_x, y))
                .release()
                .perform();
    }

    public void swipeElementLeft(By by) {
        swipeElement((MobileElement) getDriver().findElement(by), 0.1, 0.9);
    }

    public void swipeElementRight(By by) {
        swipeElement((MobileElement) getDriver().findElement(by), 0.9, 0.1);
    }

    public void swipeElement(MobileElement element, double inicio, double fim) {
        int y = element.getLocation().y + (element.getSize().height / 2);


        int start_x = (int) (element.getSize().width * inicio);
        int end_x = (int) (element.getSize().width * fim);

        new TouchAction(getDriver())
                .press(PointOption.point(start_x, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(end_x, y))
                .release()
                .perform();
    }

    protected void expectElementVisible(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), TIME_OUT);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            ReportUtil.appendImgToReport();
            fail(e.getMessage());
        }
    }

    protected void abrir() {
        getDriver().launchApp();
        esperar(5000);
    }

    protected void fechar() {
        esperar(5000);
        getDriver().closeApp();
    }

    protected void reiniciar() {
        esperar(5000);
        getDriver().resetApp();
    }
}
