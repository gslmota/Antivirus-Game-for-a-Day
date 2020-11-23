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

    public void turnoP1(){
        int contTurnos = 0;
        while(contTurnos < 2){
            System.out.println("-----------------------------");
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
                System.out.println("Digite qual inimigo deseja atacar: ");
                inimigo = input.nextInt();

            } else {
                System.out.println("Será realizada uma procura no setor!");
            }
            contTurnos ++;
        }
        
    }

    public void turnoP2(){
        int contTurnos = 0;
        while(contTurnos < 2){
            System.out.println("-----------------------------");
            System.out.println("|         Turno P2           |");
            System.out.println("-----------------------------");
            System.out.println("-----------------------------");
            System.out.println("| [1] -------------- ATACAR |");
            System.out.println("| [2] ------------ PROCURAR |");
            System.out.println("-----------------------------");
            System.out.println("Digite a opção que ecolheu: ");
            int opcao = 0, inimigo = 0;
            opcao = input.nextInt();
            if(opcao == 1){
                System.out.println("Digite qual inimigo deseja atacar: ");
                inimigo = input.nextInt();

            } else {
                System.out.println("Será realizada uma procura no setor!");
            }
            contTurnos ++;
        }
        
    }
}
