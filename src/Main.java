import java.util.Scanner;
import service.Banco;

import ui.Leitura;
import ui.Menu;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Leitura leitura = new Leitura(teclado);
        Banco banco = new Banco();
        Menu menu = new Menu(leitura, banco);

        menu.iniciar();

        teclado.close();
    }
}
