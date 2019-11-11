package services.dao;

import org.arquillian.container.chameleon.deployment.api.DeploymentParameters;
import org.arquillian.container.chameleon.deployment.maven.MavenBuild;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import java.sql.SQLException;

@RunWith(Arquillian.class)
@MavenBuild
@DeploymentParameters(testable = true)
public class AvionDAOTest {

    @EJB
    AvionDAOLocal avionDAOLocal;

    @Test
    @Transactional(TransactionMode.ROLLBACK)
    public void itShouldBePossibleToGetAllPlanes() throws SQLException {
        avionDAOLocal.getAllPlane();
    }

    @Test
    @Transactional(TransactionMode.ROLLBACK)
    public void itShouldBePossibleToGetPlaneById() throws SQLException {
        avionDAOLocal.getAvionById(1);
    }

}