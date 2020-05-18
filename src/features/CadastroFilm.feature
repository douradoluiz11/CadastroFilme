@cadastro
Feature: CadastroFilme

  @tag1
  Scenario: CadastrarFilme
    Given Cadastre o Filme

  @tag2
  Scenario: Buscar Filme Google
    Given Abro o Navegador
    And Acesso o Site "https://www.google.com.br"

  @tag3
  Scenario: Executar API
    Given Teste API
