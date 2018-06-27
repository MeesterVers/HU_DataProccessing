package P2;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Reiziger {
    private int reizigerID;
    private String voorletters;
    private String tussenvoegsel;
    private String achternaam;
    private Date gbdatum;
    private ArrayList<Ovchipkaart> ovchipkarten;


    public Reiziger(int reizigerID, String voorletters, String tussenvoegsel, String achternaam, Date gbdatum) {
        this.reizigerID = reizigerID;
        this.voorletters = voorletters;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.gbdatum = gbdatum;
        this.ovchipkarten = new ArrayList<Ovchipkaart>();
    }

    
  public int getReizigerID() {
      return reizigerID;
  }


  public void setReizigerID(int reizigerID) {
      this.reizigerID = reizigerID;
  }


  public String getVoorletters() {
      return voorletters;
  }


  public void setVoorletters(String voorletters) {
      this.voorletters = voorletters;
  }


  public String getTussenvoegsel() {
      return tussenvoegsel;
  }


  public void setTussenvoegsel(String tussenvoegsel) {
      this.tussenvoegsel = tussenvoegsel;
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


public ArrayList<Ovchipkaart> getOvchipkarten() {
    return ovchipkarten;
}


public void setOvchipkarten(ArrayList<Ovchipkaart> ovchipkarten) {
    this.ovchipkarten = ovchipkarten;
}

}