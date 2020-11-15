package semana10;

public class ImovelVelho extends Imovel{

    public ImovelVelho(Endereco end, double preco) {
        this.setEndereco(end);
        this.setPreco(preco);
    }
    
    public void calcularValorImovel() {
        int depreciacao = 2000;
        double valorImovel = this.getPreco() - depreciacao;
        System.out.println("O valor do Imóvel é: " + valorImovel);
    }
}
