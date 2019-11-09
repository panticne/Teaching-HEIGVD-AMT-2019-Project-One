package services.dao;
import model.Avion;
import model.Pilote;
import model.Trajet;
import model.Vol;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class VolDAO implements VolDAOLocal{
    @Resource(lookup = "jdbc/dbVol")
    private DataSource dataSource;

    private int nbRecordPerPages = 10;

    @Override
    public int getNbTotalVols() throws SQLException {
        int nbVol = 0;
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("SELECT COUNT(*) as nbVol FROM vol");
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        nbVol = rs.getInt("nbVol");
        connection.close();

        return nbVol;
    }

    @Override
    public List<Vol> getAllVols(int nbPage) throws SQLException{
        List<Vol> vols = new ArrayList<Vol>();

        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("SELECT vol.id, pilote_id, prenom, nom, pseudo, motdepasse, avion_id, compagnie, type, trajet_id, depart, arrivee, duree FROM pilote INNER JOIN vol  ON pilote.id = vol.pilote_id INNER JOIN avion ON avion.id = vol.avion_id INNER JOIN trajet ON trajet.id = vol.trajet_id LIMIT ? OFFSET ?");
        pstmt.setInt(1, nbRecordPerPages);
        pstmt.setInt(2, nbRecordPerPages * (nbPage - 1));
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()){
            vols.add(new Vol(
                    rs.getInt("id"),
                    new Avion(rs.getInt("avion_id"), rs.getString("compagnie"), rs.getString("type")),
                    new Pilote(rs.getString("prenom"), rs.getString("nom"), rs.getString("pseudo"), rs.getString("motdepasse")),
                    new Trajet(rs.getInt("trajet_id"), rs.getString("depart"), rs.getString("arrivee"), rs.getInt("duree"))
            ));
        }

        connection.close();
        return vols;
    }

    @Override
    public List<Vol> getVolByPiloteId(int piloteId , int nbPage) throws SQLException {
        List<Vol> vols = new ArrayList<Vol>();

        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("SELECT vol.id, pilote_id, prenom, nom, pseudo, motdepasse, avion_id, compagnie, type, trajet_id, depart, arrivee, duree FROM pilote INNER JOIN vol  ON pilote.id = vol.pilote_id INNER JOIN avion ON avion.id = vol.avion_id INNER JOIN trajet ON trajet.id = vol.trajet_id WHERE pilote_id = ? LIMIT ? OFFSET ?");
        pstmt.setInt(1, piloteId);
        pstmt.setInt(2, nbRecordPerPages);
        pstmt.setInt(3, nbRecordPerPages * (nbPage - 1));
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()){
            vols.add(
                new Vol(
                    rs.getInt("id"),
                    new Avion(rs.getInt("avion_id"), rs.getString("compagnie"), rs.getString("type")),
                    new Pilote(rs.getString("prenom"), rs.getString("nom"), rs.getString("pseudo"), rs.getString("motdepasse")),
                    new Trajet(rs.getInt("trajet_id"), rs.getString("depart"), rs.getString("arrivee"), rs.getInt("duree"))
                )
            );
        }

        connection.close();
        return vols;
    }

    @Override
    public int getNbVolByPiloteId(int piloteId) throws SQLException{
        int nbVol = 0;
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("SELECT COUNT(*) as nbVol FROM vol WHERE pilote_id = ?");
        pstmt.setInt(1, piloteId);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        nbVol = rs.getInt("nbVol");
        connection.close();
        return nbVol;
    }

    @Override
    public void deleteVolById(int volId) throws SQLException{
        String query = "DELETE FROM vol where id = ?";
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, volId);
        pstmt.executeUpdate();
        connection.close();
    }

    @Override
    public Vol getVolById(int volId) throws SQLException {
        Vol vol = null;

        String query = "SELECT vol.id, pilote_id, prenom, nom, pseudo, motdepasse, avion_id, compagnie, type, trajet_id, depart, arrivee, duree FROM pilote INNER JOIN vol  ON pilote.id = vol.pilote_id INNER JOIN avion ON avion.id = vol.avion_id INNER JOIN trajet ON trajet.id = vol.trajet_id WHERE vol.id = ?";
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, volId);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next() != false) {
            vol = new Vol(
                    rs.getInt("id"),
                    new Avion(rs.getInt("avion_id"), rs.getString("compagnie"), rs.getString("type")),
                    new Pilote(rs.getString("prenom"), rs.getString("nom"), rs.getString("pseudo"), rs.getString("motdepasse")),
                    new Trajet(rs.getInt("trajet_id"), rs.getString("depart"), rs.getString("arrivee"), rs.getInt("duree"))
            );
        }
        connection.close();

        return vol;
    }

    @Override
    public void changerVolbyPilote(int volId, int avionId, int trajetId) throws SQLException{
        Connection connection = dataSource.getConnection();
        String query = "UPDATE vol SET avion_id = ?, trajet_id = ? WHERE id = ?";
        PreparedStatement pstmtUpdate = connection.prepareStatement(query);
        pstmtUpdate.setInt(1, avionId);
        pstmtUpdate.setInt(2, trajetId);
        pstmtUpdate.setInt(3, volId);
        pstmtUpdate.executeUpdate();
        connection.close();
    }

    @Override
    public void ajouterVol(int piloteId, int avionId, int trajetId) throws SQLException{
        String query = "INSERT INTO vol VALUES(NULL, ?, ?, ?)";
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmtUpdate = connection.prepareStatement(query);
        pstmtUpdate.setInt(1, piloteId);
        pstmtUpdate.setInt(2, avionId);
        pstmtUpdate.setInt(3, trajetId);
        pstmtUpdate.executeUpdate();
        connection.close();
    }

    @Override
    public List<Vol> getAllVolsTest() throws SQLException {
        List<Vol> vols = new ArrayList<Vol>();

        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("SELECT vol.id, pilote_id, prenom, nom, pseudo, motdepasse, avion_id, compagnie, type, trajet_id, depart, arrivee, duree FROM pilote INNER JOIN vol  ON pilote.id = vol.pilote_id INNER JOIN avion ON avion.id = vol.avion_id INNER JOIN trajet ON trajet.id = vol.trajet_id ORDER BY id");
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()){
            vols.add(new Vol(
                    rs.getInt("id"),
                    new Avion(rs.getInt("avion_id"), rs.getString("compagnie"), rs.getString("type")),
                    new Pilote(rs.getString("prenom"), rs.getString("nom"), rs.getString("pseudo"), rs.getString("motdepasse")),
                    new Trajet(rs.getInt("trajet_id"), rs.getString("depart"), rs.getString("arrivee"), rs.getInt("duree"))
            ));
        }

        connection.close();
        return vols;
    }
}
