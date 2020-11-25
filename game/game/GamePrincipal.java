/*
Armazenar os movimentos em matriz e criar metodo verificar posicaoAntiga

*/
package game;
import java.util.Scanner;
public class GamePrincipal {
    public static void main(String[] args) {

        int key, contCiclos = 0, contvet = 0;
        int[] vetAux = new int[2];
        Tabuleiro tabuleiro = new Tabuleiro();
        Scanner input = new Scanner(System.in);
        Jogador1 jogador1 = new Jogador1();
        Jogador2 jogador2 = new Jogador2();
        tabuleiro.gerarTabuleiroInicial();
        System.out.println("\nVamos Começar o Jogo ? (1-sim / 2-não)");
        key = input.nextInt();

        if(key == 1){
            tabuleiro.gerarTabuleiroDeJogo();
            tabuleiro.apagarTela();
            tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
        } else{
            System.exit(0);  // Fecha o programa
        }
        
        while(contCiclos < 25){

            int vet1[] = jogador1.movimentar(contCiclos);
            boolean res1 = tabuleiro.verificarMovimento(vet1);
            tabuleiro.verificaVitoria(vet1, "P1");
            if(res1 == true){
                tabuleiro.alterarSetor(vet1, "P1");
                tabuleiro.gerarPortaParede(vet1);
                if(vet1[0] == 3 && vet1[1] == 3){
                    System.out.println("\n\nNão existe inimigos na posição central!\n");
                } else {
                    tabuleiro.gerarInimigosP1();
                }
                tabuleiro.alterarSetor(vetAux, "P2");
                tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                if(contCiclos != 0){
                    tabuleiro.limparSetor(vetAux); // Limpa a posição de PL2
                }
                System.out.println("\nTudo ok? (1-sim / 2-não)");
                key = input.nextInt();
                if(key == 1){
                    int vet2[] = jogador2.movimentar(contCiclos);
                    boolean res2 = tabuleiro.verificarMovimento(vet2);
                    tabuleiro.verificaVitoria(vet2, "P2");
                    if(res2 == true){
                        if(vet2[0] == vet1[0] && vet2[1] == vet1[1]){
                            tabuleiro.limparSetor(vet1);
                            tabuleiro.alterarSetor(vet2, "P");
                            tabuleiro.printarTabuleiro(jogador1, jogador2);
                            //tabuleiro.limparSetor(vet2);
                            System.out.println("\nTudo ok? (1-sim / 2-não)");
                            key = input.nextInt();
                            if(key == 1){
                                boolean repetir = true;
                                int contDoWhile = 0;
                                do{
                                    int contador1 = 1, contador2 = 1;
                                    while(contador1 <= 2){
                                        tabuleiro.turnoP1(jogador1, contador1);
                                        tabuleiro.printarTabuleiro(jogador1, jogador2);
                                        contador1 ++;
                                    }
    
                                    while(contador2 <= 2){
                                        tabuleiro.turnoP2(jogador1, jogador2, vet1, vet2, contador2);
                                        tabuleiro.printarTabuleiro(jogador1, jogador2);
                                        contador2 ++;
                                    }
                                    
                                    tabuleiro.turnoInimigos(jogador1, jogador2, vet1, vet2);
                                    tabuleiro.printarTabuleiro(jogador1, jogador2);
                                    boolean result1 = tabuleiro.verificarExistenciaInimigosP1();

                                    if (result1 == false){
                                        repetir = false;
                                    }
                                    
                                    if(contDoWhile != 0){
                                        contCiclos ++;
                                    } else {

                                    }

                                } while(repetir);

                                tabuleiro.limparSetor(vet1);
                                vetAux[0] = vet2[0];
                                vetAux[1] = vet2[1];
                                contCiclos ++;
                            } else {
                                System.exit(0);
                            }
                        } else {
                            tabuleiro.alterarSetor(vet2, "P2");
                            tabuleiro.gerarPortaParede(vet2);
                            if(vet2[0] == 3 && vet2[1] == 3){
                                System.out.println("\n\nNão existe inimigos na posição central!\n");
                            } else {
                                tabuleiro.gerarIninimigosP2();
                            }
                            tabuleiro.printarTabuleiro(jogador1, jogador2, 0);

                            System.out.println("\nTudo ok? (1-sim / 2-não)");
                            key = input.nextInt();
                            if(key == 1){
                                // Chama o turno de P1
                                boolean repetir = true;
                                int contDoWhile = 0;
                                do{
                                    int contador1 = 1, contador2 = 1;
                                    while(contador1 <= 2){
                                        tabuleiro.turnoP1(jogador1, contador1);
                                        tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                        contador1 ++;
                                    }
    
                                    while(contador2 <= 2){
                                        tabuleiro.turnoP2(jogador1, jogador2, vet1, vet2, contador2);
                                        tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                        contador2 ++;
                                    }
                                    
                                    tabuleiro.turnoInimigos(jogador1, jogador2, vet1, vet2);
                                    tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                    boolean result1 = tabuleiro.verificarExistenciaInimigosP1();
                                    boolean result2 = tabuleiro.verificarExistenciaInimigosP2();
                                    if (result1 == false && result2 == false){
                                        repetir = false;
                                    }

                                    if(contDoWhile != 0){
                                        contCiclos ++;
                                    } else {

                                    }

                                } while(repetir);
    
                                tabuleiro.limparSetor(vet1);
                                vetAux[0] = vet2[0];
                                vetAux[1] = vet2[1];
                                contCiclos ++;
                            }
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
        tabuleiro.fimDeJogo();
        input.close();
    }
}