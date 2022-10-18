<<<<<<< HEAD

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
=======
package com.esprit.examen.services;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.esprit.examen.entities.Stock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {
	@Autowired
	IStockService stockService;
	
	@Test
	public void testAddStock() {
	//	List<Stock> stocks = stockService.retrieveAllStocks(); hello
	//	int expected=stocks.size();
		Stock s = new Stock("stock test",10,100);
		Stock savedStock= stockService.addStock(s);
		
	//	assertEquals(expected+1, stockService.retrieveAllStocks().size());
		assertNotNull(savedStock.getLibelleStock());
		//stockService.deleteStock(savedStock.getIdStock());
		
	} 
	
	@Test
	public void testAddStockOptimized() {

		Stock s = new Stock("stock test",10,100);
		Stock savedStock= stockService.addStock(s);
		assertNotNull(savedStock.getIdStock());
		assertSame(10, savedStock.getQte());
		assertTrue(savedStock.getQteMin()>0);
		stockService.deleteStock(savedStock.getIdStock());
		
	} 
	
	@Test
	public void testDeleteStock() {
		Stock s = new Stock("stock test",30,60);
		Stock savedStock= stockService.addStock(s);
>>>>>>> 32936d41f6c1a696a8fdaddc19902865f748e16e
		stockService.deleteStock(savedStock.getIdStock());
		assertNull(stockService.retrieveStock(savedStock.getIdStock()));
	}

<<<<<<< HEAD
	@Test
	public void retrieveAllStocksTest() {
		List<Stock> stocks = (List<Stock>) stockRepository.findAll();
		assertThat(stocks).size().isPositive();


	}

}



=======
}
>>>>>>> 32936d41f6c1a696a8fdaddc19902865f748e16e
