package game;
import java.util.Random;
public class Inimigo {
    // Atributos
    int ATK, DEF;
    // Metodos
    public Inimigo() {
        Random virusPower = new Random();
        ATK = virusPower.nextInt(3) + 1;
        DEF = ATK;
    }
    
    public void atacar(){

    }

   
    
}
