package DTO;

import java.io.Serializable;

public class CategoriaDTO implements Serializable {

    private int ccategoria;
    private String nome;

    public int getCcategoria() {
        return ccategoria;
    }

    public void setCcategoria(int ccategoria) {
        this.ccategoria = ccategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
