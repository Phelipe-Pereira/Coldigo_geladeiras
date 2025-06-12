package com.example.projetotrilhawebinte.db;

import java.sql.Connection;

public class Conexao {
    private Connection conexao;

    public Connection abrirConexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Tentando conectar ao banco...");
            conexao = java.sql.DriverManager.getConnection(
                    "jdbc:mysql://localhost/bdcoldigo?"
                            + "user=root&password=Lipe@9182&useTimezone=true&serverTimezone=UTC"
            );
            System.out.println("Conectado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
            e.printStackTrace();
        }
        return conexao;
    }

    public void fecharConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                System.out.println("Conexão fechada com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Erro ao fechar conexão: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
