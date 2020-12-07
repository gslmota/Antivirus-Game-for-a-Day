package game;

public abstract class Jogador {
    protected int ATK, DEF;

    public abstract int [] movimentar();
    public abstract void atacar();
    public abstract void procurar();

    public Jogador() {
      
    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int atk) {
        ATK = atk;
    }

    public int getDEF() {
        return DEF;
    }

    public void setDEF(int def) {
        DEF = def;
    }
    
}
