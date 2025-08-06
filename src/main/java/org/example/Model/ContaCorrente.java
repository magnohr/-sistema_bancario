package org.example.Model;

import lombok.Getter;
import lombok.ToString;
import org.example.Model.Conta;
import org.example.Model.TipoTransacao;

@Getter
@ToString(callSuper = true)
public class ContaCorrente extends Conta {
    private double taxaManutencao;

    public ContaCorrente(String titular, String numero, double taxaManutencao) {
        super(titular, numero);
        this.taxaManutencao = taxaManutencao;
    }

    @Override
    public void sacar(double valor) {
        double total = valor + taxaManutencao;
        if (valor > 0 && saldo >= total) {
            saldo -= total;
            historico.add(new model.Transacao(TipoTransacao.SAQUE, -total));
        }
    }
}
