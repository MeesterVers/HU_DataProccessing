package practicum1;

import java.sql.Date;
import java.util.*;

public class Main{
	public static void main(String[] arg) {
		ReizigerOracleDaolmpl ro1 = new ReizigerOracleDaolmpl();

		
		Reiziger r1 = new Reiziger();
		String geborteString1 = "801093600000"; //05/22/1995
		long geborteDate1 = Long.valueOf(geborteString1);
		java.sql.Date date1 = new java.sql.Date(geborteDate1);
		r1.setNaam("Steven David");
		r1.setGbdatum(date1);
		ro1.save(r1);
		
		Reiziger r2 = new Reiziger();
		String geborteString2 = "703202400000"; //04/14/1992
		long geborteDate2 = Long.valueOf(geborteString2);
		System.out.println(geborteDate2);
		java.sql.Date date2 = new java.sql.Date(geborteDate2);
		r2.setNaam("Russ Stan");
		r2.setGbdatum(date2);
		ro1.save(r2);
		
		// loop om alles te zien
		System.out.println("Alle reizigers: ");
		for (Reiziger reiziger : ro1.findAll()) {
			System.out.println("naam: " +reiziger.getNaam()+ " geboortedatum: " +reiziger.getGbdatum());
		}
		
		// r2.setNaam("Russ Stan2");
		// r2.setGbdatum(date1);
		// ro1.update(r2);
		
		// if(ro1.delete(r1)) {
		// 	System.out.println("Deleted");
		// }
		
		// loop na update of delete 
		System.out.println("\nAlle reizigers na update of delete: ");
		for (Reiziger reiziger : ro1.findAll()) {
			System.out.println("naam: " +reiziger.getNaam()+ " geboortedatum: " +reiziger.getGbdatum());
		}
	  }
	  
}