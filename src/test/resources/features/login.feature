#language: pt

@all
  Funcionalidade: Validar cenarios de testes da tela de login
    Sendo um usuario do aplicativo
    Quero realizar o login
    Para visualizar a tela home do aplicativo

    Contexto: Validar tela de login
      Dado que estou na tela de login



    Cenario: Login com dados invalidos
      Quando informo dados invalidos para efetuar o login
      E clico no botao entrar
      Entao app exibe mensagem "Erro no login! :("

    Cenario: Login com dados validos
      Quando informo dados validos para efetuar o login
      E clico no botao entrar
      Entao app exibe a tela home