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

@Slf4j
@WebServlet(name = "ProductController", urlPatterns = "/product/*")
public class ProductController extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 5019171277715891863L;

    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("doGet()");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
