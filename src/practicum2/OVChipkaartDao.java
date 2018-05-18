package practicum2;

import java.sql.SQLException;
import java.util.*;

public interface OVChipkaartDao {

    public List<Ovchipkaart> findAll() throws SQLException;
    public List<Ovchipkaart> findByReiziger(int reizigerid) throws SQLException;
    public Ovchipkaart save(Ovchipkaart ovchipkaart) throws SQLException;
    public Ovchipkaart update(Ovchipkaart ovchipkaart) throws SQLException;
    public boolean delete(Ovchipkaart ovchipkaart) throws SQLException;
    public void closeConnection();
}