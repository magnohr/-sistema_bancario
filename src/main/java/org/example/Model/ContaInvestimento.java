package org.example.Model;


import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString(callSuper = true)
public class ContaInvestimento extends Conta {
    private List<Investimento> investimentos = new ArrayList<>();

    public ContaInvestimento(String titular, String numero) {
        super(titular, numero);
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            historico.add(new model.Transacao(TipoTransacao.SAQUE, -valor));
        }
    }

    public void aplicarInvestimento(String nome, double valor, double rendimentoAnual) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            Investimento inv = new Investimento(nome, valor, rendimentoAnual);
            investimentos.add(inv);
            historico.add(new model.Transacao(TipoTransacao.INVESTIMENTO, -valor));
        }
    }
}
