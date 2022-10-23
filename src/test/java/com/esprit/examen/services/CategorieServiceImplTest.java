package com.esprit.examen.services;/*package com.esprit.examen.services;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.repositories.CategorieProduitRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CategorieServiceImplTest {
    @Autowired
    CategorieProduitRepository cp;
    @Autowired
    ICategorieProduitService rs;
    @Test
    @Order(1)
    public void testRetrieveAllCategorieProduits()
    {
        List<CategorieProduit> list =this.rs.retrieveAllCategorieProduits();
        Assertions.assertEquals(10, list.size());
    }
}

 */


import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.repositories.CategorieProduitRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategorieServiceImplTest {
    @Autowired
    CategorieProduitRepository cp;
    @Autowired
    ICategorieProduitService rs;

    @Test
    public void testAddCategorieProduit() {
        //	List<Stock> stocks = stockService.retrieveAllStocks();
        //	int expected=stocks.size();
        CategorieProduit s = new CategorieProduit("test", "test");
        CategorieProduit savedSecteurActivite = rs.addCategorieProduit(s);

        //	assertEquals(expected+1, stockService.retrieveAllStocks().size());
        assertNotNull(savedSecteurActivite.getLibelleCategorie());
        rs.deleteCategorieProduit(savedSecteurActivite.getIdCategorieProduit());

    }









}

