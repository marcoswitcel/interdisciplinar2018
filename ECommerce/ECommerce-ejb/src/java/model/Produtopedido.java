package model;

public class Produtopedido  {
    private Produto cproduto;
    private Pedido cpedido;
    private int quantidade;
    private double preco;
    private double descont;

    public Produto getCproduto() {
        return cproduto;
    }

    public void setCproduto(Produto cproduto) {
        this.cproduto = cproduto;
    }

    public Pedido getCpedido() {
        return cpedido;
    }

    public void setCpedido(Pedido cpedido) {
        this.cpedido = cpedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getDescont() {
        return descont;
    }

    public void setDescont(double descont) {
        this.descont = descont;
    }
    
    
}