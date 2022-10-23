/**package com.esprit.examen.services;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.repositories.CategorieProduitRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@ExtendWith(MockitoExtension.class)
public class CategorieProduitImplTest {
    @Mock
    private EntityManagerFactory entityManagerFactory;

    @Mock
    private EntityManager entityManager;




    @Mock

    CategorieProduitRepository categorieProduitRepository;
    @InjectMocks

    ICategorieProduitService  CategorieProduitService;
    @Test
    public void addCategorieProduitTest(){
        CategorieProduit cp= new CategorieProduit();
       // CategorieProduit categorie = CategorieProduitService.addCategorieProduit(cp);
        Assertions.assertNotNull(cp.getIdCategorieProduit());
    }





}
package com.esprit.examen.services;

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
public class CategorieProduitImplTest  {
    ICategorieProduitService  cp;
    @Autowired
    CategorieProduitRepository categorieProduitRepository;
    @Test
    @Order(1)
    public void retrieveAllCategorieProduits()
    {
        List<CategorieProduit> listCategorie = cp.retrieveAllCategorieProduits();
        Assertions.assertEquals(10, listCategorie.size());
    }
}

 **/