package model;

import java.util.Date;

public class Pedido  {
    private int cpedido;
    private Cliente cpf;
    private Date data;

    public int getCpedido() {
        return cpedido;
    }

    public void setCpedido(int cpedido) {
        this.cpedido = cpedido;
    }

    public Cliente getCpf() {
        return cpf;
    }

    public void setCpf(Cliente cpf) {
        this.cpf = cpf;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
        
    
}