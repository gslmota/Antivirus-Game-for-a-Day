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

            int vet1[] = turno.coletarMovimentoP1(contTurnos);
            boolean res1 = tabuleiro.verificarMovimento(vet1);

            if(res1 == true){
                tabuleiro.alterarSetor(vet1, "P1");
                tabuleiro.gerarPortaParede(vet1);
                tabuleiro.printarTabuleiro();
                System.out.println("\nTudo ok? (1-sim / 2-não)");
                key = input.nextInt();
                if(key == 1){
                    int vet2[] = turno.coletarMovimentoP2(contTurnos);
                    boolean res2 = tabuleiro.verificarMovimento(vet2);
                    if(res2 == true){
                        tabuleiro.alterarSetor(vet2, "P2");
                        tabuleiro.printarTabuleiro();
                        tabuleiro.limparSetor(vet2);
                        System.out.println("\nTudo ok? (1-sim / 2-não)");
                        key = input.nextInt();
                        if(key == 1){
                            tabuleiro.limparSetor(vet1);
                            tabuleiro.gerarPortaParede(vet2);
                            contTurnos ++;
                        } else{
                            break;
                        }
                    } else {
                        System.out.println("Digite uma posição onde haja portas adjacentes a sua posição atual!");
                    }
                    
                } else {
                    break;
                }
            } else {
                System.out.println("Digite uma posição onde haja portas adjacentes a sua posição atual!");
            }
        }
        input.close();
    }
}