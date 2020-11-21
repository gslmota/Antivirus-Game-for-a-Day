package game;
import java.util.Random;
import java.util.Scanner;
public class Turnos {
    protected int contadorCiclos = 0;
    Scanner input = new Scanner(System.in);
    Random sorteio = new Random();
    int quantidadeDeInimigos = sorteio.nextInt(3) + 1;
    Inimigo[] vetInimigo = new Inimigo[5];

    public void gerarInimigos(){
        for(int i = 0; i < 3; i ++){
            vetInimigo[i] = new Inimigo();
        }
    }

}
