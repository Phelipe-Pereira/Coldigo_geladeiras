package com.example.projetotrilhawebinte.rest;

import com.example.projetotrilhawebinte.db.Conexao;
import com.example.projetotrilhawebinte.jdbc.JDBCMarcaDAO;
import com.example.projetotrilhawebinte.modelo.Marca;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Path("marca")
public class MarcaRest extends UtilRest {

    @GET
    @Path("/teste")
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public String teste() {
        return "REST está funcionando!";
    }

    @GET
    @Path("/buscar")
    @Produces({MediaType.APPLICATION_JSON})
    public Response buscar() {
        System.out.println("Iniciando busca de marcas...");
        try {
            List<Marca> listaMarcas = new ArrayList<Marca>();

            System.out.println("Abrindo conexão com o banco...");
            Conexao conec = new Conexao();
            Connection conexao = conec.abrirConexao();
            
            if (conexao == null) {
                throw new Exception("Não foi possível estabelecer conexão com o banco de dados");
            }

            System.out.println("Criando DAO e executando busca...");
            JDBCMarcaDAO jdbcMarca = new JDBCMarcaDAO(conexao);
            listaMarcas = jdbcMarca.buscar();
            
            System.out.println("Marcas encontradas: " + listaMarcas.size());
            
            conec.fecharConexao();
            System.out.println("Conexão fechada");

            return this.buildResponse(listaMarcas);
        } catch (Exception e) {
            System.out.println("Erro na busca de marcas: " + e.getMessage());
            e.printStackTrace();
            return this.buildErrorResponse(e.getMessage());
        }
    }
}
