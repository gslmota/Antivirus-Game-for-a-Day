package game;
import java.util.Random;
public class Inimigo {
    // Atributos
    int ATK, DEF;
    Random inimigos = new Random();
    // Metodos
    public Inimigo() {
        ATK = inimigos.nextInt(3) + 1;
        DEF = ATK;
    }
    
    public void atacar(Jogador1 jogador){
        int ataque = inimigos.nextInt(6) + 1;
        if(ataque % 2 == 0){
            jogador.DEF -= this.ATK;
        }
    }

}
