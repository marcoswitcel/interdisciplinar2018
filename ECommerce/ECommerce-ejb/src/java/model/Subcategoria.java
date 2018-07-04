package model;

public class Subcategoria  {
    private int csubcategoria;
    private Categoria ccategoria;
    private String nome;

    public int getCsubcategoria() {
        return csubcategoria;
    }

    public void setCsubcategoria(int csubcategoria) {
        this.csubcategoria = csubcategoria;
    }

    public Categoria getCcategoria() {
        return ccategoria;
    }

    public void setCcategoria(Categoria ccategoria) {
        this.ccategoria = ccategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}