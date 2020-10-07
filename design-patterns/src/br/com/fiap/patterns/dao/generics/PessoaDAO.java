package br.com.fiap.patterns.dao.generics;

import java.util.List;

public class PessoaDAO implements DAO<String> {
    @Override
    public List<String> buscaTodos() {
        return null;
    }

    @Override
    public String buscaPorId(long id) {
        return null;
    }

    @Override
    public String salva(String s) {
        return null;
    }

    @Override
    public void atualiza(String s) {

    }

    @Override
    public void exclui(long id) {

    }
}
