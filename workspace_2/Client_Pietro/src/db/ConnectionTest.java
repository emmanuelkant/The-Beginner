package db;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		Connection connection = ConnectionFactory.getConnection();
		System.out.println("Conexão criada com sucesso.");
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
