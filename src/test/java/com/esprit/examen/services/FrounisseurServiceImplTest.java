package com.esprit.examen.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Fournisseur;

import com.esprit.examen.repositories.FournisseurRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class  FournisseurMockTest {


    @Mock //declaration d'un mock
    FournisseurRepository pr;
    @InjectMocks
    FournisseurServiceImpl psi;

    Fournisseur p = Fournisseur.builder().code("abc").libelle("farah").categorieFournisseur(null).detailFournisseur(null).factures(null).secteurActivites(null).build();

    @DisplayName("Retrieving Fournisseur...!")
    @Test
    void GetFournisseurTest() {

        List<Fournisseur> lst = new ArrayList<>();
        lst.add(new Fournisseur());

        Mockito.when(pr.findAll()).thenReturn(lst);
        List<Fournisseur> exp = psi.retrieveAllFournisseurs();
        assertEquals(exp, lst);
        log.info("get ps ==> " + exp.toString());

    }

    @DisplayName("Retrieve Fournisseur by ID")
    @Test
    void GetbyID() {

        Mockito.when(pr.findById(Mockito.anyLong())).thenReturn(Optional.of(p));
        Fournisseur reg = psi.retrieveFournisseur(3L);
        assertNotNull(reg);
        log.info("get ==> " + reg.toString());
        verify(pr).findById(Mockito.anyLong());

    }

  /*  @DisplayName("Updating reglement...!")
    @Test
    void EditReglementTest() {
        Reglement pedit = new Reglement();
        pedit.setIdReglement(3L);
        pedit.setPayee(false);
        Reglement new_pedit = new Reglement();
        new_pedit.setPayee(true);
        Mockito.lenient().when(pr.findById(pedit.getIdReglement())).thenReturn(Optional.of(pedit));
        //assertEquals(pedit, psi.updateProduit(new_pedit) );
        pedit = psi.updateReglement(new_pedit);
        log.info("updated ==> " + pedit.toString());
        verify(pr).save(pedit);
    }
    @DisplayName("Adding reglement...!")
    @Test
    void AddProductTest() {
        Produit produit = new Produit();
        produit.setLibelleProduit("arctic");
        Mockito.lenient().when(pr.save(produit)).thenReturn(produit);
        Produit newp = psi.addProduit(produit);
        assertEquals(produit.getLibelleProduit(), newp.getLibelleProduit());
        verify(pr).save(produit);
        log.info("Added ==> " + produit.toString());
    }
    @DisplayName("Deleting product...!")
    @Test
    void DeleteTest() {
        Produit p = new Produit();
        p.setLibelleProduit("libelle");
        p.setIdProduit((long) 3);
        Long pid = p.getIdProduit();
        Mockito.lenient().when(pr.findById(pid)).thenReturn(Optional.of(p));
        psi.deleteProduit(pid);
        verify(pr).deleteById(pid);
        log.info("Deleted ==> " + pid.toString());
    }*/

}