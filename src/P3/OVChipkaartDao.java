package P3;

import java.sql.SQLException;
import java.util.*;

public interface OVChipkaartDao {

    public List<Ovchipkaart> findAll() throws SQLException;
    public List<Ovchipkaart> findByReiziger(Reiziger reiziger) throws SQLException;
    public Ovchipkaart save(Ovchipkaart ovchipkaart, Reiziger reiziger) throws SQLException;
    public Ovchipkaart update(Ovchipkaart ovchipkaart, Reiziger reiziger) throws SQLException;
    public boolean delete(Ovchipkaart ovchipkaart, Reiziger reiziger) throws SQLException;
    public void closeConnection();
}