package practicum2;
import java.sql.Date;

public class Ovchipkaart {
	private int kaartnummer;
	private Date geldigtot;
	private int klasse;
	private int saldo;
	private int reizigerid;
	
	
	public Ovchipkaart(int kaartnummer, Date geldigtot, int klasse, int saldo, int reizigerid) {
		this.kaartnummer = kaartnummer;
		this.geldigtot = geldigtot;
		this.klasse = klasse;
		this.saldo = saldo;
		this.reizigerid = reizigerid;
	}


	public int getKaartnummer() {
		return kaartnummer;
	}


	public void setKaartnummer(int kaartnummer) {
		this.kaartnummer = kaartnummer;
	}


	public Date getGeldigtot() {
		return geldigtot;
	}


	public void setGeldigtot(Date geldigtot) {
		this.geldigtot = geldigtot;
	}


	public int getKlasse() {
		return klasse;
	}


	public void setKlasse(int klasse) {
		this.klasse = klasse;
	}


	public int getSaldo() {
		return saldo;
	}


	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}


	public int getReizigerid() {
		return reizigerid;
	}


	public void setReizigerid(int reizigerid) {
		this.reizigerid = reizigerid;
	}

	
}
