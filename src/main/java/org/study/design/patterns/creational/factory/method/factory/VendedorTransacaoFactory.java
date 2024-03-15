package org.study.design.patterns.creational.factory.method.factory;

import org.study.design.patterns.creational.factory.method.transacao.Transacao;
import org.study.design.patterns.creational.factory.method.transacao.VendedorTransacao;

class VendedorTransacaoFactory extends TransacaoFactory {
    @Override
    public Transacao criarTransacao() {
        return new VendedorTransacao();
    }
}
