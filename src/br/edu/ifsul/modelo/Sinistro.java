/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import br.edu.ifsul.modelo.Seguro;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;


/**
 *
 * @author vanes
 */
@Entity
@Table(name="Sinistro")
public class Sinistro implements Serializable{
    @Id
    @SequenceGenerator(name = "sinistro_id", sequenceName = "sinistro_id", allocationSize = 1)
    @GeneratedValue(generator = "sinistro_id", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "Informe a descricao")
    @Column(name = "descricao", columnDefinition = "text", nullable = false)
    private String descricao;
       
    @Column(name = "cidade", length = 20)
    private String cidade;
    
    @Column(name = "estado", length = 20)
    private String estado;
    
    @ManyToOne
    @JoinColumn(name = "seguro", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_seguro")
    private Seguro seguro;
    

    public Sinistro() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

     public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
  
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Sinistro other = (Sinistro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

   
}
