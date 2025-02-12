package game;
import java.util.InputMismatchException;
import java.util.Scanner;
public class GamePrincipal {
    public static void main(String[] args) {

        int key = 0, contCiclos = 0;
        int[] vetAux = new int[2];
        int[] vetAuxP1 = new int[2];
        int[] vetAuxP2 = new int[2];
        Tabuleiro tabuleiro = new Tabuleiro();
        Scanner input = new Scanner(System.in);
        Jogador1 jogador1 = new Jogador1();
        Jogador2 jogador2 = new Jogador2();
        int[] vetVmP1 = {3,3};
        int[] vetVmP2 = {3,3};
        
        tabuleiro.gerarTabuleiroInicial();
        boolean rep = true;
        do{
            try{
                System.out.println("\nVamos Começar o Jogo ? (1-sim / 2-não)");
                key = input.nextInt();
    
                if(key == 1){
                    tabuleiro.gerarTabuleiroDeJogo();
                    tabuleiro.apagarTela();
                    tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                    rep = false;
                } else{ 
                    if(key == 2){
                        System.exit(0);  // Fecha o programa
                    }
                }
                
            } catch (InputMismatchException e){
                System.out.println(e);
                System.out.println("Digite um valor inteiro!");
                input.nextLine();
            }
        } while(rep);
        
        while(contCiclos < 25){

            boolean life1, life2;
            life1 = jogador1.verificaVida();
            life2 = jogador2.verificaVida();
            
            if(life1 == true && life2 == true){ // verifica vida de p1 e p2
                if((contCiclos != 0 && tabuleiro.verificarExistenciaInimigosP1() == true) || (contCiclos != 0 && tabuleiro.verificarExistenciaInimigosP2() == true)){

                    if(tabuleiro.verificarExistenciaInimigosP1() == true && tabuleiro.verificarExistenciaInimigosP2() == false){
                        //p1 tem inimigos  e p2 não
                        System.out.println("O PL1 possui inimigos e não pode se movimentar!");
                        boolean exe = true;
                        do{
                            try{
                                System.out.println("\nTudo ok? (1-sim / 2-não)");
                                key = input.nextInt();
                                if(key == 1){
                                    exe = false;
                                } else {
                                    if(key == 2){
                                        System.exit(0);
                                    }
                                }

                            } catch (InputMismatchException e){
                                System.out.println(e);
                                System.out.println("Digite um valor inteiro!");
                                input.nextLine();
                            }
                            
                        } while(exe);
                        if(vetAuxP2[0] == vetAuxP1[0] && vetAuxP2[1] == vetAuxP1[1]){
                            System.out.println("O PL2 possui inimigos e não pode se movimentar!");
                            tabuleiro.printarTabuleiro(jogador1, jogador2);
                            boolean tx = true;
                            do{
                                try{
                                    System.out.println("\nTudo ok? (1-sim / 2-não)");
                                    key = input.nextInt();
                                    if(key == 1){
                                        tx = false;
                                    } else {
                                        if(key == 2){
                                            System.exit(0);
                                        }
                                    }
                                    
                                } catch (InputMismatchException e){
                                    System.out.println(e);
                                    System.out.println("Digite um valor inteiro!");
                                    input.nextLine();
                                }
                                
                            } while(tx);
                            
                            if(key == 1){
                                int contador1 = 1, contador2 = 1;
                                while(contador1 <= 2){
                                    tabuleiro.turnoP1(jogador1, contador1);
                                    tabuleiro.printarTabuleiro(jogador1, jogador2);
                                    contador1 ++;
                                }

                                while(contador2 <= 2){
                                    tabuleiro.turnoP2(jogador1, jogador2, vetAuxP1, vetAuxP2, contador2);
                                    tabuleiro.printarTabuleiro(jogador1, jogador2);
                                    contador2 ++;
                                }
                                
                                tabuleiro.turnoInimigos(jogador1, jogador2, vetAuxP1, vetAuxP2);

                                if(jogador1.DEF <= 0 && jogador2.DEF <= 0){
                                    tabuleiro.fimDeJogo();
                                } else {
                                    if(jogador1.DEF <= 0){
                                        tabuleiro.fimDeJogoP1();
                                        tabuleiro.limparSetor(vetAuxP1);
                                        tabuleiro.totalInimigosP1 = 0;
                                        jogador1.ATK = 0;
                                        jogador1.DEF = 0;
                                        tabuleiro.position.posSetor1[0] = 0;
                                        tabuleiro.position.posSetor1[1] = 0;
                                    } else {
                                        if(jogador2.DEF <= 0){
                                            tabuleiro.fimDeJogoP2();
                                            tabuleiro.limparSetor(vetAuxP2);
                                            tabuleiro.totalInimigosP2 = 0;
                                            jogador2.ATK = 0;
                                            jogador2.DEF = 0;
                                            tabuleiro.position.posSetor2[0] = 0;
                                            tabuleiro.position.posSetor2[1] = 0;
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
                        } else{
                            if(key == 1){
                                int contador1 = 1;
                                while(contador1 <= 2){
                                    tabuleiro.turnoP1(jogador1, contador1);
                                    tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                    contador1 ++;
                                }
    
                                tabuleiro.turnoInimigos(jogador1, vetAuxP1);
    
                                if(jogador1.DEF <= 0 && jogador2.DEF <= 0){
                                    tabuleiro.fimDeJogo();
                                } else {
                                    if(jogador1.DEF <= 0){
                                        tabuleiro.fimDeJogoP1();
                                        tabuleiro.limparSetor(vetAuxP1);
                                        tabuleiro.totalInimigosP1 = 0;
                                        jogador1.ATK = 0;
                                        jogador1.DEF = 0;
                                        tabuleiro.position.posSetor1[0] = 0;
                                        tabuleiro.position.posSetor1[1] = 0;
                                    } else {
                                        if(jogador2.DEF <= 0){
                                            tabuleiro.fimDeJogoP2();
                                            tabuleiro.limparSetor(vetAuxP2);
                                            tabuleiro.totalInimigosP2 = 0;
                                            jogador2.ATK = 0;
                                            jogador2.DEF = 0;
                                            tabuleiro.position.posSetor2[0] = 0;
                                            tabuleiro.position.posSetor2[1] = 0;
                                        }
                                    }
                                }
    
                                tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
            
                                contCiclos ++;
                            } else {
                                System.exit(0);
                            }
    
                            int vet2[] = new int[2];
                            boolean res2 = false;
                            boolean repetir = true;
    
                            do{
                                try{
                                    int vet[] = jogador2.movimentar(contCiclos);
                                    boolean res =  tabuleiro.verificarMovimento(vetVmP2, vet);      //tabuleiro.verificarMovimento(vet);
                                    if(res = true){
                                        vet2 = vet;
                                        res2 = res;
                                        repetir = false;
                                    } else {
                                        System.out.println("Digite uma posição onde haja portas adjacentes a sua posição atual!");
                                    }
                                } catch(InputMismatchException e){
                                    System.out.println(e);
                                    System.out.println("Digite um valor inteiro!");
                                    input.nextLine();
                                }
                                
                            } while(repetir);
                            vetVmP2 = vet2;
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
                                        int contador2 = 1;
                                    
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
                                                tabuleiro.limparSetor(vetAuxP1);
                                                tabuleiro.totalInimigosP1 = 0;
                                                jogador1.ATK = 0;
                                                jogador1.DEF = 0;
                                                tabuleiro.position.posSetor1[0] = 0;
                                                tabuleiro.position.posSetor1[1] = 0;
                                            } else {
                                                if(jogador2.DEF <= 0){
                                                    tabuleiro.fimDeJogoP2();
                                                    tabuleiro.limparSetor(vet2);
                                                    tabuleiro.totalInimigosP2 = 0;
                                                    jogador2.ATK = 0;
                                                    jogador2.DEF = 0;
                                                    tabuleiro.position.posSetor2[0] = 0;
                                                    tabuleiro.position.posSetor2[1] = 0;
                                                }
                                            }
                                        }
    
                                        tabuleiro.printarTabuleiro(jogador1, jogador2);
    
                                        vetAux[0] = vet2[0];
                                        vetAux[1] = vet2[1];
                                        vetAuxP2 = vet2;
                                        contCiclos ++;
                                    } else {
                                        System.exit(0);
                                    }
    
                                } else {
                                    tabuleiro.limparSetor(vetAuxP2);
                                    tabuleiro.alterarSetor(vet2, "P2");
                                    tabuleiro.gerarPortaParede(vet2);
                                    tabuleiro.tipoSetorP2();
                                    if(vet2[0] == 3 && vet2[1] == 3){
                                        System.out.println("\n\nNão existe inimigos na posição central!\n\nMas você pode procurar itens na posição central!\n");
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
    
                                    boolean exec = true;
                                    do{
                                        try{
                                            System.out.println("\nTudo ok? (1-sim / 2-não)");
                                            key = input.nextInt();
                                            if(key == 1){
                                                exec = false;
                                            } else {
                                                if(key == 2){
                                                    System.exit(0);
                                                }
                                            }
                                            
                                        } catch (InputMismatchException e){
                                            System.out.println(e);
                                            System.out.println("Digite um valor inteiro!");
                                            input.nextLine();
                                        }
                                        
                                    } while(exec);
        
                                    if(key == 1){
                                    
                                        tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                        int contador2 = 1;
                                        while(contador2 <= 2){
                                            tabuleiro.turnoP2(jogador1, jogador2, vetAuxP1, vet2, contador2);
                                            tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                            contador2 ++;
                                        }
                                        tabuleiro.turnoInimigos(jogador2, vet2);
    
                                        if(jogador1.DEF <= 0 && jogador2.DEF <= 0){
                                            tabuleiro.fimDeJogo();
                                        } else {
                                            if(jogador1.DEF <= 0){
                                                tabuleiro.fimDeJogoP1();
                                                tabuleiro.limparSetor(vetAuxP1);
                                                tabuleiro.totalInimigosP1 = 0;
                                                jogador1.ATK = 0;
                                                jogador1.DEF = 0;
                                                tabuleiro.position.posSetor1[0] = 0;
                                                tabuleiro.position.posSetor1[1] = 0;
                                            } else {
                                                if(jogador2.DEF <= 0){
                                                    tabuleiro.fimDeJogoP2();
                                                    tabuleiro.limparSetor(vet2);
                                                    tabuleiro.totalInimigosP2 = 0;
                                                    jogador2.ATK = 0;
                                                    jogador2.DEF = 0;
                                                    tabuleiro.position.posSetor2[0] = 0;
                                                    tabuleiro.position.posSetor2[1] = 0;
                                                }
                                            }
                                        }
                                    
                                        tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
    
                                        vetAux[0] = vet2[0];
                                        vetAux[1] = vet2[1];
                                        vetAuxP2 = vet2;
                                        contCiclos ++;
                                    }
                                }
        
                            } else {
                                System.out.println("Digite uma posição onde haja portas adjacentes a sua posição atual!");
                            }
                        }
                        
                    } else {
                        if(tabuleiro.verificarExistenciaInimigosP1() == false && tabuleiro.verificarExistenciaInimigosP2() == true){
                            
                            // P1 não tem inimigos mas P2 sim
                            tabuleiro.limparSetor(vetAuxP1);
                            boolean continuar = true;
                            int vet1[] = new int[2];
                            boolean res1 = false;
                            do{
                                try{
                                
                                    int vet[] = jogador1.movimentar(contCiclos);
                                    boolean res =  tabuleiro.verificarMovimento(vetVmP1, vet);         //tabuleiro.verificarMovimento(vet);
                                    if(res == true){
                                        vet1 = vet;
                                        res1 = res;
                                        continuar = false;
                                    } else{
                                        System.out.println("Digite uma posição onde haja portas adjacentes a sua posição atual!");
                                    }
                                } catch(InputMismatchException e){
                                    System.out.println(e);
                                    System.out.println("Digite um valor inteiro!");
                                    input.nextLine();
                                }
                                
                            } while(continuar);
                            vetVmP1 = vet1;
                            tabuleiro.verificaVitoria(vet1, "P1");
                            if(res1 == true){
                                tabuleiro.alterarSetor(vet1, "P1");
                                tabuleiro.gerarPortaParede(vet1);
                                tabuleiro.tipoSetorP1();
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
                                boolean exee = true;
                                do{
                                    try{
                                        System.out.println("\nTudo ok? (1-sim / 2-não)");
                                        key = input.nextInt();
                                        if(key == 1){
                                            exee = false;
                                        } else {
                                            if(key == 2){
                                                System.exit(0);
                                            }
                                        }
                                        
                                    } catch (InputMismatchException e){
                                        System.out.println(e);
                                        System.out.println("Digite um valor inteiro!");
                                        input.nextLine();
                                    }
                                    
                                } while(exee);
                                
                                if(key == 1){
                                    System.out.println("PL2 não pode se movimentar pois ainda possui inimigos!");
                                    if(vetAuxP2[0] == vet1[0] && vetAuxP2[1] == vet1[1]){
                                        tabuleiro.limparSetor(vet1);
                                        tabuleiro.alterarSetor(vet1, "P");
                                        tabuleiro.visitaSetor(vet1, "P");
                                        tabuleiro.printarTabuleiro(jogador1, jogador2);
                                        boolean exxe = true;
                                        do{
                                            try{
                                                System.out.println("\nTudo ok? (1-sim / 2-não)");
                                                key = input.nextInt();
                                                if(key == 1){
                                                    exxe = false;
                                                } else {
                                                    if(key == 2){
                                                        System.exit(0);
                                                    }
                                                }
                                                
                                            } catch (InputMismatchException e){
                                                System.out.println(e);
                                                System.out.println("Digite um valor inteiro!");
                                                input.nextLine();
                                            }
                                            
                                        } while(exxe);
                                        
                                        if(key == 1){
                                            int contador1 = 1, contador2 = 1;
                                            while(contador1 <= 2){
                                                tabuleiro.turnoP1(jogador1, contador1);
                                                tabuleiro.printarTabuleiro(jogador1, jogador2);
                                                contador1 ++;
                                            }
            
                                            while(contador2 <= 2){
                                                tabuleiro.turnoP2(jogador1, jogador2, vet1, vetAuxP2, contador2);
                                                tabuleiro.printarTabuleiro(jogador1, jogador2);
                                                contador2 ++;
                                            }
                                            
                                            tabuleiro.turnoInimigos(jogador1, jogador2, vet1, vetAuxP2);
        
                                            if(jogador1.DEF <= 0 && jogador2.DEF <= 0){
                                                tabuleiro.fimDeJogo();
                                            } else {
                                                if(jogador1.DEF <= 0){
                                                    tabuleiro.fimDeJogoP1();
                                                    tabuleiro.limparSetor(vet1);
                                                    tabuleiro.totalInimigosP1 = 0;
                                                    jogador1.ATK = 0;
                                                    jogador1.DEF = 0;
                                                    tabuleiro.position.posSetor1[0] = 0;
                                                    tabuleiro.position.posSetor1[1] = 0;
                                                } else {
                                                    if(jogador2.DEF <= 0){
                                                        tabuleiro.fimDeJogoP2();
                                                        tabuleiro.limparSetor(vetAuxP2);
                                                        tabuleiro.totalInimigosP2 = 0;
                                                        jogador2.ATK = 0;
                                                        jogador2.DEF = 0;
                                                        tabuleiro.position.posSetor2[0] = 0;
                                                        tabuleiro.position.posSetor2[1] = 0;
                                                    }
                                                }
                                            }

                                            tabuleiro.printarTabuleiro(jogador1, jogador2);
                        
                                            contCiclos ++;
                                        } else {
                                            System.exit(0);
                                        }
        
                                    } else {

                                        tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                        boolean eexe = true;
                                        do{
                                            try{
                                                System.out.println("\nTudo ok? (1-sim / 2-não)");
                                                key = input.nextInt();
                                                if(key == 1){
                                                    eexe = false;
                                                } else {
                                                    if(key == 2){
                                                        System.exit(0);
                                                    }
                                                }
                                                
                                            } catch (InputMismatchException e){
                                                System.out.println(e);
                                                System.out.println("Digite um valor inteiro!");
                                                input.nextLine();
                                            }
                                            
                                        } while(eexe);
                                        
                                        if(key == 1){
                                            // executa turnoP1 e depois P2
                                            int contador1 = 1;
                                            while(contador1 <= 2){
                                                tabuleiro.turnoP1(jogador1, contador1);
                                                tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                                contador1 ++;
                                            }
                                            
                                            tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                            
                                        
                                            int contador2 = 1;
                                            while(contador2 <= 2){
                                                tabuleiro.turnoP2(jogador1, jogador2, vet1, vetAuxP2, contador2);
                                                tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                                contador2 ++;
                                            }

                                            tabuleiro.turnoInimigos(jogador1, jogador2, vet1, vetAuxP2);
    
                                            if(jogador1.DEF <= 0 && jogador2.DEF <= 0){
                                                tabuleiro.fimDeJogo();
                                            } else {
                                                if(jogador1.DEF <= 0){
                                                    tabuleiro.fimDeJogoP1();
                                                    tabuleiro.limparSetor(vet1);
                                                    tabuleiro.totalInimigosP1 = 0;
                                                    jogador1.ATK = 0;
                                                    jogador1.DEF = 0;
                                                    tabuleiro.position.posSetor1[0] = 0;
                                                    tabuleiro.position.posSetor1[1] = 0;
                                                } else {
                                                    if(jogador2.DEF <= 0){
                                                        tabuleiro.fimDeJogoP2();
                                                        tabuleiro.limparSetor(vetAuxP2);
                                                        tabuleiro.totalInimigosP2 = 0;
                                                        jogador2.ATK = 0;
                                                        jogador2.DEF = 0;
                                                        tabuleiro.position.posSetor2[0] = 0;
                                                        tabuleiro.position.posSetor2[1] = 0;
                                                    }
                                                }
                                            }

                                            tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                            
                                            vetAuxP1 = vet1;
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
                            // inimigos p1 e p2
                            if(tabuleiro.verificarExistenciaInimigosP1() == true && tabuleiro.verificarExistenciaInimigosP2() == true){
                                System.out.println("O jogador PL1 e PL2 não podem se movimentar pois ainda possuem inimigos!");
                                boolean xe = true;
                                do{
                                    try{
                                        System.out.println("\nTudo ok? (1-sim / 2-não)");
                                        key = input.nextInt();
                                        if(key == 1){
                                            xe = false;
                                        } else {
                                            if(key == 2){
                                                System.exit(0);
                                            }
                                        }
                                        
                                    } catch (InputMismatchException e){
                                        System.out.println(e);
                                        System.out.println("Digite um valor inteiro!");
                                        input.nextLine();
                                    }
                                    
                                } while(xe);
                                
                                if(key == 1){
                                    if(vetAuxP1[0] == vetAuxP2[0] && vetAuxP1[1] == vetAuxP2[1]){
                                        int contador1 = 1, contador2 = 1;
                                        while(contador1 <= 2){
                                            tabuleiro.turnoP1(jogador1, contador1);
                                            tabuleiro.printarTabuleiro(jogador1, jogador2);
                                            contador1 ++;
                                        }
        
                                        while(contador2 <= 2){
                                            tabuleiro.turnoP2(jogador1, jogador2, vetAuxP1, vetAuxP2, contador2);
                                            tabuleiro.printarTabuleiro(jogador1, jogador2);
                                            contador2 ++;
                                        }
                                        
                                        tabuleiro.turnoInimigos(jogador1, jogador2, vetAuxP1, vetAuxP2);
    
                                        if(jogador1.DEF <= 0 && jogador2.DEF <= 0){
                                            tabuleiro.fimDeJogo();
                                        } else {
                                            if(jogador1.DEF <= 0){
                                                tabuleiro.fimDeJogoP1();
                                                tabuleiro.limparSetor(vetAuxP1);
                                                tabuleiro.totalInimigosP1 = 0;
                                                jogador1.ATK = 0;
                                                jogador1.DEF = 0;
                                                tabuleiro.position.posSetor1[0] = 0;
                                                tabuleiro.position.posSetor1[1] = 0;
                                            } else {
                                                if(jogador2.DEF <= 0){
                                                    tabuleiro.fimDeJogoP2();
                                                    tabuleiro.limparSetor(vetAuxP2);
                                                    tabuleiro.totalInimigosP2 = 0;
                                                    jogador2.ATK = 0;
                                                    jogador2.DEF = 0;
                                                    tabuleiro.position.posSetor2[0] = 0;
                                                    tabuleiro.position.posSetor2[1] = 0;
                                                }
                                            }
                                        }

                                        tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                        
                                        contCiclos ++;
                                    } else {
                                        int contador1 = 1, contador2 = 1;
                                        while(contador1 <= 2){
                                            tabuleiro.turnoP1(jogador1, contador1);
                                            tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                            contador1 ++;
                                        }
        
                                        while(contador2 <= 2){
                                            tabuleiro.turnoP2(jogador1, jogador2, vetAuxP1, vetAuxP2, contador2);
                                            tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                            contador2 ++;
                                        }
                                        
                                        tabuleiro.turnoInimigos(jogador1, jogador2, vetAuxP1, vetAuxP2);
    
                                        if(jogador1.DEF <= 0 && jogador2.DEF <= 0){
                                            tabuleiro.fimDeJogo();
                                        } else {
                                            if(jogador1.DEF <= 0){
                                                tabuleiro.fimDeJogoP1();
                                                tabuleiro.limparSetor(vetAuxP1);
                                                tabuleiro.totalInimigosP1 = 0;
                                                jogador1.ATK = 0;
                                                jogador1.DEF = 0;
                                                tabuleiro.position.posSetor1[0] = 0;
                                                tabuleiro.position.posSetor1[1] = 0;
                                            } else {
                                                if(jogador2.DEF <= 0){
                                                    tabuleiro.fimDeJogoP2();
                                                    tabuleiro.limparSetor(vetAuxP2);
                                                    tabuleiro.totalInimigosP2 = 0;
                                                    jogador2.ATK = 0;
                                                    jogador2.DEF = 0;
                                                    tabuleiro.position.posSetor2[0] = 0;
                                                    tabuleiro.position.posSetor2[1] = 0;    
                                                }
                                            }
                                        }
                                        tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                        
                                        contCiclos ++;
                                    }
                                    
                                } else {
                                    System.exit(0);
                                }
                            }
                        }
                    }
                } else {
                    if(contCiclos == 0 || (tabuleiro.verificarExistenciaInimigosP1() == false && tabuleiro.verificarExistenciaInimigosP2() == false)){
                        if(contCiclos!= 0){
                            tabuleiro.limparSetor(vetAuxP1);
                        }
                        boolean continuar = true;
                        int vet1[] = new int[2];
                        boolean res1 = false;
                        do{
                            try{
                                
                                int vet[] = jogador1.movimentar(contCiclos);
                                boolean res =  tabuleiro.verificarMovimento(vetVmP1, vet);         //tabuleiro.verificarMovimento(vet);
                                if(res == true){
                                    vet1 = vet;
                                    res1 = res;
                                    continuar = false;
                                } else{
                                    System.out.println("Digite uma posição onde haja portas adjacentes a sua posição atual!");
                                }
                            } catch(InputMismatchException e){
                                System.out.println(e);
                                System.out.println("Digite um valor inteiro!");
                                input.nextLine();
                            }
                            
                        } while(continuar);
                        vetVmP1 = vet1;
                        tabuleiro.verificaVitoria(vet1, "P1");
                        if(res1 == true){
                            tabuleiro.alterarSetor(vet1, "P1");
                            tabuleiro.gerarPortaParede(vet1);
                            tabuleiro.tipoSetorP1();
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
                                tabuleiro.limparSetor(vetAuxP2); // Limpa a posição de PL2
                            }
                            boolean ex = true;
                            do{
                                try{
                                    System.out.println("\nTudo ok? (1-sim / 2-não)");
                                    key = input.nextInt();
                                    if(key == 1){
                                        ex = false;
                                    } else {
                                        if(key == 2){
                                            System.exit(0);
                                        }
                                    }
                                    
                                } catch (InputMismatchException e){
                                    System.out.println(e);
                                    System.out.println("Digite um valor inteiro!");
                                    input.nextLine();
                                }
                                
                            } while(ex);
                            
                            if(key == 1){
                                int vet2[] = new int[2];
                                boolean res2 = false;
                                boolean repetir = true;
                                do{
                                    try{
                                        int vet[] = jogador2.movimentar(contCiclos);
                                        boolean res = tabuleiro.verificarMovimento(vetVmP2, vet);      //tabuleiro.verificarMovimento(vet);
                                        if(res == true){
                                            vet2 = vet;
                                            res2 = res;
                                            repetir = false;
                                        } else{
                                            System.out.println("Digite uma posição onde haja portas adjacentes a sua posição atual!");
                                        }
                                    } catch(InputMismatchException e){
                                        System.out.println(e);
                                        System.out.println("Digite um valor inteiro!");
                                        input.nextLine();
                                    }
                                    
                                } while(repetir);
                                vetVmP2 = vet2;
                                if(res2 == true){
                                    if(vet2[0] == vet1[0] && vet2[1] == vet1[1]){
                                        tabuleiro.verificaVitoria(vet2, "P2");
                                        tabuleiro.limparSetor(vet1);
                                        tabuleiro.alterarSetor(vet2, "P");
                                        tabuleiro.visitaSetor(vet2, "P");
                                        tabuleiro.printarTabuleiro(jogador1, jogador2);
                                        boolean exe = true;
                                        do{
                                            try{
                                                System.out.println("\nTudo ok? (1-sim / 2-não)");
                                                key = input.nextInt();
                                                if(key == 1){
                                                    exe = false;
                                                } else {
                                                    if(key == 2){
                                                        System.exit(0);
                                                    }
                                                }
                                                
                                            } catch (InputMismatchException e){
                                                System.out.println(e);
                                                System.out.println("Digite um valor inteiro!");
                                                input.nextLine();
                                            }
                                            
                                        } while(exe);
                                        
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
                                                    tabuleiro.limparSetor(vet1);
                                                    tabuleiro.totalInimigosP1 = 0;
                                                    jogador1.ATK = 0;
                                                    jogador1.DEF = 0;
                                                    tabuleiro.position.posSetor1[0] = 0;
                                                    tabuleiro.position.posSetor1[1] = 0;
                                                } else {
                                                    if(jogador2.DEF <= 0){
                                                        tabuleiro.fimDeJogoP2();
                                                        tabuleiro.limparSetor(vet2);
                                                        tabuleiro.totalInimigosP2 = 0;
                                                        jogador2.ATK = 0;
                                                        jogador2.DEF = 0;
                                                        tabuleiro.position.posSetor2[0] = 0;
                                                        tabuleiro.position.posSetor2[1] = 0;
                                                    }
                                                }
                                            }

                                            tabuleiro.printarTabuleiro(jogador1, jogador2);
                                            if(tabuleiro.verificarExistenciaInimigosP1() == false){
                                                tabuleiro.limparSetor(vet1);
                                            }
                                            
                                            vetAux[0] = vet2[0];
                                            vetAux[1] = vet2[1];
                                            vetAuxP1 = vet1;
                                            vetAuxP2 = vet2;
                                            contCiclos ++;
                                        } else {
                                            System.exit(0);
                                        }
    
                                    } else {
                                        tabuleiro.verificaVitoria(vet2, "P2");
                                        tabuleiro.alterarSetor(vet2, "P2");
                                        tabuleiro.gerarPortaParede(vet2);
                                        tabuleiro.tipoSetorP2();
                                        // Compara a posição central para ver se tem inimigos
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
                                        boolean x = true;
                                        do{
                                            try{
                                                System.out.println("\nTudo ok? (1-sim / 2-não)");
                                                key = input.nextInt();
                                                if(key == 1){
                                                    x = false;
                                                } else {
                                                    if(key == 2){
                                                        System.exit(0);
                                                    }
                                                }
                                                
                                            } catch (InputMismatchException e){
                                                System.out.println(e);
                                                System.out.println("Digite um valor inteiro!");
                                                input.nextLine();
                                            }
                                            
                                        } while(x);
                                        
                                        if(key == 1){
                                        
                                            // executa turnoP1 e depois P2
                                            int contador1 = 1;
                                            while(contador1 <= 2){
                                                tabuleiro.turnoP1(jogador1, contador1);
                                                tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                                contador1 ++;
                                            }
    
                                            tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                            
                                        
                                            int contador2 = 1;
                                            while(contador2 <= 2){
                                                tabuleiro.turnoP2(jogador1, jogador2, vet1, vet2, contador2);
                                                tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                                contador2 ++;
                                            }
                                            tabuleiro.turnoInimigos(jogador1, jogador2, vet1, vet2);
                                            tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
    
                                            if(jogador1.DEF <= 0 && jogador2.DEF <= 0){
                                                tabuleiro.fimDeJogo();
                                            } else {
                                                if(jogador1.DEF <= 0){
                                                    tabuleiro.fimDeJogoP1();
                                                    tabuleiro.limparSetor(vet1);
                                                    tabuleiro.totalInimigosP1 = 0;
                                                    jogador1.ATK = 0;
                                                    jogador1.DEF = 0;
                                                    tabuleiro.position.posSetor1[0] = 0;
                                                    tabuleiro.position.posSetor1[1] = 0;
                                                } else {
                                                    if(jogador2.DEF <= 0){
                                                        tabuleiro.fimDeJogoP2();
                                                        tabuleiro.limparSetor(vet2);
                                                        tabuleiro.totalInimigosP2 = 0;
                                                        jogador2.ATK = 0;
                                                        jogador2.DEF = 0;
                                                        tabuleiro.position.posSetor2[0] = 0;
                                                        tabuleiro.position.posSetor2[1] = 0;
                                                    }
                                                }
                                            }

                                            tabuleiro.printarTabuleiro(jogador1, jogador2, 0);

                                            if(tabuleiro.verificarExistenciaInimigosP1() == false){
                                                tabuleiro.limparSetor(vet1);
                                            }
                                            
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
                
            } else {
                if(life1 == true && life2 == false){
                    if(tabuleiro.verificarExistenciaInimigosP1() == true){
                        System.out.println("O PL1 possui inimigos e não pode se movimentar!");
                        tabuleiro.printarTabuleiro(jogador1, jogador2);
                        boolean exe = true;
                        do{
                            try{
                                System.out.println("\nTudo ok? (1-sim / 2-não)");
                                key = input.nextInt();
                                if(key == 1){
                                    exe = false;
                                } else {
                                    if(key == 2){
                                        System.exit(0);
                                    }
                                }
                                
                            } catch (InputMismatchException e){
                                System.out.println(e);
                                System.out.println("Digite um valor inteiro!");
                                input.nextLine();
                            }
                            
                        } while(exe);
                        
                        if(key == 1){
                            int contador1 = 1;
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
                                    tabuleiro.totalInimigosP1 = 0;
                                    jogador1.ATK = 0;
                                    jogador1.DEF = 0;
                                    tabuleiro.position.posSetor1[0] = 0;
                                    tabuleiro.position.posSetor1[1] = 0;
                                } 
                            }

                            tabuleiro.printarTabuleiro(jogador1, jogador2);
        
                            contCiclos ++;
                        } else {
                            System.exit(0);
                        }
                    } else  {
                        if(tabuleiro.verificarExistenciaInimigosP1() == false){

                            boolean continuar = true;
                            int vet1[] = new int[2];
                            boolean res1 = false;
                            do{
                                try{
                                    
                                    int vet[] = jogador1.movimentar(contCiclos);
                                    boolean res =  tabuleiro.verificarMovimento(vetVmP1, vet);         //tabuleiro.verificarMovimento(vet);
                                    if(res == true){
                                        vet1 = vet;
                                        res1 = res;
                                        continuar = false;
                                    } else{
                                        System.out.println("Digite uma posição onde haja portas adjacentes a sua posição atual!");
                                    }
                                } catch(InputMismatchException e){
                                    System.out.println(e);
                                    System.out.println("Digite um valor inteiro!");
                                    input.nextLine();
                                }
                                
                            } while(continuar);
                            vetVmP1 = vet1;
                            tabuleiro.verificaVitoria(vet1, "P1");
                            tabuleiro.limparSetor(vetAuxP1);
                            if(res1 == true){
                                tabuleiro.alterarSetor(vet1, "P1");
                                tabuleiro.gerarPortaParede(vet1);
                                tabuleiro.tipoSetorP1();
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
                                tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                boolean exe = true;
                                do{
                                    try{
                                        System.out.println("\nTudo ok? (1-sim / 2-não)");
                                        key = input.nextInt();
                                        if(key == 1){
                                            exe = false;
                                        } else {
                                            if(key == 2){
                                                System.exit(0);
                                            }
                                        }
                                        
                                    } catch (InputMismatchException e){
                                        System.out.println(e);
                                        System.out.println("Digite um valor inteiro!");
                                        input.nextLine();
                                    }
                                    
                                } while(exe);
                                if(key == 1){
                                    System.out.println("\nComeçar o turno? (1-sim / 2-não)");
                                    key = input.nextInt();
                                    if(key == 1){
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
                                                tabuleiro.totalInimigosP1 = 0;
                                                jogador1.ATK = 0;
                                                jogador1.DEF = 0;
                                                tabuleiro.position.posSetor1[0] = 0;
                                                tabuleiro.position.posSetor1[1] = 0;
                                            } 
                                        }

                                        tabuleiro.printarTabuleiro(jogador1, jogador2);
                                        tabuleiro.limparSetor(vet1);
                                        contCiclos ++;
                                    } else {
                                        System.exit(0);
                                    }
                                        
                                }
                            }
                        }
                    }
                    
                } else {
                    if(life2 == true && life1 == false) {
                        if(tabuleiro.verificarExistenciaInimigosP2() == true) {
                            System.out.println("O PL2 possui inimigos e não pode se movimentar!");
                            tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                            boolean exe = true;
                            do{
                                try{
                                    System.out.println("\nTudo ok? (1-sim / 2-não)");
                                    key = input.nextInt();
                                    if(key == 1){
                                        exe = false;
                                    } else {
                                        if(key == 2){
                                            System.exit(0);
                                        }
                                    }
                                    
                                } catch (InputMismatchException e){
                                    System.out.println(e);
                                    System.out.println("Digite um valor inteiro!");
                                    input.nextLine();
                                }
                                
                            } while(exe);
                            
                            if(key == 1){
                                int contador2 = 1;
                                while(contador2 <= 2){
                                    tabuleiro.turnoP2(jogador1, jogador2, vetAuxP2, contador2);
                                    tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
                                    contador2 ++;
                                }
    
                                tabuleiro.turnoInimigos(jogador1, vetAuxP1);
    
                                if(jogador1.DEF <= 0 && jogador2.DEF <= 0){
                                    tabuleiro.fimDeJogo();
                                } else {
                                    if(jogador2.DEF <= 0){
                                        tabuleiro.fimDeJogoP2();
                                        tabuleiro.totalInimigosP2 = 0;
                                        jogador2.ATK = 0;
                                        jogador2.DEF = 0;
                                        tabuleiro.position.posSetor2[0] = 0;
                                        tabuleiro.position.posSetor2[1] = 0;
                                    }
                                }

                                tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
            
                                contCiclos ++;
                            } else {
                                System.exit(0);
                            }
                        } else {

                            if(tabuleiro.verificarExistenciaInimigosP2() == false) {
                                boolean exe = true;
                                do{
                                    try{
                                        System.out.println("\nTudo ok? (1-sim / 2-não)");
                                        key = input.nextInt();
                                        if(key == 1){
                                            exe = false;
                                        } else {
                                            if(key == 2){
                                                System.exit(0);
                                            }
                                        }
                                        
                                    } catch (InputMismatchException e){
                                        System.out.println(e);
                                        System.out.println("Digite um valor inteiro!");
                                        input.nextLine();
                                    }
                                    
                                } while(exe);
                                
                                if(key == 1){
                                    
                                    int vet2[] = new int[2];
                                    boolean res2 = false;
                                    boolean repetir = true;
                                    do{
                                        try{
                                            int vet[] = jogador2.movimentar(contCiclos);
                                            boolean rest = tabuleiro.verificarMovimento(vetVmP2, vet);         //tabuleiro.verificarMovimento(vet);
                                            if(rest == true){
                                                vet2 = vet;
                                                res2 = rest;
                                                repetir = false;
                                            } else{
                                                System.out.println("Digite uma posição onde haja portas adjacentes a sua posição atual!");
                                            }
                                        } catch(InputMismatchException e){
                                            System.out.println(e);
                                            System.out.println("Digite um valor inteiro!");
                                            input.nextLine();
                                        }
                                        
                                    } while(repetir);
                                    vetVmP2 = vet2;
                                    tabuleiro.limparSetor(vetAuxP2);
                                    tabuleiro.verificaVitoria(vet2, "P2");
                                    if(res2 == true){
                                        tabuleiro.alterarSetor(vet2, "P2");
                                        tabuleiro.gerarPortaParede(vet2);
                                        tabuleiro.tipoSetorP2();
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
                                        boolean ex = true;
                                        do{
                                            try{
                                                System.out.println("\nTudo ok? (1-sim / 2-não)");
                                                key = input.nextInt();
                                                if(key == 1){
                                                    ex = false;
                                                } else {
                                                    if(key == 2){
                                                        System.exit(0);
                                                    }
                                                }
                                                
                                            } catch (InputMismatchException e){
                                                System.out.println(e);
                                                System.out.println("Digite um valor inteiro!");
                                                input.nextLine();
                                            }
                                            
                                        } while(ex);
                                        
                                        if(key == 1){

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
                                                    tabuleiro.totalInimigosP2 = 0;
                                                    jogador2.ATK = 0;
                                                    jogador2.DEF = 0;
                                                    tabuleiro.position.posSetor2[0] = 0;
                                                    tabuleiro.position.posSetor2[1] = 0;
                                                }
                                            }

                                            tabuleiro.printarTabuleiro(jogador1, jogador2, 0);
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
                }
            }
            contCiclos ++;
        }
        tabuleiro.fimDeJogo();
        input.close();
    }
}