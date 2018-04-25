package practicum1;

import java.util.*;

public class ReizigerOracleDaolmpl extends OracleBaseDao implements ReizigerDao{
	private List<Reiziger> reizigers = new ArrayList<Reiziger>();

	public List<Reiziger> findAll() {
		return reizigers;
	}

	public List<Reiziger> findByGBdatum(String GBdatum) {
		for (Reiziger reiziger: reizigers) {
	
			if (reiziger.getGbdatum().equals(GBdatum)) {
				return (List<Reiziger>) reiziger;
			}
		}
		return (List<Reiziger>) reizigers;
	}
	
	public Reiziger save(Reiziger reiziger){
		reizigers.add(reiziger);
		return reiziger;
	}
	
	public Reiziger update(Reiziger reiziger) {
		for (Reiziger reizigerLijst : reizigers) {
			if(reiziger.getNaam().equals(reizigerLijst.getNaam())){
				reizigers.set(reizigers.indexOf(reizigerLijst), reiziger);
			}
		}
		return reiziger;
	}
	
	public boolean delete(Reiziger reiziger) {
		for (Reiziger reizigerLijst : reizigers) {
			if(reiziger.getNaam().equals(reizigerLijst.getNaam())){
				reizigers.remove(reizigers.indexOf(reizigerLijst));
				return true;
				}
			}
		return false;
	}
}