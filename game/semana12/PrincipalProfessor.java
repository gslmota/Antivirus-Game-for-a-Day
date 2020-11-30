package semana12;

import java.util.LinkedList;
import java.util.Scanner;

public class PrincipalProfessor {
 
    public static void main(String[] args) {

        LinkedList <String> listaProfessores = new LinkedList<String>();
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 5; i ++){
            System.out.println("Digite o nome do professor");
            String nome = scanner.next();
            listaProfessores.add(nome);
            System.out.println("Digite a matricula do professor");
            String matricula = scanner.next();
            listaProfessores.add(matricula);
        }
        
        System.out.println("Digite o numero de matricula do professores");
        int num = scanner.nextInt();
        String prof = listaProfessores.get(num);
        System.out.println("Sera o removido o professor cuja matricula foi passada");
        listaProfessores.remove(prof);
        
    }
}
