package services.dao;

import model.Pilote;

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
public class PiloteDAO implements PiloteDAOLocal {

    @Resource(lookup = "jdbc/dbVol")
    private DataSource dataSource;
    public int registerPilote(Pilote pilote) throws ClassNotFoundException, SQLException {
       String INSERT_PILOTE_SQL = "INSERT INTO pilote (prenom,nom,pseudo,motdepasse) VALUES (?, ?, ?, ?);";

       int result = 0;

        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(INSERT_PILOTE_SQL);

        pstmt.setString(1,pilote.getPrenom());
        pstmt.setString(2,pilote.getNom());
        pstmt.setString(3,pilote.getPseudo());
        pstmt.setString(4,pilote.getMotdepasse());

        result = pstmt.executeUpdate();

        return result;

    }


    public List<Pilote> getAllPilotes(){
        List<Pilote> pilotes = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM pilote");
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                pilotes.add(new Pilote(rs.getString("prenom"), rs.getString("nom"),rs.getString("pseudo"),rs.getString("motdepasse")));
            }
            connection.close();
        }catch(Exception e){

        }

        return pilotes;
    }

    public boolean loginControl(String pseudo2, String motdepasse) throws SQLException {
        String INSERT_PILOTE_SQL = "SELECT pseudo,motdepasse FROM pilote WHERE pseudo =?";
        String pseudoDB = null;
        String mdpDB = null;
        boolean result = true;


        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(INSERT_PILOTE_SQL);
        pstmt.setString(1,pseudo2);

        ResultSet resultatRequete = pstmt.executeQuery();

        while (resultatRequete.next()){
             pseudoDB = resultatRequete.getString("pseudo");
             mdpDB =resultatRequete.getString("motdepasse");
        }


        if(pseudo2.equals(pseudoDB) && motdepasse.equals(mdpDB)){
            result = true;
        }else{
            result = false;
        }

        return result;
    }
}
