package ro.emanuel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.helpers.DBHelper;
import ro.emanuel.pojo.Muncitor;

public class MuncitorDAO {
	 
	public static ArrayList<Muncitor> getMuncitor() throws SQLException {
		String select = "SELECT * FROM muncitor";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);

		ArrayList<Muncitor> result = new ArrayList<Muncitor>();
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getNString("nume");
			int varsta = rs.getInt("varsta");
			int vechime = rs.getInt("vechime");
			int grupaMunca = rs.getInt("grupaMunca");
			
			Muncitor m = new Muncitor(id, nume, varsta, vechime, grupaMunca);
			result.add(m);
		}
		DBHelper.closeConnection();
		return result;
	}
	
	public static Muncitor getMuncitorById (int id) throws SQLException {
		String select = "SELECT * from muncitor where id = ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Muncitor result = null;
		if(rs.next()) {
			String nume = rs.getNString("nume");
			int varsta = rs.getInt("varsta");
			int vechime = rs.getInt("vechime");
			int grupaMunca = rs.getInt("grupaMunca");
			result = new Muncitor(id, nume, varsta, vechime, grupaMunca);
		}
		DBHelper.closeConnection();
		return result;
	}
	
	public static ArrayList<Muncitor> getMuncitorByName (String nameQuery) throws SQLException {
		String select = "SELECT * FROM muncitor where nume like ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setString(1, '%' + nameQuery + '%');
		ResultSet rs = stmt.executeQuery();
		
		ArrayList<Muncitor> result = new ArrayList<Muncitor>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getNString("nume");
			int varsta = rs.getInt("varsta");
			int vechime = rs.getInt("vechime");
			int grupaMunca = rs.getInt("grupaMunca");
			result.add(new Muncitor (id, nume, varsta, vechime, grupaMunca));
		}
		DBHelper.closeConnection();
		return result;
	}
	
	public static void createMuncitor(Muncitor m) throws SQLException{
		createMuncitor(m.getNume(), m.getVarsta(), m.getVechime(), m.getGrupaMunca());
	}

	public static void createMuncitor(String nume, int varsta, int vechime, int grupaMunca) throws SQLException{
		String insert = "INSERT INTO muncitor (nume, varsta, vechime, grupaMunca)" + "value (?,?,?,?)";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(insert);
		stmt.setString(1, nume);
		stmt.setInt(2, varsta);
		stmt.setInt(3, vechime);
		stmt.setInt(4, grupaMunca);
		
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
	
	public static void updateMuncitor (Muncitor m) throws SQLException {
		String update = "UPDATE muncitor set nume = ?, varsta = ?, vechime = ?, grupaMunca = ? WHERE id = ? ";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(update);
		stmt.setString(1, m.getNume());
		stmt.setInt(2, m.getVarsta());
		stmt.setInt(3, m.getVechime());
		stmt.setInt(4, m.getGrupaMunca());
		stmt.setInt(5, m.getId());
		
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
	
	public static void deleteMuncitor(Muncitor m) throws SQLException {
		deleteMuncitor(m.getId());
	}
	
	public static void deleteMuncitor(int id) throws SQLException {
		String delete = "DELETE FROM muncitor WHERE id = ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(delete);
		stmt.setInt(1, id);
		
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
}