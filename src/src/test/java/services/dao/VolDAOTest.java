package services.dao;

import model.Avion;
import model.Pilote;
import model.Trajet;
import model.Vol;
import org.arquillian.container.chameleon.deployment.api.DeploymentParameters;
import org.arquillian.container.chameleon.deployment.maven.MavenBuild;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
@MavenBuild
@DeploymentParameters(testable = true)
public class VolDAOTest {
    @EJB
    VolDAOLocal volDAOLocal;

    @EJB
    PiloteDAOLocal piloteDAOLocal;

    @Test
    @Transactional(TransactionMode.ROLLBACK)
    public void itShouldBePossibleToGetNumberOfVols() throws SQLException {
        volDAOLocal.getNbTotalVols();
    }

    @Test
    @Transactional(TransactionMode.ROLLBACK)
    public void itShouldBePossibleToGetAllVols() throws SQLException{
        volDAOLocal.getAllVols(1);
    }

    @Test
    @Transactional(TransactionMode.ROLLBACK)
    public void itShouldBePossibleToGetVolByPiloteId() throws SQLException{
        volDAOLocal.getVolByPiloteId(1,1);
    }

    @Test
    @Transactional(TransactionMode.ROLLBACK)
    public void itShouldBePossibleToGetNbVolByPiloteId() throws SQLException{
        volDAOLocal.getNbVolByPiloteId(1);
    }

    @Test
    @Transactional(TransactionMode.ROLLBACK)
    public void itShouldBePossibleToGetVolById() throws SQLException{
        volDAOLocal.getVolById(1);
    }

    @Test
    @Transactional(TransactionMode.ROLLBACK)
    public void itShouldBePossibleToDeleteVolById() throws SQLException{
        volDAOLocal.deleteVolById(1);
        Vol vol = volDAOLocal.getVolById(1);
        assertNull(vol);
    }

    @Test
    @Transactional(TransactionMode.ROLLBACK)
    public void itShouldBePossibleToChangeVol() throws SQLException{
        volDAOLocal.changerVolbyPilote(1, 1, 1 );
        Vol vol = volDAOLocal.getVolById(1);
        Avion actuelAvion = vol.getAvion();
        Trajet actuelTrajet = vol.getTrajet();

        volDAOLocal.changerVolbyPilote(1, 2, 2 );

        vol = volDAOLocal.getVolById(1);



        assertNotEquals(actuelAvion.getId(), vol.getAvion().getId());
        assertNotEquals(actuelTrajet.getId(), vol.getTrajet().getId());
    }

    @Test
    @Transactional(TransactionMode.ROLLBACK)
    public void itShouldBePossibleToAddVol() throws SQLException{
        volDAOLocal.ajouterVol(1, 1, 1);
        List<Vol> vols = volDAOLocal.getAllVolsTest();
        Vol addedVol = vols.get(vols.size() - 1);

        assertEquals(1, addedVol.getAvion().getId());
        assertEquals(1, addedVol.getTrajet().getId());
        int piloteId = piloteDAOLocal.getPiloteId(addedVol.getPilote().getPseudo(),addedVol.getPilote().getMotdepasse());
        assertEquals(1, piloteId);
    }
}