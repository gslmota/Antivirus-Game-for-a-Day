package game;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Jogador2 extends Jogador {
    // Atributos
    protected String tipoJogador;
    protected int numAcoes;
    protected int contadorCiclos = 0;
    int[] vetPosAtualP2 = {3,3};
    int[] vetPosFuturaP2 = new int[2];
    Scanner input = new Scanner(System.in);
    Random sort = new Random();

    // Métodos
    public Jogador2() {
        this.tipoJogador = "suporte";
        this.numAcoes = 0;
        this.ATK = 1;
        this.DEF = 7;
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


    public void atacar(Inimigo[] vetInimigoP2, int inimigo, int tipo){
        if(tipo == 1){
            int i = sort.nextInt(2);
            if(i == 0){
                vetInimigoP2[inimigo - 1].DEF -= this.ATK;
            } else {
                System.out.println("O vírus não foi eliminado pois não foi encontrada a posição exata!");
            }
        } else {
            vetInimigoP2[inimigo - 1].DEF -= this.ATK;
        }
        
    }

    public void procurar(Inimigo[] vetInimigoP2, int tamanho){
        Random res = new Random();
        int valor = res.nextInt(6) + 1;
        if(valor <= 3){
            System.out.print("\nNada foi encontrado no setor!\n");
        } else{
            if(valor == 4){
                // jogador 1 DEF +=1
                System.out.println("O jogador PL2 ganhou 1 de DEF");
                this.DEF += 1;
            } else{
                if(valor == 5){
                    // jogador2 DEF += 2
                    System.out.println("O jogador PL2 ganhou 2 de DEF");
                    this.DEF += 2;
                } else{
                    // inimigos perdem 1 de DEF
                    System.out.println("Os inimigos de PL2 perdem 1 de DEF");
                    for(int i = 0; i < tamanho; i ++){
                        vetInimigoP2[i].DEF -= 1;
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
            boolean repeat = true;
            do{
                try{
                    int posLin, posCol;
                    System.out.println("");
                    System.out.println("Digite o número da linha para onde o jogador 2 (PL2) deseja ir: ");
                    posLin = input.nextInt();
                    System.out.println("Digite o número da coluna para onde o jogador 2 (PL2) deseja ir: ");
                    posCol = input.nextInt();
                    int vet[] = {posLin, posCol};
                    repeat = false;
                    return vet;
                } catch(InputMismatchException e){
                    System.err.println(e);
                    System.out.println("Digite um valor inteiro!");
                    input.nextLine();
                }
            } while(repeat);
            return null;
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
        return null;
    }

    @Override
    public void procurar() {

    }

    @Override
    public void atacar() {

    }
    
}
