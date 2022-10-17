/*package com.esprit.examen.services;
import static org.junit.Assert.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.esprit.examen.entities.Reglement;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import com.esprit.examen.repositories.ReglementRepository;
import lombok.extern.slf4j.Slf4j;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ReglementServiceImplTest {
    @Autowired
    IReglementService rs;
    @Autowired
    ReglementRepository rr;
    @Test
    @Order(1)
    public void testRetrieveAllReglement()
    {
        List<Reglement> listReglements = rs.retrieveAllReglements();
        Assertions.assertEquals(10, listReglements.size());
    }
}
*/
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

import com.esprit.examen.entities.Reglement;

import com.esprit.examen.repositories.ReglementRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class  ReglementMockTest {


    @Mock //declaration d'un mock
    ReglementRepository pr;
    @InjectMocks
    ReglementServiceImpl psi;

    Reglement p = Reglement.builder().montantPaye(2).montantRestant(2).payee(true).dateReglement(null).facture(null).build();

    @DisplayName("Retrieving reglement...!")
    @Test
    void GetProductTest() {

        List<Reglement> lst = new ArrayList<>();
        lst.add(new Reglement());

        Mockito.when(pr.findAll()).thenReturn(lst);
        List<Reglement> exp = psi.retrieveAllReglements();
        assertEquals(exp, lst);
        log.info("get ps ==> " + exp.toString());

    }

    @DisplayName("Retrieve reglement by ID")
    @Test
    void GetbyID() {

        Mockito.when(pr.findById(Mockito.anyLong())).thenReturn(Optional.of(p));
        Reglement reg = psi.retrieveReglement(3L);
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