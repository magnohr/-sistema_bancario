package org.example;

import org.example.Model.*;
import org.example.Service.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BancoService bancoService = new BancoService();
        InvestimentoService investimentoService = new InvestimentoService();

        // Criar contas exemplo
        ContaCorrente cc = new ContaCorrente("Magno Henrique", "0001", 2.5);
        ContaPoupanca cp = new ContaPoupanca("Alice Silva", "0002");
        ContaInvestimento ci = new ContaInvestimento("Carlos Souza", "0003");

        boolean running = true;

        while (running) {
            System.out.println("\n=== Menu Banco POO ===");
            System.out.println("1 - Depositar em Conta Corrente");
            System.out.println("2 - Sacar da Conta Corrente");
            System.out.println("3 - Depositar em Conta Poupança");
            System.out.println("4 - Sacar da Conta Poupança");
            System.out.println("5 - Transferir da Conta Corrente para Poupança");
            System.out.println("6 - Aplicar investimento na Conta Investimento");
            System.out.println("7 - Listar investimentos Conta Investimento");
            System.out.println("8 - Mostrar saldo de todas as contas");
            System.out.println("9 - Mostrar histórico Conta Corrente");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Valor para depositar na Conta Corrente: ");
                    double valorDepCC = sc.nextDouble();
                    bancoService.depositar(cc, valorDepCC);
                    break;
                case 2:
                    System.out.print("Valor para sacar da Conta Corrente: ");
                    double valorSaqCC = sc.nextDouble();
                    bancoService.sacar(cc, valorSaqCC);
                    break;
                case 3:
                    System.out.print("Valor para depositar na Conta Poupança: ");
                    double valorDepCP = sc.nextDouble();
                    bancoService.depositar(cp, valorDepCP);
                    break;
                case 4:
                    System.out.print("Valor para sacar da Conta Poupança: ");
                    double valorSaqCP = sc.nextDouble();
                    bancoService.sacar(cp, valorSaqCP);
                    break;
                case 5:
                    System.out.print("Valor para transferir da Conta Corrente para Poupança: ");
                    double valorTransf = sc.nextDouble();
                    bancoService.transferir(cc, cp, valorTransf);
                    break;
                case 6:
                    System.out.print("Nome do investimento: ");
                    sc.nextLine(); // limpar buffer
                    String nomeInv = sc.nextLine();
                    System.out.print("Valor do investimento: ");
                    double valInv = sc.nextDouble();
                    System.out.print("Rendimento anual (ex: 0.08 para 8%): ");
                    double rendInv = sc.nextDouble();
                    investimentoService.aplicarInvestimento(ci, nomeInv, valInv, rendInv);
                    break;
                case 7:
                    investimentoService.listarInvestimentos(ci);
                    break;
                case 8:
                    bancoService.exibirSaldo(cc);
                    bancoService.exibirSaldo(cp);
                    bancoService.exibirSaldo(ci);
                    break;
                case 9:
                    bancoService.exibirHistorico(cc);
                    break;
                case 0:
                    running = false;
                    System.out.println("Saindo do sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}
