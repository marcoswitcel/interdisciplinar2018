package DTO;

import java.io.Serializable;

public class MarcaDTO implements Serializable {
    private int cmarca;
    private String nome;

    public int getCmarca() {
        return cmarca;
    }

    public void setCmarca(int cmarca) {
        this.cmarca = cmarca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}