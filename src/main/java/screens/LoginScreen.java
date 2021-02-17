package screens;

import core.BaseScreen;
import core.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import util.ConfigProperties;
import util.ReportUtil;

import static constantes.ConstantTest.*;

public class LoginScreen extends BaseScreen {
    private ConfigProperties properties = ConfigProperties.getInstance();
    private String environment = properties.getEnvironment();

    @AndroidFindBy(accessibility = "email")
    @iOSXCUITFindBy(accessibility = "email")
    private MobileElement fieldEmail;

    @AndroidFindBy(accessibility = "senha")
    @iOSXCUITFindBy(accessibility = "senha")
    private MobileElement fieldSenha;

    @AndroidFindBy(accessibility = "entrar")
    @iOSXCUITFindBy(accessibility = "entrar")
    private MobileElement btnEntrarLogin;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Test')]")
    @iOSXCUITFindBy(accessibility = "Test")
    private MobileElement telaLogin;

    @AndroidFindBy(accessibility = "lognFail")
    @iOSXCUITFindBy(accessibility = "lognFail")
    private MobileElement idLoginFail;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Código')]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField[@name=\"RNE__Input__text-input\"])[1]\n")
    public MobileElement fieldCodigo;

    public LoginScreen(AppiumDriver<?> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void inserirDadosParaNaoFazerLogin() {
        if (environment.equals("ios")) {
            fieldEmail.sendKeys(EMAIL_INVALIDO);
            ReportUtil.appendToReport("Inserindo E-mail para acesso: " + fieldEmail.getText());
            fieldSenha.sendKeys(SENHA_INVALIDO);
            ReportUtil.appendToReport("Inserindo Senha para acesso: " + fieldSenha.getText());
        }else if (environment.equals("android")){
            fieldEmail.sendKeys(EMAIL_INVALIDO);
            ReportUtil.appendToReport("Inserindo E-mail para acesso: " + fieldEmail.getText());
            fieldSenha.sendKeys(SENHA_INVALIDO);
            ReportUtil.appendToReport("Inserindo Senha para acesso: " + fieldSenha.getText());
        }
    }

    public void inserirDadosParaFazerLogin() {
        if (environment.equals("ios")) {
            fieldEmail.sendKeys(EMAIL_VALIDO);
            ReportUtil.appendToReport("Inserindo E-mail para acesso: " + fieldEmail.getText());
            fieldSenha.sendKeys(SENHA_VALIDO);
            btnEntrarLogin.click();
        }
        else if (environment.equals("android")){
            fieldEmail.click();
            fieldEmail.sendKeys(EMAIL_VALIDO);
            ReportUtil.appendToReport("Inserindo E-mail para acesso: " + fieldEmail.getText());
            fieldSenha.sendKeys(SENHA_VALIDO);
            ReportUtil.appendToReport("Inserindo Senha para acesso: " + fieldSenha.getText());
        }
    }

    public void clicarBtnEntrarLogin() {
        if (environment.equals("ios")) {
            ocultarTeclado();
            esperar(1000);
            btnEntrarLogin.click();
            ReportUtil.appendToReport("Clicou no botao " + btnEntrarLogin.getText() + " para logar");
            esperar(1000);
        }else if (environment.equals("android")){
            ocultarTeclado();
            esperar(1000);
            btnEntrarLogin.click();
            ReportUtil.appendToReport("Clicou no botao " + btnEntrarLogin.getText() + " para logar");
            esperar(1000);
        }
    }

    public void validarTelaLogin() {
        if (environment.equals("ios")) {
            telaLogin.isEnabled();
            ReportUtil.appendToReport("Estou na tela de login: " + telaLogin.getText());
        }else if (environment.equals("android")){
            telaLogin.isEnabled();
            ReportUtil.appendToReport("Estou na tela de login: " + telaLogin.getText());
        }
    }

    public void validarMensagemErroLogin(String mensagem) {
        if (environment.equals("ios")) {
            idLoginFail.isDisplayed();
            String msn = idLoginFail.getText();
            System.out.println("Mensagem esperada na tela é: " + mensagem);
            System.out.println("Mensagem exibida na tela é: " + msn);
            Assert.assertEquals(msn, mensagem);
        }else if (environment.equals("android")){
            idLoginFail.isDisplayed();
            String msn = idLoginFail.getText();
            System.out.println("Mensagem esperada na tela é: " + mensagem);
            System.out.println("Mensagem exibida na tela é: " + msn);
            Assert.assertEquals(msn, mensagem);
        }
    }

    public void validarTelaHome() {
        if (environment.equals("ios")){
            esperar(2000);
            System.out.println("Esperando validar botao salvar");
            fieldCodigo.isEnabled();
        }else if (environment.equals("android")){
            esperar(2000);
            fieldCodigo.isEnabled();
            System.out.println("Tela Home exibida");
        }
    }
}
