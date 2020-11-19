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
    
    public void atacar(){

    }

    public void gerarInimigos(){
        int totalInimigos = inimigos.nextInt(5) + 1;
    }
   
    
}
