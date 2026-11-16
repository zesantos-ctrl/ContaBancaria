package ui;

import entities.Conta;
import minhaexcecao.MyException;

public class Menu {
    private Leitura leitura;
    private Conta conta;

    public Menu(Leitura leitura) {
        this.leitura = leitura;
    }

    public void iniciar() {
        int opcao;
        do {
            exibirMenu();
            opcao = leitura.lerOpcao();
            try {

                switch (opcao) {
                    case 1 -> criarConta();
                    case 2 -> depositar();
                    case 3 -> sacar();
                    case 4 -> mostrarSaldo();
                    case 0 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida.");
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }

        } while (opcao != 0);
    }

    private void criarConta() {
        if (conta != null) {
            System.out.println("Você já possui conta!");
            return;
        }
        String nome = leitura.leitorTexto("Digite seu nome: ");
        double saldoInicial = leitura.lerDecimal("Digite o saldo inicial: ");
        conta = new Conta(nome, saldoInicial);
        System.out.println("Conta criada com sucesso!");
    }

    private void depositar() {
        if (!temConta()) {
            return;
        }
        double valor = leitura.lerDecimal("Valor do deposito: ");
        conta.depositar(valor);
        System.out.println("Deposito feito com sucesso!");
    }

    private void sacar() {
        if (!temConta()) {
            return;
        }
        double valor = leitura.lerDecimal("Valor do saque: ");
        conta.sacar(valor);
        System.out.println("Saque feito com sucesso!");
    }

    private void mostrarSaldo() {
        if (!temConta()) {
            return;
        }
        System.out.println(conta.toString());
    }

    public boolean temConta() {
        if (conta == null) {
            System.out.println("Crie uma conta primeiro (Opção 1).");
            return false;
        }
        return true;
    }

    public void exibirMenu() {
        System.out.println("==== Menu ====");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Deposito");
        System.out.println("3 - Sacar");
        System.out.println("4 - Saldo");
        System.out.println("0 - Sair");

    }
}
