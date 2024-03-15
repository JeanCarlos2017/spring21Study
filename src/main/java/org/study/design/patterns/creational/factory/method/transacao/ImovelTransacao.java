package org.study.design.patterns.creational.factory.method.transacao;

public class ImovelTransacao implements Transacao {
    @Override
    public void processar() {
        System.out.println("Processando transação de imóvel...");
    }
}
