package game;
public class Jogador {
    // Atributos
    protected String tipoJogador;
    protected int ATK, DEF;

    // Métodos
    public Jogador(String tipoJogador) {
        this.tipoJogador = tipoJogador;
        if(tipoJogador == "simples"){
            ATK = 2;
            DEF = 6;
        } else{
            ATK = 1;
            DEF = 7;
        }
    }
    public void atacar(){

    }

    public void procurar(){

    }

    public void movimentar(){

    }

    public void recuperarDefesa(){

    }
}