package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Client;
import model.Utility;

public class ClientDAO {

	public static void insert(Client c) {
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement command = con.prepareStatement("INSERT INTO CLIENT VALUES (?, ?, ?)");
			command.setString(1, c.getCpf());
			command.setString(2, c.getName());
			command.setDate(2, Utility.dateToSql(c.getBirthday()));
			command.executeUpdate();
			command.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void update(Client c) {

		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE CLIENT SET name = ? WHERE cpf = ?");
			ps.setString(2, c.getName());
			ps.setString(3, c.getCpf());
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

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

	public static ArrayList<Client> select() {
		Connection con = ConnectionFactory.getConnection();
		ArrayList<Client> clientList = new ArrayList<Client>();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM client");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				clientList.add(new Client(rs.getString("name"), rs.getString("cpf"), null));
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
		Client c = new Client("Pedro", "22222222233", null);
		insert(c);
	}

	/**
	 * Update test.
	 */
	public static void testUpdate() {
		Client c = new Client("Emmanuel Kant Duarte", "22222222233", "22/22/2222");
		update(c);
	}

	/**
	 * Delete test.
	 */
	public static void testDelete() {
		Client c = new Client("Emmanuel Kant Duarte", "22222222233", null);
		delete(c);
	}

	/**
	 * Select test.
	 */
	public static void testSelect() {
		ArrayList<Client> selectClient = select();
		for (Client c : selectClient) {
			System.out.println("Nome: " + c.getName());
			System.out.println("CPF: " + c.getCpf() + "\n");
		}
	}

	/**
	 * Main para testes.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		 testInsert();
		 testUpdate();
		 testDelete();
//		testSelect();
	}

}
