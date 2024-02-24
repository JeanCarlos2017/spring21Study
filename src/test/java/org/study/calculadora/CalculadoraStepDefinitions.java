package org.study.calculadora;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @When("^eu realizo uma das quatro operações$")
    public void realizoCalculo(){
        resultado= Calculadora.calculadora(operacao, a, b);
    }


    @Then("o resultado é igual a {double}")
    public void verificoOResultado(Double resultado){
        assertEquals(Math.ceil(resultado), Math.ceil(this.resultado));
    }

}
