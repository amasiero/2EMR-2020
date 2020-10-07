package br.com.fiap.patterns.dao.interfaces;

import java.util.List;

public class MySQLPessoaDAO implements PessoaDAO {
    @Override
    public List<String> buscaTodos() {
        return null;
    }

    @Override
    public String buscaPorId(long id) {
        return null;
    }

    @Override
    public String salva(String pessoa) {
        return null;
    }

    @Override
    public void atualiza(String pessoa) {

    }

    @Override
    public void exclui(long id) {

    }
}
