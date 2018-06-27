package P3;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class ReizigerOracleDaolmpl extends OracleBaseDao implements ReizigerDao{
	private static Connection conn;
	private List<Reiziger> reizigers = new ArrayList<Reiziger>();
	private List<Ovchipkaart> ovchipkaarten = new ArrayList<Ovchipkaart>();
	private OVChipkaartOracleDAOImpl ov1 = new OVChipkaartOracleDAOImpl();

	public List<Reiziger> findAll() throws SQLException {
		List<Reiziger> reizigers = new ArrayList<Reiziger>();
		List<Ovchipkaart> ovchipkaarten = new ArrayList<Ovchipkaart>();
		OVChipkaartOracleDAOImpl ov1 = new OVChipkaartOracleDAOImpl();
		conn = OracleBaseDao.getConnection();

		String query = "SELECT * FROM REIZIGER";
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(query);
		
		while (result.next()) {
			int reizigerID = result.getInt("reizigerID");
			String voorletters = result.getString("voorletters");
			String tussenvoegsel = result.getString("tussenvoegsel");
			String achternaam = result.getString("achternaam");
			Date gebortedatum = result.getDate("gebortedatum");

			Reiziger reiziger = new Reiziger(reizigerID, voorletters, tussenvoegsel, achternaam, gebortedatum);
			reizigers.add(reiziger);
			
			// get ovchipkaarten
			ovchipkaarten = ov1.findByReiziger(reiziger);
			
		}
		conn.close();
		result.close();
		return reizigers;
	}

	public List<Reiziger> findByGBdatum(String GBdatum) throws SQLException {
		List<Reiziger> reizigers = new ArrayList<Reiziger>();
		conn = OracleBaseDao.getConnection();

		PreparedStatement statement = conn.prepareStatement("SELECT * FROM Reiziger WHERE gebortedatum = ?");    
		statement.setDate(1, java.sql.Date.valueOf(GBdatum));    
		ResultSet result = statement.executeQuery();
		
		while (result.next()) {
			int reizigerID = result.getInt("reizigerID");
			String voorletters = result.getString("voorletters");
			String tussenvoegsel = result.getString("tussenvoegsel");
			String achternaam = result.getString("achternaam");
			Date gebortedatum = result.getDate("gebortedatum");

			Reiziger reiziger = new Reiziger(reizigerID, voorletters, tussenvoegsel, achternaam, gebortedatum);
			reizigers.add(reiziger);
		}
		conn.close();
		result.close();
		return reizigers;
	}
	
	
	public Reiziger findByReizigerID(int reizigerid) throws SQLException {
		conn = OracleBaseDao.getConnection();

		PreparedStatement statement = conn.prepareStatement("SELECT * FROM Reiziger WHERE reizigerid = ?");    
		statement.setInt(1, reizigerid);    
		ResultSet result = statement.executeQuery();

		// Iets doen met de resultaten
		Reiziger reiziger = null;
		
		while (result.next()) {
			int reizigerID = result.getInt("reizigerID");
			String voorletters = result.getString("voorletters");
			String tussenvoegsel = result.getString("tussenvoegsel");
			String achternaam = result.getString("achternaam");
			Date gebortedatum = result.getDate("gebortedatum");

			reiziger = new Reiziger(reizigerID, voorletters, tussenvoegsel, achternaam, gebortedatum);
		}
		conn.close();
		result.close();
		return reiziger;
	}
	
	public Reiziger save(Reiziger reiziger) throws SQLException{
		conn = OracleBaseDao.getConnection();
		String query = "INSERT INTO reiziger (reizigerid, voorletters, tussenvoegsel, achternaam, gebortedatum) VALUES (?, ?, ?, ?, ?)";

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

	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub
		
	}
}