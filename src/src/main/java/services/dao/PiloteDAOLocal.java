package services.dao;

import model.Pilote;

import javax.ejb.Local;
import java.sql.SQLException;
import java.util.List;

@Local
public interface PiloteDAOLocal {
    public List<Pilote> getAllPilotes();
    public int registerPilote(Pilote pilote) throws ClassNotFoundException, SQLException;
}
