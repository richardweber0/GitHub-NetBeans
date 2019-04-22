/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Cobertura;
import br.edu.ifsul.modelo.Corretor;
import br.edu.ifsul.modelo.Seguro;
import br.edu.ifsul.modelo.Sinistro;
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
public class TestePersistirSeguro {
    
    EntityManager em;
    
    public TestePersistirSeguro() {
        
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
        try{
        Sinistro sin = new Sinistro();
        sin.setDescricao("Teste");
        sin.setEstado("RS");
        sin.setCidade("Passo Fundo");
        
        Cobertura cob = new Cobertura();
        cob.setDescricao("Teste");
        cob.setValor(1200.00);
        
        
        Seguro seguro = new Seguro();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dt = sdf.parse("12/11/2000");
        Date dtI = sdf.parse("30/07/2001");
        Date dtF = sdf.parse("14/11/2004");
        Calendar dtC = Calendar.getInstance();
        dtC.setTime(dt);
        seguro.setFimVigencia(dtC);
        dtC.setTime(dtI);
        seguro.setInicioVigencia(dtC);
        dtC.setTime(dtF);
        seguro.setFimVigencia(dtC);
        seguro.setValorTotal(3000.00);
        seguro.setValor_fipe(40000.00);
        seguro.setCarro(em.find(Carro.class, 3));
        seguro.setCorretor(em.find(Corretor.class, 3));
        seguro.addSinistro(sin);
        seguro.addCobertura(cob);
        
        em.getTransaction().begin();
        em.persist(seguro);
//        em.persist(vi1);
        em.getTransaction().commit();
        
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("ERRO: "+e);
        }
    }
}
