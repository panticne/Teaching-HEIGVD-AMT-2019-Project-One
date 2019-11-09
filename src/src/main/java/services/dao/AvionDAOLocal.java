package services.dao;

import model.Avion;
import javax.ejb.Local;
import java.sql.SQLException;
import java.util.List;

@Local
public interface AvionDAOLocal {
    public List<Avion> getAllPlane() throws SQLException;
    public Avion getAvionById(int id)  throws SQLException;
}
