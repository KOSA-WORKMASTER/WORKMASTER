package kr.or.sw.service;

import kr.or.sw.mapper.ProductDAO;
import kr.or.sw.mapper.ProductDAOImpl;
import kr.or.sw.model.ProductDTO;
import kr.or.sw.model.ProductImgDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

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

    private final ProductDAO productDAO = ProductDAOImpl.getInstance();

    @Override
    public void select(HttpServletRequest request, HttpServletResponse response) {
        log.info("select()");
    }

    @Override
    public void selectAll(HttpServletRequest request, HttpServletResponse response) {
        log.info("selectAll()");
        // 모든 상품 목록 불러오기

        List<ProductDTO> list = new ArrayList<>(productDAO.selectAllProduct());
        log.info("selectAll: {}", list);

        request.setAttribute("productList", list);
        request.setAttribute("page", Objects.requireNonNullElse(request.getParameter("page"), 1));
    }

    @Override
    public void searchBy(HttpServletRequest request, HttpServletResponse response) {
        log.info("searchBy()");

        List<ProductDTO> result;
        String keyword = request.getParameter("keyword");
        int searchOption = Integer.parseInt(request.getParameter("searchOption"));
        if (searchOption >= 2) keyword = "%" + keyword + "%";
        // searchOption이 1이면 id(숫자) 검색이므로 불필요
        // 나머지는 문자열 포함 여부 검색이므로 like 연산을 위해 앞뒤에 % 추가

        result = switch (searchOption) {
            case 1 -> productDAO.selectProductById(Integer.parseInt(keyword));
            case 2 -> productDAO.selectProductByCategory(keyword);
            case 3 -> productDAO.selectProductByName(keyword);
            default -> throw new IllegalStateException("Unexpected value: " + searchOption);
        };

        List<ProductDTO> list = new ArrayList<>(result);
        log.info("size: {}", list.size());

        request.setAttribute("productList", list);
        request.setAttribute("page", Objects.requireNonNullElse(request.getParameter("page"), 1));
        request.setAttribute("searchOption", searchOption);
        request.setAttribute("keyword", keyword);

    }

    @Override
    public boolean insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("insert()");

        String uploadPath = request.getServletContext().getRealPath("/upload");
        File uploadDirectory = new File(uploadPath);
        if (!uploadDirectory.exists()) {    // 업로드 디렉토리가 없을 경우 생성
            log.info("mkdir: {}", uploadDirectory.mkdirs());
        }

        try {
            Part part = request.getPart("productImage");
            UUID uuid = UUID.randomUUID();
            String originalFileName = part.getSubmittedFileName();
            String fileName = uuid + "_" + originalFileName;
            String filePath = uploadPath + File.separator + fileName;
            log.info("filePath: {}", filePath);
            part.write(filePath);

            ProductImgDTO productImgDTO = new ProductImgDTO(uuid.toString(), filePath, originalFileName);
            log.info("productImgDTO: {}", productImgDTO);

            ProductDTO productDTO = new ProductDTO(
                    request.getParameter("productName"),
                    request.getParameter("category"),
                    Integer.parseInt(request.getParameter("price")),
//                    Integer.parseInt(request.getParameter("stock")),
                    0,
                    productImgDTO
            );
            int result = productDAO.insertProduct(productDTO);
            if (result > 0) return true;

        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return false;
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
