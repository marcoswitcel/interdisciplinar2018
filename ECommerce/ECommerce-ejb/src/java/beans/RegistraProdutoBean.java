/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DAO.ProdutoDAO;
import DAO.SubcategoriaProdutoDAO;
import DTO.ProdutoDTO;
import DTO.SubcategoriaProdutoDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author joaomarcos
 */
@Stateless
public class RegistraProdutoBean implements RegistraProdutoBeanRemote, RegistraProdutoBeanLocal {

    public boolean registraProduto(SubcategoriaProdutoDTO subcategoriaProduto) {
        boolean cadastrado = false;

        
        registrando :
        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            SubcategoriaProdutoDAO subcategoriaProdutoDAO;
            subcategoriaProdutoDAO = new SubcategoriaProdutoDAO();
            
            ProdutoDTO produto = subcategoriaProduto.getCproduto();
            
            if (validaProduto(produto)) {
                // @TODO validar se a categoria existe
            } else {
                break registrando;
            }
            
            // Se passar por todas as validações
            produtoDAO.save(produto);            
            subcategoriaProdutoDAO.save(subcategoriaProduto);
            
        } catch (Exception ex) {
            Logger.getLogger(RegistraCompraBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cadastrado;
    }
    
    private boolean validaProduto(ProdutoDTO produto) {
        // Valida se todos os campos são dirente de null
        // e outras regras podem ser adicionadas aqui
        // cproduto é desconsiderado
        return (
            produto.getImagem() != null &&
            produto.getPreco() > 0 &&
            produto.getCaracteristicas() != null &&
            produto.getCaracteristicas().length() > 0 &&
            produto.getCmarca() != null &&
            produto.getCmarca().getCmarca() != 0
        );
    }
}
