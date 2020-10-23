package game;

public class Tabuleiro {
    String [][] tabuleiro = new String[5][5];
    String [] vetor = {"|", " ", " ", " ","|", " ", " ", " ","|", " ", " ", " ","|", " ", " ", " ","|", " ", " ", " ","|"};
    String porta = "|";
    int var = 0;

    public void gerarTabuleiro() {
        System.out.println("-----------------------------");
        System.out.println("|    Antivírus por um dia    |");
        System.out.println("-----------------------------");
        System.out.println("       1   2   3   4   5      ");
       
        for (int linha = 0; linha < tabuleiro.length; linha ++)  {  

            for (int coluna = 0; coluna < tabuleiro[linha].length; coluna ++)     { 
                tabuleiro[linha][coluna] = "-";
            }  
          } 

        for (int linha = 0; linha < tabuleiro.length; linha ++)  {  
            
            System.out.print("     |");
            for (int coluna = 0; coluna < tabuleiro[linha].length; coluna ++)     { 
                if(coluna == 2 && linha == 2){
                    tabuleiro[2][2] = "*";
                    tabuleiro[3][2] = "*";
                }
                System.out.print("-" + tabuleiro[linha][coluna] + "-|");
            }  
            
            
            System.out.println("");
            System.out.print( linha + 1 + "    ");
            for(int i = 0; i< vetor.length; i++){
                if(var == 2){
                    String [] vetor = {"|", " ", " ", " ","|", " ", " ", " ","*", " ", "c", " ","*", " ", " ", " ","|", " ", " ", " ","|"};
                    System.out.print(vetor[i]);   
                }
                else{
                    System.out.print(vetor[i]);
                }
                
            }
            
           System.out.println(""); //muda de linha
           var ++;
           
           //System.out.println(vetor[2]);
            
        }
        System.out.print("     |---|---|---|---|---|");
    }
    
}
