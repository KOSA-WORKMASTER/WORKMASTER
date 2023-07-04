package kr.or.sw.controller;

import kr.or.sw.service.SearchService;
import kr.or.sw.service.SearchServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

@Slf4j
@WebServlet(name = "MemberController", value = "/member/*")
public class MemberController extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 5060263104786618675L;
    private SearchService searchService;
    private static final String HOME_PATH = "/WEB-INF/views/home.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doGet()");

        String pathInfo = request.getPathInfo();
        switch (pathInfo) {
            case "/search" -> {
                log.info("/search");
                handleSearch(request, response);
            }
            default -> throw new IllegalStateException("Unexpected value: " + pathInfo);
        }

        request.setAttribute("path", request.getRequestURI().substring(request.getContextPath().length()));
        request.getRequestDispatcher(request.getContextPath() + HOME_PATH).forward(request, response);
    }

    @Override
    public void init() throws ServletException {
        log.info("/member/*");
        searchService = SearchServiceImpl.getInstance();
    }

    @Override
    public void destroy() {
        log.info("destroy()");
    }

    private void handleSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int searchOption = 0;
        if (request.getParameter("searchOption") != null) {
            searchOption = Integer.parseInt(request.getParameter("searchOption"));
        }

        switch (searchOption) {
            case 0 -> searchService.searchAll(request, response);
            case 1, 2, 3, 4 -> searchService.searchBy(request, response);
            default -> throw new IllegalStateException("Unexpected value: " + searchOption);
        }
    }
}
