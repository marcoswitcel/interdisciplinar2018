package DTO;

import java.io.Serializable;

public class SubcategoriaProdutoDTO implements Serializable {
    private SubcategoriaDTO csubcategoria;
    private ProdutoDTO cproduto;

    public SubcategoriaDTO getCsubcategoria() {
        return csubcategoria;
    }

    public void setCsubcategoria(SubcategoriaDTO csubcategoria) {
        this.csubcategoria = csubcategoria;
    }

    public ProdutoDTO getCproduto() {
        return cproduto;
    }

    public void setCproduto(ProdutoDTO cproduto) {
        this.cproduto = cproduto;
    }
}