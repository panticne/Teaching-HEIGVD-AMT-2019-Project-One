package services.dao;

import model.Trajet;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class TrajetDAO implements TrajetDAOLocal {
    @Resource(lookup = "jdbc/dbVol")
    private DataSource dataSource;

    /**
     * Permet de récupérer un trajet selon son Id
     * @param id Id du trajet
     * @return Trajet
     */
    @Override
    public Trajet getTrajetById(int id) {
        Trajet trajet = null;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM trajet WHERE id = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            trajet = new Trajet(rs.getInt("id"), rs.getString("depart"), rs.getString("arrivee"), rs.getInt("duree"));
            connection.close();
        }catch(Exception e){

        }

        return trajet;
    }

    /**
     * Permet de récupérer tous les trajets de la base de données
     * @return Liste de trajet
     */
    @Override
    public List<Trajet> getAllTrajet() {
        List<Trajet> trajets = new ArrayList<>();

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM trajet");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                trajets.add(new Trajet(rs.getInt("id"), rs.getString("depart"), rs.getString("arrivee"), rs.getInt("duree")));
            }
            connection.close();
        }catch(Exception e){

        }

        return trajets;
    }
}
