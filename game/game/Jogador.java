package game;
import java.util.Random;
import java.util.Scanner;
public class Jogador {
    // Atributos
    protected String tipoJogador;
    protected int ATK, DEF;
    protected int numAcoes;
    protected int contadorCiclos = 0;
    Scanner input = new Scanner(System.in);

    // Métodos
    public Jogador(String tipoJogador) {
        this.tipoJogador = tipoJogador;
        this.numAcoes = 0;
        if(tipoJogador == "simples"){
            this.ATK = 2;
            this.DEF= 6;
        } else{
            this.ATK = 1;
            this.DEF = 7;
        }
    }

    public String getTipoJogador() {
        return tipoJogador;
    }

    public void setTipoJogador(String tipoJogador) {
        this.tipoJogador = tipoJogador;
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

    public int getNumAcoes() {
        return numAcoes;
    }

    public void setNumAcoes(int numAcoes) {
        this.numAcoes = numAcoes;
    }

    public int getContadorCiclos() {
        return contadorCiclos;
    }

    public void setContadorCiclos(int contadorCiclos) {
        this.contadorCiclos = contadorCiclos;
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

    public void recuperarDefesa(Jogador jogador){
        if(jogador.tipoJogador == "simples"){
            jogador.DEF += 2;
        } else {
            this.DEF += 2;
        }
    }

    public void habilidadeEspecial(){
        
    }

    public int[] coletarMovimento(int contadorCiclos){

        if(this.tipoJogador == "simples"){
            if(contadorCiclos<25){
                int posLin, posCol;
                System.out.println("");
                System.out.println("Digite a posição para onde o jogador 1 (PL1) deseja ir na ordem (linha/coluna): ");
                posLin = input.nextInt();
                posCol = input.nextInt();
                int vet[] = {posLin, posCol};
                return vet;
            } else{
    
                System.out.println("Você Já chegou no limite de 25 ciclos!");
                return null;
            }
        } else {
            if(contadorCiclos<25){

                int posLin, posCol;
                System.out.println("");
                System.out.println("Digite a posição para onde o jogador 2 (PL2) deseja ir na ordem (linha/coluna): ");
                posLin = input.nextInt();
                posCol = input.nextInt();
                int vet[] = {posLin, posCol};
                return vet;
            } else{
    
                System.out.println("Você Já chegou no limite de 25 ciclos!");
                return null;
            }
        }
        
    }

}