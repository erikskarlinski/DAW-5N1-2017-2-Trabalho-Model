package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "paciente")
public class Paciente implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_paciente", sequenceName = "seq_paciente_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_paciente", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 40, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 40, nullable = false)
    private String nome;    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_nascimento", nullable = false)
    private Calendar data_nascimento;    
    @Length(max = 20, message = "O telefone não pode ter mais que {max} caracteres")
    @Column(name = "telefone", length = 20, nullable = false)
    private String telefone;
    @NotNull(message = "O sexo não pode ser nulo")
    @NotBlank(message = "O sexo não pode ser em branco")
    @Length(max = 1, message = "O sexo não pode ter mais que {max} caracteres")
    @Column(name = "sexo", length = 1, nullable = false)
    private String sexo;
    @Column(name = "historico")
    private String historico;
    //@NotNull(message = "O peso deve ser informado")
    @Column(name = "peso", nullable = false,
            columnDefinition = "numeric(10,2)")
    private Double peso;
    //@NotNull(message = "A altura deve ser informado")
    @Column(name = "altura", nullable = false,
            columnDefinition = "numeric(10,2)")
    private Double altura;

    public Paciente() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Calendar getData() {
        return data_nascimento;
    }

    public void setData(Calendar data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

}

