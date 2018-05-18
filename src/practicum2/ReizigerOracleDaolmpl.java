package practicum2;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class ReizigerOracleDaolmpl extends OracleBaseDao implements ReizigerDao{
	private static Connection conn;
	private List<Reiziger> reizigers = new ArrayList<Reiziger>();

	public List<Reiziger> findAll() throws SQLException {
		conn = OracleBaseDao.getConnection();
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

	public List<Reiziger> findByGBdatum(String GBdatum) {
		for (Reiziger reiziger: reizigers) {

			if (reiziger.getGbdatum().equals(GBdatum)) {
				return (List<Reiziger>) reiziger;
			}
		}
		return (List<Reiziger>) reizigers;
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
		return reiziger;
	}
	
	public Reiziger update(Reiziger reiziger) {
		for (Reiziger reizigerLijst : reizigers) {
			if(reiziger.getAchternaam().equals(reizigerLijst.getAchternaam())){
				reizigers.set(reizigers.indexOf(reizigerLijst), reiziger);
			}
		}
		return reiziger;
	}
	
	public boolean delete(Reiziger reiziger) {
		for (Reiziger reizigerLijst : reizigers) {
			if(reiziger.getAchternaam().equals(reizigerLijst.getAchternaam())){
				reizigers.remove(reizigers.indexOf(reizigerLijst));
				return true;
			}
		}
		return false;
	}
}