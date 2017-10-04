package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Medicamento;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jorge
 */
public class TestePersistirMedicamento {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirMedicamento() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("DAW-5N1-2017-2-Trabalho-PU");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void teste() {
        boolean exception = false;
        try {
            Medicamento m = new Medicamento();
            m.setNome("dipirona");

            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            exception = true;
        }
        // verifica que o valor do atributo exception continua falso
        Assert.assertEquals(false, exception);
    }

}
