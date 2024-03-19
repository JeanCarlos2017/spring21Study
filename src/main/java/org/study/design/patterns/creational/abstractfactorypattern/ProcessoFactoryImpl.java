package org.study.design.patterns.creational.abstractfactorypattern;

import org.study.design.patterns.creational.abstractfactorypattern.ocorrencia.EnumOcorrencia;
import org.study.design.patterns.creational.abstractfactorypattern.ocorrencia.Ocorrencia;
import org.study.design.patterns.creational.abstractfactorypattern.ocorrencia.SinistroDFI;
import org.study.design.patterns.creational.abstractfactorypattern.ocorrencia.SinistroMip;
import org.study.design.patterns.creational.factory.method.transacao.*;

public class ProcessoFactoryImpl extends ProcessoFactory {
    @Override
    public Transacao criaTransacao(EnumTransacao transacao) {
        switch (transacao){
            case IMOVEL -> {
                return new ImovelTransacao();
            }
            case COMPRADOR -> {
                return new CompradorTransacao();
            }
            case VENDEDOR -> {
                return new VendedorTransacao();
            }
        }
       throw new IllegalArgumentException("Transação inválida");
    }

    @Override
    public Ocorrencia criaOcorrencia(EnumOcorrencia enumOcorrencia) {
        switch (enumOcorrencia){
            case SinistroDFI -> {
                return new SinistroDFI();
            }
            case SinistroMIP -> {
                return new SinistroMip();
            }
        }
        throw new IllegalArgumentException("Ocorrência inválida");
    }
}
