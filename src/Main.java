import java.util.Scanner;

import ui.Leitura;
import ui.Menu;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Leitura leitura = new Leitura(teclado);
        Menu menu = new Menu(leitura);

        menu.iniciar();

        teclado.close();
    }
}
