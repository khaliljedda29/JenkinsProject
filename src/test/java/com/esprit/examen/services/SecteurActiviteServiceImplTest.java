package com.esprit.examen.services;

import com.esprit.examen.entities.SecteurActivite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecteurActiviteServiceImplTest {
    @Autowired
    ISecteurActiviteService secteurActiviteService;

    @Test
    public void testAddStock() {
        //	List<Stock> stocks = stockService.retrieveAllStocks();
        //	int expected=stocks.size();
        SecteurActivite s = new SecteurActivite("test", "test");
        SecteurActivite savedSecteurActivite = secteurActiviteService.addSecteurActivite(s);

        //	assertEquals(expected+1, stockService.retrieveAllStocks().size());
        assertNotNull(savedSecteurActivite.getLibelleSecteurActivite());
        secteurActiviteService.deleteSecteurActivite(savedSecteurActivite.getIdSecteurActivite());

    }
}