package game;

import java.util.Random;
import java.util.Scanner;
public class Tabuleiro {

    Setor [] criaSetor = new Setor[5]; // Vetor de setor
    Setor position = new Setor();
    Random posicao = new Random(); // Aleatoriedade para posicionar o virus
    Turnos turno = new Turnos();
    Scanner input = new Scanner(System.in);
    public String [][] tabuleiro = new String[5][5]; // Cria a matriz 5 X 5
    public int posLinha = posicao.nextInt(5);
    public int posColuna = posicao.nextInt(5);
    public int contPorta = 0, contParede = 0;
    public int totalInimigosP1 = 0;
    public int totalInimigosP2 = 0;
    public boolean [][] movimentosP1 = new boolean [5][5];
    public boolean [][] movimentosP2 = new boolean [5][5];
    
    // Método para criar setores vazios
    public void gerarSetorVazio(){
        for(int i = 0; i < criaSetor.length; i++){
            criaSetor[i] = new Setor();
        }
    }

    public void gerarTabuleiroInicial() {

        String porta = "|"; // paredes/portas
        String [] vetorInicial = {"|", " ", " ", " ",porta, " ", " ", " ",porta, " ", " ", " ",porta, " ", " ", " ",porta, " ", " ", " ","|"}; // Vetor criado para gerar os setores do tabuleiro
        int contador = 0; // Contador usado durante o percorrimento dos setores
        
        System.out.println("-----------------------------");
        System.out.println("|    Antivírus por um dia    |");
        System.out.println("-----------------------------");
        System.out.println("       1   2   3   4   5      ");
       
        // Preenche a matriz cada posição da matriz com " - "
        for (int linha = 0; linha < tabuleiro.length; linha ++)  {  

            for (int coluna = 0; coluna < tabuleiro[linha].length; coluna ++)     { 
                tabuleiro[linha][coluna] = "-";
            }  
          } 
        
        // Percorre a matriz para criar o tabuleiro
        for (int linha = 0; linha < tabuleiro.length; linha ++)  {  

            System.out.print("     |"); // Cria a parede da esquerda do tabuleiro
            for (int coluna = 0; coluna < tabuleiro[linha].length; coluna ++){ 
                // Esse if gera o centro do tabuleiro
                if(coluna == 2 && linha == 2){
                    tabuleiro[2][2] = "*";
                    tabuleiro[3][2] = "*";
                }
                System.out.print("-" + tabuleiro[linha][coluna] + "-|"); // Gera as paredes internas do tabuleiro
                if(coluna == 4 && linha == 2){
                    System.out.print("    |             |");
                }
                if(coluna == 4 && linha == 3){
                    System.out.print("    *             *");
                }
                if(coluna == 4 && linha == 4){
                    System.out.print("    |  2/6    1/7 |");
                }
            }  
            System.out.println(" ");// Pula para próxima linha da matriz
            System.out.print(linha + 1 + "    ");// Gera o inicio da linha, o interior do tabuleiro
            for(int i = 0; i < vetorInicial.length; i++){
                // Esse IF gera o Centro do tabuleiro (* C *) e o posiciona o vírus
                if(contador == 2){// contador 2 porque é o centro do tabuleiro
                    if(contador == posLinha){
                        if(posColuna != 2){
                            // Tratamento para cada posição do X (virus) para posicionar na linha central
                            if(posColuna == 0){
                                String [] vetor = {"|", " ", "X", " ","|", " ", " ", " ","*", " ", "C", " ","*", " ", " ", " ","|", " ", " ", " ","|"};
                                System.out.print(vetor[i]);
                            }
                            if(posColuna == 1){
                                String [] vetor = {"|", " ", " ", " ","|", " ", "X", " ","*", " ", "C", " ","*", " ", " ", " ","|", " ", " ", " ","|"};
                                System.out.print(vetor[i]);
                            }
                            if(posColuna == 3){
                                String [] vetor = {"|", " ", " ", " ","|", " ", " ", " ","*", " ", "C", " ","*", " ", "X", " ","|", " ", " ", " ","|"};
                                System.out.print(vetor[i]);
                            }
                            if(posColuna == 4){
                                String [] vetor = {"|", " ", " ", " ","|", " ", " ", " ","*", " ", "C", " ","*", " ", " ", " ","|", " ", "X", " ","|"};
                                System.out.print(vetor[i]);
                            }
                        } else{
                            String [] vetor = {"|", " ", " ", " ","|", " ", " ", " ","*", " ", "C", " ","*", " ", " ", " ","|", " ", "X", " ","|"};
                            System.out.print(vetor[i]);
                        }
                    } else{
                        String [] vetor = {"|", " ", " ", " ","|", " ", " ", " ","*", " ", "C", " ","*", " ", " ", " ","|", " ", " ", " ","|"};
                        System.out.print(vetor[i]);
                    }   
                }
                else{
                    // Esse IF Posiciona o vírus (X) em posições que não estejam relacionadas a linha do meio da matriz 
                    if(contador == posLinha){
                        if(posColuna == 0){
                            String [] vetor = {"|", " ", "X", " ","|", " ", " ", " ","|", " ", " ", " ","|", " ", " ", " ","|", " ", " ", " ","|"};
                            System.out.print(vetor[i]);
                        }
                        if(posColuna == 1){
                            String [] vetor = {"|", " ", " ", " ","|", " ", "X", " ","|", " ", " ", " ","|", " ", " ", " ","|", " ", " ", " ","|"};
                            System.out.print(vetor[i]);
                        }
                        if(posColuna == 2){
                            String [] vetor = {"|", " ", " ", " ","|", " ", " ", " ","|", " ", "X", " ","|", " ", " ", " ","|", " ", " ", " ","|"};
                            System.out.print(vetor[i]);
                        }
                        if(posColuna == 3){
                            String [] vetor = {"|", " ", " ", " ","|", " ", " ", " ","|", " ", " ", " ","|", " ", "X", " ","|", " ", " ", " ","|"};
                            System.out.print(vetor[i]);
                        }
                        if(posColuna == 4){
                            String [] vetor = {"|", " ", " ", " ","|", " ", " ", " ","|", " ", " ", " ","|", " ", " ", " ","|", " ", "X", " ","|"};
                            System.out.print(vetor[i]);
                        }
                    }
                    else{
                        System.out.print(vetorInicial[i]);
                    }
                }
            }
            // Abaixo é criada caixa de informações que fica ao lado do tabuleiro
            if(contador == 0){
                System.out.print("      Setor [3,3]");
            } else{
                if(contador == 1 || contador ==4){
                    System.out.print("    |------*------|");
                } else{
                    if(linha == 2){
                        System.out.print("    |             |");
                    }
                    else{
                        if(linha == 3){
                            System.out.print("    |  PL1    PL2 |");
                        }
                    }
                }
            }
           System.out.println(""); //muda de linha
           contador ++;
        }
        System.out.print("     |---|---|---|---|---|\n\n"); // Cria a parede inferior do tabuleiro
    }
    // Método para apagar a exibição no terminal
    public void apagarTela(){
        for(int i = 0; i<=50; i++){
            System.out.println("");
        }
    }
    // Método para gerar tabuleiro de jogo
    public void gerarTabuleiroDeJogo(){

        gerarSetorVazio();
        // Preenche a matriz cada posição da matriz com " - "
        for (int linha = 0; linha < tabuleiro.length; linha ++)  {  

            for (int coluna = 0; coluna < tabuleiro[linha].length; coluna ++)     { 
                tabuleiro[linha][coluna] = "-";
            }  
        } 

         // Percorre a matriz para criar o tabuleiro
        for (int linha = 0; linha < tabuleiro.length; linha ++)  {  

            for (int coluna = 0; coluna < tabuleiro[linha].length; coluna ++){ 
                // Esse if gera o centro do tabuleiro
                if(coluna == 2 && linha == 2){
                    tabuleiro[2][2] = "*";
                    tabuleiro[3][2] = "*";
                }
            }  
            
            // Gera o interior do setor
            for(int vet = 0; vet < criaSetor[linha].vetorSetor.length; vet ++){

                if(linha == 2){
                    // Gera o centro do tabuleiro
                    criaSetor[linha].vetorSetor[8] = "*";
                    criaSetor[linha].vetorSetor[12] = "*";
                    criaSetor[linha].vetorSetor[10] = "C";
                }

                if(linha == posLinha){
                    if(posColuna == 0){
                        criaSetor[linha].vetorSetor[2] = "X";
                    } else {
                        if(posColuna == 1){
                            criaSetor[linha].vetorSetor[6] = "X";
                        } else {
                            if(posColuna == 2){
                                if(posColuna == posLinha){
                                    criaSetor[linha].vetorSetor[18] = "X";
                                    posColuna = 4;
                                    posLinha = 2;
                                } else {
                                    criaSetor[linha].vetorSetor[10] = "X";
                                }
                                
                            } else {
                                if(posColuna == 3){
                                    criaSetor[linha].vetorSetor[14] = "X";
                                } else {
                                    criaSetor[linha].vetorSetor[18] = "X";
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void printarTabuleiro(Jogador1 jogador1, Jogador2 jogador2, int cont){

        //apagarTela();
        System.out.println("");
        System.out.println("-----------------------------");
        System.out.println("|    Antivírus por um dia    |");
        System.out.println("-----------------------------");
        System.out.println("       1   2   3   4   5      ");

        // Percorre a matriz para criar o tabuleiro
        for (int linha = 0; linha < tabuleiro.length; linha ++)  {  

            System.out.print("     |"); // Cria a parede da esquerda do tabuleiro
            for (int coluna = 0; coluna < tabuleiro[linha].length; coluna ++){ 
                
                System.out.print("-" + tabuleiro[linha][coluna] + "-|"); // Gera as paredes internas do tabuleiro

                if(coluna == 4 && linha == 2){
                    if(this.totalInimigosP1 == 0 && this.totalInimigosP2 == 0){
                        System.out.print("    |             |" + "    |             |");
                    } else {
                        if(this.totalInimigosP1 == 0 && this.totalInimigosP2 == 1){
                            System.out.print("    |             |" + "    | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + "         |");
                        } 
                        if(this.totalInimigosP1 == 0 && this.totalInimigosP2 == 2){
                            System.out.print("    |             |" + "    | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + " " + turno.vetInimigoP2[1].ATK + "/" + turno.vetInimigoP2[1].DEF + "     |");
                        }
                        if(this.totalInimigosP1 == 0 && this.totalInimigosP2 == 3){
                            System.out.print("    |             |" + "    | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + " " + turno.vetInimigoP2[1].ATK + "/" + turno.vetInimigoP2[1].DEF + " " +  turno.vetInimigoP2[2].ATK + "/" + turno.vetInimigoP2[2].DEF + " |");
                        }
                        if(this.totalInimigosP1 == 0 && this.totalInimigosP2 == 4){
                            System.out.print("    |             |" +  "    | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + " " + turno.vetInimigoP2[1].ATK + "/" + turno.vetInimigoP2[1].DEF + " " +  turno.vetInimigoP2[2].ATK + "/" + turno.vetInimigoP2[2].DEF + " |");
                        }
                        if(this.totalInimigosP1 == 0 && this.totalInimigosP2 == 5){
                            System.out.print("    |             |" +"    | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + " " + turno.vetInimigoP2[1].ATK + "/" + turno.vetInimigoP2[1].DEF + " " +  turno.vetInimigoP2[2].ATK + "/" + turno.vetInimigoP2[2].DEF + " |");
                        }
                        else{
                            if(this.totalInimigosP1 == 1 && this.totalInimigosP2 == 0){
                                System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + "         |" + "    |             |");
                            } else {
                                if(this.totalInimigosP1 == 1 && this.totalInimigosP2 == 1){
                                    System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + "         |" + "    | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + "         |");
                                }
                                if(this.totalInimigosP1 == 1 && this.totalInimigosP2 == 2){
                                    System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + "         |" + "    | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + " " + turno.vetInimigoP2[1].ATK + "/" + turno.vetInimigoP2[1].DEF + "     |");
                                }
                                if(this.totalInimigosP1 == 1 && this.totalInimigosP2 == 3){
                                    System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + "         |" + "    | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + " " + turno.vetInimigoP2[1].ATK + "/" + turno.vetInimigoP2[1].DEF + " " +  turno.vetInimigoP2[2].ATK + "/" + turno.vetInimigoP2[2].DEF + " |");
                                }
                                if(this.totalInimigosP1 == 1 && this.totalInimigosP2 == 4){
                                    System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + "         |" + "    | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + " " + turno.vetInimigoP2[1].ATK + "/" + turno.vetInimigoP2[1].DEF + " " +  turno.vetInimigoP2[2].ATK + "/" + turno.vetInimigoP2[2].DEF + " |");
                                }
                                if(this.totalInimigosP1 == 1 && this.totalInimigosP2 == 5){
                                    System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + "         |" + "    | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + " " + turno.vetInimigoP2[1].ATK + "/" + turno.vetInimigoP2[1].DEF + " " +  turno.vetInimigoP2[2].ATK + "/" + turno.vetInimigoP2[2].DEF + " |");
                                }
    
                                if(this.totalInimigosP1 == 2 && this.totalInimigosP2 == 0){
                                    System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + " " + turno.vetInimigoP1[1].ATK + "/" + turno.vetInimigoP1[1].DEF + "     |" + "    |             |");
                                } else {
                                    if(this.totalInimigosP1 == 2 && this.totalInimigosP2 == 1){
                                        System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + " " + turno.vetInimigoP1[1].ATK + "/" + turno.vetInimigoP1[1].DEF + "     |" + "    | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + "         |");
                                    }
                                    if(this.totalInimigosP1 == 2 && this.totalInimigosP2 == 2){
                                        System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + " " + turno.vetInimigoP1[1].ATK + "/" + turno.vetInimigoP1[1].DEF + "     |" + "    | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + " " + turno.vetInimigoP2[1].ATK + "/" + turno.vetInimigoP2[1].DEF + "     |");
                                    }
                                    if(this.totalInimigosP1 == 2 && this.totalInimigosP2 == 3){
                                        System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + " " + turno.vetInimigoP1[1].ATK + "/" + turno.vetInimigoP1[1].DEF + "     |" + "    | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + " " + turno.vetInimigoP2[1].ATK + "/" + turno.vetInimigoP2[1].DEF + " " +  turno.vetInimigoP2[2].ATK + "/" + turno.vetInimigoP2[2].DEF + " |");
                                    }
                                    if(this.totalInimigosP1 == 2 && this.totalInimigosP2 == 4){
                                        System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + " " + turno.vetInimigoP1[1].ATK + "/" + turno.vetInimigoP1[1].DEF + "     |" + "    | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + " " + turno.vetInimigoP2[1].ATK + "/" + turno.vetInimigoP2[1].DEF + " " +  turno.vetInimigoP2[2].ATK + "/" + turno.vetInimigoP2[2].DEF + " |");
                                    }
                                    if(this.totalInimigosP1 == 2 && this.totalInimigosP2 == 5) {
                                        System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + " " + turno.vetInimigoP1[1].ATK + "/" + turno.vetInimigoP1[1].DEF + "     |" + "    | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + " " + turno.vetInimigoP2[1].ATK + "/" + turno.vetInimigoP2[1].DEF + " " +  turno.vetInimigoP2[2].ATK + "/" + turno.vetInimigoP2[2].DEF + " |");
                                    }
    
                                    if(this.totalInimigosP1 == 3 && this.totalInimigosP2 == 0){
                                        System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + " " + turno.vetInimigoP1[1].ATK + "/" + turno.vetInimigoP1[1].DEF + " " +  turno.vetInimigoP1[2].ATK + "/" + turno.vetInimigoP1[2].DEF + " |" + "    |             |");
                                    } else {
                                        if(this.totalInimigosP1 == 3 && this.totalInimigosP2 == 1){
                                            System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + " " + turno.vetInimigoP1[1].ATK + "/" + turno.vetInimigoP1[1].DEF + " " +  turno.vetInimigoP1[2].ATK + "/" + turno.vetInimigoP1[2].DEF + " |" + "    | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + "         |");
                                        }
                                        if(this.totalInimigosP1 == 3 && this.totalInimigosP2 == 2){
                                            System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + " " + turno.vetInimigoP1[1].ATK + "/" + turno.vetInimigoP1[1].DEF + " " +  turno.vetInimigoP1[2].ATK + "/" + turno.vetInimigoP1[2].DEF + " |" + "    | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + " " + turno.vetInimigoP2[1].ATK + "/" + turno.vetInimigoP2[1].DEF + "     |");
                                        }
                                        if(this.totalInimigosP1 == 3 && this.totalInimigosP2 == 3){
                                            System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + " " + turno.vetInimigoP1[1].ATK + "/" + turno.vetInimigoP1[1].DEF + " " +  turno.vetInimigoP1[2].ATK + "/" + turno.vetInimigoP1[2].DEF + " |" + "    | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + " " + turno.vetInimigoP2[1].ATK + "/" + turno.vetInimigoP2[1].DEF + " " +  turno.vetInimigoP2[2].ATK + "/" + turno.vetInimigoP2[2].DEF + " |");
    
                                        }
                                        if(this.totalInimigosP1 == 3 && this.totalInimigosP2 == 4){
                                            System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + " " + turno.vetInimigoP1[1].ATK + "/" + turno.vetInimigoP1[1].DEF + " " +  turno.vetInimigoP1[2].ATK + "/" + turno.vetInimigoP1[2].DEF + " |" + "    | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + " " + turno.vetInimigoP2[1].ATK + "/" + turno.vetInimigoP2[1].DEF + " " +  turno.vetInimigoP2[2].ATK + "/" + turno.vetInimigoP2[2].DEF + " |");
                                        }
                                        if(this.totalInimigosP1 == 3 && this.totalInimigosP2 == 5){
                                            System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + " " + turno.vetInimigoP1[1].ATK + "/" + turno.vetInimigoP1[1].DEF + " " +  turno.vetInimigoP1[2].ATK + "/" + turno.vetInimigoP1[2].DEF + " |" + "    | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + " " + turno.vetInimigoP2[1].ATK + "/" + turno.vetInimigoP2[1].DEF + " " +  turno.vetInimigoP2[2].ATK + "/" + turno.vetInimigoP2[2].DEF + " |");
                                        }
    
                                        if(this.totalInimigosP1 == 4 && this.totalInimigosP2 == 0){
                                            System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + " " + turno.vetInimigoP1[1].ATK + "/" + turno.vetInimigoP1[1].DEF + " " +  turno.vetInimigoP1[2].ATK + "/" + turno.vetInimigoP1[2].DEF + " |" + "    |             |");
                                        } else {
                                            if(this.totalInimigosP1 == 4 && this.totalInimigosP2 == 1){
                                                System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + " " + turno.vetInimigoP1[1].ATK + "/" + turno.vetInimigoP1[1].DEF + " " +  turno.vetInimigoP1[2].ATK + "/" + turno.vetInimigoP1[2].DEF + " |" + "    | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + "         |");
                                            }
                                            if(this.totalInimigosP1 == 4 && this.totalInimigosP2 == 2){
                                                System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + " " + turno.vetInimigoP1[1].ATK + "/" + turno.vetInimigoP1[1].DEF + " " +  turno.vetInimigoP1[2].ATK + "/" + turno.vetInimigoP1[2].DEF + " |" + "    | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + " " + turno.vetInimigoP2[1].ATK + "/" + turno.vetInimigoP2[1].DEF + "     |");
                                            }
                                            if(this.totalInimigosP1 == 4 && this.totalInimigosP2 == 3){
                                                System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + " " + turno.vetInimigoP1[1].ATK + "/" + turno.vetInimigoP1[1].DEF + " " +  turno.vetInimigoP1[2].ATK + "/" + turno.vetInimigoP1[2].DEF + " |" +  "    | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + " " + turno.vetInimigoP2[1].ATK + "/" + turno.vetInimigoP2[1].DEF + " " +  turno.vetInimigoP2[2].ATK + "/" + turno.vetInimigoP2[2].DEF + " |");
                                            }
                                            if(this.totalInimigosP1 == 4 && this.totalInimigosP2 == 4){
                                                System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + " " + turno.vetInimigoP1[1].ATK + "/" + turno.vetInimigoP1[1].DEF + " " +  turno.vetInimigoP1[2].ATK + "/" + turno.vetInimigoP1[2].DEF + " |" +  "    | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + " " + turno.vetInimigoP2[1].ATK + "/" + turno.vetInimigoP2[1].DEF + " " +  turno.vetInimigoP2[2].ATK + "/" + turno.vetInimigoP2[2].DEF + " |");
                                            }
                                            if(this.totalInimigosP1 == 4 && this.totalInimigosP2 == 5){
                                                System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + " " + turno.vetInimigoP1[1].ATK + "/" + turno.vetInimigoP1[1].DEF + " " +  turno.vetInimigoP1[2].ATK + "/" + turno.vetInimigoP1[2].DEF + " |" +  "    | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + " " + turno.vetInimigoP2[1].ATK + "/" + turno.vetInimigoP2[1].DEF + " " +  turno.vetInimigoP2[2].ATK + "/" + turno.vetInimigoP2[2].DEF + " |");
                                            }
    
                                            if(this.totalInimigosP1 == 5 && this.totalInimigosP2 == 0){
                                                System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + " " + turno.vetInimigoP1[1].ATK + "/" + turno.vetInimigoP1[1].DEF + " " +  turno.vetInimigoP1[2].ATK + "/" + turno.vetInimigoP1[2].DEF + " |" + "    |             |");
                                            } else {
                                                if(this.totalInimigosP1 == 5 && this.totalInimigosP2 == 1){
                                                    System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + " " + turno.vetInimigoP1[1].ATK + "/" + turno.vetInimigoP1[1].DEF + " " +  turno.vetInimigoP1[2].ATK + "/" + turno.vetInimigoP1[2].DEF + "      | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + "         |");
                                                }
                                                if(this.totalInimigosP1 == 5 && this.totalInimigosP2 == 2){
                                                    System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + " " + turno.vetInimigoP1[1].ATK + "/" + turno.vetInimigoP1[1].DEF + " " +  turno.vetInimigoP1[2].ATK + "/" + turno.vetInimigoP1[2].DEF + "      | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + " " + turno.vetInimigoP2[1].ATK + "/" + turno.vetInimigoP2[1].DEF + "     |");
                                                }
                                                if(this.totalInimigosP1 == 5 && this.totalInimigosP2 == 3){
                                                    System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + " " + turno.vetInimigoP1[1].ATK + "/" + turno.vetInimigoP1[1].DEF + " " +  turno.vetInimigoP1[2].ATK + "/" + turno.vetInimigoP1[2].DEF + "      | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + " " + turno.vetInimigoP2[1].ATK + "/" + turno.vetInimigoP2[1].DEF + " " +  turno.vetInimigoP2[2].ATK + "/" + turno.vetInimigoP2[2].DEF + " |");
                                                }
                                                if(this.totalInimigosP1 == 5 && this.totalInimigosP2 == 4){
                                                    System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + " " + turno.vetInimigoP1[1].ATK + "/" + turno.vetInimigoP1[1].DEF + " " +  turno.vetInimigoP1[2].ATK + "/" + turno.vetInimigoP1[2].DEF + "      | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + " " + turno.vetInimigoP2[1].ATK + "/" + turno.vetInimigoP2[1].DEF + " " +  turno.vetInimigoP2[2].ATK + "/" + turno.vetInimigoP2[2].DEF + " |");
                                                }
                                                if(this.totalInimigosP1 == 5 && this.totalInimigosP2 == 5){
                                                    System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + " " + turno.vetInimigoP1[1].ATK + "/" + turno.vetInimigoP1[1].DEF + " " +  turno.vetInimigoP1[2].ATK + "/" + turno.vetInimigoP1[2].DEF + "      | " + turno.vetInimigoP2[0].ATK + "/" + turno.vetInimigoP2[0].DEF + " " + turno.vetInimigoP2[1].ATK + "/" + turno.vetInimigoP2[1].DEF + " " +  turno.vetInimigoP2[2].ATK + "/" + turno.vetInimigoP2[2].DEF + " |");
                                                }
                                            }
                                        }
                                        
                                    }
                                }
                            }
                        }
                    }
                }
                if(coluna == 4 && linha == 3){
                    System.out.print("    *             *" + "    *             *");
                }
                if(coluna == 4 && linha == 4){
                    System.out.print("    |     " + jogador1.ATK + "/" + jogador1.DEF + "     |" + "    |     " + jogador2.ATK + "/" + jogador2.DEF + "     |");
                }
            }  
            System.out.println(" ");// Pula para próxima linha da matriz
            System.out.print(linha + 1 + "    ");// Gera o inicio da linha, o interior do tabuleiro

            // Gera o interior do setor
            for(int vet = 0; vet < criaSetor[linha].vetorSetor.length; vet ++){

                System.out.print(criaSetor[linha].vetorSetor[vet]);
            }
            if(linha == 0){
                System.out.print("      Setor [" + position.posSetor1[0] + "," + position.posSetor1[1] + "]" + "        Setor [" + position.posSetor2[0] + "," + position.posSetor2[1] + "]");
            }
            if(linha == 1 || linha ==4){
                System.out.print("    |------*------|" + "    |------*------|");
            } else{
                if(linha == 2){
                    if(this.totalInimigosP1 < 4 && this.totalInimigosP2 < 4){
                        System.out.print("    |             |" + "    |             |");
                    }
                    
                    if(this.totalInimigosP1 < 4 && this.totalInimigosP2 == 4){
                        System.out.print("    |             |" + "    |   " + turno.vetInimigoP2[3].ATK + "/" + turno.vetInimigoP2[3].DEF + "       |");
                    }

                    if(this.totalInimigosP1 < 4 && this.totalInimigosP2 == 5){
                        System.out.print("    |             |" + "    |   " + turno.vetInimigoP2[3].ATK + "/" + turno.vetInimigoP2[3].DEF + " " + turno.vetInimigoP2[4].ATK + "/" + turno.vetInimigoP2[4].DEF + "   |");
                    }else {
                        if(this.totalInimigosP1 == 4 && this.totalInimigosP2 < 4){
                            System.out.print("    |   " + turno.vetInimigoP1[3].ATK + "/" + turno.vetInimigoP1[3].DEF + "       |"  + "    |             |");
                        } else {
                            if(this.totalInimigosP1 == 4 && this.totalInimigosP2 == 4){
                                System.out.print("    |   " + turno.vetInimigoP1[3].ATK + "/" + turno.vetInimigoP1[3].DEF + "       |"  + "    |   " +turno.vetInimigoP2[3].ATK + "/" + turno.vetInimigoP2[3].DEF + "       |");
                            }

                            if(this.totalInimigosP1 == 4 && this.totalInimigosP2 == 5){
                                System.out.print("    |   " + turno.vetInimigoP1[3].ATK + "/" + turno.vetInimigoP1[3].DEF + "       |"  + "    |   " + turno.vetInimigoP2[3].ATK + "/" + turno.vetInimigoP2[3].DEF + " " + turno.vetInimigoP2[4].ATK + "/" + turno.vetInimigoP2[4].DEF + "   |");
                            }
                            if(this.totalInimigosP1 == 5 && this.totalInimigosP2 < 4){
                                System.out.print("    |   " + turno.vetInimigoP1[3].ATK + "/" + turno.vetInimigoP1[3].DEF + " " + turno.vetInimigoP1[4].ATK + "/" + turno.vetInimigoP1[4].DEF + "   |" + "    |             |");
                            } else {
                                if(this.totalInimigosP1 == 5 && this.totalInimigosP2 == 4){
                                    System.out.print("    |   " + turno.vetInimigoP1[3].ATK + "/" + turno.vetInimigoP1[3].DEF + " " + turno.vetInimigoP1[4].ATK + "/" + turno.vetInimigoP1[4].DEF + "   |" + "    |   " + turno.vetInimigoP2[3].ATK + "/" + turno.vetInimigoP2[3].DEF + "       |");
                                }
                                if(this.totalInimigosP1 == 5 && this.totalInimigosP2 == 5) {
                                    System.out.print("    |   " + turno.vetInimigoP1[3].ATK + "/" + turno.vetInimigoP1[3].DEF + " " + turno.vetInimigoP1[4].ATK + "/" + turno.vetInimigoP1[4].DEF + "   |" + "    |   " + turno.vetInimigoP2[3].ATK + "/" + turno.vetInimigoP2[3].DEF + " " + turno.vetInimigoP2[4].ATK + "/" + turno.vetInimigoP2[4].DEF + "   |");
                                }
                            }
                        }
                    }
                }
                else{
                    if(linha == 3){
                        System.out.print("    |     PL1     |" + "    |     PL2     |");
                    }
                }
            }
           System.out.println(""); //muda de linha
        }
        System.out.print("     |---|---|---|---|---|\n\n"); // Cria a parede inferior do tabuleiro
    }

    public void printarTabuleiro(Jogador1 jogador1, Jogador2 jogador2){
        //apagarTela();
        System.out.println("");
        System.out.println("-----------------------------");
        System.out.println("|    Antivírus por um dia    |");
        System.out.println("-----------------------------");
        System.out.println("       1   2   3   4   5      ");

        // Percorre a matriz para criar o tabuleiro
        for (int linha = 0; linha < tabuleiro.length; linha ++)  {  

            System.out.print("     |"); // Cria a parede da esquerda do tabuleiro
            for (int coluna = 0; coluna < tabuleiro[linha].length; coluna ++){ 
                
                System.out.print("-" + tabuleiro[linha][coluna] + "-|"); // Gera as paredes internas do tabuleiro

                if(coluna == 4 && linha == 2){
                    if(this.totalInimigosP1 == 0){
                        System.out.print("    |             |");
                    } else {
                        if(this.totalInimigosP1 == 1){
                            System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + "         |");
                        } else {
                            if(this.totalInimigosP1 == 2){
                                System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + " " + turno.vetInimigoP1[1].ATK + "/" + turno.vetInimigoP1[1].DEF + "     |");
                            } else {
                                if(this.totalInimigosP1 == 3){
                                    System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + " " + turno.vetInimigoP1[1].ATK + "/" + turno.vetInimigoP1[1].DEF + " " +  turno.vetInimigoP1[2].ATK + "/" + turno.vetInimigoP1[2].DEF + " |");
                                } else {
                                    if(this.totalInimigosP1 == 4){
                                        System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + " " + turno.vetInimigoP1[1].ATK + "/" + turno.vetInimigoP1[1].DEF + " " +  turno.vetInimigoP1[2].ATK + "/" + turno.vetInimigoP1[2].DEF + " |");
                                    } else {
                                        if(this.totalInimigosP1 == 5){
                                            System.out.print("    | " + turno.vetInimigoP1[0].ATK + "/" + turno.vetInimigoP1[0].DEF + " " + turno.vetInimigoP1[1].ATK + "/" + turno.vetInimigoP1[1].DEF + " " +  turno.vetInimigoP1[2].ATK + "/" + turno.vetInimigoP1[2].DEF + " |" );
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if(coluna == 4 && linha == 3){
                    System.out.print("    *             *");
                }
                if(coluna == 4 && linha == 4){
                    System.out.print("    |  " + jogador1.ATK + "/" + jogador1.DEF +"    " + jogador2.ATK + "/" + jogador2.DEF + " |");
                }
            }  
            System.out.println(" ");// Pula para próxima linha da matriz
            System.out.print(linha + 1 + "    ");// Gera o inicio da linha, o interior do tabuleiro

            // Gera o interior do setor
            for(int vet = 0; vet < criaSetor[linha].vetorSetor.length; vet ++){

                System.out.print(criaSetor[linha].vetorSetor[vet]);
            }
            if(linha == 0){
                System.out.print("      Setor [" + position.posSetor2[0] + "," + position.posSetor2[1] + "]");
            }
            if(linha == 1 || linha ==4){
                System.out.print("    |------*------|");
            } else{
                if(linha == 2){
                    if(this.totalInimigosP1 < 4){
                        System.out.print("    |             |");
                    } else {
                        if(this.totalInimigosP1 == 4){
                            System.out.print("    |   " + turno.vetInimigoP1[3].ATK + "/" + turno.vetInimigoP1[3].DEF + "       |");
                        } else {
                            if(this.totalInimigosP1 == 5){
                                System.out.print("    |   " + turno.vetInimigoP1[3].ATK + "/" + turno.vetInimigoP1[3].DEF + " " + turno.vetInimigoP1[4].ATK + "/" + turno.vetInimigoP1[4].DEF + "   |");
                            }
                        }
                    }
                }
                else{
                    if(linha == 3){
                        System.out.print("    |  PL1    PL2 |");
                    }
                }
            }
           System.out.println(""); //muda de linha
        }
        System.out.print("     |---|---|---|---|---|\n\n"); // Cria a parede inferior do tabuleiro
    }

    public void alterarSetor(int[] posicoes, String jogador){
        
        // Percorre a matriz para criar o tabuleiro
        for (int linha = 0; linha < tabuleiro.length; linha ++)  {  

            for (int coluna = 0; coluna < tabuleiro[linha].length; coluna ++){ 
                // Esse for serve para modificar a matriz
                if(jogador == "P1"){

                    if(linha == posicoes[0] - 1 && coluna == posicoes[1] - 1){
                        if(linha != 2 || coluna != 2){
                            if(coluna == 0){
                                criaSetor[linha].vetorSetor[coluna + 1] = "P";
                                criaSetor[linha].vetorSetor[coluna + 2] = "L";
                                criaSetor[linha].vetorSetor[coluna + 3] = "1";
                                position.posSetor1[0] = posicoes[0];
                                position.posSetor1[1] = posicoes[1];
                            } else {
                                if(coluna == 1){
                                    criaSetor[linha].vetorSetor[coluna + 4] = "P";
                                    criaSetor[linha].vetorSetor[coluna + 5] = "L";
                                    criaSetor[linha].vetorSetor[coluna + 6] = "1";
                                    position.posSetor1[0] = posicoes[0];
                                    position.posSetor1[1] = posicoes[1];

                                } else {
                                    if(coluna == 2){
                                        criaSetor[linha].vetorSetor[coluna + 7] = "P";
                                        criaSetor[linha].vetorSetor[coluna + 8] = "L";
                                        criaSetor[linha].vetorSetor[coluna + 9] = "1";
                                        position.posSetor1[0] = posicoes[0];
                                        position.posSetor1[1] = posicoes[1];
    
                                    } else {
                                        if(coluna == 3){
                                            /*
                                            String vet[] = criaSetor[linha].getVetorSetor();
                                            vet[coluna+10] = "D";
                                            vet[coluna+11] = "E";
                                            vet[coluna+12] = "U";                                criaSetor[linha].setVetorSetor(vet);
                                            position.posSetor1[0] = posicoes[0];
                                            position.posSetor1[1] = posicoes[1];
                                            */
                                            criaSetor[linha].vetorSetor[coluna + 10] = "P";
                                            criaSetor[linha].vetorSetor[coluna + 11] = "L";
                                            criaSetor[linha].vetorSetor[coluna + 12] = "1";
                                            position.posSetor1[0] = posicoes[0];
                                            position.posSetor1[1] = posicoes[1];
        
                                            
                                        } else {
                                            if(coluna == 4){
                                                criaSetor[linha].vetorSetor[coluna + 13] = "P";
                                                criaSetor[linha].vetorSetor[coluna + 14] = "L";
                                                criaSetor[linha].vetorSetor[coluna + 15] = "1";
                                                position.posSetor1[0] = posicoes[0];
                                                position.posSetor1[1] = posicoes[1];
            
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            System.out.println("\nVocê retornou a posição central!\n");
                            System.out.println("\nNão é mostrado o jogador na posição central!\n");
                            position.posSetor1[0] = 3;
                            position.posSetor1[1] = 3;
                            this.totalInimigosP1 = 0;
                        }
                    }
                } else {
                    if(jogador == "P2"){
                        if(linha == posicoes[0] - 1 && coluna == posicoes[1] - 1){
                            if(linha != 2 || coluna != 2){
                                if(coluna == 0){
                                    criaSetor[linha].vetorSetor[coluna + 1] = "P";
                                    criaSetor[linha].vetorSetor[coluna + 2] = "L";
                                    criaSetor[linha].vetorSetor[coluna + 3] = "2";
                                    position.posSetor2[0] = posicoes[0];
                                    position.posSetor2[1] = posicoes[1];
                                } else {
                                    if(coluna == 1){
                                        criaSetor[linha].vetorSetor[coluna + 4] = "P";
                                        criaSetor[linha].vetorSetor[coluna + 5] = "L";
                                        criaSetor[linha].vetorSetor[coluna + 6] = "2";
                                        position.posSetor2[0] = posicoes[0];
                                        position.posSetor2[1] = posicoes[1];

                                    } else {
                                        if(coluna == 2){
                                            criaSetor[linha].vetorSetor[coluna + 7] = "P";
                                            criaSetor[linha].vetorSetor[coluna + 8] = "L";
                                            criaSetor[linha].vetorSetor[coluna + 9] = "2";
                                            position.posSetor2[0] = posicoes[0];
                                            position.posSetor2[1] = posicoes[1];
    
                                        } else {
                                            if(coluna == 3){
                                                criaSetor[linha].vetorSetor[coluna + 10] = "P";
                                                criaSetor[linha].vetorSetor[coluna + 11] = "L";
                                                criaSetor[linha].vetorSetor[coluna + 12] = "2";
                                                position.posSetor2[0] = posicoes[0];
                                                position.posSetor2[1] = posicoes[1];
        
                                            } else {
                                                if(coluna == 4){
                                                    criaSetor[linha].vetorSetor[coluna + 13] = "P";
                                                    criaSetor[linha].vetorSetor[coluna + 14] = "L";
                                                    criaSetor[linha].vetorSetor[coluna + 15] = "2";
                                                    position.posSetor2[0] = posicoes[0];
                                                    position.posSetor2[1] = posicoes[1];
            
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                System.out.println("\nVocê retornou a posição central!\n");
                                System.out.println("\nNão é mostrado o jogador na posição central!\n");
                                position.posSetor1[0] = 3;
                                position.posSetor1[1] = 3;
                                this.totalInimigosP2 = 0;
                            }
                        }
                    } else {
                        if(linha == posicoes[0] - 1 && coluna == posicoes[1] - 1){
                            if(linha != 2 || coluna != 2){
                                if(coluna == 0){
                                    criaSetor[linha].vetorSetor[coluna + 2] = "P";
                                    position.posSetor2[0] = posicoes[0];
                                    position.posSetor2[1] = posicoes[1];

                                } else {
                                    if(coluna == 1){
                                        criaSetor[linha].vetorSetor[coluna + 5] = "P";
                                        position.posSetor2[0] = posicoes[0];
                                        position.posSetor2[1] = posicoes[1];
    

                                    } else {
                                        if(coluna == 2){
                                            criaSetor[linha].vetorSetor[coluna + 8] = "P";
                                            position.posSetor2[0] = posicoes[0];
                                            position.posSetor2[1] = posicoes[1];
        
    
                                        } else {
                                            if(coluna == 3){
                                                criaSetor[linha].vetorSetor[coluna + 11] = "P";
                                                position.posSetor2[0] = posicoes[0];
                                                position.posSetor2[1] = posicoes[1];
            
        
                                            } else {
                                                if(coluna == 4){
                                                    criaSetor[linha].vetorSetor[coluna + 14] = "P";
                                                    position.posSetor2[0] = posicoes[0];
                                                    position.posSetor2[1] = posicoes[1];
                
            
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                System.out.println("\nVocê retornou a posição central!\n");
                                System.out.println("\nNão é mostrado o jogador na posição central!\n");
                                position.posSetor2[0] = 3;
                                position.posSetor2[1] = 3;
                                this.totalInimigosP1 = 0;
                                this.totalInimigosP2 = 0;
                            }
                        }
                    }
                }
            }  
        }
    }

    public void gerarPortaParede(int[] posicoes){
        String porta = "*";
        String parede = "|";
        int tPorta = 0, tParede = 0;
        int escolha = posicao.nextInt(2);
        // escolha == 0 porta

        // Sorteia as portas e paredes
        for(int i = 0; i < 3; i ++){
            if(this.contPorta < this.contParede){
                tPorta = 2;
                tParede = 1;
            } else {
                int geraPortaParede = posicao.nextInt(10) + 1;
                if(geraPortaParede > 3){
                    tPorta++;
                } else {
                    tParede++;
                }
            }
            
        }

        // Previnir a não criação de portas
        if(tPorta == 0){
            tPorta = 1;
            tParede --;
        }

        this.contParede += tParede;
        this.contPorta += tPorta;

        // Modifica os setores
        if(escolha == 0 && tPorta != 0){
            for (int linha = 0; linha < tabuleiro.length; linha ++)  {  

                for (int coluna = 0; coluna < tabuleiro[linha].length; coluna ++){ 
                    if(linha != 2 || coluna != 2){
                        if(linha == posicoes[0] - 1 && coluna == posicoes[1] - 1){
                            if(coluna == 0){
                                criaSetor[linha].vetorSetor[coluna + 4] = porta;
                            } else {
                                if(coluna == 1){
                                    criaSetor[linha].vetorSetor[coluna + 7] = porta;
                                } else {
                                    if(coluna == 2){
                                        criaSetor[linha].vetorSetor[coluna + 10] = porta;
                                        
                                    } else {
                                        if(coluna == 3){
                                            criaSetor[linha].vetorSetor[coluna + 13] = porta;
                                            
                                        } else {
                                            //System.out.println("Não pode haver porta nessas posições");
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        //System.out.println("Não pode haver porta nessas posições");
                    }
                } 
            }
            tPorta --;
        } else {
            if(tParede != 0){
                // Modifica os setores
                // Percorre a matriz para criar o tabuleiro
                for (int linha = 0; linha < tabuleiro.length; linha ++)  {  

                    for (int coluna = 0; coluna < tabuleiro[linha].length; coluna ++){ 
                        // Esse for serve para modificar a matriz
                        if(linha != 2 || coluna != 2){
                            if(linha == posicoes[0] - 1 && coluna == posicoes[1] - 1){
                                if(coluna == 0){
                                    criaSetor[linha].vetorSetor[coluna + 4] = parede;
                                } else {
                                    if(coluna == 1){
                                        criaSetor[linha].vetorSetor[coluna + 7] = parede;
                                    } else {
                                        if(coluna == 2){
                                            criaSetor[linha].vetorSetor[coluna + 10] = parede;
                                            
                                        } else {
                                            if(coluna == 3){
                                                criaSetor[linha].vetorSetor[coluna + 13] = parede;
                                                
                                            } else {
                                                //System.out.println("Não pode haver paredes nessa posição!");
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            //System.out.println("Não pode haver paredes nessa posição!");
                        }
                            
                    } 
            }
            tParede --;
            }
            
        }
        
        // Modifica as linhas
        if(escolha == 0 && tPorta != 0){
            for (int linha = 1; linha < tabuleiro.length; linha ++) {  

                for (int coluna = 0; coluna < tabuleiro[linha].length; coluna ++) { 
                    if(linha != 2 || coluna != 2){
                        if(linha == posicoes[0] - 1 && coluna == posicoes[1] - 1){
                            tabuleiro[linha][coluna] = porta;
                        }
                    } else {
                        System.out.println("Não é possível fazer alterações no centro do tabuleiro!");
                    }
                }  
            }
            tPorta --;
        } else {
            tParede --;
        }

        // Modifica as linhas
        if(escolha == 0 && tPorta != 0){
            for (int linha = 1; linha < tabuleiro.length; linha ++) {  

                for (int coluna = 0; coluna < tabuleiro[linha].length; coluna ++) { 
                    if(linha != 2 || coluna != 2){
                        if(linha == posicoes[0] && coluna == posicoes[1] - 1){
                            tabuleiro[linha][coluna] = porta;
                        }
                    } else {
                        System.out.println("Não é possível fazer alterações no centro do tabuleiro!");
                    }
                }  
            }
            tPorta --;
        } else {
            tParede --;
        }
    }

    public void limparSetor(int[] posicoes){
        // Percorre a matriz para criar o tabuleiro
        for (int linha = 0; linha < tabuleiro.length; linha ++)  {  

            for (int coluna = 0; coluna < tabuleiro[linha].length; coluna ++){ 
                // Esse for serve para modificar a matriz
                    if(linha == posicoes[0] - 1 && coluna == posicoes[1] - 1){
                        if(linha != 2 || coluna != 2){
                            if(coluna == 0){
                                criaSetor[linha].vetorSetor[coluna + 1] = " ";
                                criaSetor[linha].vetorSetor[coluna + 2] = " ";
                                criaSetor[linha].vetorSetor[coluna + 3] = " ";
                            } else {
                                if(coluna == 1){
                                    criaSetor[linha].vetorSetor[coluna + 4] = " ";
                                    criaSetor[linha].vetorSetor[coluna + 5] = " ";
                                    criaSetor[linha].vetorSetor[coluna + 6] = " ";
                                } else {
                                    if(coluna == 2){
                                        criaSetor[linha].vetorSetor[coluna + 7] = " ";
                                        criaSetor[linha].vetorSetor[coluna + 8] = " ";
                                        criaSetor[linha].vetorSetor[coluna + 9] = " ";
                                    } else {
                                        if(coluna == 3){
                                            criaSetor[linha].vetorSetor[coluna + 10] = " ";
                                            criaSetor[linha].vetorSetor[coluna + 11] = " ";
                                            criaSetor[linha].vetorSetor[coluna + 12] = " ";
                                        } else {
                                            if(coluna == 4){
                                                criaSetor[linha].vetorSetor[coluna + 13] = " ";
                                                criaSetor[linha].vetorSetor[coluna + 14] = " ";
                                                criaSetor[linha].vetorSetor[coluna + 15] = " ";
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            System.out.println("\n Não é possível limpar o centro do tabuleiro!\n");
                        }
                    }
            }
        }
    }
    // fazer a interação verificar 
    public boolean verificarMovimento(int[] posicoes) {

        for (int linha = 0; linha < tabuleiro.length; linha ++)  {  

            for (int coluna = 0; coluna < tabuleiro[linha].length; coluna ++){ 

                    if(linha == posicoes[0] - 1 && coluna == posicoes[1] - 1){
                        if(coluna == 0){
                            if(criaSetor[linha].vetorSetor[4] == "*"){
                                return true;
                            } else {
                                if(tabuleiro[linha + 1][coluna] == "*"){
                                    return true;
                                } else {
                                    return false;
                                }
                            }
                        } else {
                            if(coluna == 1){
                                if(criaSetor[linha].vetorSetor[4] == "*" || criaSetor[linha].vetorSetor[8] == "*"){
                                    return true;
                                } else {
                                    if(tabuleiro[linha + 1][coluna] == "*" || tabuleiro[linha][coluna] == "*"){
                                        return true;
                                    } else {
                                        return false;
                                    }
                                }
                            } else {
                                if(coluna == 2){
                                    if(criaSetor[linha].vetorSetor[8] == "*" || criaSetor[linha].vetorSetor[12] == "*"){
                                        return true;
                                    } else {
                                        if(tabuleiro[linha + 1][coluna] == "*" || tabuleiro[linha][coluna] == "*"){
                                            return true;
                                        } else {
                                            return false;
                                        }
                                    }
                                } else {
                                    if(coluna == 3){
                                        if(criaSetor[linha].vetorSetor[12] == "*" || criaSetor[linha].vetorSetor[16] == "*"){
                                            return true;
                                        } else {
                                            if(tabuleiro[linha + 1][coluna] == "*" || tabuleiro[linha][coluna] == "*"){
                                                return true;
                                            } else {
                                                return false;
                                            }
                                        }
                                    } else {
                                        if(coluna == 4){
                                            if(criaSetor[linha].vetorSetor[16] == "*"){
                                                return true;
                                            } else {
                                                if(tabuleiro[linha][coluna] == "*"){
                                                    return true;
                                                } else {
                                                    return false;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
            }
        }
        return true;
    }

    public boolean verificarMovimento(int[] posicoesAtual, int[] posicoesFuturas) {

        for (int linha = 0; linha < tabuleiro.length; linha ++)  {  

            for (int coluna = 0; coluna < tabuleiro[linha].length; coluna ++){ 

                    if(linha == posicoesAtual[0] - 1 && coluna == posicoesAtual[1] - 1){

                        if(linha == posicoesFuturas[0] - 1){

                            if(posicoesFuturas[1] - 1 == posicoesAtual[1]){

                                if(posicoesFuturas[1] - 1 == 0){
                                    if(criaSetor[linha].vetorSetor[4] == "*"){
                                        return true;
                                    } else {
                                        return false;
                                    }
                                } else {
                                    if(posicoesFuturas[1] - 1 == 1){
                                        if(criaSetor[linha].vetorSetor[4] == "*"){
                                            return true;
                                        } else {
                                            return false;
                                        }
                                    } else {
                                        if(posicoesFuturas[1] - 1 == 2){
                                            if(criaSetor[linha].vetorSetor[8] == "*"){
                                                return true;
                                            } else {
                                                return false;
                                            }
                                        } else {
                                            if(posicoesFuturas[1] - 1 == 3){
                                                if(criaSetor[linha].vetorSetor[12] == "*"){
                                                    return true;
                                                } else {
                                                    return false;
                                                }
                                            } else {
                                                if(posicoesFuturas[1] - 1 == 4){
                                                    if(criaSetor[linha].vetorSetor[16] == "*"){
                                                        return true;
                                                    } else {
                                                        return false;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                if(posicoesFuturas[1] == posicoesAtual[1] - 1){

                                    if(posicoesFuturas[1] - 1 == 0){
                                        if(criaSetor[linha].vetorSetor[4] == "*"){
                                            return true;
                                        } else {
                                            return false;
                                        }
                                    } else {
                                        if(posicoesFuturas[1] - 1 == 1){
                                            if(criaSetor[linha].vetorSetor[8] == "*"){
                                                return true;
                                            } else {
                                                return false;
                                            }
                                        } else {
                                            if(posicoesFuturas[1] - 1 == 2){
                                                if(criaSetor[linha].vetorSetor[12] == "*"){
                                                    return true;
                                                } else {
                                                    return false;
                                                }
                                            } else {
                                                if(posicoesFuturas[1] - 1 == 3){
                                                    if(criaSetor[linha].vetorSetor[16] == "*"){
                                                        return true;
                                                    } else {
                                                        return false;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    return false;
                                }
                            }
                        } else {
                            if(coluna == posicoesFuturas[1] - 1){
                                if(posicoesFuturas[0] == posicoesAtual[0] - 1){

                                    if(tabuleiro[posicoesFuturas[0]][posicoesFuturas[1] - 1] == "*"){
                                        return true;
                                    } else{
                                        return false;
                                    }
                                } else {
                                    if(posicoesFuturas[0] - 1 == posicoesAtual[0]){
                                        if(tabuleiro[posicoesAtual[0]][posicoesAtual[0] - 1] == "*"){
                                            return true;
                                        } else {
                                            return false;
                                        }
                                    } else{
                                        return false;
                                    }
                                }
                            }
                        }
                    }
            }
        }
        return true;
    }

    public void gerarInimigosP1(){
        int nInimigos = turno.gerarInimigosP1();
        this.totalInimigosP1 = nInimigos;
    }

    public void gerarInimigosP2(){
        int nInimigos = turno.gerarInimigosP2();
        this.totalInimigosP2 = nInimigos;
    }

    public void turnoP1(Jogador1 jogador1, int contador){
        turno.turnoP1(jogador1, contador);
    }

    public void turnoP2(Jogador1 jogador1, Jogador2 jogador2,int[] vet2, int contador){
        turno.turnoP2(jogador1, jogador2, vet2, contador);
    }

    public void turnoP2(Jogador1 jogador1, Jogador2 jogador2, int[] vet1, int[] vet2, int contador){
        turno.turnoP2(jogador1, jogador2, vet1, vet2, contador);
    }

    public void turnoInimigos(Jogador1 jogador1, Jogador2 jogador2, int[] vet1, int[] vet2){
        turno.turnoInimigos(jogador1, jogador2, vet1, vet2);
    }

    public void turnoInimigos(Jogador2 jogador2, int[] vet2){
        turno.turnoInimigos(jogador2, vet2);
    }

    public void turnoInimigos(Jogador1 jogador1, int[] vet1){
        turno.turnoInimigos(jogador1, vet1);
    }

    public boolean verificarExistenciaInimigosP1(){
        boolean res1 = turno.verificarExistenciaInimigosP1(turno.vetInimigoP1);
        return res1;
    }

    public boolean verificarExistenciaInimigosP2(){
        boolean res2 = turno.verificarExistenciaInimigosP2(turno.vetInimigoP2);
        return res2;
    }

    public void verificaVitoria(int[] vet1, String jogador){
        if(this.posLinha == vet1[0] - 1){
            if(this.posColuna == vet1[1] - 1){
                if(jogador == "P1"){
                    System.out.println("\n    -----------------------------");
                    System.out.println("    ------- O JOGADOR PL1 ------- ");
                    System.out.println("    -----------VENCEU!-----------");
                    System.out.println("    -----------------------------");
                    System.out.println("\n\n FECHAR PROGRAMA ? (1-sim)");
                    int escolha = 0;
                    escolha = input.nextInt();
                    if(escolha == 1){
                        System.exit(0);  // Fecha o programa
                    }
                } else{
                    System.out.println("\n    -----------------------------");
                    System.out.println("    ------- O JOGADOR PL2 ------- ");
                    System.out.println("    -----------VENCEU!-----------");
                    System.out.println("    -----------------------------");
                    System.out.println("\n\n FECHAR PROGRAMA ? (1-sim)");
                    int escolha = 0;
                    escolha = input.nextInt();
                    if(escolha == 1){
                        System.exit(0);  // Fecha o programa
                    }
                }
            }
        }
    }

    public void fimDeJogoP1(){
        System.out.println("\n    -----------------------------");
        System.out.println("    ------- O JOGADOR PL1 ------- ");
        System.out.println("    -----------PERDEU!-----------");
        System.out.println("    -----------------------------");
    }

    public void fimDeJogoP2(){
        System.out.println("\n    -----------------------------");
        System.out.println("    ------- O JOGADOR PL2 ------- ");
        System.out.println("    -----------PERDEU!-----------");
        System.out.println("    -----------------------------");
    }

    public void fimDeJogo(){
        System.out.println("\n    -----------------------------");
        System.out.println("    ----------- O JOGO ---------- ");
        System.out.println("    ------------ACABOU!----------");
        System.out.println("    -----------------------------");
        System.out.println("Todos os jogadores morreram!");
        System.out.println("\n\n FECHAR PROGRAMA ? (1-sim)");
        int escolha = 0;
        escolha = input.nextInt();
        if(escolha == 1){
            System.exit(0);  // Fecha o programa
        }
    }

    public boolean verificarVisitaP1(int[] posicoes){
        // Percorre a matriz para criar o tabuleiro
        for (int linha = 0; linha < movimentosP1.length; linha ++) {  
            for (int coluna = 0; coluna < movimentosP1[linha].length; coluna ++){ 
                if(linha == posicoes[0] - 1 && coluna == posicoes[1] - 1){
                    if(movimentosP1[linha][coluna] == true){
                        return true;
                    }
                }
            }  
        }
        return false;
    }

    public boolean verificarVisitaP2(int[] posicoes){
        // Percorre a matriz para criar o tabuleiro
        for (int linha = 0; linha < movimentosP2.length; linha ++) {  
            for (int coluna = 0; coluna < movimentosP2[linha].length; coluna ++){ 
                if(linha == posicoes[0] - 1 && coluna == posicoes[1] - 1){
                    if(movimentosP2[linha][coluna] == true){
                        return true;
                    }
                }
            }  
        }
        return false;
    }

    public void visitaSetor(int[] vet, String jogador){
        if(jogador == "P1"){
            movimentosP1[vet[0] - 1][vet[1] - 1] = true;
        } else if(jogador == "P2"){
            movimentosP2[vet[0] - 1][vet[1] - 1] = true;
        } else if(jogador == "P"){
            movimentosP1[vet[0] - 1][vet[1] - 1] = true;
            movimentosP2[vet[0] - 1][vet[1] - 1] = true;
        }
    }

    public int tipoSetor(){
        int tipo = 0;
        tipo = posicao.nextInt(3);
        return tipo;
    }

    public void tipoSetorP1(){
        int tipo = tipoSetor();
        turno.tipoSetorP1 = tipo;
    }

    public void tipoSetorP2(){
        int tipo = tipoSetor();
        turno.tipoSetorP2 = tipo;
    }
}
