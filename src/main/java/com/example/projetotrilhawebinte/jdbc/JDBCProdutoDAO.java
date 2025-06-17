package com.example.projetotrilhawebinte.jdbc;

import com.example.projetotrilhawebinte.jdbcinterface.ProdutoDAO;
import com.example.projetotrilhawebinte.modelo.Produto;
import com.google.gson.JsonObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JDBCProdutoDAO implements ProdutoDAO {
    private Connection conexao;

    public JDBCProdutoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void cadastrar(Produto produto) {
        String sql = "INSERT INTO produto (modelo, capacidade, valor, categoria, idMarca) VALUES (?, ?, ?, ?, ?)";
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
    public void cadastrar(Produto produto) {

    }

    @Override
    public List<JsonObject> buscarPorNome(String nome) {
        List<JsonObject> listaProdutos = new ArrayList<>();
        String comando = "SELECT p.id, p.modelo, p.capacidade, p.valor, p.categoria, m.nome " +
                "FROM produto p INNER JOIN marca m ON p.idMarca = m.id ";
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
                byte categoria = rs.getByte("categoria");
                String nomeMarca = rs.getString("nome");

                String categoriaTexto = switch (categoria) {
                    case 1 -> "Geladeira";
                    case 2 -> "Fogão";
                    case 3 -> "Micro-ondas";
                    case 4 -> "Máquina de lavar";
                    case 5 -> "Lava-louças";
                    default -> "";
                };

                JsonObject produto = new JsonObject();
                produto.addProperty("id", id);
                produto.addProperty("modelo", modelo);
                produto.addProperty("capacidade", capacidade);
                produto.addProperty("valor", valor);
                produto.addProperty("categoria", categoriaTexto);
                produto.addProperty("marca", nomeMarca);
                listaProdutos.add(produto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProdutos;
    }
}
