package kr.or.sw.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.sw.model.ProductDTO;

public interface ProductDAO {
	
	List<ProductDTO> selectAllProduct(SqlSession sqlSession);


}
