package semana10;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Imovel[] imoveis = new Imovel [200];
        Random altenar = new Random();

        // Usei o next para prencher pq o nextLine não funciona
        for(int i = 0; i < imoveis.length; i++){
            System.out.println("Digite a rua: ");
            String rua = input.nextLine();
            System.out.println("Digite o numero: ");
            int num = input.nextInt();
            input.nextLine();
            System.out.println("Digite o bairro: ");
            String bairro = input.nextLine();
            System.out.println("Digite a cidade: ");
            String cidade = input.nextLine();
            System.out.println("Digite o estado: ");
            String estado = input.nextLine();
            Endereco end = new Endereco(rua, bairro, cidade, estado, num);
            System.out.println("Digite o preço do imovel: ");
            double preco = input.nextDouble();
            input.nextLine();
            int sort = altenar.nextInt(2);
            if(sort == 0){
                imoveis[i] = new ImovelVelho(end, preco);
            } else {
                imoveis[i] = new ImovelNovo(end, preco);
            }
        }

        for(int i = 0; i < imoveis.length; i ++){
            imoveis[i].calcularValorImovel();
        }

    }

}
