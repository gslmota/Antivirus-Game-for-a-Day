package game;
import java.util.Random;
import java.util.Scanner;
public class Turnos {
    protected int contadorCiclos = 0;
    Scanner input = new Scanner(System.in);
    Random sorteio = new Random();
    
    Inimigo[] vetInimigoP1 = new Inimigo[5];
    Inimigo[] vetInimigoP2 = new Inimigo[5];

    public int gerarInimigosP1(){
        int quantidadeDeInimigos = sorteio.nextInt(5) + 1;
        for(int i = 0; i < quantidadeDeInimigos; i ++){
            vetInimigoP1[i] = new Inimigo();
        }
        return quantidadeDeInimigos;
    }

    public int gerarInimigosP2(){
        int quantidadeDeInimigos = sorteio.nextInt(5) + 1;
        for(int i = 0; i < quantidadeDeInimigos; i ++){
            vetInimigoP2[i] = new Inimigo();
        }
        return quantidadeDeInimigos;
    }

    public Turnos() {
        
    }

}
