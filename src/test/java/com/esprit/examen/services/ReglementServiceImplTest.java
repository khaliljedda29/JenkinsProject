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
import com.esprit.examen.entities.Reglement;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.CategorieProduitRepository;
import com.esprit.examen.repositories.ReglementRepository;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReglementServiceImplTest {
    @Mock
    ReglementRepository cp;
    @InjectMocks
    ReglementServiceImpl rs;
    Reglement p = Reglement.builder().montantPaye(2).montantRestant(2).payee(true).dateReglement(null).facture(null).build();

    @Test
    public void testAddReglement() {
        //given
        Reglement f = new Reglement(9L,1, 2,true,null,null);

        //when
        Mockito.when(this.cp.save(Mockito.any())).thenReturn(f);
        Reglement savedSecteurActivite = rs.addReglement(f);


        //then
        assertNotNull(savedSecteurActivite.getPayee());


        // List<Stock> stocks = stockService.retrieveAllStocks();
        // int expected=stocks.size();
//        CategorieProduit s = new CategorieProduit("test", "test");
//        CategorieProduit savedSecteurActivite = rs.addCategorieProduit(s);
//
//        //   assertEquals(expected+1, stockService.retrieveAllStocks().size());
//        assertNotNull(savedSecteurActivite.getLibelleCategorie());
//        rs.deleteCategorieProduit(savedSecteurActivite.getIdCategorieProduit());


    }


  /*  @Test
    public void testVerif() {
        for (Reglement s : rs.retrieveAllReglements())
        {
            assertEquals(s.getDateReglement().toString(),"1");
        }
    }*/

}