package services.dao;

import model.Pilote;

import javax.ejb.Local;
import java.util.List;

@Local
public interface PiloteDAOLocal {
    public List<Pilote> getAllPilotes();
}
