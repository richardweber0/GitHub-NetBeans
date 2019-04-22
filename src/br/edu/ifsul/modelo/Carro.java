/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import br.edu.ifsul.modelo.Pessoa;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author vanes
 */
@Entity
public class Carro implements Serializable{
    @Id
    @SequenceGenerator(name = "carro_id", allocationSize = 1, sequenceName = "id_carro")
    @GeneratedValue(generator = "carro_id", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "placa", nullable = false, length = 30)
    @NotBlank(message = "Campo placa precisa ser informado")
    @Length(max=30, message = "Campo placa não pode conter mais que {max} caracteres")
    private String placa;
    
    @Column(name = "renavan", nullable = false, length = 30)
    @NotBlank(message = "Campo renavan precisa ser informado")
    @Length(max=30, message = "Campo renavan não pode conter mais que {max} caracteres")
    private String renavan;
        
    @Column(name = "modelo", nullable = false, columnDefinition = "text")
    private String modelo;
    
    @Column(name = "fabricante", nullable = false, columnDefinition = "text")
    private String fabricante;
    
    @Column(name="anoFabricacao", nullable = false, columnDefinition = "numeric(4)")
    @Min(value = 0, message = "O ano de fabricacao não pode ser negativo")
    private Integer anoFabricacao;
    
    @Column(name="anoModelo", nullable = false, columnDefinition = "numeric(4)")
    @Min(value = 0, message = "O ano do modelo não pode ser negativo")
    private Integer anoModelo;

    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false)
    private Pessoa pessoa;
    
    @ManyToMany
    @JoinTable(name="contem",
            joinColumns = 
                @JoinColumn(name = "carro", referencedColumnName = "id", nullable = true),
             inverseJoinColumns =       
                @JoinColumn(name="acessorios", referencedColumnName = "id", nullable = true)
            )
    private Set<Acessorios> listaContem = new HashSet<>();
    
    public Carro() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

       public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavan() {
        return renavan;
    }

    public void setRenavan(String renavan) {
        this.renavan = renavan;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        final Carro other = (Carro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    public void adicionarAcessorio(Acessorios a){
        listaContem.add(a);
    }
    
    public void removerAcessorio(Acessorios a){
        listaContem.remove(a);
    }


    @Override
    public String toString() {
        return modelo;
    }
 
}
