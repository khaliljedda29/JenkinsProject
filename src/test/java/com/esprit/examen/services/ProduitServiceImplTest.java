package com.esprit.examen.services;

import com.esprit.examen.entities.Produit;
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
        Produit p= produitService.addProduit(Produit.builder().libelleProduit("produit test").codeProduit("produit test").prix(10).build());
        //assertNotNull(p);
    }
}
