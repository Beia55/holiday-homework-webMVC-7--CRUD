package ro.emanuel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.helpers.DBHelper;
import ro.emanuel.pojo.Fabrica;

public class FabricaDAO {
	
	public static ArrayList<Fabrica> getFabrica() throws SQLException {
		String select = "SELECT * FROM fabrica";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		ArrayList<Fabrica> result = new ArrayList<Fabrica>();
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String denumire = rs.getNString("denumire");
			String industrie = rs.getNString("industrie");
			String adresa = rs.getNString("adresa");

			Fabrica f = new Fabrica(id, denumire, industrie, adresa);
			result.add(f);
		}
		DBHelper.closeConnection();
		return result;
	}
	
	public static Fabrica getFabricaById (int id) throws SQLException {
		String select = "SELECT * from fabrica where id = ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Fabrica result = null;
		if(rs.next()) {
			String denumire = rs.getNString("denumire");
			String industrie = rs.getNString("industrie");
			String adresa = rs.getNString("adresa");
			result = new Fabrica(id, denumire, industrie, adresa);
		}
		DBHelper.closeConnection();
		return result;
	}
	
	public static ArrayList<Fabrica> getFabricaByName (String nameQuery) throws SQLException {
		String select = "SELECT * FROM fabrica where denumire like ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setString(1, '%' + nameQuery + '%');
		ResultSet rs = stmt.executeQuery();
		ArrayList<Fabrica> result = new ArrayList<Fabrica>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String denumire = rs.getNString("denumire");
			String industrie = rs.getNString("industrie");
			String adresa = rs.getNString("adresa");
			result.add(new Fabrica (id, denumire, industrie, adresa));
		}
		DBHelper.closeConnection();
		return result;
	}
	
	public static void createFabrica(Fabrica f) throws SQLException{
		createFabrica(f.getDenumire(), f.getIndustrie(), f.getAdresa());
	}

	public static void createFabrica(String denumire, String industrie, String adresa) throws SQLException{
		String insert = "INSERT INTO fabrica (denumire, industrie, adresa)" + "value (?,?,?)";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(insert);
		stmt.setString(1, denumire);
		stmt.setString(2, industrie);
		stmt.setString(3, adresa);
		
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
	
	public static void updateFabrica (Fabrica s) throws SQLException {
		String update = "UPDATE fabrica set denumire = ?, industrie = ?, adresa = ? WHERE id = ? ";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(update);
		stmt.setString(1, s.getDenumire());
		stmt.setString(2, s.getIndustrie());
		stmt.setString(3, s.getAdresa());
		stmt.setInt(4, s.getId());
		
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
	
	public static void deleteFabrica(Fabrica f) throws SQLException {
		deleteFabrica(f.getId());
	}
	
	public static void deleteFabrica(int id) throws SQLException {
		String delete = "DELETE FROM fabrica WHERE id = ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(delete);
		stmt.setInt(1, id);
		
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
}