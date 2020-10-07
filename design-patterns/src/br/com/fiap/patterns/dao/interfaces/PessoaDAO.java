package br.com.fiap.patterns.dao.interfaces;

import java.util.List;

public interface PessoaDAO {
    List<String> buscaTodos();
    String buscaPorId(long id);
    String salva(String pessoa);
    void atualiza(String pessoa);
    void exclui(long id);
}
