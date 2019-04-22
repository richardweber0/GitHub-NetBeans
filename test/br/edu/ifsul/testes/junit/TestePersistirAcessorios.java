/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Acessorios;
import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Pessoa;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vanes
 */
public class TestePersistirAcessorios {
    
    EntityManager em;
    
    public TestePersistirAcessorios() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
    }
    
    @Test
    public void teste(){
        try {
            Acessorios a = new Acessorios();
            a.setDescricao("Vidro eletrico");
                  
            Carro carro = new Carro();
            carro.setModelo("Golf");
            carro.setAnoModelo(2010);
            carro.setAnoFabricacao(2009);
            carro.setFabricante("Ford");
            carro.setPlaca("ALF-3011");
            carro.setRenavan("123213");
            carro.setPessoa(em.find(Pessoa.class, 3));
            
            
            carro.adicionarAcessorio(a);
            
            em.getTransaction().begin();
            em.persist(a);
            em.persist(carro);
            em.getTransaction().commit();
                    
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro: "+e);
        }
    }
    
}
