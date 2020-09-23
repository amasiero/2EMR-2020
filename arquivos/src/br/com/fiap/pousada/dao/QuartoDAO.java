package br.com.fiap.pousada.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import br.com.fiap.pousada.domain.Categoria;
import br.com.fiap.pousada.domain.Quarto;
import br.com.fiap.pousada.exception.FileException;
import br.com.fiap.pousada.helper.FileHelper;

public class QuartoDAO {

	private Connection conn;

	private void conecta() throws ClassNotFoundException, SQLException, FileException {
		Properties props = FileHelper.getProperties();
		conn = DriverManager.getConnection(props.getProperty("database.url"),
				props.getProperty("database.user"),
				props.getProperty("database.password"));
	}

	public List<Quarto> consultaTodos() throws ClassNotFoundException, SQLException, FileException {
		List<Quarto> quartos = new ArrayList<>();
		this.conecta();

		String sql = "select * from tb_quarto";
		Statement stmt = this.conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			Integer numero = rs.getInt("numero");
			Categoria categoria = Categoria.valueOf(rs.getString("categoria"));
			Integer maxPessoas = rs.getInt("max_pessoas");
			Double valorDiaria = rs.getDouble("valor_diaria");

			quartos.add(new Quarto(numero, categoria, maxPessoas, valorDiaria));
		}

		this.desconecta();
		return quartos.isEmpty() ? null : quartos;
	}

	public Quarto consultaPorNumero(Integer numero) throws ClassNotFoundException, SQLException, FileException {
		Quarto quarto = null;
		this.conecta();

		String sql = String.format("select * from tb_quarto where numero = %s", numero);
		Statement stmt = this.conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		if (rs.next()) {
			Categoria categoria = Categoria.valueOf(rs.getString("categoria"));
			Integer maxPessoas = rs.getInt("max_pessoas");
			Double valorDiaria = rs.getDouble("valor_diaria");

			quarto = new Quarto(numero, categoria, maxPessoas, valorDiaria);
		}

		this.desconecta();
		return quarto;
	}

	public void salva(Quarto quarto) throws ClassNotFoundException, SQLException, FileException {
		this.conecta();
		
		String sql = String.format("insert into tb_quarto(numero, categoria, max_pessoas, valor_diaria)"
				+ " values (%s, '%s', %s, %s)", quarto.getNumero(), quarto.getCategoria(),
				quarto.getMaxPessoas(), quarto.getValorDiaria());
		Statement stmt = this.conn.createStatement();
		stmt.executeUpdate(sql);
		
		this.desconecta();
	}

	private void desconecta() throws SQLException {
		if (!conn.isClosed())
			conn.close();
	}
}
