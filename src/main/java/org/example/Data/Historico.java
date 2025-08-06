package org.example.Data;

import model.Transacao;
import java.util.ArrayList;
import java.util.List;

public class Historico {

    private List<Transacao> transacoes;

    public Historico() {
        this.transacoes = new ArrayList<>();
    }

    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public List<Transacao> getTransacoes() {
        return new ArrayList<>(transacoes); // devolve cópia para evitar alterações externas
    }

    public void imprimirHistorico() {
        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação registrada.");
            return;
        }
        System.out.println("Histórico de Transações:");
        for (Transacao t : transacoes) {
            System.out.println(t);
        }
    }
}
