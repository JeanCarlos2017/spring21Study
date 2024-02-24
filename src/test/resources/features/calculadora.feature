Feature: realizando operações com a calculadora

  Scenario Outline: realizando as quatro operações básicas
    Given uma operacao <operacao>
    And o valor de <a> e <b>
    But se uma operacao é invalida eu nao realizo o calculo
    When eu realizo uma das quatro operações
    Then o resultado é igual a <resultado>

    Examples:
      | operacao        | a   | b   | resultado |
      | "soma"          | 4.8 | 8.2 | 13        |
      | "subtracao"     | 4   | 8.2 | -4.2      |
      | "divisao"       | 4   | 8   | 0.5       |
      | "multiplicacao" | 4   | 8   | 32        |
      | "inexistente"   | 4   | 8   | 0         |
