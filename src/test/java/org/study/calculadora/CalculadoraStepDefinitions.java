package org.study.calculadora;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculadoraStepDefinitions {
    private OperacoesEnum operacao;
    private Double a, b, resultado;

    @Given("uma operacao {string}")
    public void tenhoUmaOperacao(String operacao){
        this.operacao= OperacoesEnum.fromString(operacao);
    }

    @And("o valor de {double} e {double}")
    public void tenhoValorDeAeB(Double a, Double b){
        this.a= a;
        this.b= b;
    }

    @But("se uma operacao é invalida eu nao realizo o calculo")
    public void seUmaOperacaoÉInvalidaEuNaoRealizoOCalculo() {
        if(operacao == OperacoesEnum.INVALIDO){
            assertThrows(
                    IllegalArgumentException.class,
                    ()-> Calculadora.calculadora(operacao, 0d, 0d)
            );

            this.a = this.b = this.resultado = 0d;
            this.operacao= OperacoesEnum.SOMA;
        }
    }

    @When("^eu realizo uma das quatro operações$")
    public void realizoCalculo(){
        resultado= Calculadora.calculadora(operacao, a, b);
    }


    @Then("o resultado é igual a {double}")
    public void verificoOResultado(Double resultado){
        assertEquals(Math.ceil(resultado), Math.ceil(this.resultado));
    }
}
