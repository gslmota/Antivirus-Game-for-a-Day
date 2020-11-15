package game;
import java.util.Scanner;
public class Turnos {
    int contadorCiclos = 0;
    Scanner input = new Scanner(System.in);

    public int[] coletarMovimentoP1(int contadorCiclos){

        if(contadorCiclos<25){

            int posLin, posCol;
            System.out.println("");
            System.out.println("Digite a posição para onde P1 deseja ir na ordem (linha/coluna): ");
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
            System.out.println("Digite a posição para onde P2 deseja ir na ordem (linha/coluna): ");
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
