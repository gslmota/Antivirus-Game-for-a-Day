package game;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class Turnos {
    protected int contadorCiclos = 0;
    Scanner input = new Scanner(System.in);
    Random sorteio = new Random();
    Inimigo[] vetInimigoP1 = new Inimigo[5];
    Inimigo[] vetInimigoP2 = new Inimigo[5];
    int totalIniP1 = 0, totalIniP2 = 0;
    int tipoSetorP1 = 0, tipoSetorP2 = 0;

    public Turnos() {
        
    }

    public int gerarInimigosP1(){
        int quantidadeDeInimigos = sorteio.nextInt(5) + 1;
        for(int i = 0; i < quantidadeDeInimigos; i ++){
            vetInimigoP1[i] = new Inimigo();
        }
        this.totalIniP1 = quantidadeDeInimigos;
        return quantidadeDeInimigos;
    }

    public int gerarInimigosP2(){
        int quantidadeDeInimigos = sorteio.nextInt(5) + 1;
        for(int i = 0; i < quantidadeDeInimigos; i ++){
            vetInimigoP2[i] = new Inimigo();
        }
        this.totalIniP2 = quantidadeDeInimigos;
        return quantidadeDeInimigos;
    }

    public void turnoP1(Jogador1 jogador1, int contador) {
        if(this.tipoSetorP1== 2){
            System.out.println("\nComeça agora o turno " + contador + " de P1, escolha uma opção abaixo: ");
            System.out.println("\n    -----------------------------");
            System.out.println("    |         Turno P1           |");
            System.out.println("    -----------------------------");
            System.out.println("    -----------------------------");
            System.out.println("    | [1] -------------- ATACAR |");
            System.out.println("    -----------------------------");
            int opcao = 0, inimigo = 0;
            boolean rep = true;
            do{
                do{
                    try{
                        System.out.println("Digite a opção que escolheu: ");
                        opcao = input.nextInt();
                        rep = false;
                    } catch(InputMismatchException e){
                        System.out.println(e);
                        System.out.println("Digite um valor inteiro!");
                        input.nextLine();
                    }
                } while (rep);
            } while (opcao != 1);
            
            if(opcao == 1){
                boolean x = true;
                do{ 
                    do{
                        try{
                            System.out.println("Digite qual inimigo deseja atacar: (Os inimigos vão de 1 até 5)");
                            inimigo = input.nextInt();
                            if(verificaLife(vetInimigoP1, inimigo) == true){
                                x = false;
                            } else{
                                System.out.println("Digite um inimigo que esteja vivo!");
                            }
                        } catch(InputMismatchException e){
                            System.out.println(e);
                            System.out.println("Digite um valor inteiro!");
                            input.nextLine();
                        } catch(NullPointerException e){
                            System.out.println(e);
                            System.out.println("Digite um inimigo que exista!");
                        }
                    } while (x);
                } while(inimigo < 1 || inimigo > totalIniP1);

                jogador1.atacar(vetInimigoP1, inimigo, 2);
            } else {
                System.out.println("O setor é Privado, ou seja você só pode realizar ataques");
            }
            verificarDefP1(vetInimigoP1);
            contador ++;
        } else  {
            System.out.println("\nComeça agora o turno " + contador + " de P1, escolha uma opção abaixo: ");
            System.out.println("\n    -----------------------------");
            System.out.println("    |         Turno P1           |");
            System.out.println("    -----------------------------");
            System.out.println("    -----------------------------");
            System.out.println("    | [1] -------------- ATACAR |");
            System.out.println("    | [2] ------------ PROCURAR |");
            System.out.println("    -----------------------------");
            int opcao = 0, inimigo = 0;
            boolean rep = true;
            do{
                do{
                    try{
                        System.out.println("Digite a opção que escolheu: ");
                        opcao = input.nextInt();
                        rep = false;
                    } catch(InputMismatchException e){
                        System.out.println(e);
                        System.out.println("Digite um valor inteiro!");
                        input.nextLine();
                    }
                } while (rep);
            } while(opcao != 1 && opcao != 2);

            if(opcao == 1){
                boolean x = true;
                do{ 
                    do{
                        try{
                            System.out.println("Digite qual inimigo deseja atacar: (Os inimigos vão de 1 até 5)");
                            inimigo = input.nextInt();
                            if(verificaLife(vetInimigoP1, inimigo) == true){
                                x = false;
                            } else{
                                System.out.println("Digite um inimigo que esteja vivo!");
                            }
                        } catch(InputMismatchException e){
                            System.out.println(e);
                            System.out.println("Digite um valor inteiro!");
                            input.nextLine();
                        } catch(NullPointerException e){
                            System.out.println(e);
                            System.out.println("Digite um inimigo que exista!");
                        }
                    } while (x);
                } while(inimigo < 1 || inimigo > totalIniP1);
                
                if(this.tipoSetorP1 == 1){
                    jogador1.atacar(vetInimigoP1, inimigo, 1);
                } else {
                    jogador1.atacar(vetInimigoP1, inimigo, 0);
                }
            } else {
                System.out.println("Será realizada uma procura no setor!");
                jogador1.procurar(vetInimigoP1, totalIniP1);
            }
            verificarDefP1(vetInimigoP1);
            contador ++;
        }
        
    }

    public void turnoP2(Jogador1 jogador1, Jogador2 jogador2, int[] vet1, int[] vet2, int contador){
        if(this.tipoSetorP2 == 2){
            System.out.println("O setor é Privado");
            System.out.println("\n Começa agora o turno " + contador  + " de P2, escolha uma opção abaixo: ");
            System.out.println("\n    -----------------------------");
            System.out.println("    |         Turno P2           |");
            System.out.println("    -----------------------------");
            System.out.println("    -----------------------------");
            System.out.println("    | [1] -------------- ATACAR |");
            System.out.println("    | [2] ---- RECUPERAR DEFESA |");
            System.out.println("    -----------------------------");
    
            int opcao = 0, inimigo = 0;
            boolean rep = true;

            do{ 
                try{
                    System.out.println("Digite a opção que escolheu: ");
                    opcao = input.nextInt();
                    if(opcao == 1 || opcao == 2) {
                        rep = false;
                    }
                } catch (InputMismatchException e){
                    System.out.println(e);
                    System.out.println("Digite um valor inteiro: ");
                    input.nextLine();
                }
                
            } while(rep);

            if(opcao == 1){
                
                if(vet2[0] == vet1[0] && vet2[1] == vet1[1]){
                    boolean x = true;
                    do{
                        do{
                            try{
                                System.out.println("Digite qual inimigo deseja atacar: (Os inimigos vão de 1 até 5)");
                                inimigo = input.nextInt();
                                if(verificaLife(vetInimigoP1, inimigo) == true){
                                    x = false;
                                } else{
                                    System.out.println("Digite um inimigo que esteja vivo!");
                                }
                            } catch (InputMismatchException e){
                                System.out.println(e);
                                System.out.println("Digite um valor inteiro!");
                                input.nextLine();
                            } catch(NullPointerException e){
                                System.out.println(e);
                                System.out.println("Digite um inimigo que exista!");
                            }
                            
                        } while(x);
                    } while(inimigo < 1 || inimigo > totalIniP1);
                    
                    jogador2.atacar(vetInimigoP1, inimigo, 2);
                } else {
                    do{
                        boolean x = true;
                        do{
                            try{
                                System.out.println("Digite qual inimigo deseja atacar: (Os inimigos vão de 1 até 5)");
                                inimigo = input.nextInt();
                                if(verificaLife(vetInimigoP2, inimigo) == true){
                                    x = false;
                                } else{
                                    System.out.println("Digite um inimigo que esteja vivo!");
                                }
                            } catch (InputMismatchException e){
                                System.out.println(e);
                                System.out.println("Digite um valor inteiro!");
                                input.nextLine();
                            } catch(NullPointerException e){
                                System.out.println(e);
                                System.out.println("Digite um inimigo que exista!");
                            }
                            
                        } while(x);
                    } while(inimigo < 1 || inimigo > totalIniP2);

                    jogador2.atacar(vetInimigoP2, inimigo, 2);
                }
                
            } else {
            
                if(opcao == 2){
                    System.out.println("Deseja recuperar defesa de P1 ou P2 ?");
                    System.out.println("\n    -----------------------------");
                    System.out.println("    ------RECUPERAR  DEFESA------");
                    System.out.println("    -----------------------------");
                    System.out.println("    | [1] ------------------ P1 |");
                    System.out.println("    | [2] ------------------ P2 |");
                    System.out.println("    -----------------------------");
                    int escolha = 0;
                    boolean repe = true;
                    do{
                        try{
                            escolha = input.nextInt();
                            if(escolha == 1){
                                if(vet2[0] == vet1[0] && vet2[1] == vet1[1]){
                                    jogador1.DEF += 2;
                                    repe = false;
                                } else{
                                    System.out.println("Você não pode recuperar defesa de P1!");
                                    System.out.println("As posições de de PL1 e PL2 são diferentes!");
                                    System.out.println("Digite outro jogador: ");
                                }
                            } else {
                                if(escolha == 2){
                                    jogador2.DEF += 2;
                                    repe = false;
                                }
                            }
                        } catch (InputMismatchException e){
                            System.out.println(e);
                            System.out.println("Digite um valor inteiro!");
                            input.nextLine();
                        }
                        
                    } while(repe);
                    
                }
            }
            if(vet2[0] == vet1[0] && vet2[1] == vet1[1]){
                verificarDefP1(vetInimigoP1);
            } else {
                verificarDefP2(vetInimigoP2);
            }
            contador ++;
        } else {
            System.out.println("\n Começa agora o turno " + contador  + " de P2, escolha uma opção abaixo: ");
            System.out.println("\n    -----------------------------");
            System.out.println("    |         Turno P2           |");
            System.out.println("    -----------------------------");
            System.out.println("    -----------------------------");
            System.out.println("    | [1] -------------- ATACAR |");
            System.out.println("    | [2] ------------ PROCURAR |");
            System.out.println("    | [3] ---- RECUPERAR DEFESA |");
            System.out.println("    -----------------------------");
            int opcao = 0, inimigo = 0;
            boolean rep = true;
            do{ 
                try{
                    System.out.println("Digite a opção que escolheu: ");
                    opcao = input.nextInt();
                    if(opcao == 1 || opcao == 2 || opcao == 3) {
                        rep = false;
                    }
                } catch (InputMismatchException e){
                    System.out.println(e);
                    System.out.println("Digite um valor inteiro!");
                    input.nextLine();
                }
                
            } while(rep);
            
            if(opcao == 1){
                if(vet2[0] == vet1[0] && vet2[1] == vet1[1]){
                    boolean x = true;
                    do{
                        do{
                            try{
                                System.out.println("Digite qual inimigo deseja atacar: (Os inimigos vão de 1 até 5)");
                                inimigo = input.nextInt();
                                if(verificaLife(vetInimigoP1, inimigo) == true){
                                    x = false;
                                } else{
                                    System.out.println("Digite um inimigo que esteja vivo!");
                                }
                            } catch (InputMismatchException e){
                                System.out.println(e);
                                System.out.println("Digite um valor inteiro!");
                                input.nextLine();
                            } catch(NullPointerException e){
                                System.out.println(e);
                                System.out.println("Digite um inimigo que exista!");
                            }
                            
                        } while(x);
                    } while(inimigo < 1 || inimigo > totalIniP1);

                    if(this.tipoSetorP2 == 1){
                        jogador2.atacar(vetInimigoP1, inimigo, 1);
                    } else {
                        jogador2.atacar(vetInimigoP1, inimigo, 0);
                    }
                    
                } else{
                    boolean x = true;
                    do{
                        do{
                            try{
                                System.out.println("Digite qual inimigo deseja atacar: (Os inimigos vão de 1 até 5)");
                                inimigo = input.nextInt();
                                if(verificaLife(vetInimigoP2, inimigo) == true){
                                    x = false;
                                } else{
                                    System.out.println("Digite um inimigo que esteja vivo!");
                                }
                            } catch (InputMismatchException e){
                                System.out.println(e);
                                System.out.println("Digite um valor inteiro!");
                                input.nextLine();
                            } catch(NullPointerException e){
                                System.out.println(e);
                                System.out.println("Digite um inimigo que exista!");
                            }
                            
                        } while(x);
                    } while(inimigo < 1 || inimigo > totalIniP2);

                    if(this.tipoSetorP2 == 1){
                        jogador2.atacar(vetInimigoP2, inimigo, 1);
                    } else {
                        jogador2.atacar(vetInimigoP2, inimigo, 0);
                    }
                }

            } else {
                if (opcao == 2){
                    System.out.println("Será realizada uma procura no setor!");
                    jogador2.procurar(vetInimigoP2, totalIniP2);
                }
    
                if(opcao == 3){
                    System.out.println("Deseja recuperar defesa de P1 ou P2 ?");
                    System.out.println("\n    -----------------------------");
                    System.out.println("    ------RECUPERAR  DEFESA------");
                    System.out.println("    -----------------------------");
                    System.out.println("    | [1] ------------------ P1 |");
                    System.out.println("    | [2] ------------------ P2 |");
                    System.out.println("    -----------------------------");
                    int escolha = 0;
                    boolean repe = true;
                    do{
                        try{
                            escolha = input.nextInt();
                            if(escolha == 1){
                                if(vet2[0] == vet1[0] && vet2[1] == vet1[1]){
                                    jogador1.DEF += 2;
                                    repe = false;
                                } else{
                                    System.out.println("Você não pode recuperar defesa de P1!");
                                    System.out.println("As posições de de PL1 e PL2 são diferentes!");
                                    System.out.println("Digite outro jogador: ");
                                }
                            } else {
                                if(escolha == 2){
                                    jogador2.DEF += 2;
                                    repe = false;
                                }
                            }
                        } catch (InputMismatchException e){
                            System.out.println(e);
                            System.out.println("Digite um valor inteiro!");
                            input.nextLine();
                        }
                        
                    } while(repe);
                }
            }
            if(vet2[0] == vet1[0] && vet2[1] == vet1[1]){
                verificarDefP1(vetInimigoP1);
            } else {
                verificarDefP2(vetInimigoP2);
            }
            contador ++;
        }
        
    }

    public void turnoP2(Jogador1 jogador1, Jogador2 jogador2, int[] vet2, int contador){
        if(this.tipoSetorP2 == 2){
            System.out.println("O setor é Privado");
            System.out.println("\n Começa agora o turno " + contador  + " de P2, escolha uma opção abaixo: ");
            System.out.println("\n    -----------------------------");
            System.out.println("    |         Turno P2           |");
            System.out.println("    -----------------------------");
            System.out.println("    -----------------------------");
            System.out.println("    | [1] -------------- ATACAR |");
            System.out.println("    | [2] ---- RECUPERAR DEFESA |");
            System.out.println("    -----------------------------");
            int opcao = 0, inimigo = 0;
            boolean rep = true;
            do{ 
                try{
                    System.out.println("Digite a opção que escolheu: ");
                    opcao = input.nextInt();
                    if(opcao == 1 || opcao == 2) {
                        rep = false;
                    }
                } catch (InputMismatchException e){
                    System.out.println(e);
                    System.out.println("Digite um valor inteiro!");
                    input.nextLine();
                }
                
            } while(rep);
            if(opcao == 1){
                boolean x = true;
                    do{
                        do{
                            try{
                                System.out.println("Digite qual inimigo deseja atacar: (Os inimigos vão de 1 até 5)");
                                inimigo = input.nextInt();
                                if(verificaLife(vetInimigoP2, inimigo) == true){
                                    x = false;
                                } else{
                                    System.out.println("Digite um inimigo que esteja vivo!");
                                }
                            } catch (InputMismatchException e){
                                System.out.println(e);
                                System.out.println("Digite um valor inteiro!");
                                input.nextLine();
                            } catch(NullPointerException e){
                                System.out.println(e);
                                System.out.println("Digite um inimigo que exista!");
                            }
                            
                        } while(x);
                    } while(inimigo < 1 || inimigo > totalIniP2);
                jogador2.atacar(vetInimigoP2, inimigo, 2);
            } else {
            
                if(opcao == 2){
                    System.out.println("Deseja recuperar defesa?");
                    System.out.println("\n    -----------------------------");
                    System.out.println("    ------RECUPERAR  DEFESA------");
                    System.out.println("    -----------------------------");
                    System.out.println("    | [1] ------------------ P2 |");
                    System.out.println("    -----------------------------");
                    int escolha = 0;
                    boolean rp = true;
                    do{
                        do{
                            try{
                                System.out.println("Digite a opção que escolheu: ");
                                escolha = input.nextInt();
                                rp = false;
                            } catch (InputMismatchException e){
                                System.out.println(e);
                                System.out.println("Digite um valor inteiro!");
                                input.nextLine();
                            }
                        } while(rp);
                    } while(escolha != 1);
                    
                    if(escolha == 1){
                        jogador2.DEF += 2;
                    }
                } 
            }
            verificarDefP2(vetInimigoP2);
            contador ++;
        } else {
            System.out.println("\n Começa agora o turno " + contador  + " de P2, escolha uma opção abaixo: ");
            System.out.println("\n    -----------------------------");
            System.out.println("    |         Turno P2           |");
            System.out.println("    -----------------------------");
            System.out.println("    -----------------------------");
            System.out.println("    | [1] -------------- ATACAR |");
            System.out.println("    | [2] ------------ PROCURAR |");
            System.out.println("    | [3] ---- RECUPERAR DEFESA |");
            System.out.println("    -----------------------------");
            int opcao = 0, inimigo = 0;
            boolean rep = true;
            do{ 
                try{
                    System.out.println("Digite a opção que escolheu: ");
                    opcao = input.nextInt();
                    if(opcao == 1 || opcao == 2 || opcao == 3) {
                        rep = false;
                    }
                } catch (InputMismatchException e){
                    System.out.println(e);
                    System.out.println("Digite um valor inteiro!");
                    input.nextLine();
                }
                
            } while(rep);
            if(opcao == 1){
                boolean x = true;
                    do{
                        do{
                            try{
                                System.out.println("Digite qual inimigo deseja atacar: (Os inimigos vão de 1 até 5)");
                                inimigo = input.nextInt();
                                if(verificaLife(vetInimigoP2, inimigo) == true){
                                    x = false;
                                } else{
                                    System.out.println("Digite um inimigo que esteja vivo!");
                                }
                            } catch (InputMismatchException e){
                                System.out.println(e);
                                System.out.println("Digite um valor inteiro!");
                                input.nextLine();
                            } catch(NullPointerException e){
                                System.out.println(e);
                                System.out.println("Digite um inimigo que exista!");
                            }
                            
                        } while(x);
                    } while(inimigo < 1 || inimigo > totalIniP2);
                if(this.tipoSetorP2 == 1){
                    jogador2.atacar(vetInimigoP2, inimigo, 1);
                } else {
                    jogador2.atacar(vetInimigoP2, inimigo, 0);
                }
            } else {
                if (opcao == 2){
                    System.out.println("Será realizada uma procura no setor!");
                    jogador2.procurar(vetInimigoP2, totalIniP2);
                }
    
                if(opcao == 3){
                    System.out.println("Deseja recuperar defesa?");
                    System.out.println("\n    -----------------------------");
                    System.out.println("    ------RECUPERAR  DEFESA------");
                    System.out.println("    -----------------------------");
                    System.out.println("    | [1] ------------------ P2 |");
                    System.out.println("    -----------------------------");
                    int escolha = 0;
                    boolean rp = true;
                    do{
                        do{
                            try{
                                System.out.println("Digite a opção que escolheu: ");
                                escolha = input.nextInt();
                                rp = false;
                            } catch (InputMismatchException e){
                                System.out.println(e);
                                System.out.println("Digite um valor inteiro!");
                                input.nextLine();
                            }
                        } while(rp);
                    } while(escolha != 1);
                    if(escolha == 1){
                        jogador2.DEF += 2;
                    }
                }
            }
            verificarDefP2(vetInimigoP2);
            contador ++;
        }
        
    }

    public void turnoInimigos(Jogador1 jogador1, Jogador2 jogador2, int[] vet1, int[] vet2){
        System.out.println("Começa agora o turno dos Inimigos.");
        if(vet2[0] == vet1[0] && vet2[1] == vet1[1]){
            for(int i = 0; i < totalIniP1; i ++){
                if(vetInimigoP1[i].DEF != 0){
                    int resultado = sorteio.nextInt(6) + 1;
                    if(resultado %2 == 0){
                        jogador1.DEF -= vetInimigoP1[i].ATK;
                        jogador2.DEF -= vetInimigoP1[i].ATK;
                    } else {
    
                    }
                }
            }
        } else {
            for(int i = 0; i < totalIniP1; i ++){
                if(vetInimigoP1[i].DEF != 0){
                    int resultado = sorteio.nextInt(6) + 1;
                    if(resultado %2 == 0){
                        jogador1.DEF -= vetInimigoP1[i].ATK;
                    } else {
    
                    }
                }
            }
    
            for(int i = 0; i < totalIniP2; i ++){
                if(vetInimigoP2[i].DEF != 0){
                    int resultado = sorteio.nextInt(6) + 1;
                    if(resultado %2 == 0){
                        jogador2.DEF -= vetInimigoP2[i].ATK;
                    } else {
    
                    }
                }
            }
        }
    }

    public void turnoInimigos(Jogador2 jogador2,int[] vet2){
        System.out.println("Começa agora o turno dos Inimigos.");
        for(int i = 0; i < totalIniP2; i ++){
            if(vetInimigoP2[i].DEF != 0){
                int resultado = sorteio.nextInt(6) + 1;
                if(resultado %2 == 0){
                    jogador2.DEF -= vetInimigoP2[i].ATK;
                } else {

                }
            }
        }
    }

    public void turnoInimigos(Jogador1 jogador1,int[] vet1){
        System.out.println("Começa agora o turno dos Inimigos.");
        for(int i = 0; i < totalIniP1; i ++){
            if(vetInimigoP1[i].DEF != 0){
                int resultado = sorteio.nextInt(6) + 1;
                if(resultado %2 == 0){
                    jogador1.DEF -= vetInimigoP1[i].ATK;
                } else {

                }
            }
        }
    }

    public void verificarDefP1(Inimigo[] vet){
        for(int i = 0; i < totalIniP1; i ++){
            if(vet[i].DEF <= 0){
                vet[i].DEF = 0;
                vet[i].ATK = 0;
            }
        }
    }

    public void verificarDefP2(Inimigo[] vet){
        for(int i = 0; i < totalIniP2; i ++){
            if(vet[i].DEF <= 0){
                vet[i].DEF = 0;
                vet[i].ATK = 0;
            }
        }
    }

    public boolean verificarExistenciaInimigosP1(Inimigo[] vet){
        for(int i = 0; i < totalIniP1; i ++){
            if(vet[i].DEF > 0){
                return true;
            }
        }
        return false;
    }

    public boolean verificarExistenciaInimigosP2(Inimigo[] vet){
        for(int i = 0; i < totalIniP2; i ++){
            if(vet[i].DEF > 0){
                return true;
            }
        }
        return false;
    }

    public boolean verificaLife(Inimigo[] vet, int pos){
        
        if(vet[pos - 1].DEF > 0){
            return true;
        } 
        return false;
    }

}
