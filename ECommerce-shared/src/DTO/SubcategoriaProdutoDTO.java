package DTO;

import java.io.Serializable;

public class SubcategoriaProdutoDTO implements Serializable {
    private Subcategoria csubcategoria;
    private ProdutoDTO cproduto;

    public Subcategoria getCsubcategoria() {
        return csubcategoria;
    }

    public void setCsubcategoria(Subcategoria csubcategoria) {
        this.csubcategoria = csubcategoria;
    }

    public ProdutoDTO getCproduto() {
        return cproduto;
    }

    public void setCproduto(ProdutoDTO cproduto) {
        this.cproduto = cproduto;
    }
}