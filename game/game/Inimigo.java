package game;
import java.util.Random;
public class Inimigo {
    // Atributos
    public int ATK, DEF;
    Random inimigos = new Random();
    // Metodos
    public Inimigo() {
        this.ATK = inimigos.nextInt(3) + 1;
        this.DEF = this.ATK;
    }
    
    public void atacar(Jogador1 jogador1){
        int ataque = inimigos.nextInt(6) + 1;
        if(ataque % 2 == 0){
            jogador1.DEF -= this.ATK;
        }
    }

    public void atacar(Jogador2 jogador2){

    }

}
