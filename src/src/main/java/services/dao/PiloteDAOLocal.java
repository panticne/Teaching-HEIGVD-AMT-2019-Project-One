package services.dao;

import model.Pilote;
import model.Vol;

import javax.ejb.Local;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

@Local
public interface PiloteDAOLocal {
    public List<Pilote> getAllPilotes();
    public int registerPilote(Pilote pilote) throws ClassNotFoundException, SQLException;
    public boolean loginControl(String pseudo, String motdepasse)throws ClassNotFoundException, SQLException;
    public int getPiloteId(String pseudo, String mdp);
    public Pilote getPiloteById(int pilotId);
    public boolean changePassword(int id, String oldPassword, String newPassword, String confirmPassword);
}
