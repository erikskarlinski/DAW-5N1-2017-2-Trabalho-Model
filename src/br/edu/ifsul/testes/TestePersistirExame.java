package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Exame;
import br.edu.ifsul.modelo.Medico;
import br.edu.ifsul.modelo.Paciente;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class TestePersistirExame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-5N1-2017-2-Trabalho-PU");
        EntityManager em = emf.createEntityManager();
        Exame e = new Exame();
        e.setNome("raio x");
        e.setDescricao("descrição de teste");
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();

        Especialidade es = new Especialidade();
        es.setDescricao("pediatra");
        em.getTransaction().begin();
        em.persist(es);
        em.getTransaction().commit();

        Medico obj = new Medico();
        obj.setNome("João da silva");
        obj.setCrm("123456789");
        Especialidade ee = em.find(Especialidade.class, 1);
        obj.setEspecialidade(ee);
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();

        Paciente p = new Paciente();
        p.setNome("Eriks Karlinski");
        p.setTelefone("5499891938");
        p.setSexo("M");
        p.setAltura(1.70);
        p.setPeso(65.3);
        p.setData(new GregorianCalendar(1995, Calendar.JUNE, 14));
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

}
