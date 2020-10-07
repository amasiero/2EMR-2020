package br.com.fiap.patterns.dao.generics;

import java.util.List;

public interface DAO<T> {
    List<T> buscaTodos();
    T buscaPorId(long id);
    T salva(T t);
    void atualiza(T t);
    void exclui(long id);
}
