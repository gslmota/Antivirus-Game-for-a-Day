package game;
import java.util.Scanner;
public class GamePrincipal {
    public static void main(String[] args) {

        int key, contTurnos = 0;
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
        
        while(contTurnos <= 25){

            int vet [] = turno.coletarMovimentoP1(contTurnos);
            tabuleiro.alterarSetor(vet, "P1");
            tabuleiro.gerarPortaParede(vet);
            tabuleiro.printarTabuleiro();
            tabuleiro.limparSetor(vet);
            System.out.println("\nTudo ok? (1-sim / 2-não)");
            key = input.nextInt();
            if(key == 1){
                contTurnos ++;
            } else {
                break;
            }
        }
    }
}