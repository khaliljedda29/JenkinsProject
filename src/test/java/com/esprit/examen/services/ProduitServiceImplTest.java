package com.esprit.examen.services;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.ProduitRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;

public class ProduitServiceImplTest {

    @Autowired
    IProduitService produitService;

    @Test
    public void addProduitTest(){
        Produit p = new Produit("stock test","stock test",100);
        Produit savedProduit= produitService.addProduit(p);

        //	assertEquals(expected+1, stockService.retrieveAllStocks().size());
        assertNotNull(savedProduit.getLibelleProduit());
        //stockService.deleteStock(savedStock.getIdStock());
    }
}
