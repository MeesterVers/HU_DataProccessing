package practicum2;
import java.sql.Date;

public class Reiziger {
    private int ID;
    private String voorletters;
    private String tussenvoegsel;
    private String achternaam;
    private Date gbdatum;


    public Reiziger(String voorletters, String tussenvoegsel, String achternaam, Date gbdatum) {
    	this.achternaam = achternaam;
    	this.gbdatum = gbdatum;
	}

	public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public Date getGbdatum() {
        return gbdatum;
    }

    public void setGbdatum(Date gbdatum) {
        this.gbdatum = gbdatum;
    }

}