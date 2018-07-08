package DTO;

import java.io.Serializable;
import java.util.Date;

public class PedidoDTO implements Serializable {
    private int cpedido;
    private ClienteDTO cpf;
    private Date data;

    public int getCpedido() {
        return cpedido;
    }

    public void setCpedido(int cpedido) {
        this.cpedido = cpedido;
    }

    public ClienteDTO getCpf() {
        return cpf;
    }

    public void setCpf(ClienteDTO cpf) {
        this.cpf = cpf;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}