package org.study.calculadora;

import lombok.Getter;

public enum OperacoesEnum {

    SOMA("soma"),

    MULTIPLICACAO("multiplicacao"),

    SUBTRACAO("subtracao"),

    DIVISAO("divisao"),

    INVALIDO("invalido");

    private final String operacao;

    OperacoesEnum(String operacao) {
        this.operacao = operacao;
    }
    public static OperacoesEnum fromString(String texto) {
        for (OperacoesEnum operacao : OperacoesEnum.values()) {
            if (operacao.operacao.equalsIgnoreCase(texto)) {
                return operacao;
            }
        }
        return INVALIDO;
    }




}
