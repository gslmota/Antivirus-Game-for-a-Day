package game;
import java.util.Scanner;
public class GamePrincipal {
    public static void main(String[] args) {

        int key, pl, pc, contTurnos = 0;
        Tabuleiro tabuleiro = new Tabuleiro();
        Turnos turno = new Turnos();
        Scanner input = new Scanner(System.in);
        tabuleiro.gerarTabuleiroInicial();
        System.out.println("\nVamos Começar o Jogo ? (1-sim / 2-não)");
        key = input.nextInt();
        if(key == 1){
            tabuleiro.gerarTabuleiroDeJogo();
            tabuleiro.apagarTela();
            tabuleiro.printarTabuleiro();
            
        } else{
            System.exit(0);  // Fecha o programa
        }
        /*
        while(contTurnos <= 25){
            System.out.println("\nPara onde P1 vai se movimentar ? ");
            System.out.println("\nDigite a linha e depois a coluna: ");
            pl = input.nextInt();
            pc = input.nextInt();

            contTurnos ++;

        }*/
        turno.coletarMovimento();
    }
}