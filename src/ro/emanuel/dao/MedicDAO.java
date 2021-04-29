package ro.emanuel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.helpers.DBHelper;
import ro.emanuel.pojo.Medic;

public class MedicDAO {
	
	public static ArrayList<Medic> getMedic() throws SQLException {
		String select = "SELECT * FROM medic";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);

		ArrayList<Medic> result = new ArrayList<Medic>();
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getNString("nume");
			String specialitate = rs.getNString("specialitate");
			int vechime = rs.getInt("vechime");
			double salar = rs.getInt("salar");

			Medic m = new Medic(id, nume, specialitate, vechime, salar);
			result.add(m);
		}
		DBHelper.closeConnection();
		return result;
	}
	
	public static Medic getMedicById (int id) throws SQLException {
		String select = "SELECT * from medic where id = ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Medic result = null;
		if(rs.next()) {
			String nume = rs.getNString("nume");
			String specialitate = rs.getNString("specialitate");
			int vechime = rs.getInt("vechime");
			int salar = rs.getInt("salar");
			result = new Medic(id, nume, specialitate, vechime, salar);
		}
		DBHelper.closeConnection();
		return result;
	}
	
	public static ArrayList<Medic> getMedicByName (String nameQuery) throws SQLException {
		String select = "SELECT * FROM medic where nume like ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setString(1, '%' + nameQuery + '%');
		ResultSet rs = stmt.executeQuery();
		ArrayList<Medic> result = new ArrayList<Medic>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getNString("nume");
			String specialitate = rs.getNString("specialitate");
			int vechime = rs.getInt("vechime");
			int salar = rs.getInt("salar");
			result.add(new Medic (id, nume, specialitate, vechime, salar));
		}
		DBHelper.closeConnection();
		return result;
	}
	
	public static void createMedic(Medic m) throws SQLException{
		createMedic(m.getNume(), m.getSpecialitate(), m.getVechime(), m.getSalar());
	}
	
	public static void createMedic(String nume, String specialitate, int vechime, double salar) throws SQLException{
		String insert = "INSERT INTO medic (nume, specialitate, vechime, salar)" + "value (?,?,?,?)";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(insert);
		stmt.setString(1, nume);
		stmt.setString(2, specialitate);
		stmt.setInt(3, vechime);
		stmt.setDouble(4, salar);
		
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
	
	public static void updateMedic (Medic m) throws SQLException {
		String update = "UPDATE medic set nume = ?, specialitate = ?, vechime = ?, salar = ? WHERE id = ? ";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(update);
		stmt.setString(1, m.getNume());
		stmt.setString(2, m.getSpecialitate());
		stmt.setInt(3, m.getVechime());
		stmt.setDouble(4, m.getSalar());
		stmt.setInt(5, m.getId());
		
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
	
	public static void deleteMedic(Medic m) throws SQLException {
		deleteMedic(m.getId());
	}
	
	public static void deleteMedic(int id) throws SQLException {
		String delete = "DELETE FROM medic WHERE id = ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(delete);
		stmt.setInt(1, id);
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
}