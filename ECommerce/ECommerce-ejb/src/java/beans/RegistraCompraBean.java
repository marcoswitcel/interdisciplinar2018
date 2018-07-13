package beans;

import DAO.ClienteDAO;
import DAO.PedidoDAO;
import DAO.ProdutoPedidoDAO;
import DAO.ProdutoDAO;
import DTO.ClienteDTO;
import DTO.PedidoDTO;
import DTO.ProdutoDTO;
import DTO.ProdutoPedidoDTO;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 * @author joaomarcos
 */

@Stateless
public class RegistraCompraBean implements RegistraCompraBeanLocal {
    /**
     * EJB responsável por cadastrar uma compra.
     * Ele valida e os dados mandados e insere.
     */
    
    public boolean registraCompra(ClienteDTO cliente, List<ProdutoPedidoDTO> produtos) {
        boolean realizadaComSucesso = false;
        
        try {
            // Gerencia Cliente
            ClienteDAO clienteDAO = new ClienteDAO();
            // Se houver erro de parse retorna false também
            ClienteDTO clienteNoBanco = clienteDAO.findById(Integer.parseInt(cliente.getCpf()));
            
            boolean existe = (clienteNoBanco != null);
            
            if (existe) {
                clienteDAO.update(cliente);
            } else  {
                clienteDAO.save(cliente);
            }
            // Gerencia Cliente - fim
            ProdutoDAO produtoDAO = new ProdutoDAO();
            for (ProdutoPedidoDTO produtoPedido : produtos) {
                if (produtoPedido.getQuantidade() > 0) {
                    ProdutoDTO produto = produtoPedido.getCproduto();
                    ProdutoDTO produtoNoBanco = produtoDAO.findById(produto.getCproduto());
                    if (produtoNoBanco != null) {
                        // @TODO verificar se há produtos suficientes para
                        // registrar a compra
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            
            // Realizando inserção
            PedidoDAO pedidoDAO = new PedidoDAO();
            PedidoDTO pedidoDTO = new PedidoDTO();
            pedidoDTO.setCpedido(0);
            pedidoDTO.setCpf(cliente);
            pedidoDTO.setData(new Date());
            pedidoDTO.setCpedido(pedidoDAO.save(pedidoDTO));
            
            ProdutoPedidoDAO produtoPedidoDAO = new ProdutoPedidoDAO();
            for (ProdutoPedidoDTO produtoPedidoDTO : produtos) {
                ProdutoDTO produtoDTO = produtoDAO.findById(produtoPedidoDTO.getCproduto().getCproduto());
                produtoPedidoDTO.setCpedido(pedidoDTO);
                produtoPedidoDTO.setDesconto(produtoDTO.getDesconto());
                produtoPedidoDTO.setPreco(produtoDTO.getPreco());
                produtoPedidoDAO.save(produtoPedidoDTO);
            }
            
            realizadaComSucesso = true;
                        
        } catch (Exception ex) {
            Logger.getLogger(RegistraCompraBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return realizadaComSucesso;
    }
}
