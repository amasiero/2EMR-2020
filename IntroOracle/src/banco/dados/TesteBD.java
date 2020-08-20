package banco.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteBD {
	
	public static void main(String[] args) {
		
		try {
			// Carrega o driver de conex�o com o banco na mem�ria
			Class.forName("oracle.jdbc.driver.OracleDriver"); // new OracleDriver();
			
			// Abre uma conex�o com o banco de dados
			// localhost ==> oracle.fiap.com.br
			// XE ==> ORCL
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"system", "system");
			
			System.out.println("Conectado com o banco de dados!");
			
			Statement stmt = conn.createStatement();
			// Inclus�o
			String insertTarefa = "INSERT INTO TB_TAREFA(ID, DESCRICAO) VALUES (SQ_TAREFA.NEXTVAL, 'Estudar Java Collection')";
			stmt.executeUpdate(insertTarefa);
			
			// Atualiza��o
//			stmt.executeUpdate("UPDATE TB_TAREFA SET FEITA = 1 WHERE ID > 1");
			
			// Exclus�o
//			stmt.executeUpdate("DELETE FROM TB_TAREFA WHERE FEITA = 1");
			
			// Consultar
			ResultSet rs = stmt.executeQuery("SELECT * FROM TB_TAREFA");
			
			while(rs.next()) {
				Integer id = rs.getInt("ID");
				String descricao = rs.getString("DESCRICAO");
				Boolean feita = rs.getBoolean("FEITA");
				
				System.out.println("{" + id + ", " + descricao + ", " + feita + "}");
			}
			
			
			// Fechar a conex�o com o banco de dados
			conn.close();
			
		} catch (ClassNotFoundException e) {
			System.err.printf("O Driver JDBC n�o foi encontrado: %s", e.getMessage());
		} catch (SQLException e) {
			System.err.println("N�o foi poss�vel conectar com o banco de dados");
			System.err.println(e.getMessage());
		}
		
		
	}

}
