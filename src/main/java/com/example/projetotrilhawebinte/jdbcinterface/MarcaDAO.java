package com.example.projetotrilhawebinte.jdbcinterface;

import com.example.projetotrilhawebinte.modelo.Marca;

import java.util.List;

public interface MarcaDAO {
    public List<Marca> buscar();
    public boolean inserir(Marca marca);
    public boolean alterar(Marca marca);
    public boolean deletar(int id);
}
