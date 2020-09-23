package br.com.fiap.pousada.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import br.com.fiap.pousada.domain.Quarto;
import br.com.fiap.pousada.domain.Reserva;
import br.com.fiap.pousada.exception.ConexaoBDException;
import br.com.fiap.pousada.exception.FileException;
import br.com.fiap.pousada.exception.ReservaDaoException;
import br.com.fiap.pousada.helper.FileHelper;

public class ReservaDAO {

	private Connection conn;

	private void conecta() throws ConexaoBDException {
		try {
			Properties props = FileHelper.getProperties();
			conn = DriverManager.getConnection(props.getProperty("database.url"),
					props.getProperty("database.user"),
					props.getProperty("database.password"));
		} catch (SQLException | FileException e) {
			throw new ConexaoBDException("Não foi possível criar a conexão com o banco de dados");
		}
	}

	public List<Reserva> consultaTodos() throws ReservaDaoException {
		try {
			this.conecta();
			List<Reserva> reservas = new ArrayList<>();
			String sql = "select * from tb_reserva";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Long id = rs.getLong("id");
				Integer numeroQuarto = rs.getInt("id_quarto");
				LocalDate dataEntrada = rs.getDate("data_entrada").toLocalDate();
				LocalDate dataSaida = rs.getDate("data_saida").toLocalDate();
				Integer qtdePessoas = rs.getInt("qtde_pessoas");

				Quarto quarto = new QuartoDAO().consultaPorNumero(numeroQuarto);
				reservas.add(new Reserva(id, quarto, dataEntrada, dataSaida, qtdePessoas));
			}

			return reservas;
		} catch (ConexaoBDException | SQLException | ClassNotFoundException | FileException e) {
			System.out.println(e.getMessage());
			throw new ReservaDaoException("Houve um erro ao recuperar as informações de reserva no banco de dados.");
		} finally {
			this.desconecta();
		}
	}
	
	public Reserva salva(Reserva reserva) throws ReservaDaoException {
		try {
			this.conecta();
			String sqlConsultaId = "select sq_reserva.nextval as id from dual";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlConsultaId);
			if(rs.next()) reserva.setId(rs.getLong("id"));
			
			String sqlInsereReserva = "insert into tb_reserva(id, id_quarto, data_entrada, data_saida, qtde_pessoas)"
					+ " values(?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sqlInsereReserva);
			
			pStmt.setLong(1, reserva.getId());
			pStmt.setInt(2, reserva.getQuarto().getNumero());
			pStmt.setDate(3, Date.valueOf(reserva.getDataEntrada()));
			pStmt.setDate(4, Date.valueOf(reserva.getDataSaida()));
			pStmt.setInt(5, reserva.getQtdePessoas());
			
			pStmt.executeQuery();
			return reserva;
		} catch(ConexaoBDException | SQLException e) {
			throw new ReservaDaoException("Houve uma falha ao salvar o registro da reserva.\nTente novamente mais tarde.");
		} finally {
			this.desconecta();
		}
	}

	private void desconecta() {
		try {
			if (!conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
