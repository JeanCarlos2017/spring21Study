package org.study.jvm.cardtable;

class CardTable {
    private final byte[] cardTable;

    public CardTable(int heapSize) {
        // Inicializa a tabela de cartões com tamanho proporcional ao heap
        cardTable = new byte[heapSize / 512]; // Exemplo de divisão do heap em "cartões" de 512 bytes
    }

    public void markCardAsDirty(int address) {
        int cardIndex = address / 512;
        cardTable[cardIndex] = 1; // Marca o cartão como sujo
    }

    public boolean isCardDirty(int address) {
        int cardIndex = address / 512;
        return cardTable[cardIndex] == 1;
    }
}


