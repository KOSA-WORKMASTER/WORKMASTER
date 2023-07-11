package kr.or.sw.mapper;

import kr.or.sw.model.ProductDTO;
import kr.or.sw.util.MyBatisUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductDAOImpl implements ProductDAO {

    private static ProductDAO instance;

    public static synchronized ProductDAO getInstance() {
        if (instance == null) {
            instance = new ProductDAOImpl();
        }
        return instance;
    }

    @Override
    public List<ProductDTO> selectAllProduct() {
        log.info("selectAllProducts()");
        List<ProductDTO> productList;
        try (SqlSession sqlSession = MyBatisUtil.getSession()) {
            productList = sqlSession.selectList("selectAllProducts");
        }
        return productList;
    }

    @Override
    public List<ProductDTO> selectProductById(int productID) {
        log.info("selectMemberById(): {}", productID);
        List<ProductDTO> productList;
        try (SqlSession sqlSession = MyBatisUtil.getSession()) {
            productList = sqlSession.selectList("selectProductById", productID);
        }
        return productList;
    }

    @Override
    public List<ProductDTO> selectProductByCategory(String category) {
        log.info("selectProductByCategory()");
        List<ProductDTO> productList;
        try (SqlSession sqlSession = MyBatisUtil.getSession()) {
            productList = sqlSession.selectList("selectProductByCategory", category);
        }
        return productList;
    }

    @Override
    public List<ProductDTO> selectProductByName(String productName) {
        log.info("selectProductByName()");
        List<ProductDTO> productList;
        try (SqlSession sqlSession = MyBatisUtil.getSession()) {
            productList = sqlSession.selectList("selectProductByName", productName);
        }
        return productList;
    }

    @Override
    public int insertProduct(ProductDTO productDTO) {
        log.info("insertProduct(): {}", productDTO);

        int result;
        int imgResult;
        if (productDTO == null) return 0;
        try (SqlSession sqlSession = MyBatisUtil.getSession()) {
            result = sqlSession.insert("insertProduct", productDTO);
            imgResult = sqlSession.insert("insertProductImg", productDTO.getImage());
            if (result > 0 && imgResult > 0) sqlSession.commit();
            else sqlSession.rollback();
        }
        return result;
    }
}
