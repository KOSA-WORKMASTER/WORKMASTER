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

@Slf4j
@WebServlet(name = "MemberController", value = "/member/*")
public class MemberController extends HttpServlet {

    private final SearchService searchService = SearchServiceImpl.getInstance();
    private static final String HOME_PATH = "/WEB-INF/views/home.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doGet()");
        log.info("/member");

        String pathInfo = request.getPathInfo();
        switch (pathInfo) {
            case "/search":
                log.info("/search");
                handleSearch(request, response);
                break;
            default:
                break;
        }

        request.setAttribute("path", request.getRequestURI().substring(request.getContextPath().length()));
        request.getRequestDispatcher(request.getContextPath() + HOME_PATH).forward(request, response);
    }
    private void handleSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int type = 0;
        String keyword = null;
        int page = 1;
        if (request.getParameter("searchOption") != null) {
            type = Integer.parseInt(request.getParameter("searchOption"));
            keyword = request.getParameter("keyword");
        }
        if (request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));

        switch (type) {
            case 0:
                searchService.searchAll(request, response, page);
                break;
            case 1:
            case 2:
            case 3:
            case 4:
                searchService.searchBy(request, response, type, keyword, page);
                break;
        }
    }
}
