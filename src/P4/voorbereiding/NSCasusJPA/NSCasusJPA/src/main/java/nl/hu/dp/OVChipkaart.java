package nl.hu.dp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ovchipkaart")
public class OVChipkaart {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "kaart_Sequence")
    @SequenceGenerator(name = "kaart_Sequence", sequenceName = "KAART_SEQ")
    private int kaartnr;
    private Date geldigheid;
    private String kaartopdruk;

    public int getKaartnr() {
        return kaartnr;
    }

    public void setKaartnr(int kaartnr) {
        this.kaartnr = kaartnr;
    }

    public Date getGeldigheid() {
        return geldigheid;
    }

    public void setGeldigheid(Date geldigheid) {
        this.geldigheid = geldigheid;
    }

    public String getKaartopdruk() {
        return kaartopdruk;
    }

    public void setKaartopdruk(String kaartopdruk) {
        this.kaartopdruk = kaartopdruk;
    }

    @Override
    public String toString() {
        return "OVChipkaart{" +
                "kaartnr=" + kaartnr +
                ", geldigheid=" + geldigheid +
                ", kaartopdruk='" + kaartopdruk + '\'' +
                '}';
    }
}
