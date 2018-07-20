package DTO;

import java.io.Serializable;

public class SubcategoriaDTO implements Serializable {
    private int csubcategoria;
    private CategoriaDTO ccategoria;
    private String nome;

    public int getCsubcategoria() {
        return csubcategoria;
    }

    public void setCsubcategoria(int csubcategoria) {
        this.csubcategoria = csubcategoria;
    }

    public CategoriaDTO getCcategoria() {
        return ccategoria;
    }

    public void setCcategoria(CategoriaDTO ccategoria) {
        this.ccategoria = ccategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}