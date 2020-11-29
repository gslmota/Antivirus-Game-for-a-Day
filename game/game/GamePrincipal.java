/*
Armazenar os movimentos em matriz e criar metodo verificar posicaoAntiga
Try e catch

refazer os atributos def e atk de jogador 1 2

posição igual central, passar total ini como 0
*/
package game;
import java.util.InputMismatchException;
import java.util.Scanner;
public class GamePrincipal {
    public static void main(String[] args) {

        int key, contCiclos = 0;
        int contP1 = 0, contP2 = 0;
        int[] vetAux = new int[2];
        int[] vetAuxP1 = new int[2];
        int[] vetAuxP2 = new int[2];
        Tabuleiro tabuleiro = new Tabuleiro();
        Scanner input = new Scanner(System.in);
        Jogador1 jogador1 = new Jogador1();
        Jogador2 jogador2 = new Jogador2();
        tabuleiro.gerarTabuleiroInicial();
        try{
            System.out.println("\nVamos Começar o Jogo ? (1-sim / 2-não)");
            key = input.nextInt();

            if(key == 1){
                tabuleiro.gerarTabuleiroDeJogo();
                tabuleiro.apagarTela();
                tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
            } else{
                System.exit(0);  // Fecha o programa
            }
            
        } catch (InputMismatchException e){
            System.err.println(e);
            System.out.println("Digite um valor inteiro: ");
        }
        
        while(contCiclos < 25){
            boolean life1, life2;
            life1 = jogador1.verificaVida();
            life2 = jogador2.verificaVida();

            if(life1 == true && life2 == true){
                if((contCiclos != 0 && tabuleiro.verificarExistenciaInimigosP1() == true) || (contCiclos != 0 && tabuleiro.verificarExistenciaInimigosP2() == true)){

                    if(tabuleiro.verificarExistenciaInimigosP1() == true && tabuleiro.verificarExistenciaInimigosP2() == false){
                        System.out.println("O PL1 possui inimigos e não pode se movimentar!");
                        System.out.println("\nTudo ok? (1-sim / 2-não)");
                        key = input.nextInt();
                        if(key == 1){
                            int contador1 = 1, contador2 = 1;
                            while(contador1 <= 2){
                                tabuleiro.turnoP1(jogador1, contador1);
                                tabuleiro.printarTabuleiro(jogador1, jogador2);
                                contador1 ++;
                            }

                            tabuleiro.turnoInimigos(jogador1, vetAuxP1);

                            if(jogador1.DEF <= 0 && jogador2.DEF <= 0){
                                tabuleiro.fimDeJogo();
                            } else {
                                if(jogador1.DEF <= 0){
                                    tabuleiro.fimDeJogoP1();
                                } else {
                                    if(jogador2.DEF <= 0){
                                        tabuleiro.fimDeJogoP2();
                                    }
                                }
                            }
                            tabuleiro.printarTabuleiro(jogador1, jogador2);
                            if(tabuleiro.verificarExistenciaInimigosP1() == false){
                                tabuleiro.limparSetor(vetAuxP1);
                            }
                            contCiclos ++;
                        } else {
                            System.exit(0);
                        }

                        int vet2[] = jogador2.movimentar(contCiclos);
                                boolean res2 = tabuleiro.verificarMovimento(vet2);
                                tabuleiro.verificaVitoria(vet2, "P2");
                                if(res2 == true){
                                    if(vet2[0] == vetAuxP1[0] && vet2[1] == vetAuxP1[1]){
                                        tabuleiro.limparSetor(vetAuxP1);
                                        tabuleiro.alterarSetor(vet2, "P");
                                        tabuleiro.visitaSetor(vet2, "P");
                                        tabuleiro.printarTabuleiro(jogador1, jogador2);
                                        //tabuleiro.limparSetor(vet2);
                                        System.out.println("\nTudo ok? (1-sim / 2-não)");
                                        key = input.nextInt();
                                        if(key == 1){
                                            int contador1 = 1, contador2 = 1;
                                        
                                            while(contador2 <= 2){
                                                tabuleiro.turnoP2(jogador1, jogador2, vetAuxP1, vet2, contador2);
                                                tabuleiro.printarTabuleiro(jogador1, jogador2);
                                                contador2 ++;
                                            }
                                            
                                            tabuleiro.turnoInimigos(jogador2, vet2);
        
                                            if(jogador1.DEF <= 0 && jogador2.DEF <= 0){
                                                tabuleiro.fimDeJogo();
                                            } else {
                                                if(jogador1.DEF <= 0){
                                                    tabuleiro.fimDeJogoP1();
                                                } else {
                                                    if(jogador2.DEF <= 0){
                                                        tabuleiro.fimDeJogoP2();
                                                    }
                                                }
                                            }
                                            tabuleiro.printarTabuleiro(jogador1, jogador2);
                                            if(tabuleiro.verificarExistenciaInimigosP1() == false){
                                                tabuleiro.limparSetor(vetAuxP1);
                                            }
                                            
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
                                            tabuleiro.totalInimigosP2 = 0;
                                        } else {
                                            boolean resVisit = tabuleiro.verificarVisitaP2(vet2);
                                            if(resVisit == true){
                                                // Não gera inimigos novamente
                                                tabuleiro.totalInimigosP2 = 0;
                                            } else {
                                                tabuleiro.gerarInimigosP2();
                                            }
                                        }
                                        tabuleiro.visitaSetor(vet2, "P2");
                                        tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
            
                                        System.out.println("\nTudo ok? (1-sim / 2-não)");
                                        key = input.nextInt();
                                        if(key == 1){
                                        
                                            // executa turnoP1 e depois P2
                                            
                                            tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                            
                                        
                                            int contador2 = 1;
                                            while(contador2 <= 2){
                                                tabuleiro.turnoP2(jogador1, jogador2, vetAuxP1, vet2, contador2);
                                                tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                                contador2 ++;
                                            }
                                            //tabuleiro.turnoInimigos(jogador1, jogador2, vet1, vet2);
    
                                            if(jogador1.DEF <= 0 && jogador2.DEF <= 0){
                                                tabuleiro.fimDeJogo();
                                            } else {
                                                if(jogador1.DEF <= 0){
                                                    tabuleiro.fimDeJogoP1();
                                                } else {
                                                    if(jogador2.DEF <= 0){
                                                        tabuleiro.fimDeJogoP2();
                                                    }
                                                }
                                            }
                                            tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                            
                                            
                                            tabuleiro.limparSetor(vet1);
                                            vetAux[0] = vet2[0];
                                            vetAux[1] = vet2[1];
                                            vetAuxP2 = vet2;
                                            contCiclos ++;
            
                                        }
                                    }
            
                                } else {
                                    System.out.println("Digite uma posição onde haja portas adjacentes a sua posição atual!");
                                }
                                
                    } else {
                        if(tabuleiro.verificarExistenciaInimigosP1() == false && tabuleiro.verificarExistenciaInimigosP2() == true){

                        }
                    }
                } else {
                    if(contCiclos == 0 || tabuleiro.verificarExistenciaInimigosP1() == false && tabuleiro.verificarExistenciaInimigosP2() == false){

                        int vet1[] = jogador1.movimentar(contCiclos);
                        jogador1.vetPosFuturaP1 = vet1;
                        //tabuleiro.verificarMovimento(jogador1.vetPosAtualP1, vet1, jogador1, jogador2);
                        boolean res1 = tabuleiro.verificarMovimento(vet1);
                        tabuleiro.verificaVitoria(vet1, "P1");
                        if(res1 == true){
                            tabuleiro.alterarSetor(vet1, "P1");
                            tabuleiro.gerarPortaParede(vet1);
                            if(vet1[0] == 3 && vet1[1] == 3){
                                System.out.println("\n\nNão existe inimigos na posição central!\n");
                                tabuleiro.totalInimigosP1 = 0;
                            } else {
                                boolean resVisit = tabuleiro.verificarVisitaP1(vet1);
                                if(resVisit == true){
                                    // Não gera inimigos novamente
                                    tabuleiro.totalInimigosP1 = 0;
                                } else {
                                    tabuleiro.gerarInimigosP1();
                                }
                            }
                            tabuleiro.visitaSetor(vet1, "P1");
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
                                        tabuleiro.visitaSetor(vet2, "P");
                                        tabuleiro.printarTabuleiro(jogador1, jogador2);
                                        //tabuleiro.limparSetor(vet2);
                                        System.out.println("\nTudo ok? (1-sim / 2-não)");
                                        key = input.nextInt();
                                        if(key == 1){
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
        
                                            if(jogador1.DEF <= 0 && jogador2.DEF <= 0){
                                                tabuleiro.fimDeJogo();
                                            } else {
                                                if(jogador1.DEF <= 0){
                                                    tabuleiro.fimDeJogoP1();
                                                } else {
                                                    if(jogador2.DEF <= 0){
                                                        tabuleiro.fimDeJogoP2();
                                                    }
                                                }
                                            }
                                            tabuleiro.printarTabuleiro(jogador1, jogador2);
                                
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
                                            tabuleiro.totalInimigosP2 = 0;
                                        } else {
                                            boolean resVisit = tabuleiro.verificarVisitaP2(vet2);
                                            if(resVisit == true){
                                                // Não gera inimigos novamente
                                                tabuleiro.totalInimigosP2 = 0;
                                            } else {
                                                tabuleiro.gerarInimigosP2();
                                            }
                                        }
                                        tabuleiro.visitaSetor(vet2, "P2");
                                        tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
            
                                        System.out.println("\nTudo ok? (1-sim / 2-não)");
                                        key = input.nextInt();
                                        if(key == 1){
                                        
                                            // executa turnoP1 e depois P2
                                            int contador1 = 1;
                                            while(contador1 <= 2){
                                                tabuleiro.turnoP1(jogador1, contador1);
                                                tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                                contador1 ++;
                                            }
                                            //tabuleiro.turnoInimigos(jogador1, jogador2, vet1, vet2);
                                            if(jogador1.DEF <= 0 && jogador2.DEF <= 0){
                                                tabuleiro.fimDeJogo();
                                            } else {
                                                if(jogador1.DEF <= 0){
                                                    tabuleiro.fimDeJogoP1();
                                                } else {
                                                    if(jogador2.DEF <= 0){
                                                        tabuleiro.fimDeJogoP2();
                                                    }
                                                }
                                            }
                                            tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                            
                                        
                                            int contador2 = 1;
                                            while(contador2 <= 2){
                                                tabuleiro.turnoP2(jogador1, jogador2, vet1, vet2, contador2);
                                                tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                                contador2 ++;
                                            }
                                            //tabuleiro.turnoInimigos(jogador1, jogador2, vet1, vet2);
    
                                            if(jogador1.DEF <= 0 && jogador2.DEF <= 0){
                                                tabuleiro.fimDeJogo();
                                            } else {
                                                if(jogador1.DEF <= 0){
                                                    tabuleiro.fimDeJogoP1();
                                                } else {
                                                    if(jogador2.DEF <= 0){
                                                        tabuleiro.fimDeJogoP2();
                                                    }
                                                }
                                            }
                                            tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                            
                                            
                                            tabuleiro.limparSetor(vet1);
                                            vetAux[0] = vet2[0];
                                            vetAux[1] = vet2[1];
                                            vetAuxP1 = vet1;
                                            vetAuxP2 = vet2;
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
                }
                int vet1[] = jogador1.movimentar(contCiclos);
                jogador1.vetPosFuturaP1 = vet1;
                //tabuleiro.verificarMovimento(jogador1.vetPosAtualP1, vet1, jogador1, jogador2);
                boolean res1 = tabuleiro.verificarMovimento(vet1);
                tabuleiro.verificaVitoria(vet1, "P1");
                if(res1 == true){
                    tabuleiro.alterarSetor(vet1, "P1");
                    tabuleiro.gerarPortaParede(vet1);
                    if(vet1[0] == 3 && vet1[1] == 3){
                        System.out.println("\n\nNão existe inimigos na posição central!\n");
                        tabuleiro.totalInimigosP1 = 0;
                    } else {
                        boolean resVisit = tabuleiro.verificarVisitaP1(vet1);
                        if(resVisit == true){
                            // Não gera inimigos novamente
                            tabuleiro.totalInimigosP1 = 0;
                        } else {
                            tabuleiro.gerarInimigosP1();
                        }
                    }
                    tabuleiro.visitaSetor(vet1, "P1");
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
                                tabuleiro.visitaSetor(vet2, "P");
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
    
                                        if(jogador1.DEF <= 0 && jogador2.DEF <= 0){
                                            tabuleiro.fimDeJogo();
                                        } else {
                                            if(jogador1.DEF <= 0){
                                                tabuleiro.fimDeJogoP1();
                                            } else {
                                                if(jogador2.DEF <= 0){
                                                    tabuleiro.fimDeJogoP2();
                                                }
                                            }
                                        }
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
                                    tabuleiro.totalInimigosP2 = 0;
                                } else {
                                    boolean resVisit = tabuleiro.verificarVisitaP2(vet2);
                                    if(resVisit == true){
                                        // Não gera inimigos novamente
                                        tabuleiro.totalInimigosP2 = 0;
                                    } else {
                                        tabuleiro.gerarInimigosP2();
                                    }
                                }
                                tabuleiro.visitaSetor(vet2, "P2");
                                tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
    
                                System.out.println("\nTudo ok? (1-sim / 2-não)");
                                key = input.nextInt();
                                if(key == 1){
                                    // Chama o turno de P1
                                    boolean repetir = true;
                                    int contDoWhile = 0;
                                    // executa turnoP1 e depois P2
                                    do {
                                        int contador1 = 1;
                                        while(contador1 <= 2){
                                            tabuleiro.turnoP1(jogador1, contador1);
                                            tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                            contador1 ++;
                                        }
                                        //tabuleiro.turnoInimigos(jogador1, jogador2, vet1, vet2);
                                        if(jogador1.DEF <= 0 && jogador2.DEF <= 0){
                                            tabuleiro.fimDeJogo();
                                        } else {
                                            if(jogador1.DEF <= 0){
                                                tabuleiro.fimDeJogoP1();
                                            } else {
                                                if(jogador2.DEF <= 0){
                                                    tabuleiro.fimDeJogoP2();
                                                }
                                            }
                                        }
                                        tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                        boolean result1 = tabuleiro.verificarExistenciaInimigosP1();
                                        if (result1 == false){
                                            repetir = false;
                                        }
    
                                        if(contDoWhile != 0){
                                            contCiclos ++;
                                        } else {
    
                                        }
                                    } while(repetir);

                                    do {
                                        int contador2 = 1;
                                        while(contador2 <= 2){
                                            tabuleiro.turnoP2(jogador1, jogador2, vet1, vet2, contador2);
                                            tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                            contador2 ++;
                                        }
                                        //tabuleiro.turnoInimigos(jogador1, jogador2, vet1, vet2);

                                        if(jogador1.DEF <= 0 && jogador2.DEF <= 0){
                                            tabuleiro.fimDeJogo();
                                        } else {
                                            if(jogador1.DEF <= 0){
                                                tabuleiro.fimDeJogoP1();
                                            } else {
                                                if(jogador2.DEF <= 0){
                                                    tabuleiro.fimDeJogoP2();
                                                }
                                            }
                                        }
                                        tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                        boolean result1 = tabuleiro.verificarExistenciaInimigosP2();
                                        if (result1 == false){
                                            repetir = false;
                                        }
    
                                        if(contDoWhile != 0){
                                            contCiclos ++;
                                        } else {
    
                                        }
                                    } while(repetir);
                                    /*
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
                                        
                                        if(jogador1.DEF <= 0 && jogador2.DEF <= 0){
                                            tabuleiro.fimDeJogo();
                                        } else {
                                            if(jogador1.DEF <= 0){
                                                tabuleiro.fimDeJogoP1();
                                            } else {
                                                if(jogador2.DEF <= 0){
                                                    tabuleiro.fimDeJogoP2();
                                                }
                                            }
                                        }
    
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
    
                                    } while(repetir);*/
        
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
            } else {
                if(life1 == true && life2 == false){
                    int vet1[] = jogador1.movimentar(contCiclos);
                    boolean res1 = tabuleiro.verificarMovimento(vet1);
                    tabuleiro.verificaVitoria(vet1, "P1");
                    if(res1 == true){
                        tabuleiro.alterarSetor(vet1, "P1");
                        tabuleiro.gerarPortaParede(vet1);
                        if(vet1[0] == 3 && vet1[1] == 3){
                            System.out.println("\n\nNão existe inimigos na posição central!\n");
                            tabuleiro.totalInimigosP1 = 0;
                        } else {
                            boolean resVisit = tabuleiro.verificarVisitaP1(vet1);
                            if(resVisit == true){
                                // Não gera inimigos novamente
                                tabuleiro.totalInimigosP1 = 0;
                            } else {
                                tabuleiro.gerarInimigosP1();
                            }
                        }
                        tabuleiro.visitaSetor(vet1, "P1");
                        tabuleiro.alterarSetor(vetAux, "P2");
                        tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                        if(contCiclos != 0){
                            //tabuleiro.limparSetor(vetAux); // Limpa a posição de PL2
                        }
                        System.out.println("\nTudo ok? (1-sim / 2-não)");
                        key = input.nextInt();
                        if(key == 1){
                            System.out.println("\nComeçar o turno? (1-sim / 2-não)");
                            key = input.nextInt();
                            if(key == 1){
                                boolean repetir = true;
                                int contDoWhile = 0;
                                do{
                                    int contador1 = 1;
                                    while(contador1 <= 2){
                                        tabuleiro.turnoP1(jogador1, contador1);
                                        tabuleiro.printarTabuleiro(jogador1, jogador2);
                                        contador1 ++;
                                    }

                                    tabuleiro.turnoInimigos(jogador1, vet1);

                                    if(jogador1.DEF <= 0 && jogador2.DEF <= 0){
                                        tabuleiro.fimDeJogo();
                                    } else {
                                        if(jogador1.DEF <= 0){
                                            tabuleiro.fimDeJogoP1();
                                        } 
                                    }
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
                                contCiclos ++;
                            } else {
                                System.exit(0);
                            }
                                
                        }
                    }
                } else {
                    if(life2 == true && life1 == false) {
                        System.out.println("\nTudo ok? (1-sim / 2-não)");
                        key = input.nextInt();
                        if(key == 1){
                            int vet2[] = jogador2.movimentar(contCiclos);
                            boolean res2 = tabuleiro.verificarMovimento(vet2);
                            tabuleiro.verificaVitoria(vet2, "P2");
                            if(res2 == true){
                                tabuleiro.alterarSetor(vet2, "P2");
                                tabuleiro.gerarPortaParede(vet2);
                                if(vet2[0] == 3 && vet2[1] == 3){
                                    System.out.println("\n\nNão existe inimigos na posição central!\n");
                                    tabuleiro.totalInimigosP2 = 0;
                                } else {
                                    boolean resVisit = tabuleiro.verificarVisitaP2(vet2);
                                    if(resVisit == true){
                                        // Não gera inimigos novamente
                                        tabuleiro.totalInimigosP2 = 0;
                                    } else {
                                        tabuleiro.gerarInimigosP2();
                                    }
                                }

                                tabuleiro.visitaSetor(vet2, "P2");
                                tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
    
                                System.out.println("\nTudo ok? (1-sim / 2-não)");
                                key = input.nextInt();
                                if(key == 1){
                                    
                                    boolean repetir = true;
                                    int contDoWhile = 0;
                                    do{
                                        int contador2 = 1;
                                    
                                        while(contador2 <= 2){
                                            tabuleiro.turnoP2(jogador1, jogador2, vet2, contador2);
                                            tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                            contador2 ++;
                                        }
                                        
                                        tabuleiro.turnoInimigos(jogador2, vet2);
                                        
                                        if(jogador1.DEF <= 0 && jogador2.DEF <= 0){
                                            tabuleiro.fimDeJogo();
                                        } else {
                                            if(jogador2.DEF <= 0){
                                                tabuleiro.fimDeJogoP2();
                                            }
                                        }
    
                                        tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                        boolean result2 = tabuleiro.verificarExistenciaInimigosP2();
                                        if (result2 == false){
                                            repetir = false;
                                        }
    
                                        if(contDoWhile != 0){
                                            contCiclos ++;
                                        } else {
    
                                        }
    
                                    } while(repetir);
                                    tabuleiro.limparSetor(vet2);
                                    contCiclos ++;
                                }
                            } else {
                                System.out.println("Digite uma posição onde haja portas adjacentes a sua posição atual!");
                            }
                        }
                    }
                }
            }
            contCiclos ++;
        }
        tabuleiro.fimDeJogo();
        input.close();
    }
}