package practicum1;

import java.util.*;

public interface ReizigerDao {

    public List<Reiziger> findAll();
    public List<Reiziger> findByGBdatum(String GBdatum);
    public Reiziger save(Reiziger reiziger);
    public Reiziger update(Reiziger reiziger);
    public boolean delete(Reiziger reiziger);
    public void closeConnection();
}