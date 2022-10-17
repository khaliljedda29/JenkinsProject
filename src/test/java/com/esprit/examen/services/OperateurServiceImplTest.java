package com.esprit.examen.services;

import com.esprit.examen.entities.Operateur;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;

public class OperateurServiceImplTest {
    @Autowired
     IOperateurService operateurService;
    @Test
    public void addOperateur(){
        Operateur p = new Operateur("stock test","stock test",100);
        Operateur savedProduit= OperateurServiceImpl.addOperateur(p);
        //	assertEquals(expected+1, stockService.retrieveAllStocks().size());
        assertNotNull(savedProduit.getIdOperateur());
        //stockService.deleteStock(savedStock.getIdStock());
    }
}
