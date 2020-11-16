package semana10;

public abstract class Imovel {

    protected Endereco endereco;
    protected double preco;

    public Imovel (){

    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public void calcularValorImovel (){
        System.out.println("O preço do Imóvel é: " + this.preco);
    }
}
