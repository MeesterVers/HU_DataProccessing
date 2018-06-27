package P3;

import java.sql.Date;
import java.sql.SQLException;
import java.util.*;

public class Main{
public static void main(String[] arg) throws SQLException {
		// DerbyBaseDao connectionTest = new DerbyBaseDao(); check connection hier
		// ---------------------------------------------------------------------------------
		

		// implementaties oproepen
		ReizigerOracleDaolmpl ro1 = new ReizigerOracleDaolmpl();
		OVChipkaartOracleDAOImpl ov1 = new OVChipkaartOracleDAOImpl();
		// ---------------------------------------------------------------------------------


		// nieuwe reiziger
		// Reiziger r1 = new Reiziger(4, "George", "f", "neef", java.sql.Date.valueOf("1992-06-20"));
		// ro1.save(r1);
		 // ------------------------------------------------------------------------------------------
		

		// loop alle reizigers
		System.out.println("Alle reizigers: ");
		List<Reiziger> reizigers = ro1.findAll();
		for (Reiziger reiziger : reizigers) {
			System.out.println("Reiziger: #" +reiziger.getReizigerID() + " "+reiziger.getVoorletters()+ ". "+ reiziger.getTussenvoegsel()+" "+reiziger.getAchternaam()+ " geboortedatum: " +reiziger.getGbdatum());
		}
		// ---------------------------------------------------------------------------------------------------------


		// find by date reizigers
		// System.out.println("\nGevonden reizigers: ");
		// List<Reiziger> gevonden_reizigers = ro1.findByGBdatum("1992-05-04");
		// for (Reiziger gevonden_reiziger : gevonden_reizigers) {
		// 	System.out.println("Reiziger: #" +gevonden_reiziger.getReizigerID() + " "+gevonden_reiziger.getVoorletters()+ ". "+ gevonden_reiziger.getTussenvoegsel()+" "+gevonden_reiziger.getAchternaam()+ " geboortedatum: " +gevonden_reiziger.getGbdatum());
		// }
		// ---------------------------------------------------------------------------------------------------------------------------

		
		// Nieuw OvChipkaart bestaande reiziger
		// Reiziger r2 = (Reiziger)ro1.findByReizigerID(2);
		// Ovchipkaart k1 = new Ovchipkaart(5, java.sql.Date.valueOf("2026-10-01"), 1, 120, r2.getReizigerID());
		// ov1.update(k1, r2);
		// ----------------------------------------------------------------------------------------------------------------------------


		// Nieuw OvChipkaart nieuwe reiziger
		// Ovchipkaart k1 = new Ovchipkaart(5, java.sql.Date.valueOf("2022-10-01"), 1, 300, r1.getReizigerID());
		// ov1.save(k1, r1);
		// ----------------------------------------------------------------------------------------------------------------------------


		// loop alle ovchipkaarten
		 System.out.println("\nAlle OvChipkarten: ");
		 List<Ovchipkaart> ovchipkarten = ov1.findAll();
		 for (Ovchipkaart ovchipkaart : ovchipkarten) {
		 	System.out.println("Ovchipkaart: #" +ovchipkaart.getKaartnummer() + " Geldig tot:"+ovchipkaart.getGeldigtot()+ ", Klasse:"+ ovchipkaart.getKlasse()+", Saldo:"+ovchipkaart.getSaldo()+ " rezigerID: " +ovchipkaart.getReizigerid());
		 }
		// ------------------------------------------------------------------------------------------------------------------------------

		// find ovchipkaart by reizigerid
		// System.out.println("\nGevonden OVChipkarten: ");
		// List<Ovchipkaart> gevonden_ovchipkarten = ov1.findByReiziger(3);
		// for (Ovchipkaart gevonden_ovchipkaart : gevonden_ovchipkarten) {
		// 	System.out.println("Ovchipkaart: #" +gevonden_ovchipkaart.getKaartnummer() + " Geldig tot:"+gevonden_ovchipkaart.getGeldigtot()+ ", Klasse:"+ gevonden_ovchipkaart.getKlasse()+", Saldo:"+gevonden_ovchipkaart.getSaldo()+ " rezigerID: " +gevonden_ovchipkaart.getReizigerid());
		// }
	}
}