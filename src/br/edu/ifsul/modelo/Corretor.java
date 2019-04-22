/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import br.edu.ifsul.modelo.Pessoa;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import org.hibernate.validator.constraints.br.CNPJ;

/**
 *
 * @author vanes
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Corretor extends Pessoa implements Serializable{
    
    @Column(name = "percentualComissao", nullable = false)
    private Double percentualComissao;
    
    @Column(name = "nomeUsuario", nullable = false, length = 20)
    private String nomeUsuario;
    
    @Column(name = "senha", nullable = false, length = 20)
    private String senha;

    public Double getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(Double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    
}
