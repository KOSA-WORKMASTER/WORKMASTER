package kr.or.sw.controller;

import kr.or.sw.service.StockService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

import static kr.or.sw.controller.HomeController.HOME_PATH;
import static kr.or.sw.controller.HomeController.VIEW_PATH;

@Slf4j
@WebServlet(name = "StockController", urlPatterns = "/stock/*")
public class StockController extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 4974481185726010330L;
    private StockService stockService;

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
        log.info("/stock/*");
    }

    @Override
    public void destroy() {
        log.info("destroy()");
    }
}
