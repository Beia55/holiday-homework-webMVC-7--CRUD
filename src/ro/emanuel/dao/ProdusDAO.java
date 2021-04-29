package ro.emanuel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.helpers.DBHelper;
import ro.emanuel.pojo.Produs;

public class ProdusDAO {
	
	public static ArrayList<Produs> getProdus() throws SQLException {
		String select = "SELECT * FROM produs";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);

		ArrayList<Produs> result = new ArrayList<Produs>();
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String denumire = rs.getNString("denumire");
			double pret = rs.getDouble("pret");
			double cantitate = rs.getDouble("cantitate");
			String culoare = rs.getNString("culoare");	
			
			Produs p = new Produs(id, denumire, pret, cantitate, culoare);
			result.add(p);
		}
		DBHelper.closeConnection();
		return result;
	}
	
	public static Produs getProdusById (int id) throws SQLException {
		String select = "SELECT * from produs where id = ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Produs result = null;
		if(rs.next()) {
			String denumire = rs.getNString("denumire");
			double pret = rs.getDouble("pret");
			double cantitate = rs.getDouble("cantitate");
			String culoare = rs.getNString("culoare");	
			result = new Produs(id, denumire, pret, cantitate, culoare);
		}
		DBHelper.closeConnection();
		return result;
	}
	
	public static ArrayList<Produs> getProdusByName (String nameQuery) throws SQLException {
		String select = "SELECT * FROM Produs where denumire like ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setString(1, '%' + nameQuery + '%');
		ResultSet rs = stmt.executeQuery();
		ArrayList<Produs> result = new ArrayList<Produs>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String denumire = rs.getNString("denumire");
			double pret = rs.getDouble("pret");
			double cantitate = rs.getDouble("cantitate");
			String culoare = rs.getNString("culoare");	
			result.add(new Produs (id, denumire, pret, cantitate, culoare));
		}
		DBHelper.closeConnection();
		return result;
	}
	
	public static void createProdus(Produs p) throws SQLException{
		createProdus(p.getDenumire(), p.getPret(), p.getCantitate(), p.getCuloare());
	}

	public static void createProdus(String denumire, double pret, double cantitate, String culoare) throws SQLException{
		String insert = "INSERT INTO produs (denumire, pret, cantitate, culoare)" + "value (?,?,?,?)";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(insert);
		stmt.setString(1, denumire);
		stmt.setDouble(2, pret);
		stmt.setDouble(3, cantitate);
		stmt.setString(4, culoare);
		
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
	
	public static void updateProdus (Produs p) throws SQLException {
		String update = "UPDATE produs set denumire = ?, pret = ?, cantitate = ?, culoare = ? WHERE id = ? ";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(update);
		stmt.setString(1, p.getDenumire());
		stmt.setDouble(2, p.getPret());
		stmt.setDouble(3, p.getCantitate());
		stmt.setString(4, p.getCuloare());
		stmt.setInt(5, p.getId());
		
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
	
	public static void deleteProdus(Produs p) throws SQLException {
		deleteProdus(p.getId());
	}
	
	public static void deleteProdus(int id) throws SQLException {
		String delete = "DELETE FROM produs WHERE id = ?";
		Connection con = DBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(delete);
		stmt.setInt(1, id);
		
		stmt.executeUpdate();
		DBHelper.closeConnection();
	}
}