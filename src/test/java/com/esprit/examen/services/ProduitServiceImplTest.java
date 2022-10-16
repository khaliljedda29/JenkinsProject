package com.esprit.examen.services;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public class ProduitServiceImplTest {

    @Autowired
    IProduitService produitService;

    @Test
    public void addProduitTest(){
        Produit p = new Produit(1L,"xx","xx", 3.5F);
        /*Produit produit = produitService.addProduit(p);*/
        /*assertNotNull(produit.getIdProduit());
        assertNotNull(produit.getCodeProduit());
        assertNotNull(produit.getLibelleProduit());
        assertNotNull(produit.getPrix());*/
    }
}
