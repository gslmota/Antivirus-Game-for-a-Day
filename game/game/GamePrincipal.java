package game;
import java.util.Scanner;
public class GamePrincipal {
    public static void main(String[] args) {

        int key, pl, pc;
        Tabuleiro jogo = new Tabuleiro();
        Scanner input = new Scanner(System.in);
        /*jogo.gerarTabuleiroInicial();
        System.out.println("\nVamos Começar o Jogo ? (1-sim / 2-não)");
        key = input.nextInt();
        if(key == 1){
            jogo.gerarTabuleiroDeJogo();
            
        } else{
            System.exit(0);  // Fecha o programa
        }
        System.out.println("\nPara onde P1 vai se movimentar ? ");
        System.out.println("\nDigite a linha e depois a coluna: ");
        pl = input.nextInt();
        pc = input.nextInt();
        
*/
        jogo.gerarTabuleiroDeJogo();
        jogo.printarTabuleiro();
    }
}