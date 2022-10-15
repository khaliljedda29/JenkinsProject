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
        Produit p = new Produit();
        Produit produit = produitService.addProduit(p);
        Assertions.assertNotNull(p.getIdProduit());
    }
}
