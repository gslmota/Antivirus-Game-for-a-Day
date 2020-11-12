package game;
import java.util.Random;
public class Tabuleiro {
    String porta = "|"; // paredes/portas
    String [][] tabuleiro = new String[5][5]; // Cria a matriz 5 X 5
    String [] vetor = {"|", " ", " ", " ",porta, " ", " ", " ",porta, " ", " ", " ",porta, " ", " ", " ",porta, " ", " ", " ","|"}; // Vetor criado para gerar os setores do tabuleiro
    Setor [] criaSetor = new Setor[5];
    Random posicao = new Random(); // Aleatoriedade para posicionar o virus
    Turnos turno = new Turnos();
    int posLinha = posicao.nextInt(5);
    int posColuna = posicao.nextInt(5);
    int contPorta = 0, contParede = 0;

    // Função para criar setores vazios
    public void gerarSetorVazio(){
        for(int i = 0; i < criaSetor.length; i++){
            criaSetor[i] = new Setor();
        }
    }

    public void gerarTabuleiroInicial() {
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
            for(int i = 0; i < vetor.length; i++){
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
                            String [] vetor = {"|", " ", "X", " ","|", " ", " ", " ","*", " ", "C", " ","*", " ", " ", " ","|", " ", " ", " ","|"};
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
                        System.out.print(vetor[i]);
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
                            System.out.print("    |  P1     P2  |");
                        }
                    }
                }
            }
           System.out.println(""); //muda de linha
           contador ++;
        }
        System.out.print("     |---|---|---|---|---|\n\n"); // Cria a parede inferior do tabuleiro
    }

    // Função para apagar a exibição no terminal
    public void apagarTela(){
        for(int i = 0; i<=50; i++){
            System.out.println("");
        }
    }

    // Função para gerar tabuleiro de jogo
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

                if(linha== 2){
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
                            criaSetor[linha].vetorSetor[3] = "X";
                        } else {
                            if(posColuna == 2){
                                if(posColuna == posLinha){
                                    criaSetor[linha].vetorSetor[18] = "X";
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

    public void printarTabuleiro(){

        //apagarTela();

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

            // Gera o interior do setor
            for(int vet = 0; vet < criaSetor[linha].vetorSetor.length; vet ++){

                System.out.print(criaSetor[linha].vetorSetor[vet]);
            }
            if(linha == 0){
                System.out.print("      Setor [" + criaSetor[linha].posSetor[0] + "," + criaSetor[linha].posSetor[1] + "]");
            }
            if(linha == 1 || linha ==4){
                System.out.print("    |------*------|");
            } else{
                if(linha == 2){
                    System.out.print("    |             |");
                }
                else{
                    if(linha == 3){
                        System.out.print("    |  P1     P2  |");
                    }
                }
            }
           System.out.println(""); //muda de linha
        }
        System.out.print("     |---|---|---|---|---|\n\n"); // Cria a parede inferior do tabuleiro

    }

    public void alterarSetor(int[] posicoes, String jogador){
        // Sorteia as portas e paredes
        for(int i = 0; i < 3; i ++){

            int geraPortaParede = posicao.nextInt(10) + 1;
            if(geraPortaParede > 3){
                this.contPorta ++;
            } else {
                this.contParede ++;
            }
        }
        
         // Percorre a matriz para criar o tabuleiro
        for (int linha = 0; linha < tabuleiro.length; linha ++)  {  

            for (int coluna = 0; coluna < tabuleiro[linha].length; coluna ++){ 
                // Esse for serve para modificar a matriz
                if(jogador == "P1"){
                    if(linha == posicoes[0] && coluna == posicoes[1]){
                        criaSetor[linha].posSetor[0] = posicoes[0];
                        if(coluna == 1){
                            criaSetor[linha].vetorSetor[coluna] = "º";
                            criaSetor[linha].posSetor[1] = posicoes[1];
                        } else {
                            if(coluna == 2){
                                criaSetor[linha].vetorSetor[coluna + 1] = "º";
                                criaSetor[linha].posSetor[1] = posicoes[1];
                            } else {
                                if(coluna == 3){
                                    criaSetor[linha].vetorSetor[coluna + 3] = "º";
                                    criaSetor[linha].posSetor[1] = posicoes[1];
                                } else {
                                    if(coluna == 4){
                                        criaSetor[linha].vetorSetor[coluna + 3] = "º";
                                        criaSetor[linha].posSetor[1] = posicoes[1];
                                    } else {
                                        criaSetor[linha].vetorSetor[coluna + 5] = "º";
                                        criaSetor[linha].posSetor[1] = posicoes[1];
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
