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
}
