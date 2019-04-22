/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Corretor;
import br.edu.ifsul.modelo.Corretor;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author vanes
 */
@Entity
public class Seguro implements Serializable{
    @Id
    @SequenceGenerator(name = "seguro_id", allocationSize = 1, sequenceName = "id_seguro")
    @GeneratedValue(generator = "seguro_id", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Temporal(TemporalType.DATE)
    @Column(name="data", nullable = false)
    private Calendar data;
    
    @Temporal(TemporalType.DATE)
    @Column(name="inicioVigencia", nullable = false)
    private Calendar inicioVigencia;
    
    @Temporal(TemporalType.DATE)
    @Column(name="fimVigencia", nullable = false)
    private Calendar fimVigencia;
    
    @Column(name="valor_total", columnDefinition = "numeric(10,2)")
    private Double valorTotal;
    
    @Column(name="valor_fipe", columnDefinition = "numeric(10,2)")
    private Double valor_fipe;
       
    @ManyToOne
    @JoinColumn(name = "corretor", referencedColumnName = "id", nullable = false)
    @NotNull(message = "O Corretor deve ser informado")
    @ForeignKey(name = "fk_corretor")
    private Corretor corretor;
    
    @ManyToOne
    @JoinColumn(name = "carro", referencedColumnName = "id", nullable = false)
    @NotNull(message = "O Carro deve ser informado")
    @ForeignKey(name = "fk_carro")
    private Carro carro;

    @OneToMany(mappedBy = "seguro", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Sinistro> sinistros = new ArrayList<>();
    
    @OneToMany(mappedBy = "seguro", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Cobertura> listaCobertura = new ArrayList<>();
    
    public Seguro() {
        valorTotal = 0.0;
        data = Calendar.getInstance();
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

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

        public Calendar getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(Calendar inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public Calendar getFimVigencia() {
        return fimVigencia;
    }

    public void setFimVigencia(Calendar fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    public Double getValor_fipe() {
        return valor_fipe;
    }

    public void setValor_fipe(Double valor_fipe) {
        this.valor_fipe = valor_fipe;
    }

    public Corretor getCorretor() {
        return corretor;
    }

    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Seguro other = (Seguro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    public void addSinistro(Sinistro s){
        sinistros.add(s);
        s.setSeguro(this);       
    }
    
    public void removeSinistro(Sinistro s){
        sinistros.remove(s);
    }
    
    public void removeSinistro(int index){
        Sinistro obj = sinistros.get(index);
        sinistros.remove(obj);
    }
   
    public void addCobertura(Cobertura c){
        listaCobertura.add(c);
        c.setSeguro(this);
         
    }
    
    public void removeCobertura(Cobertura c){
        listaCobertura.remove(c);
    }
    
    public void removeCobertura(int index){
        Cobertura obj = listaCobertura.get(index);
        listaCobertura.remove(obj);
    }
   
        @Override
    public String toString() {
        return "Seguro nº: "+id;
    }
    
}
