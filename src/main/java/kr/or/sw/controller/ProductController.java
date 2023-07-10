package kr.or.sw.controller;

import kr.or.sw.service.ProductService;
import kr.or.sw.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

import static kr.or.sw.controller.HomeController.HOME_PATH;
import static kr.or.sw.controller.HomeController.handleInvalidAccess;

@Slf4j
@WebServlet(name = "ProductController", urlPatterns = "/product/*")
public class ProductController extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 5019171277715891863L;

    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doGet()");

        String pathInfo = request.getPathInfo();
        switch (pathInfo) {
            case "/order" -> {
                log.info("/order");
//                request.getRequestDispatcher(VIEW_PATH + "/product/productOrder.jsp").forward(request, response);
            }
            case "/insert" -> {
                log.info("/insert");
                // 상품 추가 페이지 불러오기
//                request.getRequestDispatcher(VIEW_PATH + "/product/productInsert.jsp").forward(request, response);
            }
            default -> handleInvalidAccess(request, response);
        }
        request.setAttribute("path", request.getRequestURI().substring(request.getContextPath().length()));
        request.getRequestDispatcher(request.getContextPath() + HOME_PATH).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doPost()");
    }

    @Override
    public void init() throws ServletException {
        log.info("/product/*");
        productService = ProductServiceImpl.getInstance();
    }

    @Override
    public void destroy() {
        log.info("destroy()");
    }
}
