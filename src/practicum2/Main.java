package practicum2;

import java.sql.Date;
import java.sql.SQLException;
import java.util.*;

public class Main{
	public static void main(String[] arg) throws SQLException {
		ReizigerOracleDaolmpl ro1 = new ReizigerOracleDaolmpl();

		// loop om alles te zien
		System.out.println("Alle reizigers: ");
		List<Reiziger> reizigers = ro1.findAll();
		for (Reiziger reiziger : reizigers) {
			System.out.println("Reiziger: #" +reiziger.getReizigerID() + " "+reiziger.getVoorletters()+ ". "+ reiziger.getTussenvoegsel()+" "+reiziger.getAchternaam()+ " geboortedatum: " +reiziger.getGbdatum());
		}
	  }
	  
}