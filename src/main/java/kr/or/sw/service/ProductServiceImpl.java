package kr.or.sw.service;

import kr.or.sw.mapper.ProductDAO;
import kr.or.sw.mapper.ProductDAOImpl;
import kr.or.sw.model.MemberDTO;
import kr.or.sw.model.ProductDTO;
import kr.or.sw.util.MyBatisUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import static kr.or.sw.controller.ProductController.uploadPath;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductServiceImpl implements ProductService {

	private static ProductService instance;

	public static synchronized ProductService getInstance() {
		if (instance == null) {
			instance = new ProductServiceImpl();
		}
		return instance;
	}

	private final ProductDAO productDao = ProductDAOImpl.getInstance();

	@Override
	public void select(HttpServletRequest request, HttpServletResponse response) {
		log.info("select()");
	}

	@Override
	public void selectAll(HttpServletRequest request, HttpServletResponse response) {
		log.info("selectAll()");
		// 모든 상품 목록 불러오기

		List<ProductDTO> list;
		try (SqlSession sqlSession = MyBatisUtil.getSession()) {
			list = new ArrayList<>(productDao.selectAllProduct(sqlSession));
		}
		log.info("selectAll: {}", list);

		request.setAttribute("productList", list);
		request.setAttribute("page", Objects.requireNonNullElse(request.getParameter("page"), 1));
	}

	@Override
	public boolean insert(HttpServletRequest request, HttpServletResponse response) {
		log.info("insert()");
		log.info("uploadPath: {}", uploadPath);

		return true;
	}

	@Override
	public boolean delete(HttpServletRequest request, HttpServletResponse response) {
		log.info("delete()");
		return false;
	}

	@Override
	public boolean update(HttpServletRequest request, HttpServletResponse response) {
		log.info("update()");
		return false;
	}
}
