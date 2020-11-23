package game;
import java.util.Random;
import java.util.Scanner;
public class Turnos {
    protected int contadorCiclos = 0;
    Scanner input = new Scanner(System.in);
    Random sorteio = new Random();
    
    Inimigo[] vetInimigoP1 = new Inimigo[5];
    Inimigo[] vetInimigoP2 = new Inimigo[5];

    public Turnos() {
        
    }

    public int gerarInimigosP1(){
        int quantidadeDeInimigos = sorteio.nextInt(5) + 1;
        for(int i = 0; i < quantidadeDeInimigos; i ++){
            vetInimigoP1[i] = new Inimigo();
        }
        return quantidadeDeInimigos;
    }

    public int gerarInimigosP2(){
        int quantidadeDeInimigos = sorteio.nextInt(5) + 1;
        for(int i = 0; i < quantidadeDeInimigos; i ++){
            vetInimigoP2[i] = new Inimigo();
        }
        return quantidadeDeInimigos;
    }

    public void turnoP1(Jogador1 jogador1) {
        int contador = 0;
        while(contador < 2){
            System.out.println("\n Começa agora o turno " + contador + 1 + " de P1, escolha uma opção abaixo: ");
            System.out.println("\n-----------------------------");
            System.out.println("|         Turno P1           |");
            System.out.println("-----------------------------");
            System.out.println("-----------------------------");
            System.out.println("| [1] -------------- ATACAR |");
            System.out.println("| [2] ------------ PROCURAR |");
            System.out.println("-----------------------------");
            System.out.println("Digite a opção que ecolheu: ");
            int opcao = 0, inimigo = 0;
            opcao = input.nextInt();
            if(opcao == 1){
                System.out.println("Digite qual inimigo deseja atacar: (Os inimigos vão de 1 até 5)");
                inimigo = input.nextInt();
                vetInimigoP1[inimigo - 1].DEF -= jogador1.ATK;
                jogador1.atacar(vetInimigoP1, inimigo);
            } else {
                System.out.println("Será realizada uma procura no setor!");
                jogador1.procurar(vetInimigoP1);
            }
            contador ++;
        }
    }

    public void turnoP2(Jogador1 jogador1, Jogador2 jogador2, int[] vet1, int[] vet2){
        int contador = 0;
        while(contador < 2){
            System.out.println("\n  Começa agora o turno " + contador + 1 + " de P2, escolha uma opção abaixo: ");
            System.out.println("\n-----------------------------");
            System.out.println("|         Turno P2           |");
            System.out.println("-----------------------------");
            System.out.println("-----------------------------");
            System.out.println("| [1] -------------- ATACAR |");
            System.out.println("| [2] ------------ PROCURAR |");
            System.out.println("| [3] ---- RECUPERAR DEFESA |");
            System.out.println("-----------------------------");
            System.out.println("Digite a opção que ecolheu: ");
            int opcao = 0, inimigo = 0;
            opcao = input.nextInt();
            if(opcao == 1){
                System.out.println("Digite qual inimigo deseja atacar: (Os inimigos vão de 1 até 5)");
                inimigo = input.nextInt();
                vetInimigoP2[inimigo - 1].DEF -= jogador2.ATK;
            } else {
                if (opcao == 2){
                    System.out.println("Será realizada uma procura no setor!");
                    jogador2.procurar(vetInimigoP2);
                }

                if(opcao == 3){
                    System.out.println("Deseja recuperar defesa de P1 ou P2 ?");
                    System.out.println("\n-----------------------------");
                    System.out.println("| [1] ------------------ P1 |");
                    System.out.println("| [2] ------------------ P2 |");
                    System.out.println("-----------------------------");
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
            contador ++;
        }
    }

    public void turnoInimigos(){

    }
}
