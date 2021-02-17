package steps;

import cucumber.api.java.pt.*;
import screens.HomeScreen;
import screens.LoginScreen;


import static core.DriverFactory.getDriver;

public class LoginSteps {

    LoginScreen login = new LoginScreen(getDriver());


    @Dado("que estou na tela de login")
    public void que_estou_na_tela_de_login() {
        login.validarTelaLogin();
    }

    @Quando("informo dados invalidos para efetuar o login")
    public void informo_dados_invalidos_para_efetuar_o_login() {
        login.inserirDadosParaNaoFazerLogin();
    }

    @Quando("clico no botao entrar")
    public void clico_no_botao_entrar() {
        login.clicarBtnEntrarLogin();
    }

    @Entao("app exibe mensagem {string}")
    public void appExibeMensagem(String mensagem) {
        login.validarMensagemErroLogin(mensagem);
    }

    @Quando("informo dados validos para efetuar o login")
    public void informoDadosValidosParaEfetuarOLogin() {
        login.inserirDadosParaFazerLogin();
    }

    @Entao("app exibe a tela home")
    public void appExibeATelaHome() {
//        home.validarTelaHome();
        login.validarTelaHome();
    }

    @E("clico no botao entrarr")
    public void clicoNoBotaoEntrarr() {
        login.clicarBtnEntrarLogin();
    }


}
