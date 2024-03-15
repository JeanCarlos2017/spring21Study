package org.study.design.patterns.creational.factory.method.factory;

import org.junit.jupiter.api.Test;
import org.study.design.patterns.creational.factory.method.transacao.CompradorTransacao;
import org.study.design.patterns.creational.factory.method.transacao.ImovelTransacao;
import org.study.design.patterns.creational.factory.method.transacao.Transacao;
import org.study.design.patterns.creational.factory.method.transacao.VendedorTransacao;

import static org.junit.jupiter.api.Assertions.*;

class TransacaoFactoryTest {

    @Test
    void testCriarImovelTransacao() {
        TransacaoFactory factory = new ImovelTransacaoFactory();
        Transacao transacao = factory.criarTransacao();
        transacao.processar();
        assertNotNull(transacao);
        assertInstanceOf(ImovelTransacao.class, transacao);
    }

    @Test
    void testCriarCompradorTransacao() {
        TransacaoFactory factory = new CompradorTransacaoFactory();
        Transacao transacao = factory.criarTransacao();
        transacao.processar();
        assertNotNull(transacao);
        assertInstanceOf(CompradorTransacao.class, transacao);
    }

    @Test
    void testCriarVendedorTransacao() {
        TransacaoFactory factory = new VendedorTransacaoFactory();
        Transacao transacao = factory.criarTransacao();
        assertNotNull(transacao);
        transacao.processar();
        assertInstanceOf(VendedorTransacao.class, transacao);
    }
}
