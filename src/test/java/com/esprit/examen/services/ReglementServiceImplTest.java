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
    void GetReglementTest() {

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
    @DisplayName("Adding reglement...!")
    @Test
    void AddReglementTest() {

        Reglement reglement = new Reglement();
        reglement.setPayee(true);
        Mockito.lenient().when(pr.save(reglement)).thenReturn(reglement);
        Reglement newp = psi.addReglement(reglement);
        assertEquals(reglement.getPayee(), newp.getPayee());
        verify(pr).save(reglement);
        log.info("Added ==> " + reglement.toString());
        System.out.println("add works !");

    }
  /*  @DisplayName("Deleting reglement...!")
    @Test
    void DeleteTest() {
        Reglement p = new Reglement();
        p.setPayee(true);
        p.setIdProduit((long) 3);
        Long pid = p.getIdProduit();
        Mockito.lenient().when(pr.findById(pid)).thenReturn(Optional.of(p));

        psi.deleteProduit(pid);
        verify(pr).deleteById(pid);
        log.info("Deleted ==> " + pid.toString());
    }
   /* @Test
    public void DeleteStockTest() {
        sr.save(stock1);
        is.deleteStock(stock1.getIdStock());
        verify(sr, times(1)).deleteById(stock1.getIdStock());
        System.out.println("Delete works !");

    }


    @Test
    public void UpdateStockTest() {
        when(sr.save(stock1)).thenReturn(stock1);
        assertNotNull(stock1);
        assertEquals(stock1, is.updateStock(stock1));
        System.out.println("Update works !");
    }*/


}