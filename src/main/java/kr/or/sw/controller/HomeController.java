package kr.or.sw.controller;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

@Slf4j
@WebServlet(name = "HomeController", urlPatterns = "/home")
public class HomeController extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1586602244798946410L;

    static final String HOME_PATH = "/WEB-INF/views/home.jsp";
    static final String VIEW_PATH = "/WEB-INF/views/";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doGet()");
        request.getRequestDispatcher(request.getContextPath() + HOME_PATH).forward(request, response);
    }

    @Override
    public void init() throws ServletException {
        log.info("/home");
    }

    @Override
    public void destroy() {
        log.info("destroy()");
    }
}
