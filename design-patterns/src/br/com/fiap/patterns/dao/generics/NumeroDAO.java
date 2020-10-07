package br.com.fiap.patterns.dao.generics;

import java.util.List;

public class NumeroDAO implements DAO<Integer> {
    @Override
    public List<Integer> buscaTodos() {
        return null;
    }

    @Override
    public Integer buscaPorId(long id) {
        return null;
    }

    @Override
    public Integer salva(Integer integer) {
        return null;
    }

    @Override
    public void atualiza(Integer integer) {

    }

    @Override
    public void exclui(long id) {

    }
}
