package game;
import java.util.Random;
import java.util.Scanner;
public class Jogador1 extends Jogador {
    // Atributos
    protected String tipoJogador;
    protected int numAcoes;
    protected int contadorCiclos = 0;
    Scanner input = new Scanner(System.in);

    // Métodos
    public Jogador1() {
        this.tipoJogador = "simples";
        this.numAcoes = 0;
        this.ATK = 2;
        this.DEF= 6;
    }

    public String getTipoJogador() {
        return tipoJogador;
    }

    public void setTipoJogador(String tipoJogador) {
        this.tipoJogador = tipoJogador;
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


    public void atacar(Inimigo[] vetInimigoP1, int inimigo){
        vetInimigoP1[inimigo - 1].DEF -= this.ATK;

    }

    public void procurar(Inimigo[] vetInimigoP1, int tamanho){
        Random res = new Random();
        int valor = res.nextInt(6) + 1;
        if(valor <= 3){
            System.out.print("\nNada foi encontrado no setor!\n");
        } else{
            if(valor == 4){
                // jogador 1 DEF +=1
                this.DEF += 1;
            } else{
                if(valor == 5){
                    // jogador2 DEF += 2
                    this.DEF += 2;
                } else{
                    // inimigos perdem 1 de DEF
                    for(int i = 0; i < tamanho; i ++){
                        vetInimigoP1[i].DEF -= 1;
                    }
                }
            }
        }
    }

    public void recuperarDefesa(Jogador1 jogador){
        if(jogador.tipoJogador == "simples"){
            jogador.DEF += 2;
        } else {
            this.DEF += 2;
        }
    }

    public int[] movimentar(int contadorCiclos){

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
    }

    public boolean verificaVida(){
        if(this.DEF <= 0){
            this.ATK = 0;
            this.DEF = 0;
            return false;
        }
        return true;
    }

    @Override
    public int[] movimentar() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void procurar() {
     
    }

    @Override
    public void atacar() {
        // TODO Auto-generated method stub

    }
}