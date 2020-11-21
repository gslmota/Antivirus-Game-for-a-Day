package game;
import java.util.Random;
import java.util.Scanner;
public class Turnos {
    protected int contadorCiclos = 0;
    Scanner input = new Scanner(System.in);
    Random sorteio = new Random();
    
    Inimigo[] vetInimigo = new Inimigo[5];

    public int gerarInimigos(){
        int quantidadeDeInimigos = sorteio.nextInt(3) + 1;
        for(int i = 0; i < quantidadeDeInimigos; i ++){
            vetInimigo[i] = new Inimigo();
        }
        return quantidadeDeInimigos;
    }

    public Turnos() {
        
    }

}
