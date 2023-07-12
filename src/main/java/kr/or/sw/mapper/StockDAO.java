package kr.or.sw.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.sw.model.StockDTO;

public interface StockDAO {

	List<StockDTO> selectAllStocks();
	
	List<StockDTO> selectStockById(int stockID);
	
	List<StockDTO> selectStockByProductID(int productID);
	
	List<StockDTO> selectStockByName(String stockName);
	

	
	StockDTO selectStock(int stockID);
	

}
