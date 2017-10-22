package db;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.Utility;
import model.Client;

public class ClientDAO {

	/**
	 * Insere no banco.
	 * 
	 * @param c
	 *            Cliente a ser inserido no banco.
	 */
	public static void insert(Client c) {
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement command = con.prepareStatement("INSERT INTO client VALUES (?, ?, ?)");
			command.setString(1, c.getCpf());
			command.setString(2, c.getName());
			command.setDate(3, Utility.dateToSql(c.getBirthday()));
			command.executeUpdate();
			command.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualiza no banco.
	 * 
	 * @param c
	 *            Cliente a ser atualizado no banco.
	 */
	public static void update(Client c) {

		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE CLIENT SET nome = ?, dataNascimento = ? WHERE cpf = ?");
			ps.setString(1, c.getName());
			ps.setDate(2, Utility.dateToSql(c.getBirthday()));
			ps.setString(3, c.getCpf());
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Deleta do banco.
	 * 
	 * @param c
	 *            Cliente a ser deletado do banco.
	 */
	public static void delete(Client c) {

		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM client WHERE cpf = ?");
			ps.setString(1, c.getCpf());
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Realiza um select na tabela Cliente do banco de dados.
	 * 
	 * @return Um {@code ArrayList} com todos os clientes criado no banco.
	 */
	public static ArrayList<Client> select() {
		Connection con = ConnectionFactory.getConnection();
		ArrayList<Client> clientList = new ArrayList<Client>();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM client");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				clientList.add(new Client(rs.getString("nome"), rs.getString("cpf"), rs.getDate("dataNascimento")));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientList;
	}

	/**
	 * Insert test.
	 */
	public static void testInsert() {
		Client c = new Client("Pedro", "22222222233", new Date());
		insert(c);
	}

	/**
	 * Update test.
	 */
	public static void testUpdate() {
		Client c = new Client("Emmanuel Kant Duarte", "22222222233", new Date());
		update(c);
	}

	/**
	 * Delete test.
	 */
	public static void testDelete() {
		Client c = new Client("Emmanuel Kant Duarte", "22222222233", new Date());
		delete(c);
	}

	/**
	 * Select test.
	 */
	public static void testSelect() {
		ArrayList<Client> selectClient = select();
		for (Client c : selectClient) {
			System.out.println("Nome: " + c.getName());
			System.out.println("Birthday: " + Utility.dateToString(c.getBirthday()));
			System.out.println("CPF: " + c.getCpf() + "\n");
		}
	}

	/**
	 * Main para testes.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// testInsert();
		// testUpdate();
		// testDelete();
		// testSelect();
	}

}
