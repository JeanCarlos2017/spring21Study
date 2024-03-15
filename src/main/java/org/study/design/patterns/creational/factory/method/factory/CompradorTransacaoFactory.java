package org.study.design.patterns.creational.factory.method.factory;

import org.study.design.patterns.creational.factory.method.transacao.CompradorTransacao;
import org.study.design.patterns.creational.factory.method.transacao.Transacao;

class CompradorTransacaoFactory extends TransacaoFactory {
    @Override
    public Transacao criarTransacao() {
        return new CompradorTransacao();
    }
}
