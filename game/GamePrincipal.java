package game;
import java.util.Scanner;
public class GamePrincipal {
    public static void main(String[] args) {

        int key;
        Tabuleiro jogo = new Tabuleiro();
        Scanner input = new Scanner(System.in);
        jogo.gerarTabuleiroInicial();
        System.out.println("\nVamos Começar o Jogo ? (1-sim / 2-não)");
        key = input.nextInt();
        if(key == 1){
            jogo.movimentaSetor(jogo.turno.movimentar());
            
        } else{
            System.exit(0);
        }
        // update de memoria no java
    }
}