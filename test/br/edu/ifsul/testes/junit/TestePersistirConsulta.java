package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Consulta;
import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Exame;
import br.edu.ifsul.modelo.Medico;
import br.edu.ifsul.modelo.Paciente;
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
public class TestePersistirConsulta {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirConsulta() {
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
            
            
            
            Consulta c = new Consulta();
            c.setData(new GregorianCalendar(2017, Calendar.DECEMBER, 05));
            c.setPreconsulta("paciente está diz estar com dor de cabeça");
            c.setPosconsulta("tomar aspirina  de 8 em 8 horas");
            Medico m = em.find(Medico.class, 7);
            Paciente p = em.find(Paciente.class, 7);
            c.setMedico(m);
            c.setPaciente(p);
           
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }
    
}
