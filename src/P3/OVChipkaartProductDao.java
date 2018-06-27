package P3;

import java.sql.SQLException;
import java.util.*;

public interface OVChipkaartProductDao {

    public List<OVChipkaartProduct> findAll() throws SQLException;
    public List<OVChipkaartProduct> findByReiziger(Reiziger reiziger) throws SQLException;
    public OVChipkaartProduct save(OVChipkaartProduct product, Ovchipkaart ovchipkaart, Reiziger reiziger) throws SQLException;
    public OVChipkaartProduct update(OVChipkaartProduct product, Ovchipkaart ovchipkaart, Reiziger reiziger) throws SQLException;
    public boolean delete(OVChipkaartProduct product, Ovchipkaart ovchipkaart, Reiziger reiziger) throws SQLException;
    public void closeConnection();
}