package P3;
import java.sql.Date;

public class OVChipkaartProduct {
	private int ovproductID;
	private int kaartNummer;
	private int productNummer;
	private String reisproductStatus;
	private Date lastUpdate;
	
	public OVChipkaartProduct(int ovproductID, int kaartNummer, int productNummer, String reisproductStatus,
			Date lastUpdate) {
		this.ovproductID = ovproductID;
		this.kaartNummer = kaartNummer;
		this.productNummer = productNummer;
		this.reisproductStatus = reisproductStatus;
		this.lastUpdate = lastUpdate;
	}

	public int getOvproductID() {
		return ovproductID;
	}

	public void setOvproductID(int ovproductID) {
		this.ovproductID = ovproductID;
	}

	public int getKaartNummer() {
		return kaartNummer;
	}

	public void setKaartNummer(int kaartNummer) {
		this.kaartNummer = kaartNummer;
	}

	public int getProductNummer() {
		return productNummer;
	}

	public void setProductNummer(int productNummer) {
		this.productNummer = productNummer;
	}

	public String getReisproductStatus() {
		return reisproductStatus;
	}

	public void setReisproductStatus(String reisproductStatus) {
		this.reisproductStatus = reisproductStatus;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
}