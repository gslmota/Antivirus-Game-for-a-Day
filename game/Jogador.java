package game;
import java.util.Random;
public class Jogador {
    // Atributos
    protected String tipoJogador;
    protected int ATK, DEF;
    protected int numAcoes;

    // Métodos
    public Jogador(String tipoJogador) {
        this.tipoJogador = tipoJogador;
        this.numAcoes = 0;
        if(tipoJogador == "simples"){
            ATK = 2;
            DEF = 6;
        } else{
            ATK = 1;
            DEF = 7;
        }
    }
    public void atacar(){
        if(numAcoes < 2){
            numAcoes += 1;
        }

    }

    public void procurar(){
        Random res = new Random();
        int valor = res.nextInt(6) + 1;
        if(valor <= 3){
            if(numAcoes < 2){
                System.out.print("Nada foi encontrado no setor!");
                numAcoes += 1;
            }
        } else{
            if(numAcoes < 2){
                if(valor == 4){
                    // jogador 1 DEF +=1
                } else{
                    if(valor == 5){
                        // jogador2 DEF += 2
                    } else{
                        // inimigos perdem 1 de DEF
                    }
                }
                numAcoes += 1;
            }
        }
    }

    public void movimentar(){

    }

    public void recuperarDefesa(){

    }

    public void habilidadeEspecial(){
        
    }
}