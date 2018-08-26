/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import DTO.ClienteDTO;
import DTO.ProdutoDTO;
import DTO.ProdutoPedidoDTO;
import beans.RegistraCompraBeanRemote;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joaomarcos
 */
@WebServlet(name = "RegistraCompra", urlPatterns = {"/registracompra"})
public class RegistraCompra extends HttpServlet {
    
    @EJB
    private RegistraCompraBeanRemote bean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        throw new ServletException("Método GET não suportado");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            
            /* Pega payload */
            String textJSON = "";
            try (BufferedReader leitor = request.getReader()) {
                textJSON = leitor.lines().collect(Collectors.joining());
            }
            
            /* Monta Objeto para ajuda a manipular o JSON (que veio como payload) */
            JsonReader reader = Json.createReader(new StringReader(textJSON));
            JsonObject dataJSON = reader.readObject();
           
            /* Monta os objetos necessários e usa os dados do JSON para isso */
            /* Cliente */
            ClienteDTO cliente = new ClienteDTO();
            cliente.setCpf(dataJSON.getJsonString("cpf").getString());
            cliente.setCep(dataJSON.getJsonString("cep").getString());
            cliente.setRua(dataJSON.getJsonString("rua").getString());
            cliente.setNumero(dataJSON.getJsonNumber("numero").intValue());
            
            /* Lista de itens */
            List<ProdutoPedidoDTO> produtos = new ArrayList<ProdutoPedidoDTO>();
            
            for (JsonValue jsonValue : dataJSON.getJsonArray("itens")) {
                JsonObject jsoObject = jsonValue.asJsonObject();
                
                ProdutoPedidoDTO produtoPedido = new ProdutoPedidoDTO();
                produtoPedido.setQuantidade(jsoObject.getJsonNumber("cproduto").intValue());
                ProdutoDTO produto = new ProdutoDTO();
                produto.setCproduto(jsoObject.getJsonNumber("quantidade").intValue());
                produtoPedido.setCproduto(produto);
                produtos.add(produtoPedido);
            }
            
            /* Registra compra */
            /* @TODO verificar por que retorna false
            * o cliente é cadastrado, não dá erro, possivelmente falha em algum
            * aspecto da validação
            */
            String msg = bean.registraCompra(cliente, produtos) ? "sucesso" : "falha";
            
            /* @TODO retorna JSON com mensagem de sucesso ou falha
            * ou usar response cods
            */
            JsonObject resposta = Json.createObjectBuilder()
                    .add("mensagem", msg)
                    .build();
            out.println(resposta.toString());
        }
    }

    @Override
    public String getServletInfo() {
        return "Registra compra.";
    }
}
