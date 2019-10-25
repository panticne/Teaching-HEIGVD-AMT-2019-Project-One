package services.dao;

import model.Pilote;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PiloteDAO implements PiloteDAOLocal {

    @Resource(lookup = "jdbc/dbVol")
    private DataSource dataSource;
    public List<Pilote> getAllPilotes(){
        List<Pilote> pilotes = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM pilote");
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                pilotes.add(new Pilote(rs.getString("firstname"), rs.getString("lastname")));
            }
            connection.close();
        }catch(Exception e){

        }

        return pilotes;
    }
}
