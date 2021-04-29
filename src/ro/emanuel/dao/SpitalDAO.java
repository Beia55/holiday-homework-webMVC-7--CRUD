package ro.emanuel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.helpers.DBHelper;
import ro.emanuel.pojo.Spital;

public class SpitalDAO {

	public static ArrayList<Spital> getSpital() throws SQLException {
		String select = "SELECT * FROM spital";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);

		ArrayList<Spital> result = new ArrayList<Spital>();
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getNString("nume");
			String adresa = rs.getNString("adresa");
			String telefon = rs.getNString("telefon");
			String email = rs.getNString("email");

			Spital s = new Spital(id, nume, adresa, telefon, email);
			result.add(s);
		}
		DBHelper.closeConnection();
		return result;
	}
	
	public static Spital getSpitalById (int id) throws SQLException {
		String select = "SELECT * from spital where id = ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Spital result = null;
		if(rs.next()) {
			String nume = rs.getNString("nume");
			String adresa = rs.getNString("adresa");
			String telefon = rs.getNString("telefon");
			String email = rs.getNString("email");
			result = new Spital(id, nume, adresa, telefon, email);
		}
		DBHelper.closeConnection();
		return result;
	}
	
	public static ArrayList<Spital> getSpitalByName (String nameQuery) throws SQLException {
		String select = "SELECT * FROM spital where nume like ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setString(1, '%' + nameQuery + '%');
		ResultSet rs = stmt.executeQuery();
		ArrayList<Spital> result = new ArrayList<Spital>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getNString("nume");
			String adresa = rs.getNString("adresa");
			String telefon = rs.getNString("telefon");
			String email = rs.getNString("email");
			result.add(new Spital (id, nume, adresa, telefon, email));
		}
		DBHelper.closeConnection();
		return result;
	}
	
	public static void createSpital(Spital s) throws SQLException{
		createSpital(s.getNume(), s.getAdresa(), s.getTelefon(), s.getEmail());

	}
	
	public static void createSpital(String nume, String adresa, String telefon, String email) throws SQLException{
		String insert = "INSERT INTO spital (nume, adresa, telefon, email)" + "value (?,?,?,?)";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(insert);
		stmt.setString(1, nume);
		stmt.setString(2, adresa);
		stmt.setString(3, telefon);
		stmt.setString(4, email);
		
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
	
	public static void updateSpital (Spital s) throws SQLException {
		String update = "UPDATE spital set nume = ?, adresa = ?, telefon = ?, email = ? WHERE id = ? ";
		Connection con = DBHelper.getConnection();
		
		PreparedStatement stmt = con.prepareStatement(update);
		stmt.setString(1, s.getNume());
		stmt.setString(2, s.getAdresa());
		stmt.setString(3, s.getTelefon());
		stmt.setString(4, s.getEmail());
		stmt.setInt(5, s.getId());
		
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
	
	public static void deleteSpital(Spital s) throws SQLException {
		deleteSpitalByID(s.getId());
	}
	
	public static void deleteSpitalByID(int id) throws SQLException {
		String delete = "DELETE FROM spital WHERE id = ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(delete);
		stmt.setInt(1, id);
		
		stmt.executeUpdate();
		
		DBHelper.closeConnection();
	}
}