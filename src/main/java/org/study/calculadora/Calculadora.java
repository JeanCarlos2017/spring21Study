package org.study.calculadora;

public class Calculadora {
    public static Double calculadora(OperacoesEnum operacao, Double a, Double b){
        switch (operacao) {
            case SOMA -> {
                return a + b;
            }
            case SUBTRACAO -> {
                return a - b;
            }
            case DIVISAO -> {
                return a / b;
            }
            case MULTIPLICACAO -> {
                return a * b;
            }
            default -> throw new IllegalArgumentException("operação desconhecida");
        }
    }
}
