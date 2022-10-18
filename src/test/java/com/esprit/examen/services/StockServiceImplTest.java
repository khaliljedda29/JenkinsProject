

package com.esprit.examen.services;
import com.esprit.examen.TpAchatProjectApplication;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.StockRepository;
import com.esprit.examen.services.IStockService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TpAchatProjectApplication.class)

		public class StockServiceImplTest {
	@Autowired
	IStockService stockService;
	@Autowired
	StockRepository stockRepository;

	@Test
	public void addStockTest() {
		Stock s = new Stock("stock test", 10, 100);
		Stock savedStock = stockService.addStock(s);
		assertNotNull(savedStock.getIdStock());
		assertSame(10, savedStock.getQte());
		assertTrue(savedStock.getQteMin() > 0);
		stockService.deleteStock(savedStock.getIdStock());
	}

	@Test
	public void deleteStockTest() {
		Stock s = new Stock("stock test", 30, 60);
		Stock savedStock = stockService.addStock(s);

		stockService.deleteStock(savedStock.getIdStock());
		assertNull(stockService.retrieveStock(savedStock.getIdStock()));
	}


	@Test
	public void retrieveAllStocksTest() {
		List<Stock> stocks = (List<Stock>) stockRepository.findAll();
		assertThat(stocks).size().isPositive();


	}

}




