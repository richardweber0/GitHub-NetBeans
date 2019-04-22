/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import br.edu.ifsul.modelo.Carro;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author vanes
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Acessorios implements Serializable{
    @Id
    @SequenceGenerator(name = "acessorio_id", allocationSize = 1, sequenceName = "id_acessorio")
    @GeneratedValue(generator = "acessorio_id", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "descricao", nullable = false, length = 14)
    private String descricao;
  
    @ManyToMany
    @JoinTable(name="contem",
            joinColumns = 
                @JoinColumn(name = "acessorios", referencedColumnName = "id", nullable = true),
             inverseJoinColumns =       
                @JoinColumn(name="carro", referencedColumnName = "id", nullable = true)
            )
    private Set<Carro> listaContem = new HashSet<>();

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
       
    public void adicionarCarro(Carro c){
        listaContem.add(c);
    }

    @Override
    public String toString() {
        return descricao;
    }
 
    
}