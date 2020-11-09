package game;
public class Setor {
    String porta = "|";
    String [] vetorSetor = {"|", " ", " ", " ",porta, " ", " ", " ",porta, " ", " ", " ",porta, " ", " ", " ",porta, " ", " ", " ","|"};




    public void movimentaSetor(int[] vet){
        int posLin = vet[0];
        int posCol = vet[1];
        apagarTela();
        criarSetor(posLin, posCol);
    }

    public void criarSetor(int posLin, int posCol) {
        int nPortas = posicao.nextInt(10) + 1;
        int totalPortas = nPortas;

    }

}
