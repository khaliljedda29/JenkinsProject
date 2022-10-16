package com.esprit.examen.services;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.ReglementRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;



import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FrounisseurServiceImplTest {
    @Autowired
    IFournisseurService rs;

    @Autowired
    ReglementRepository rr;

    @Test
    @Order(1)
    public void testRetrieveAllReglement()
    {
        List<Fournisseur> listFournisseur = rs.retrieveAllFournisseurs();
        Assertions.assertEquals(10, listFournisseur.size());
    }



}
