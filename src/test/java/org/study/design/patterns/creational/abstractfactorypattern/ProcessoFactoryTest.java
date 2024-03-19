package org.study.design.patterns.creational.abstractfactorypattern;

import org.junit.jupiter.api.Test;
import org.study.design.patterns.creational.abstractfactorypattern.ocorrencia.EnumOcorrencia;
import org.study.design.patterns.creational.abstractfactorypattern.ocorrencia.SinistroDFI;
import org.study.design.patterns.creational.abstractfactorypattern.ocorrencia.SinistroMip;
import org.study.design.patterns.creational.factory.method.transacao.CompradorTransacao;
import org.study.design.patterns.creational.factory.method.transacao.EnumTransacao;
import org.study.design.patterns.creational.factory.method.transacao.ImovelTransacao;
import org.study.design.patterns.creational.factory.method.transacao.VendedorTransacao;

import static org.junit.jupiter.api.Assertions.*;

class ProcessoFactoryTest {
    @Test
    void quandoTransacaoImovelESinistroMip(){
        ProcessoFactory processoFactory= new ProcessoFactoryImpl();
        processoFactory.criaOcorrencia(EnumOcorrencia.SinistroMIP).processar();
        assertInstanceOf(ImovelTransacao.class,  processoFactory.criaTransacao(EnumTransacao.IMOVEL));
        assertInstanceOf(SinistroMip.class,  processoFactory.criaOcorrencia(EnumOcorrencia.SinistroMIP));
    }

    @Test
    void quandoTransacaoVendedorESinistroMip(){
        ProcessoFactory processoFactory = new ProcessoFactoryImpl();

        assertInstanceOf(VendedorTransacao.class,  processoFactory.criaTransacao(EnumTransacao.VENDEDOR));
        assertInstanceOf(SinistroMip.class,  processoFactory.criaOcorrencia(EnumOcorrencia.SinistroMIP));

    }

    @Test
    void quandoTransacaoCompradorESinistroDFI(){
        ProcessoFactory processoFactory = new ProcessoFactoryImpl();
        processoFactory.criaOcorrencia(EnumOcorrencia.SinistroDFI).processar();

        assertInstanceOf(CompradorTransacao.class,  processoFactory.criaTransacao(EnumTransacao.COMPRADOR));
        assertInstanceOf(SinistroDFI.class,  processoFactory.criaOcorrencia(EnumOcorrencia.SinistroDFI));

    }

    @Test
    void quandoTransacaoEOcorrenciaInvalida(){
        ProcessoFactory processoFactory = new ProcessoFactoryImpl();

        assertThrows(
                IllegalArgumentException.class,
                ()-> processoFactory.criaTransacao(EnumTransacao.INVALIDA)
        );

        assertThrows(
                IllegalArgumentException.class,
                ()-> processoFactory.criaOcorrencia(EnumOcorrencia.INVALIDA)
        );

    }
}