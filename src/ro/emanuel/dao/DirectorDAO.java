package ro.emanuel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.helpers.DBHelper;
import ro.emanuel.pojo.Director;

public class DirectorDAO {
	
	public static ArrayList<Director> getDirector() throws SQLException {
		String select = "SELECT * FROM director";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);

		ArrayList<Director> result = new ArrayList<Director>();
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getNString("nume");
			int varsta = rs.getInt("varsta");
			String telefon = rs.getNString("telefon");
			double salar = rs.getDouble("salar");

			Director d = new Director(id, nume, varsta, telefon, salar);
			result.add(d);
		}
		DBHelper.closeConnection();
		return result;
	}
	
	public static Director getDirectorById (int id) throws SQLException {
		String select = "SELECT * from director where id = ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Director result = null;
		if(rs.next()) {
			String nume = rs.getNString("nume");
			int varsta = rs.getInt("varsta");
			String telefon = rs.getNString("telefon");
			double salar = rs.getDouble("salar");
			result = new Director(id, nume, varsta, telefon, salar);
		}
		DBHelper.closeConnection();
		return result;
	}
	
	public static ArrayList<Director> getDirectorByName (String nameQuery) throws SQLException {
		String select = "SELECT * FROM director where nume like ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setString(1, '%' + nameQuery + '%');
		ResultSet rs = stmt.executeQuery();
		
		ArrayList<Director> result = new ArrayList<Director>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getNString("nume");
			int varsta = rs.getInt("varsta");
			String telefon = rs.getNString("telefon");
			double salar = rs.getDouble("salar");
			result.add(new Director (id, nume, varsta, telefon, salar));
		}
		DBHelper.closeConnection();
		return result;
	}
	
	public static void createDirector(Director d) throws SQLException{
		createDirector(d.getNume(), d.getVarsta(), d.getTelefon(), d.getSalar());
	}

	public static void createDirector(String nume, int varsta, String telefon, double salar) throws SQLException{
		String insert = "INSERT INTO director (nume, varsta, telefon, salar)" + "value (?,?,?,?)";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(insert);
		stmt.setString(1, nume);
		stmt.setInt(2, varsta);
		stmt.setString(3, telefon);
		stmt.setDouble(4, salar);
		
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
	
	public static void updateDirector (Director s) throws SQLException {
		String update = "UPDATE director set nume = ?, varsta = ?, telefon = ?, salar = ? WHERE id = ? ";
		Connection con = DBHelper.getConnection();
		
		PreparedStatement stmt = con.prepareStatement(update);
		stmt.setString(1, s.getNume());
		stmt.setInt(2, s.getVarsta());
		stmt.setString(3, s.getTelefon());
		stmt.setDouble(4, s.getSalar());
		stmt.setInt(5, s.getId());
		
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
	
	public static void deleteDirector(Director s) throws SQLException {
		deleteDirector(s.getId());
	}
	
	public static void deleteDirector(int id) throws SQLException {
		String delete = "DELETE FROM director WHERE id = ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(delete);
		stmt.setInt(1, id);
		
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
}