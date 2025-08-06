package org.example.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.Transacao;
import org.example.Model.TipoTransacao;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public abstract class Conta {
    protected String titular;
    protected String numero;
    protected double saldo;
    protected List<model.Transacao> historico = new ArrayList<>();

    public Conta(String titular, String numero) {
        this.titular = titular;
        this.numero = numero;
        this.saldo = 0.0;
    }

    public abstract void sacar(double valor);

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            historico.add(new model.Transacao(TipoTransacao.DEPOSITO, valor));
        }
    }

    public void transferir(Conta destino, double valor) {
        if (valor > 0 && saldo >= valor) {
            this.saldo -= valor;
            destino.saldo += valor;

            this.historico.add(new model.Transacao(TipoTransacao.TRANSFERENCIA, -valor));
            destino.historico.add(new Transacao(TipoTransacao.TRANSFERENCIA, valor));
        }
    }
}
