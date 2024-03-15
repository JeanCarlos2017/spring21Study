package org.study.design.patterns.creational.factory.method.factory;

import org.study.design.patterns.creational.factory.method.transacao.ImovelTransacao;
import org.study.design.patterns.creational.factory.method.transacao.Transacao;

class ImovelTransacaoFactory extends TransacaoFactory {
    @Override
    public Transacao criarTransacao() {
        return new ImovelTransacao();
    }
}
