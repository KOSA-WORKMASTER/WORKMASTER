package kr.or.sw.mapper;

<<<<<<< Updated upstream
=======
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.sw.model.MemberDTO;
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
    @Override
    public List<ProductDTO> selectAllProduct() {
        log.info("selectAllProducts()");
        List<ProductDTO> productList;
        try (SqlSession sqlSession = MyBatisUtil.getSession()) {
            productList = sqlSession.selectList("selectAllProducts");
        }
        return productList;
=======
	@Override
	public List<ProductDTO> selectAllProduct(SqlSession sqlSession) {
		log.info("selectAllProducts()");
        return sqlSession.selectList("selectAllProducts");
	}
	
	@Override
    public List<ProductDTO> selectProductById(SqlSession sqlSession, int productID) {
        log.info("selectMemberById(): {}", productID);
        return sqlSession.selectList("selectProductById", productID);
    }

    @Override
    public List<ProductDTO> selectProductByCategory(SqlSession sqlSession, String productName) {
        log.info("selectMemberByName()");
        return sqlSession.selectList("selectProductByCategory", productName);
    }

    @Override
    public List<ProductDTO> selectProductByName(SqlSession sqlSession, String email) {
        log.info("selectMemberByEmail()");
        return sqlSession.selectList("selectProductByName", email);
>>>>>>> Stashed changes
    }
}
