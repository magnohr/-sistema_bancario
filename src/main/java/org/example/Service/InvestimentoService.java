package org.example.Service;

import org.example.Model.ContaInvestimento;
import org.example.Model.Investimento;

import java.util.List;

public class InvestimentoService {

    // Aplica um novo investimento na conta
    public void aplicarInvestimento(ContaInvestimento conta, String nome, double valor, double rendimentoAnual) {
        if (valor > 0 && rendimentoAnual > 0) {
            conta.aplicarInvestimento(nome, valor, rendimentoAnual);
            System.out.println("Investimento aplicado com sucesso!");
        } else {
            System.out.println("Dados inválidos para investimento.");
        }
    }

    // Lista todos os investimentos da conta
    public void listarInvestimentos(ContaInvestimento conta) {
        List<Investimento> lista = conta.getInvestimentos();
        if (lista.isEmpty()) {
            System.out.println("Nenhum investimento realizado ainda.");
        } else {
            System.out.println("Investimentos da conta:");
            for (Investimento inv : lista) {
                System.out.println(inv);
            }
        }
    }

    // Simula o rendimento dos investimentos após um certo número de anos
    public void simularRendimento(ContaInvestimento conta, int anos) {
        System.out.println("\nSimulação de rendimentos em " + anos + " anos:");
        for (Investimento inv : conta.getInvestimentos()) {
            double valorFinal = inv.getValorAplicado() * Math.pow(1 + inv.getRendimentoAnual(), anos);
            System.out.printf("- %s: de R$%.2f para R$%.2f%n", inv.getNome(), inv.getValorAplicado(), valorFinal);
        }
    }
}
