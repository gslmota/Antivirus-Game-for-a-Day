package game;

public abstract class Jogador {
    protected int ATK, DEF;

    public abstract void movimentar();
    public abstract void atacar();
    public abstract void procurar();

    public Jogador(int aTK, int dEF) {
        ATK = aTK;
        DEF = dEF;
    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int aTK) {
        ATK = aTK;
    }

    public int getDEF() {
        return DEF;
    }

    public void setDEF(int dEF) {
        DEF = dEF;
    }
    
}
