package game;
import java.util.Scanner;
public class Turnos {
    int contadorCiclos = 0;
    Scanner input = new Scanner(System.in);

    public int[] movimentar(){
        
        int posLin, posCol;
        System.out.println("");
        System.out.println("Digite a posição para onde deseja ir na ordem (linha/coluna): ");
        posLin = input.nextInt();
        posCol = input.nextInt();
        int vet[] = {posLin, posCol};
        return vet;
    }
    
}
