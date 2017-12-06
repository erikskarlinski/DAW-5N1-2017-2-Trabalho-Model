package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Consulta;
import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Exame;
import br.edu.ifsul.modelo.Medico;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jorge
 */
public class TestePersistirExame {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirExame() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("DAW-5N1-2017-2-Trabalho-PU");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
    }

    @Test
    public void teste() {
        boolean exception = false;
        try {

            Exame ex = new Exame();
            ex.setDescricao("teste");
            ex.setNome("aaaaaaaaa");
            Consulta c = em.find(Consulta.class, 2);
            ex.setConsulta(c);
            em.getTransaction().begin();
            em.persist(ex);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }

}
