Feature: Testando transacao factory

  Scenario: Processar uma transação válida
    Given um ImovelTransacaoFactory
    And cria um ImovelTransacao
    And executa o metodo processar
    Then a classe vai ser do tipo <ImovelClass>