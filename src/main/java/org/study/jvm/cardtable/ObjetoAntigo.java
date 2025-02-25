package org.study.jvm.cardtable;

import lombok.Getter;

class ObjetoAntigo {
    @Getter
    private ObjetoReferencia referencia;
    private final CardTable cardTable;
    private final int address;

    public ObjetoAntigo(CardTable cardTable, int address) {
        this.cardTable = cardTable;
        this.address = address;
    }

    public void atualizarReferencia(ObjetoReferencia novaReferencia) {
        this.referencia = novaReferencia;
        // Barra de gravação: marca a tabela de cartões como suja após a atualização do campo
        cardTable.markCardAsDirty(address);
    }

}
