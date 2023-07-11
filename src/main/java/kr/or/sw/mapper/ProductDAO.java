package kr.or.sw.mapper;

import kr.or.sw.model.ProductDTO;

import java.util.List;

public interface ProductDAO {

    List<ProductDTO> selectAllProduct();


}
