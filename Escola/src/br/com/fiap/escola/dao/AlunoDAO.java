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

public class AlunoDAO {

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
