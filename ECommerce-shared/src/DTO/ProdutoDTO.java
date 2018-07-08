package DTO;

import java.io.Serializable;

public class ProdutoDTO implements Serializable {
    private int cproduto; 
    private double preco;
    private String caracteristicas;
    private double desconto;
    private int quantidade;
    private MarcaDTO cmarca;

    public int getCproduto() {
        return cproduto;
    }

    public void setCproduto(int cproduto) {
        this.cproduto = cproduto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public MarcaDTO getCmarca() {
        return cmarca;
    }

    public void setCmarca(MarcaDTO cmarca) {
        this.cmarca = cmarca;
    }
}