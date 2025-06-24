package com.example.projetotrilhawebinte.jdbc;

import com.example.projetotrilhawebinte.jdbcinterface.ProdutoDAO;
import com.example.projetotrilhawebinte.modelo.Produto;
import com.google.gson.JsonObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCProdutoDAO implements ProdutoDAO {
    private Connection conexao;

    public JDBCProdutoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void cadastrar(Produto produto) {
        String sql = "INSERT INTO produtos (modelo, capacidade, valor, categoria, marcas_id) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, produto.getModelo());
            ps.setInt(2, produto.getCapacidade());
            ps.setDouble(3, produto.getValor());
            ps.setByte(4, produto.getCategoria());
            ps.setInt(5, produto.getIdMarca());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<JsonObject> buscarPorNome(String nome) {
        List<JsonObject> listaProdutos = new ArrayList<>();
        String comando = "SELECT p.id, p.modelo, p.capacidade, p.valor, p.categoria, m.nome, p.marcas_id " +
                "FROM produtos p INNER JOIN marcas m ON p.marcas_id = m.id ";
        if (!nome.equals("")) {
            comando += "WHERE LOWER(p.modelo) LIKE LOWER(?) ";
        }
        comando += "ORDER BY p.modelo ASC";

        try {
            PreparedStatement p = this.conexao.prepareStatement(comando);
            if (!nome.equals("")) {
                p.setString(1, "%" + nome + "%");
            }
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String modelo = rs.getString("modelo");
                int capacidade = rs.getInt("capacidade");
                double valor = rs.getDouble("valor");
                int categoria = rs.getInt("categoria");
                String nomeMarca = rs.getString("nome");
                int marcaId = rs.getInt("marcas_id");

                String categoriaTexto = "";
                if (categoria == 1) categoriaTexto = "Geladeira";
                else if (categoria == 2) categoriaTexto = "Freezer";
                // Adicione mais categorias se necessário

                JsonObject produto = new JsonObject();
                produto.addProperty("id", id);
                produto.addProperty("modelo", modelo);
                produto.addProperty("capacidade", capacidade);
                produto.addProperty("valor", valor);
                produto.addProperty("categoria", categoria);
                produto.addProperty("categoriaTexto", categoriaTexto);
                produto.addProperty("marca", nomeMarca);
                produto.addProperty("marcaId", marcaId);
                listaProdutos.add(produto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProdutos;
    }

    @Override
    public boolean deletar(int id) {
        String comando = "DELETE FROM produtos WHERE id = ?";
        try (PreparedStatement p = this.conexao.prepareStatement(comando)) {
            p.setInt(1, id);
            p.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Produto buscarPorId(int id) {
        String comando = "SELECT * FROM produtos WHERE id = ?";
        Produto produto = new Produto();
        try (PreparedStatement p = this.conexao.prepareStatement(comando)) {
            p.setInt(1, id);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                produto.setId(rs.getInt("id"));
                produto.setCategoria(rs.getInt("categoria"));
                produto.setModelo(rs.getString("modelo"));
                produto.setCapacidade(rs.getInt("capacidade"));
                produto.setValor(rs.getFloat("valor"));
                produto.setIdMarca(rs.getInt("marcas_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produto;
    }

    @Override
    public boolean alterar(Produto produto) {
        String comando = "UPDATE produtos SET categoria=?, modelo=?, capacidade=?, valor=?, marcas_id=? WHERE id=?";
        try (PreparedStatement p = this.conexao.prepareStatement(comando)) {
            p.setByte(1, produto.getCategoria());
            p.setString(2, produto.getModelo());
            p.setInt(3, produto.getCapacidade());
            p.setDouble(4, produto.getValor());
            p.setInt(5, produto.getIdMarca());
            p.setInt(6, produto.getId());
            p.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
