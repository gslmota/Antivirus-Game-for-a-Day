package game;
import java.util.Random;
public class Tabuleiro {
    String [][] tabuleiro = new String[5][5];
    String [] vetor = {"|", " ", " ", " ","|", " ", " ", " ","|", " ", " ", " ","|", " ", " ", " ","|", " ", " ", " ","|"};
    String porta = "|";
    Random posicaoVirus = new Random();
    int posLinha = posicaoVirus.nextInt(5);
    int posColuna = posicaoVirus.nextInt(5);
    
    public void gerarTabuleiro() {

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
                    System.out.print("    *      *      *");
                }
                if(coluna == 4 && linha == 4){
                    System.out.print("    |  2/6    1/7 |");
                }
            }  
            System.out.println(" ");// Pula para próxima linha da matriz
            System.out.print(linha + 1 + "    ");// Gera o inicio da linha, o interior do tabuleiro
            int cont = 0;
            for(int i = 0; i < vetor.length; i++){
                // Esse IF gera o Centro do tabuleiro (* C *) e o restante
                if(cont == 2){
                    String [] vetor = {"|", " ", " ", " ","|", " ", " ", " ","*", " ", "C", " ","*", " ", " ", " ","|", " ", " ", " ","|"};
                    System.out.print(vetor[i]);   
                }
                else{
                    // Esse IF Posiciona o vírus (X) na posição [5,2]
                    if(cont == posLinha){
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
            if(cont == 0){
                System.out.print("      Setor [3,3]");
            } else{
                if(cont == 1 || cont ==4){
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
           cont ++;
        }
        System.out.print("     |---|---|---|---|---|"); // Cria a parede inferior do tabuleiro
    }
}
