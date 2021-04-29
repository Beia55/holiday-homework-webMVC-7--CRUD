package ro.emanuel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.helpers.DBHelper;
import ro.emanuel.pojo.Pacient;

public class PacientDAO {

	public static ArrayList<Pacient> getPacient() throws SQLException {
		String select = "SELECT * FROM pacient";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);

		ArrayList<Pacient> result = new ArrayList<Pacient>();
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getNString("nume");
			String adresa = rs.getNString("adresa");
			int varsta = rs.getInt("varsta");
			String diagnostic = rs.getNString("diagnostic");
	
			Pacient p = new Pacient(id, nume, adresa, varsta, diagnostic);
			result.add(p);
		}
		DBHelper.closeConnection();
		return result;
	}
	
	public static Pacient getPacientById (int id) throws SQLException {
		String select = "SELECT * from pacient where id = ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Pacient result = null;
		if(rs.next()) {
			String nume = rs.getNString("nume");
			String adresa = rs.getNString("adresa");
			int varsta = rs.getInt("varsta");
			String diagnostic = rs.getNString("diagnostic");
			result = new Pacient(id, nume, adresa, varsta, diagnostic);
		}
		DBHelper.closeConnection();
		return result;
	}
	
	public static ArrayList<Pacient> getPacientByName (String nameQuery) throws SQLException {
		String select = "SELECT * FROM pacient where nume like ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setString(1, '%' + nameQuery + '%');
		ResultSet rs = stmt.executeQuery();
		ArrayList<Pacient> result = new ArrayList<Pacient>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String nume = rs.getNString("nume");
			String adresa = rs.getNString("adresa");
			int varsta = rs.getInt("varsta");
			String diagnostic = rs.getNString("diagnostic");
			result.add(new Pacient (id, nume, adresa, varsta, diagnostic));
		}
		DBHelper.closeConnection();
		return result;
	}
	
	public static void createPacient(Pacient p) throws SQLException{
		createPacient(p.getNume(), p.getAdresa(), p.getVarsta(), p.getDiagnostic());
	}
	
	public static void createPacient(String nume, String adresa, int varsta, String diagnostic) throws SQLException{
		String insert = "INSERT INTO pacient (nume, adresa, varsta, diagnostic)" + "value (?,?,?,?)";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(insert);
		stmt.setString(1, nume);
		stmt.setString(2, adresa);
		stmt.setInt(3, varsta);
		stmt.setString(4, diagnostic);
		
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
	
	public static void updatePacient (Pacient p) throws SQLException {
		String update = "UPDATE pacient set nume = ?, adresa = ?, varsta = ?, diagnostic = ? WHERE id = ? ";
		Connection con = DBHelper.getConnection();
		
		PreparedStatement stmt = con.prepareStatement(update);
		stmt.setString(1, p.getNume());
		stmt.setString(2, p.getAdresa());
		stmt.setInt(3, p.getVarsta());
		stmt.setString(4, p.getDiagnostic());
		stmt.setInt(5, p.getId());
		
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
	
	public static void deletePacient(Pacient p) throws SQLException {
		deletePacient(p.getId());
	}
	
	public static void deletePacient(int id) throws SQLException {
		String delete = "DELETE FROM pacient WHERE id = ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(delete);
		stmt.setInt(1, id);
		
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
}