package services.dao;

import model.Vol;

import javax.ejb.Local;
import java.util.List;

@Local
public interface VolDAOLocal {
    List<Vol> getAllVols();
    List<Vol> getVolByPiloteId(int piloteId);
    boolean deleteVolById(int volId);
    Vol getVolById(int volId);
    boolean changerVol(int volId, int avionId, int trajetId);
}
