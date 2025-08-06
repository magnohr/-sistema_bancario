package org.example.Service;



import org.example.Model.Conta;

public class BancoService {

    public void sacar(Conta conta, double valor) {
        if (valor > 0) {
            conta.sacar(valor);
        } else {
            System.out.println("Valor inválido para saque.");
        }
    }

    public void depositar(Conta conta, double valor) {
        if (valor > 0) {
            conta.depositar(valor);
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public void transferir(Conta origem, Conta destino, double valor) {
        if (valor > 0) {
            origem.transferir(destino, valor);
        } else {
            System.out.println("Valor inválido para transferência.");
        }
    }

    public void exibirSaldo(Conta conta) {
        System.out.println("Saldo da conta " + conta.getNumero() + ": R$ " + String.format("%.2f", conta.getSaldo()));
    }

    public void exibirHistorico(Conta conta) {
        System.out.println("\nHistórico da conta " + conta.getNumero() + ":");
        conta.getHistorico().forEach(System.out::println);
    }
}
