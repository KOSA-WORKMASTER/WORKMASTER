package kr.or.sw.controller;

import kr.or.sw.service.AuthService;
import kr.or.sw.service.AuthServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "auth", value = "/auth/*")
public class AuthController extends HttpServlet {

    private static final long serialVersionUID = -2930158301476609066L;
    private AuthService authService;
    private static final String REDIRECT_PATH = "/index.html?redirect=true";
    private static final String VIEW_PATH = "/WEB-INF/views/home.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doGet()");

        String pathInfo = request.getPathInfo();
        switch (pathInfo) {
            case "/index":
                redirectToIndex(request, response);
                break;
            default:
                handleInvalidAccess(response, pathInfo);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doPost()");

//        System.setProperty("user.language", "ko");
//        System.setProperty("user.country", "KR");
        String pathInfo = request.getPathInfo();
        switch (pathInfo) {
            case "/login":
                log.info("/login");
                handleLogin(request, response);
                break;
            default:
                handleInvalidAccess(response, pathInfo);
                break;
        }
    }

    private void redirectToIndex(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("redirectToIndex()");
        response.sendRedirect(request.getContextPath() + REDIRECT_PATH);
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("handleLogin()");

        String account = request.getParameter("account");
        String password = request.getParameter("password");
        authService = AuthServiceImpl.getINSTANCE();
        if (!authService.login(request, response)) {
            log.error("로그인 실패\nAC: {}, PW: {}", account, password);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{ \"message\": \"Login Failed\" }");
//            request.getRequestDispatcher("/index.html").forward(request, response);   // 인덱스로 이동
        } else {
            log.info("로그인 성공{}</u> : {}", account, password);
            request.getSession().setAttribute("account", account);  // 로그인 세션 저장
//            response.setStatus(HttpServletResponse.SC_OK);
//            response.setHeader("Location", "/WEB-INF/views/home.jsp");
            request.getRequestDispatcher(VIEW_PATH).forward(request, response); // 홈 화면으로 이동
        }
    }

    private void handleInvalidAccess(HttpServletResponse response, String pathInfo) throws ServletException, IOException {
        log.info("handleInvalidAccess()");

        log.error("잘못된 접근 : {}", pathInfo);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");
        response.getWriter().write("{ \"message\": \"FORBIDDEN\" }");
//        response.sendError(HttpServletResponse.SC_FORBIDDEN);
    }
}
