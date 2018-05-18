package practicum2;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class OVChipkaartOracleDAOImpl extends OracleBaseDao implements OVChipkaartDao{
	private static Connection conn;
	private List<Ovchipkaart> ovchipkaart = new ArrayList<Ovchipkaart>();

	public List<Ovchipkaart> findAll() throws SQLException {
		conn = OracleBaseDao.getConnection();
		String query = "SELECT * FROM ov_chipkaart";
		
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(query);

		// Iets doen met de resultaten
		int kaartnummer;
		Date geldigtot;
		int klasse;
		int saldo;
		int reizigerid;
		Ovchipkaart obj;
		
		while (result.next()) {
			kaartnummer = result.getInt("kaartnummer");
			geldigtot = result.getDate("geldigtot");
			klasse = result.getInt("klasse");
			saldo = result.getInt("saldo");
			reizigerid = result.getInt("reizigerid");

			obj = new Ovchipkaart(kaartnummer, geldigtot, klasse, saldo, reizigerid);
			ovchipkaart.add(obj);
		}
		conn.close();
		result.close();
		return ovchipkaart;
	}

	public List<Ovchipkaart> findByReiziger(int reizigerid) throws SQLException {
		conn = OracleBaseDao.getConnection();
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM ov_chipkaart WHERE reizigerid = ?");    
		statement.setInt(1, reizigerid);    
		ResultSet result = statement.executeQuery();

		// Iets doen met de resultaten
		int kaartnummer;
		Date geldigtot;
		int klasse;
		int saldo;
		Ovchipkaart obj;
		
		while (result.next()) {
			kaartnummer = result.getInt("kaartnummer");
			geldigtot = result.getDate("geldigtot");
			klasse = result.getInt("klasse");
			saldo = result.getInt("saldo");
			reizigerid = result.getInt("reizigerid");

			obj = new Ovchipkaart(kaartnummer, geldigtot, klasse, saldo, reizigerid);
			ovchipkaart.add(obj);;
		}
		conn.close();
		result.close();
		return ovchipkaart;
	}
	
	public Ovchipkaart save(Ovchipkaart ovchipkaart) throws SQLException{
		conn = OracleBaseDao.getConnection();
		String query = "INSERT INTO ov_chipkaart (kaartnummer, geldigtot, klasse, saldo, reizigerid) VALUES (?, ?, ?, ?, ?)";

		PreparedStatement statement = conn.prepareStatement(query);
		statement.setInt(1, ovchipkaart.getKaartnummer());
		statement.setDate(2, ovchipkaart.getGeldigtot());
		statement.setInt(3, ovchipkaart.getKlasse());
		statement.setInt(4, ovchipkaart.getSaldo());
		statement.setInt(5, ovchipkaart.getReizigerid());


		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
			System.out.println("Ovchipkaart toegevoegd");
		}
		conn.close();
		return ovchipkaart;
	}
	
	public Ovchipkaart update(Ovchipkaart ovchipkaart) throws SQLException {
		conn = OracleBaseDao.getConnection();
		String query = "UPDATE ov_chipkaart set geldigtot = ?, klasse = ?, saldo = ? WHERE reizigerid = ?";

		PreparedStatement statement = conn.prepareStatement(query);
		statement.setDate(1, ovchipkaart.getGeldigtot());
		statement.setInt(2, ovchipkaart.getKlasse());
		statement.setInt(3, ovchipkaart.getSaldo());
		statement.setInt(4, ovchipkaart.getReizigerid());

		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0) {
			System.out.println("ovchipkaart aangepast");
		}
		conn.close();
		return ovchipkaart;
	}
	
	public boolean delete(Ovchipkaart ovchipkaart) throws SQLException {
		conn = OracleBaseDao.getConnection();
		String query = "DELETE FROM ov_chipkaart WHERE kaartnummer = ?";

		PreparedStatement statement = conn.prepareStatement(query);
		statement.setInt(1, ovchipkaart.getKaartnummer());

		int rowsDeleted = statement.executeUpdate();
		if (rowsDeleted > 0) {
			System.out.println("ovchipkaart verwijderd");
			return true;
		}
		conn.close();
		return false;
	}
}