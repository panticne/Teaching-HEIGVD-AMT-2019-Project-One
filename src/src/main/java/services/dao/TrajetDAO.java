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
