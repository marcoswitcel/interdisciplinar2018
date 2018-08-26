/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import DTO.ClienteDTO;
import DTO.ProdutoDTO;
import DTO.ProdutoPedidoDTO;
import beans.RegistraCompraBeanRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joaomarcos
 */
@WebServlet(name = "Teste", urlPatterns = {"/Teste"})
public class Teste extends HttpServlet {
    
    @EJB
    private RegistraCompraBeanRemote bean;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // @TODO apagar esta página de teste
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Teste</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Teste at " + request.getContextPath() + "</h1>");
            
            ClienteDTO cliente = new ClienteDTO();
            cliente.setCpf("12345678912349");
            cliente.setCep("12345679");
            cliente.setRua("Rua do Teste2");
            cliente.setNumero(22);
            
            List<ProdutoPedidoDTO> produtos = new ArrayList<ProdutoPedidoDTO>();
            ProdutoPedidoDTO produtoPedido = new ProdutoPedidoDTO();
            produtoPedido.setQuantidade(2);
            produtoPedido.setPreco(22.4);
            produtoPedido.setDesconto(10);
            ProdutoDTO produto = new ProdutoDTO();
            produto.setCproduto(1);
            produtoPedido.setCproduto(produto);
            produtos.add(produtoPedido);
            
            bean.registraCompra(cliente, produtos);
            
            out.println("passei o EJB");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
