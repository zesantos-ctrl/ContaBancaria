package entities;

import minhaexcecao.SaldoInsuficiente;
import minhaexcecao.ValorInvalido;

public class Conta {

    private double saldo;

    private final Cliente cliente;

    private static int contador;
    private final int numero;

    public Conta(Cliente cliente, double saldo) {
        if (cliente == null) {
            throw new ValorInvalido("Cliente não encontrado.");
        }

        if (saldo < 0.0) {
            throw new ValorInvalido("Saldo não pode ser negativo!");
        }
        this.numero = contador;
        contador++;
        this.cliente = cliente;
        this.saldo = saldo;

    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new ValorInvalido("Valor inválido: deve ser maior que zero");
        }
        saldo += valor;
    }

    public void sacar(double valor) throws SaldoInsuficiente, ValorInvalido {
        if (valor <= 0) {
            throw new ValorInvalido("Valor invalido: deve ser maior que zero.");
        }
        if (valor > saldo) {
            throw new SaldoInsuficiente("Saque insuficiente para o saque!");
        }
        saldo -= valor;
    }

    @Override
    public String toString() {
        return "Conta  "
                + contador
                + " | "
                + cliente.getCpf()
                + " | Saldo: R$ "
                + String.format(" %.2f", saldo);
    }
}
