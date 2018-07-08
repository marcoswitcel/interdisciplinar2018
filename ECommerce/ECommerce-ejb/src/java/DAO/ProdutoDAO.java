
package DAO;

import DTO.MarcaDTO;
import DTO.ProdutoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionUtil;

public class ProdutoDAO {
    private Connection connection;
    
    public ProdutoDAO() throws Exception {
        connection = ConnectionUtil.getConnection();
    }
    
    public ProdutoDTO findById(int cproduto) {
        ProdutoDTO produto = null;
        
        // @TODO lógica 
        
        return produto; 
    }
    
    public List<ProdutoDTO> findAll() throws Exception {
        // Lista para manter os valores do ResultSet
        List<ProdutoDTO> list = new ArrayList<ProdutoDTO>();
        ProdutoDTO produtoDTO;
        String SQL = "SELECT * FROM PRODUTO";
        try {
            // Prepara a SQL
            PreparedStatement p = connection.prepareStatement(SQL);
            // Executa a SQL e mantem os valores no ResultSet rs
            ResultSet rs = p.executeQuery();
            // Navega pelos registros no rs
            while (rs.next()) {
                // Instancia a classe e informa os valores do BD
                produtoDTO = new ProdutoDTO();
                produtoDTO.setCproduto(rs.getInt("produto_id"));
                produtoDTO.setPreco(rs.getDouble("preco"));
                produtoDTO.setCaracteristicas(rs.getString("caracteristicas"));
                produtoDTO.setDesconto(rs.getDouble("desconto"));
                produtoDTO.setQuantidade(rs.getInt("quantidade"));
                MarcaDTO marcaDTO = new MarcaDTO();
                marcaDTO.setCmarca(rs.getInt("cmarca"));
                produtoDTO.setCmarca(marcaDTO);
                // Inclui na lista
                list.add(produtoDTO);
            }
            rs.close();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
        // Retorna a lista
        return list;
    }
}
