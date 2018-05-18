package practicum2;

import java.sql.Date;
import java.sql.SQLException;
import java.util.*;

public class Main{
	public static void main(String[] arg) throws SQLException {
		ReizigerOracleDaolmpl ro1 = new ReizigerOracleDaolmpl();

		// nieuwe reiziger
		Reiziger r1 = new Reiziger(2, "T", "Plain", "Scott", java.sql.Date.valueOf("1990-12-23"));
		ro1.save(r1);

		// loop om alles te zien
		System.out.println("Alle reizigers: ");
		List<Reiziger> reizigers = ro1.findAll();
		for (Reiziger reiziger : reizigers) {
			System.out.println("Reiziger: #" +reiziger.getReizigerID() + " "+reiziger.getVoorletters()+ ". "+ reiziger.getTussenvoegsel()+" "+reiziger.getAchternaam()+ " geboortedatum: " +reiziger.getGbdatum());
		}
	  }
	  
}