package game;
import java.util.Random;
import java.util.Scanner;
public class Turnos {
    protected int contadorCiclos = 0;
    Scanner input = new Scanner(System.in);
    Random sorteio = new Random();
    Inimigo[] vetInimigoP1 = new Inimigo[5];
    Inimigo[] vetInimigoP2 = new Inimigo[5];
    int totalIniP1 = 0, totalIniP2 = 0;
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

        System.out.println("\nComeça agora o turno " + contador + " de P1, escolha uma opção abaixo: ");
        System.out.println("\n    -----------------------------");
        System.out.println("    |         Turno P1           |");
        System.out.println("    -----------------------------");
        System.out.println("    -----------------------------");
        System.out.println("    | [1] -------------- ATACAR |");
        System.out.println("    | [2] ------------ PROCURAR |");
        System.out.println("    -----------------------------");
        System.out.println("Digite a opção que escolheu: ");
        int opcao = 0, inimigo = 0;
        opcao = input.nextInt();
        if(opcao == 1){
            System.out.println("Digite qual inimigo deseja atacar: (Os inimigos vão de 1 até 5)");
            inimigo = input.nextInt();
            //vetInimigoP1[inimigo - 1].DEF -= jogador1.ATK;
            jogador1.atacar(vetInimigoP1, inimigo);
        } else {
            System.out.println("Será realizada uma procura no setor!");
            jogador1.procurar(vetInimigoP1, totalIniP1);
        }
        verificarDefP1(vetInimigoP1);
        contador ++;
    }

    public void turnoP2(Jogador1 jogador1, Jogador2 jogador2, int[] vet1, int[] vet2, int contador){
        System.out.println("\n Começa agora o turno " + contador  + " de P2, escolha uma opção abaixo: ");
        System.out.println("\n    -----------------------------");
        System.out.println("    |         Turno P2           |");
        System.out.println("    -----------------------------");
        System.out.println("    -----------------------------");
        System.out.println("    | [1] -------------- ATACAR |");
        System.out.println("    | [2] ------------ PROCURAR |");
        System.out.println("    | [3] ---- RECUPERAR DEFESA |");
        System.out.println("    -----------------------------");
        System.out.println("Digite a opção que escolheu: ");
        int opcao = 0, inimigo = 0;
        opcao = input.nextInt();
        if(opcao == 1){
            System.out.println("Digite qual inimigo deseja atacar: (Os inimigos vão de 1 até 5)");
            inimigo = input.nextInt();
            //vetInimigoP2[inimigo - 1].DEF -= jogador2.ATK;
            jogador2.atacar(vetInimigoP2, inimigo);
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
                escolha = input.nextInt();
                if(escolha == 1){
                    if(vet2[0] == vet1[0] && vet2[1] == vet1[1]){
                        jogador1.DEF += 2;
                    }
                } else {
                    jogador2.DEF += 2;
                }
            }
        }

        verificarDefP2(vetInimigoP2);
        contador ++;
    }

    public void turnoInimigos(Jogador1 jogador1, Jogador2 jogador2){
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

}
