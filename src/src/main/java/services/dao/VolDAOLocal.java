package services.dao;

import model.Vol;

import javax.ejb.Local;
import java.util.List;

@Local
public interface VolDAOLocal {
    List<Vol> getAllVols(int nbPage);
    List<Vol> getVolByPiloteId(int piloteId, int nbPage);
    boolean deleteVolById(int volId);
    Vol getVolById(int volId);
    boolean changerVol(int volId, int avionId, int trajetId);
    void ajouterVol(int piloteId, int avionId, int trajetId);
    int getNbTotalVols();
    int getNbVolByPiloteId(int piloteId);
}
