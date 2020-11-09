package game1;
import java.util.Scanner;
public class Turnos {
    int contadorCiclos = 0;
    Scanner input = new Scanner(System.in);

    public int[] movimentar(){
        if(contadorCiclos<25){
            int posLin, posCol;
            System.out.println("");
            System.out.println("Digite a posição para onde deseja ir na ordem (linha/coluna): ");
            posLin = input.nextInt();
            posCol = input.nextInt();
            int vet[] = {posLin, posCol};
            contadorCiclos ++;
            return vet;
        } else{
            System.out.println("Você Já chegou no limite de 25 ciclos!");
            return null;
        }
    }
    
}
