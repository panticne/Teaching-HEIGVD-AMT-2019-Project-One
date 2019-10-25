package services.dao;

import model.Avion;
import model.Pilote;

import javax.ejb.Local;
import java.util.List;

@Local
public interface AvionDAOLocal {
    public List<Avion> getAllPlane();

}
