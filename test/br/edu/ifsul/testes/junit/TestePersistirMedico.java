package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Especialidade;
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
public class TestePersistirMedico {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirMedico() {
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
            Medico obj = new Medico();
            obj.setNome("João da silva");
            obj.setCrm("123456789");
            Especialidade e = em.find(Especialidade.class, 1);
            obj.setNome("Eriks Karlinski");
            obj.setTelefone("5499891938");
            obj.setSexo("M");
            obj.setAltura(1.70);
            obj.setPeso(65.3);
            obj.setData(new GregorianCalendar(1995, Calendar.JUNE, 14));
            obj.setEspecialidade(e);
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }
    
}
