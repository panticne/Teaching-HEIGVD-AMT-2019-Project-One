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


    private AvionDAO avionDAO;
    @Resource(lookup = "jdbc/dbVol")
    private DataSource dataSource;

    @Override
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

    @Override
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

    @Override
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

    @Override
    public int getPiloteId(String pseudo, String mdp){
        int id = 0;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT id FROM pilote WHERE pseudo = ? AND motdepasse = ?");
            pstmt.setString(1, pseudo);
            pstmt.setString(2, mdp);
            ResultSet rs = pstmt.executeQuery();

            rs.next();
            id = rs.getInt("id");

            connection.close();
        }catch(Exception e){

        }
        return id;
    }

    @Override
    public Pilote getPiloteById(int pilotId){
        Pilote pilote = null;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM pilote WHERE id = ?");
            pstmt.setInt(1, pilotId);
            ResultSet rs = pstmt.executeQuery();

            rs.next();
            pilote = new Pilote(rs.getString("prenom"), rs.getString("nom"), rs.getString("pseudo"), rs.getString("motdepasse"));

            connection.close();
        }catch(Exception e){

        }
        return pilote;
    }

    @Override
    public boolean changePassword(int id, String oldPassword, String newPassword, String confirmPassword) {
        try {
            String query = "SELECT motdepasse FROM pilote WHERE id = ?";
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            rs.next();
            String dbPassword = rs.getString("motdepasse");
            if(oldPassword.equals(dbPassword) && confirmPassword.equals(newPassword)){
                query = "UPDATE pilote SET motdepasse = ? WHERE id = ?";
                PreparedStatement pstmtUpdate = connection.prepareStatement(query);
                pstmtUpdate.setString(1, newPassword);
                pstmtUpdate.setInt(2, id);
                pstmtUpdate.executeUpdate();
                connection.close();
                return true;
            }

            connection.close();
        }catch(Exception e){

        }

        return false;
    }
}
