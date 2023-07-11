package kr.or.sw.service;

import kr.or.sw.mapper.ProductDAO;
import kr.or.sw.mapper.ProductDAOImpl;
import kr.or.sw.model.ProductDTO;
import kr.or.sw.util.MyBatisUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
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

        List<ProductDTO> list = new ArrayList<>(productDao.selectAllProduct());
        log.info("selectAll: {}", list);

        request.setAttribute("productList", list);
        request.setAttribute("page", Objects.requireNonNullElse(request.getParameter("page"), 1));
    }

    @Override
    public boolean insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("insert()");

        String uploadPath = request.getServletContext().getRealPath("/upload");
        File uploadDirectory = new File(uploadPath);
        if (!uploadDirectory.exists()) {    // 업로드 디렉토리가 없을 경우 생성
            log.info("mkdir: {}", uploadDirectory.mkdirs());
        }

        Part  part = request.getPart("productImage");
        String fileName = part.getSubmittedFileName();
        String filePath = uploadPath + File.separator + fileName;
        log.info("filePath: {}", filePath);
        part.write(filePath);

        ProductDTO productDTO = new ProductDTO();

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
