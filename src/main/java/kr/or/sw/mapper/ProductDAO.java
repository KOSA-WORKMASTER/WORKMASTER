package kr.or.sw.mapper;

import kr.or.sw.model.ProductDTO;

import java.util.List;

public interface ProductDAO {
<<<<<<< Updated upstream

    List<ProductDTO> selectAllProduct();
=======
	
	List<ProductDTO> selectAllProduct(SqlSession sqlSession);
	
	List<ProductDTO> selectProductById(SqlSession sqlSession, int ProductID);
	
	List<ProductDTO> selectProductByCategory(SqlSession sqlSession, String name);
	
	List<ProductDTO> selectProductByName(SqlSession sqlSession, String name);
>>>>>>> Stashed changes


}
