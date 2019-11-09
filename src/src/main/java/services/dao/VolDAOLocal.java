package services.dao;

import model.Vol;

import javax.ejb.Local;
import java.sql.SQLException;
import java.util.List;

@Local
public interface VolDAOLocal {
    List<Vol> getAllVols(int nbPage) throws SQLException;
    List<Vol> getAllVolsTest() throws SQLException;
    List<Vol> getVolByPiloteId(int piloteId, int nbPage) throws SQLException;
    void deleteVolById(int volId) throws SQLException;
    Vol getVolById(int volId) throws SQLException;
    void changerVolbyPilote(int volId, int avionId, int trajetId) throws SQLException;
    void ajouterVol(int piloteId, int avionId, int trajetId) throws SQLException;
    int getNbTotalVols() throws SQLException;
    int getNbVolByPiloteId(int piloteId) throws SQLException;

}
