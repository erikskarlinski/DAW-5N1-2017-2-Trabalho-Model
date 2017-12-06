package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 */
@Entity
@Table(name = "consulta")
public class Consulta implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_consulta", sequenceName = "seq_consulta_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_consulta", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "A data deve ser informada")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data", nullable = false)
    private Calendar data;
    @Column(name = "preconsulta")
    private String preconsulta;
    @Column(name = "posconsulta")
    private String posconsulta;
    @NotNull(message = "O paciente deve ser informado")
    @ManyToOne
    @JoinColumn(name = "paciente", referencedColumnName = "id", nullable = false)
    private Paciente paciente;
    @NotNull(message = "O medico deve ser informado")
    @ManyToOne
    @JoinColumn(name = "medico", referencedColumnName = "id", nullable = false)
    private Medico medico;

    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Exame> listaExames = new ArrayList<>();
    
    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Receituario> listaReceituarios  = new ArrayList<>();

    public Consulta() {

    }

    public void adicionarExame(Exame obj) {
        obj.setConsulta(this);
        this.getListaExames().add(obj);
    }

    public void removerExame(int index) {
        this.getListaExames().remove(index);
    }

   public void adicionarReceituario(Receituario obj){
        obj.setConsulta(this);
        this.getListaReceituarios().add(obj);
    }
    
    public void removerReceituario(int index){
        this.getListaReceituarios().remove(index);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getPreconsulta() {
        return preconsulta;
    }

    public void setPreconsulta(String preconsulta) {
        this.preconsulta = preconsulta;
    }

    public String getPosconsulta() {
        return posconsulta;
    }

    public void setPosconsulta(String posconsulta) {
        this.posconsulta = posconsulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Consulta other = (Consulta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

   

   

    public List<Exame> getListaExames() {
        return listaExames;
    }

    public void setListaExames(List<Exame> listaExames) {
        this.listaExames = listaExames;
    }

    public List<Receituario> getListaReceituarios() {
        return listaReceituarios;
    }

    public void setListaReceituarios(List<Receituario> listaReceituarios) {
        this.listaReceituarios = listaReceituarios;
    }

}
