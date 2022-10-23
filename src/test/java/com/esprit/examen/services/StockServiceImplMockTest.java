/*package com.esprit.examen.services;


import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.StockRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplMockTest {

    @Mock
    StockRepository stockRepo;
    @InjectMocks
    StockServiceImpl stockServiceImpl;

    @Test
    public void addStockMockTest() {
        //given
        Stock stock = new Stock("LibelleTest", 10, 1);

        //when
        Mockito.when(this.stockRepo.save(Mockito.any())).thenReturn(stock);
        Stock savedStock = stockServiceImpl.addStock(stock);


        //then
        assertNotNull(savedStock.getLibelleStock());
    }
}*/
