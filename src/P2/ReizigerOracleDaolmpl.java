package P2;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class ReizigerOracleDaolmpl extends OracleBaseDao implements ReizigerDao{
	private static Connection conn;
	private List<Reiziger> reizigers = new ArrayList<Reiziger>();

	public List<Reiziger> findAll() throws SQLException {
		conn = OracleBaseDao.getConnection();
		List<Reiziger> reizigers = new ArrayList<Reiziger>();
		String query = "SELECT * FROM REIZIGER";
		
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(query);

		// Iets doen met de resultaten
		int reizigerID;
		String voorletters;
		String tussenvoegsel;
		String achternaam;
		Date gebortedatum;
		Reiziger obj;
		
		while (result.next()) {
			reizigerID = result.getInt("reizigerID");
			voorletters = result.getString("voorletters");
			tussenvoegsel = result.getString("tussenvoegsel");
			achternaam = result.getString("achternaam");
			gebortedatum = result.getDate("gebortedatum");

			obj = new Reiziger(reizigerID, voorletters, tussenvoegsel, achternaam, gebortedatum);
			reizigers.add(obj);
		}
		conn.close();
		result.close();
		return reizigers;
	}

	public List<Reiziger> findByGBdatum(String GBdatum) throws SQLException {
		conn = OracleBaseDao.getConnection();
		List<Reiziger> reizigers = new ArrayList<Reiziger>();
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM Reiziger WHERE gebortedatum = ?");    
		statement.setDate(1, java.sql.Date.valueOf(GBdatum));    
		ResultSet result = statement.executeQuery();

		// Iets doen met de resultaten
		int reizigerID;
		String voorletters;
		String tussenvoegsel;
		String achternaam;
		Date gebortedatum;
		Reiziger obj;
		
		while (result.next()) {
			reizigerID = result.getInt("reizigerID");
			voorletters = result.getString("voorletters");
			tussenvoegsel = result.getString("tussenvoegsel");
			achternaam = result.getString("achternaam");
			gebortedatum = result.getDate("gebortedatum");

			obj = new Reiziger(reizigerID, voorletters, tussenvoegsel, achternaam, gebortedatum);
			reizigers.add(obj);
		}
		conn.close();
		result.close();
		return reizigers;
	}
	
	public Reiziger save(Reiziger reiziger) throws SQLException{
		conn = OracleBaseDao.getConnection();
		String query = "INSERT INTO reiziger (reizigerID, voorletters, tussenvoegsel, achternaam, gebortedatum) VALUES (?, ?, ?, ?, ?)";

		PreparedStatement statement = conn.prepareStatement(query);
		statement.setInt(1, reiziger.getReizigerID());
		statement.setString(2, reiziger.getVoorletters());
		statement.setString(3, reiziger.getTussenvoegsel());
		statement.setString(4, reiziger.getAchternaam());
		statement.setDate(5, reiziger.getGbdatum());

		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
			System.out.println("Reiziger toegevoegd");
		}
		conn.close();
		return reiziger;
	}
	
	public Reiziger update(Reiziger reiziger) throws SQLException {
		conn = OracleBaseDao.getConnection();
		String query = "UPDATE reiziger set voorletters = ?, tussenvoegsel = ?, achternaam = ?, gebortedatum = ? WHERE reizigerid = ?";

		PreparedStatement statement = conn.prepareStatement(query);
		statement.setString(1, reiziger.getVoorletters());
		statement.setString(2, reiziger.getTussenvoegsel());
		statement.setString(3, reiziger.getAchternaam());
		statement.setDate(4, reiziger.getGbdatum());
		statement.setInt(5, reiziger.getReizigerID());

		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0) {
			System.out.println("Reiziger aangepast");
		}
		conn.close();
		return reiziger;
	}
	
	public boolean delete(Reiziger reiziger) throws SQLException {
		conn = OracleBaseDao.getConnection();
		String query = "DELETE FROM reiziger WHERE reizigerid = ?";

		PreparedStatement statement = conn.prepareStatement(query);
		statement.setInt(1, reiziger.getReizigerID());

		int rowsDeleted = statement.executeUpdate();
		if (rowsDeleted > 0) {
			System.out.println("Reiziger verwijderd");
			return true;
		}
		conn.close();
		return false;
	}
}