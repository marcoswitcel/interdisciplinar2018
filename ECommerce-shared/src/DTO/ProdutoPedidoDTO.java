package DTO;

import java.io.Serializable;

public class ProdutoPedidoDTO implements Serializable {
    private ProdutoDTO cproduto;
    private PedidoDTO cpedido;
    private int quantidade;
    private double preco;
    private double descont;

    public ProdutoDTO getCproduto() {
        return cproduto;
    }

    public void setCproduto(ProdutoDTO cproduto) {
        this.cproduto = cproduto;
    }

    public PedidoDTO getCpedido() {
        return cpedido;
    }

    public void setCpedido(PedidoDTO cpedido) {
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