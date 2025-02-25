package org.study.jvm.cardtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WriteBarrierExemploTest {

    private CardTable cardTable;
    private ObjetoAntigo objetoAntigo;
    private ObjetoReferencia referenciaAntiga;
    private ObjetoReferencia referenciaNova;
    private static final int HEAP_SIZE = 1024 * 1024;
    private static final int OBJETO_ADDRESS = 2048;

    @BeforeEach
    void setUp() {
        cardTable = new CardTable(HEAP_SIZE);
        objetoAntigo = new ObjetoAntigo(cardTable, OBJETO_ADDRESS);
        referenciaAntiga = new ObjetoReferencia("Antigo");
        referenciaNova = new ObjetoReferencia("Novo");
    }

    @Test
    void testAtualizacaoReferencia() {
        objetoAntigo.atualizarReferencia(referenciaAntiga);
        assertEquals("Antigo", objetoAntigo.getReferencia().getValor(),
            "A referência antiga deve ser 'Antigo'");

        objetoAntigo.atualizarReferencia(referenciaNova);
        assertEquals("Novo", objetoAntigo.getReferencia().getValor(),
            "A referência nova deve ser 'Novo'");
    }

    @Test
    void testCardTableMarcacao() {
        objetoAntigo.atualizarReferencia(referenciaNova);
        assertTrue(cardTable.isCardDirty(OBJETO_ADDRESS),
            "O cartão deve estar marcado como sujo após atualização");
    }
}