package com.esprit.examen.services;

import static org.junit.Assert.*;
import java.util.List;

import com.esprit.examen.entities.SecteurActivite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.esprit.examen.entities.Operateur;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperateurServiceImplTest {
    @Autowired
    IOperateurService operateurService;

    @Test
    public void testAddOperateur() {
        //	List<Stock> stocks = stockService.retrieveAllStocks();
        //	int expected=stocks.size();
        Operateur s = new Operateur("test","test","hedi");
        Operateur savedOperateur= operateurService.addOperateur(s);

        //	assertEquals(expected+1, stockService.retrieveAllStocks().size());
        assertNotNull(savedOperateur.getNom());
        operateurService.deleteOperateur(savedOperateur.getIdOperateur());

    }

    /*@Test
    public void testAddStockOptimized() {
        Stock s = new Stock("stock test",10,100);
        Stock savedStock= stockService.addStock(s);
        assertNotNull(savedStock.getIdStock());
        assertSame(10, savedStock.getQte());
        assertTrue(savedStock.getQteMin()>0);
        stockService.deleteStock(savedStock.getIdStock());
    }
    @Test
    public void testDeleteStock() {
        Stock s = new Stock("stock test",30,60);
        Stock savedStock= stockService.addStock(s);
        stockService.deleteStock(savedStock.getIdStock());
        assertNull(stockService.retrieveStock(savedStock.getIdStock()));
    }*/

}