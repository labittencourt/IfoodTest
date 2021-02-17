package steps;

import cucumber.api.java.pt.*;
import screens.HomeScreen;

import static core.DriverFactory.getDriver;

public class HomeSteps {
    HomeScreen home = new HomeScreen(getDriver());

    @Dado("que informo codigo valido")
    public void queInformoCodigoValido() {
        home.setCodeCadastro();
    }

    @E("informo um nome aluno")
    public void informoUmNomeAluno() {
        home.setNameCadastro();
    }

    @Quando("clico em salvar")
    public void clicoEmSalvar() {
        home.clickBtnSalvar();
    }

    @Entao("o app exibe o cadastro na tela")
    public void oAppExibeOCadastroNaTela() {
        home.validarCadastro();
    }

    @E("clico em sair")
    public void clicoEmSair() {
        home.clickBtnSair();
    }
}
