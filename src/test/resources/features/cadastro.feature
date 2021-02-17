#language: pt

  Funcionalidade: Realizar cadastro de aluno
    Eu como usuario
    Quero realizar um cadastro de aluno
    Para visualizar na tela do app

    Contexto: Validar tela de login
      Dado que estou na tela de login
      Quando informo dados validos para efetuar o login
      E clico no botao entrar
      Entao app exibe a tela home

    @all
    Cenario: Realizar um cadastro de um aluno e sair do app
    Dado que informo codigo valido
    E informo um nome aluno
    Quando clico em salvar
    Entao o app exibe o cadastro na tela
    E clico em sair
