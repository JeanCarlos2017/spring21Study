package org.study.design.patterns.creational.factory.method.factory;

import org.study.design.patterns.creational.factory.method.transacao.Transacao;

abstract class TransacaoFactory {
    public abstract Transacao criarTransacao();
}
