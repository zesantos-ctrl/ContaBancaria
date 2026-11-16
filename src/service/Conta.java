package service;

import minhaexcecao.MyException;
import minhaexcecao.SaldoInsuficiente;
import minhaexcecao.ValorInvalido;

public class Conta {

    private String nome;
    private double saldo;

    public Conta(String nome, double saldo) {
        if (saldo < 0.0) {
            throw new MyException("Saldo não pode ser negativo!");
        }
        this.nome = nome;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new MyException("Valor inválido: deve ser maior que zero");
        }
        saldo += valor;
    }

    public void sacar(double valor) throws SaldoInsuficiente, ValorInvalido{
        if (valor <= 0) {
            throw new ValorInvalido("Valor invalido: deve ser maior que zero e menor ou igual a saldo.");
        }
        if (valor > saldo) {
            throw new SaldoInsuficiente("Saque insuficiente para o saque!");
        }
        saldo -= valor;
    }

    @Override
    public String toString() {
        return "Conta [nome=" + nome + ", saldo=" + saldo + "]";
    }

    

}
