package ui;

import java.util.Scanner;
import minhaexcecao.ValorInvalido;

public class Leitura {

    private final Scanner teclado;

    public Leitura(Scanner teclado) {
        this.teclado = teclado;
    }

    public int lerOpcao() {
        try {
            return Integer.parseInt(teclado.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public double lerDecimal(String mensagem) {
        System.out.print(mensagem);
        String texto = teclado.nextLine().trim().replace(",", ".");
        try {
            return Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            throw new ValorInvalido("Digite apenas numeros.");
        }
    }

    public String leitorTexto(String mensagem) {
        System.out.print(mensagem);
        return teclado.nextLine().trim();
    }

    public int lerInteiro(String mensagem) {
        System.out.println(mensagem);
        try {
            return Integer.parseInt(teclado.nextLine().trim());
        } catch (NumberFormatException e) {
            throw  new ValorInvalido("Digite apenas numero.");
        }
    }
}
