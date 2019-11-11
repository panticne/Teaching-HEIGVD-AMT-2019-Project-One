package services.dao;

import model.Avion;

import javax.annotation.Resource;
import javax.ejb.DuplicateKeyException;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class AvionDAO implements AvionDAOLocal {

    @Resource(lookup = "jdbc/dbVol")
    private DataSource dataSource;

    /**
     * Permet de récupérer tous les avions de la base de données
     * @return List d'avion
     * @throws SQLException
     */
    @Override
    public List<Avion> getAllPlane() throws SQLException{
        List<Avion> planes = new ArrayList<>();
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM avion");
        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            planes.add(new Avion(rs.getInt("id"),rs.getString("compagnie"), rs.getString("type")));
        }

        connection.close();
        return planes;
    }

    /**
     * Permet de récupérer un avion de la base de données selon son Id
     * @param id Id de l'avion à récupérer
     * @return Avion
     * @throws SQLException
     */
    @Override
    public Avion getAvionById(int id) throws SQLException{
        Avion avion = null;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM avion WHERE id = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            avion = new Avion(rs.getInt("id"), rs.getString("compagnie"), rs.getString("type"));
            connection.close();
        }catch(Exception e){

        }

        return avion;
    }
}
