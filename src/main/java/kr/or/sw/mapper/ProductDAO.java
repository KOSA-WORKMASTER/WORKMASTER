package kr.or.sw.mapper;

import java.util.List;

import kr.or.sw.model.ProductDTO;

public interface ProductDAO {

    List<ProductDTO> selectAllProduct();

    List<ProductDTO> selectProductById(int productID);

    List<ProductDTO> selectProductByCategory(String category);

    List<ProductDTO> selectProductByName(String productName);
    
    ProductDTO selectProduct(int productID);

    int insertProduct(ProductDTO productDTO);
    
    int updateProduct(ProductDTO productDTO);
    
    int deleteProduct(int productID);
}
