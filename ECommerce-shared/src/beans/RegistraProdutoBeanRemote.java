/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DTO.SubcategoriaProdutoDTO;
import javax.ejb.Remote;

/**
 *
 * @author joaomarcos
 */
@Remote
public interface RegistraProdutoBeanRemote {
     public boolean registraProduto(SubcategoriaProdutoDTO subcategoriaProduto);
}
