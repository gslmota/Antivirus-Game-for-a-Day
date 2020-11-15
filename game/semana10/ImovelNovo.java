package semana10;

public class ImovelNovo extends Imovel{
    
    public ImovelNovo(Endereco end , double preco) {
        this.setEndereco(end);
        this.setPreco(preco);
    }

    public void calcularValorImovel(){
        int depreciacao = 500;
        double valorTotal = this.getPreco() - depreciacao;
        System.out.println("O valor do Imóvel é: " + valorTotal);
    }
}
