package services.dao;

import model.Trajet;

import java.util.List;

public interface TrajetDAOLocal {
    public Trajet getTrajetById(int id);
    public List<Trajet> getAllTrajet();
}
