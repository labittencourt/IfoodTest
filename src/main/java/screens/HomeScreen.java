package screens;

import core.BaseScreen;
import core.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import util.ConfigProperties;
import util.ReportUtil;

import static constantes.ConstantTest.*;

public class HomeScreen extends BaseScreen {
    LoginScreen login = new LoginScreen(DriverFactory.getDriver());
    private ConfigProperties properties = ConfigProperties.getInstance();
    private String environment = properties.getEnvironment();


    @AndroidFindBy(accessibility = "salvar")
    @iOSXCUITFindBy(accessibility = "salvar")
    private MobileElement btnSalvar;

    @AndroidFindBy(accessibility = "aluno")
    @iOSXCUITFindBy(accessibility = "aluno")
    private MobileElement fieldAluno;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, '123000 - MANUELA')]")
    @iOSXCUITFindBy(xpath = "//android.widget.TextView/[@text='123000 - MANUELA']")
    private MobileElement checkCadastro;

    @AndroidFindBy(accessibility = "codigo")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField[@name=\"RNE__Input__text-input\"])[1]\n")
    private MobileElement fieldCodigo;

    @AndroidFindBy(accessibility = "logout")
    @iOSXCUITFindBy(accessibility = "logout")
    private MobileElement btnSair;


    public HomeScreen(AppiumDriver<?> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void setCodeCadastro() {
        if (environment.equals("ios")){
            login.fieldCodigo.click();
            login.fieldCodigo.setValue(CODIGO_CAD_VALIDO);
            ReportUtil.appendToReport("Inserindo codigo para cadastro: " + login.fieldCodigo.getText());
        }else if (environment.equals("android")){
            fieldCodigo.click();
            fieldCodigo.setValue(CODIGO_CAD_VALIDO);
            ReportUtil.appendToReport("Inserindo codigo para cadastro: " + login.fieldCodigo.getText());
        }
    }

    public void setNameCadastro() {
        if (environment.equals("ios")){
            fieldAluno.click();
            fieldAluno.setValue(NOME_CAD_VALIDO);
            ReportUtil.appendToReport("Inserindo nome para cadastro: " + fieldAluno.getText());
        }else if (environment.equals("android")){
            fieldAluno.click();
            fieldAluno.setValue(NOME_CAD_VALIDO);
            ReportUtil.appendToReport("Inserindo nome para cadastro: " + fieldAluno.getText());
        }
    }

    public void clickBtnSalvar() {
        if (environment.equals("ios")){
            btnSalvar.click();
        }else if (environment.equals("android")){
            btnSalvar.click();
        }
    }

    public void validarCadastro() {
        if (environment.equals("ios")){
            Assert.assertEquals(checkCadastro, VALIDAR_CADASTRO);
            System.out.println("Cadastro realizado é: " + VALIDAR_CADASTRO);
            System.out.println("Cadastro exibida na tela é: " + checkCadastro);
        }else if (environment.equals("android")){
            DriverFactory.getDriver().hideKeyboard();
            String msn = checkCadastro.getText();
            Assert.assertEquals(msn, VALIDAR_CADASTRO);
            System.out.println("Cadastro realizado é: " + VALIDAR_CADASTRO);
            System.out.println("Cadastro exibida na tela é: " + msn);
        }
    }

    public void clickBtnSair() {
        if (environment.equals("ios")){
            btnSair.click();
        }else if (environment.equals("android")){
            btnSair.click();
            ReportUtil.appendToReport("Clicou no botao " + btnSair.getText() + " para deslogar");

        }
    }

}
