package com.esprit.examen.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.StockRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StockServiceImpl implements IStockService {

	@Autowired
	StockRepository stockRepository;


	@Override
	public List<Stock> retrieveAllStocks() {
		List<Stock> stocks = stockRepository.findAll();
		for (Stock stock : stocks) {
			log.info(" Stock : " + stock);
		}

		return stocks;
	}

	@Override
	public Stock addStock(Stock s) {
		return stockRepository.save(s);
		
	}

	@Override
	public void deleteStock(Long stockId) {
		stockRepository.deleteById(stockId);

	}

	@Override
	public Stock updateStock(Stock s) {
		return stockRepository.save(s);
	}

	@Override
	public Stock retrieveStock(Long stockId) {
		long start = System.currentTimeMillis();
		Stock stock = stockRepository.findById(stockId).orElse(null);
		 long elapsedTime = System.currentTimeMillis() - start;
		log.info("Method execution time: " + elapsedTime + " milliseconds.");

		return stock;
	}


	@Override
	public String retrieveStatusStock() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String msgDate = sdf.format(now);
		String newLine = System.getProperty("line.separator");
		List<Stock> stocksEnRouge = stockRepository.retrieveStatusStock();
		StringBuilder bld = new StringBuilder();
		for(int i = 0; i < stocksEnRouge.size(); i++)
		{
			bld = 	bld.append(newLine).append(bld).append(msgDate).append(newLine).append(": le stock ").append(stocksEnRouge.get(i).getLibelleStock()).append(" a une quantité de ")
					.append(stocksEnRouge.get(i).getQte())
					.append(" inférieur à la quantité minimale a ne pas dépasser de ")
					.append(stocksEnRouge.get(i).getQteMin())
					.append(newLine);
		}
		String str = bld.toString();
		log.info(str);
		return str;


	}


}