/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.SubcategoriaProdutoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import util.ConnectionUtil;

/**
 *
 * @author joaomarcos
 */
public class SubcategoriaProdutoDAO {
    private Connection connection;
    
    public SubcategoriaProdutoDAO() throws Exception {
        connection = ConnectionUtil.getConnection();
    }
    
    public void save(SubcategoriaProdutoDTO ubcategoriaProduto) throws Exception {
        // @TODO implementar
    }
}
