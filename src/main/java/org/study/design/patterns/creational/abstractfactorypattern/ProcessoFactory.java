package org.study.design.patterns.creational.abstractfactorypattern;

import org.study.design.patterns.creational.abstractfactorypattern.ocorrencia.EnumOcorrencia;
import org.study.design.patterns.creational.abstractfactorypattern.ocorrencia.Ocorrencia;
import org.study.design.patterns.creational.factory.method.transacao.EnumTransacao;
import org.study.design.patterns.creational.factory.method.transacao.Transacao;

public abstract class ProcessoFactory {
    public abstract Transacao criaTransacao(EnumTransacao transacao);
    public abstract Ocorrencia criaOcorrencia(EnumOcorrencia enumOcorrencia);
}
