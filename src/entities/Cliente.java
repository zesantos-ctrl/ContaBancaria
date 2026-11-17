package entities;

import minhaexcecao.ValorInvalido;

public class Cliente {

    private final String cpf;
    private String nome;

    public Cliente(String cpf, String nome) {
        if (nome == null || nome.isBlank()) {
            throw new ValorInvalido("Nome inválido.");
        }
        if (cpf == null) {
            throw new ValorInvalido("CPF Inválido.");
        }
        String cpfLimpo = cpf.replaceAll("\\D", "");
        if (cpfLimpo.length() != 11) {
            throw new ValorInvalido("só pode número");
        }

        this.cpf = cpfLimpo;
        this.nome = nome.trim();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

}
