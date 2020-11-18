/*

Criar os jogadores e definir os tipos(suporte,simples)
Criar ATk e DEF dos jogadores e printar
Criar os metodos referentes as acoes dos jogadores

Criar o metodo para criação dos inimigos

Testar a criação de setores por movimentação

*/
package game;
import java.util.Scanner;
public class GamePrincipal {
    public static void main(String[] args) {

        int key, contTurnos = 0;
        Tabuleiro tabuleiro = new Tabuleiro();
        Turnos turno = new Turnos();
        Scanner input = new Scanner(System.in);
        Jogador jogador1 = new Jogador("simples");
        Jogador jogador2 = new Jogador("suporte");

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

            int vet1[] = jogador1.coletarMovimento(contTurnos);
            boolean res1 = tabuleiro.verificarMovimento(vet1);

            if(res1 == true){
                tabuleiro.alterarSetor(vet1, "P1");
                tabuleiro.gerarPortaParede(vet1);
                tabuleiro.printarTabuleiro();
                System.out.println("\nTudo ok? (1-sim / 2-não)");
                key = input.nextInt();
                if(key == 1){
                    int vet2[] = jogador2.coletarMovimento(contTurnos);
                    boolean res2 = tabuleiro.verificarMovimento(vet2);
                    if(res2 == true){
                        if(vet2[0] == vet1[0] && vet2[1] == vet1[1]){
                            tabuleiro.limparSetor(vet1);
                            tabuleiro.alterarSetor(vet2, "P");
                            tabuleiro.printarTabuleiro(jogador1, jogador2);
                        } else {
                            tabuleiro.alterarSetor(vet2, "P2");
                            tabuleiro.gerarPortaParede(vet2);
                            tabuleiro.printarTabuleiro();
                            }
                        
                        System.out.println("\nTudo ok? (1-sim / 2-não)");
                        key = input.nextInt();
                        if(key == 1){
                            tabuleiro.limparSetor(vet1);
                            tabuleiro.limparSetor(vet2);
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