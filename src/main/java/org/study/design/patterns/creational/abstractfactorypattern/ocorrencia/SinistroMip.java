package org.study.design.patterns.creational.abstractfactorypattern.ocorrencia;

public class SinistroMip implements Ocorrencia{
    @Override
    public void processar() {
        System.out.println("Sinistro mip");
    }
}
