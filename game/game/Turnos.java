package game;
import java.util.Scanner;
public class Turnos {
    protected int contadorCiclos = 0;
    Scanner input = new Scanner(System.in);

    public int[] coletarMovimento(int contadorCiclos){

        if(contadorCiclos<25){

            int posLin, posCol;
            System.out.println("");
            System.out.println("Digite a posição para onde o jogador 1 (PL1) deseja ir na ordem (linha/coluna): ");
            posLin = input.nextInt();
            posCol = input.nextInt();
            int vet[] = {posLin, posCol};
            return vet;
        } else{

            System.out.println("Você Já chegou no limite de 25 ciclos!");
            return null;
        }
    }

    public int [] coletarMovimentoP2(int contadorCiclos){
        if(contadorCiclos<25){

            int posLin, posCol;
            System.out.println("");
            System.out.println("Digite a posição para onde o jogador 2 (PL2) deseja ir na ordem (linha/coluna): ");
            posLin = input.nextInt();
            posCol = input.nextInt();
            int vet[] = {posLin, posCol};
            return vet;
        } else{

            System.out.println("Você Já chegou no limite de 25 ciclos!");
            return null;
        }
    }

    

    public void movimentar(int[] vet){
        
    }
}
