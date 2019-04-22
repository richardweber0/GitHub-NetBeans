/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Corretor;

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
public class TestePersistirCorretor {
    
    EntityManager em;
    
    public TestePersistirCorretor() {
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
            Corretor c = new Corretor();
            c.setNome("Vivente 03");
            c.setCpf("007.079.140-60");
            c.setRg("1231231231");
            c.setEmail("carlos@gmail.com");
            c.setTelefone("1231231231");
            c.setPercentualComissao(5.0);
            c.setNomeUsuario("carlos123");
            c.setSenha("123");
                              
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
                    
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro: "+e);
        }
    }
    
}
