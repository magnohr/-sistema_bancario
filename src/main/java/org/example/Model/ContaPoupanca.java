package org.example.Model;


import lombok.ToString;

@ToString(callSuper = true)
public class ContaPoupanca extends Conta {
    private double rendimentoMensal = 0.005; // 0,5% ao mês

    public ContaPoupanca(String titular, String numero) {
        super(titular, numero);
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            historico.add(new model.Transacao(TipoTransacao.SAQUE, -valor));
        }
    }

    public void aplicarRendimento() {
        double rendimento = saldo * rendimentoMensal;
        saldo += rendimento;
        historico.add(new model.Transacao(TipoTransacao.INVESTIMENTO, rendimento));
    }
}
