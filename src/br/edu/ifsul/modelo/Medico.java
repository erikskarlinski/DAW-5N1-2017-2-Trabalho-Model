package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "medico")
public class Medico extends Paciente implements Serializable{

   
    @NotNull(message = "O CRM não pode ser nulo")
    @NotBlank(message = "O CRM não pode ser em branco")
    @Length(max = 40, message = "O CRM não pode ter mais que {max} caracteres")
    @Column(name = "crm", length = 40, nullable = false)
    private String crm;
    @NotNull(message = "A especialidade não pode ser nula")
    @ManyToOne
    @JoinColumn(name = "especialidade", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_especialidade_id")// importar import org.hibernate.annotations.ForeignKey;
    private Especialidade especialidade;

    public Medico() {

    }

    

  

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

 

}
