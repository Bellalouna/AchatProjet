package tn.esprit.rh.achat.services;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StockServiceTest {
	
	@Autowired
	IStockService ss;
	
	@Autowired
	private StockRepository stockRepository;
	
	@Order(1)
	@Test
	public void testRetrieveAllStocks() {
		List<Stock> listStocks = ss.retrieveAllStocks();
		Assertions.assertEquals(5, listStocks.size());
	}
	
	@Order(2)
	@Test
	public void testAddStock() {
		Stock expected = new Stock();
		Stock result = ss.addStock(expected);
		Assertions.assertEquals(expected, result);
	}
	
	@Order(3)
	@Test
	public void testUpdateStock() {
		Stock s = new Stock();
		Stock updateStock = ss.updateStock(s);
		Assertions.assertEquals(s, updateStock);
	}
	
	@Order(4)
	@Test
	public void testDeleteStock() {
		Long stockId = 12L;
		ss.deleteStock(stockId);
		Optional<Stock> stock = stockRepository.findById(stockId);
	    Assertions.assertFalse(stock.isPresent());
	}
	
	@Order(5)
	@Test
	public void testRetrieveStock() {
		Long stockId = 1L;
		Stock stock = ss.retrieveStock(stockId);
		Assertions.assertNotNull(stock);
	}
	
	@Order(6)
	@Test
	public void testRetrieveStatusStock() {
	  List<Stock> stocks = new ArrayList<>();
	  Stock stock1 = new Stock("stock1", 10, 5);
	  Stock stock2 = new Stock("stock2", 20, 15);
	  stocks.add(stock1);
	  stocks.add(stock2);

	  when(stockRepository.retrieveStatusStock()).thenReturn(stocks);
	  String result = ss.retrieveStatusStock();
	  Assertions.assertNotNull(result);
	}

}
