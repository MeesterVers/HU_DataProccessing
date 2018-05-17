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
		String achternaam;
		Date gebortedatum;
		Reiziger obj;
		
		while (result.next()) {
			achternaam = result.getString("achternaam");
			gebortedatum = result.getDate("gebortedatum");
			
			obj = new Reiziger(achternaam, gebortedatum);
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
	
	public Reiziger save(Reiziger reiziger){
		reizigers.add(reiziger);
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