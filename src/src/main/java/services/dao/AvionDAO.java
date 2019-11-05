package services.dao;

import model.Avion;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class AvionDAO implements AvionDAOLocal {

    @Resource(lookup = "jdbc/dbVol")
    private DataSource dataSource;

    public List<Avion> getAllPlane(){
        List<Avion> planes = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM avion");
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                planes.add(new Avion(rs.getInt("id"),rs.getString("compagnie"), rs.getString("type")));
            }
            connection.close();
        }catch(Exception e){

        }

        return planes;
    }

    public Avion getAvionById(int id){
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
