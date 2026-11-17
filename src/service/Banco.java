package service;

import java.util.ArrayList;
import java.util.List;

import entities.Cliente;
import entities.Conta;
import minhaexcecao.ContaNaoEncontrada;

public class Banco {

    private final List<Conta> contas = new ArrayList<>();

    public Conta criarConta(Cliente cliente, double saldoInicial) {
        Conta conta = new Conta(cliente, saldoInicial);
        contas.add(conta);

        return conta;
    }

    public Conta buscarPorNumero(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        throw new ContaNaoEncontrada("Conta " + numero + " não encontrada.");
    }

    public void depositar(int numero, double valor) {
        buscarPorNumero(numero).depositar(valor);
    }

    public void sacar(int numero, double valor) {
        buscarPorNumero(numero).sacar(valor);
    }

    public List<Conta> listarContas() {
        return List.copyOf(contas);
    }
}
