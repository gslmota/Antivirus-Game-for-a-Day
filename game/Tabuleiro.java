package game;
import java.util.Random;
public class Tabuleiro {
    String porta = "|"; // paredes/portas
    String [][] tabuleiro = new String[5][5]; // Cria a matriz 5 X 5
    String [] vetor = {"|", " ", " ", " ",porta, " ", " ", " ",porta, " ", " ", " ",porta, " ", " ", " ",porta, " ", " ", " ","|"}; // Vetor criado para gerar os setores do tabuleiro
    Random posicaoVirus = new Random(); // Aleatoriedade para posicionar o virus
    Turnos turno = new Turnos();
    int posLinha = posicaoVirus.nextInt(5);
    int posColuna = posicaoVirus.nextInt(5);
    
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
        System.out.print("     |---|---|---|---|---|"); // Cria a parede inferior do tabuleiro
    }

    public void apagarTela(){
        for(int i = 0; i<=50; i++){
            System.out.println("");
        }
    }
}
