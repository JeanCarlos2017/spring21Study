package org.study.design.patterns.creational.factory.method.factory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.study.design.patterns.creational.factory.method.transacao.ImovelTransacao;
import org.study.design.patterns.creational.factory.method.transacao.Transacao;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class TransacaoFactoryBDDTest {
    private TransacaoFactory factory;
    private Transacao transacao;

    @Given("um ImovelTransacaoFactory")
    public void dadoUmImovelTransacaoFactory() {
        factory = new ImovelTransacaoFactory();

    }
    @And("cria um ImovelTransacao")
    public void dadoUmImovelTransacao() {
        transacao= factory.criarTransacao();
    }

    @And("executa o metodo processar")
    public void processar() {
        transacao.processar();
    }

    @Then("a classe vai ser do tipo <ImovelClass>")
    public void aClasseVaiSerDoTipoImovelClass() {
        assertInstanceOf(ImovelTransacao.class, transacao);
    }
}
