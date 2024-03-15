package org.study.design.patterns.creational.factory.method.transacao;

public class CompradorTransacao implements Transacao {
    @Override
    public void processar() {
        System.out.println("Processando transação de comprador...");
    }
}
