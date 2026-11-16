package entities;

import minhaexcecao.ValorInvalido;

public class Cliente {

    private String cpf;
    private String nome;

    public Cliente(String cpf, String nome) {
        if (nome != null || cpf != null) {
            throw new ValorInvalido("");
        }
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

}
