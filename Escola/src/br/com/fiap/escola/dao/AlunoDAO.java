package br.com.fiap.escola.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.escola.domain.Aluno;

/**
 * 
 * Esse á uma classe que implementa os métodos de acesso ao banco de dados,
 * referente a classe de domínio Aluno.
 * 
 * Por favor, veja a classe {@link br.com.fiap.escola.domain.Aluno} para identificar
 * seus atributos.
 * 
 * @author Luke Skywalker
 * @version 1.0
 * 
 */
public class AlunoDAO {

	/**
	 * Conexão privada com o banco de dados.
	 * 
	 * @see java.sql.Connection
	 * 
	 */
	private Connection conn;

	private void conecta() throws ClassNotFoundException, SQLException {
		this.conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
				"system", "system");
	}

	public void salva(Aluno aluno) throws ClassNotFoundException, SQLException {
		this.conecta();
		Statement stmt = this.conn.createStatement();
		String sql = String.format(
				"insert into tb_aluno(id, rm, nome, nota1, nota2) " + 
				"values(sq_aluno.nextval, %s, '%s', %s, %s)",
				aluno.getRm(), aluno.getNome(), aluno.getNota1(), aluno.getNota2());

		stmt.executeUpdate(sql);

		this.desconecta();
	}

	public List<Aluno> consultaTodos() throws ClassNotFoundException, SQLException {
		this.conecta();

		List<Aluno> alunos = new ArrayList<>();
		Statement stmt = this.conn.createStatement();

		String sql = "select * from tb_aluno";
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			Long id = rs.getLong("id");
			Long rm = rs.getLong("rm");
			String nome = rs.getString("nome");
			Boolean ativo = rs.getBoolean("ativo");
			Double nota1 = rs.getDouble("nota1");
			Double nota2 = rs.getDouble("nota2");

			alunos.add(new Aluno(id, rm, nome, ativo, nota1, nota2));
		}

		this.desconecta();
		return alunos.isEmpty() ? null : alunos;
	}

	/**
	 * <p>Consulta a existência do 
	 * <a href="https://xkcd.com/2203/">aluno</a> no banco de dados a partir
	 * de seu rm</p>
	 * 
	 * @param rm atributo long que refere-se ao número de identificação do aluno
	 * @return o aluno encontrado no banco ou nulo em caso negativo
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 * @see <a href="https://xkcd.com/1884/">TASK #1</a>
	 * @since 1.0
	 */
	public Aluno consultaPorRM(Long rm) throws ClassNotFoundException, SQLException {
		this.conecta();

		Aluno aluno = null;
		String sql = "select * from tb_aluno where rm = ?";
		PreparedStatement stmt = this.conn.prepareStatement(sql);
		stmt.setLong(1, rm);

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			Long id = rs.getLong("id");
			String nome = rs.getString("nome");
			Boolean ativo = rs.getBoolean("ativo");
			Double nota1 = rs.getDouble("nota1");
			Double nota2 = rs.getDouble("nota2");

			aluno = new Aluno(id, rm, nome, ativo, nota1, nota2);
		}

		this.desconecta();
		return aluno;
	}

	private void desconecta() throws SQLException {
		if (!this.conn.isClosed())
			this.conn.close();
	}

}
