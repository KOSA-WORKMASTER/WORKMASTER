package kr.or.sw.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.or.sw.service.AuthService;
import kr.or.sw.service.AuthServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@WebServlet(name = "auth", value = "/auth/*")
public class AuthController extends HttpServlet {

    private static final long serialVersionUID = -2930158301476609066L;
    private final AuthService authService = AuthServiceImpl.getInstance();

    private static final String REDIRECT_PATH = "/index.html?redirect=true";
    private static final String VIEW_PATH = "/WEB-INF/views/home.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doGet()");

        String pathInfo = request.getPathInfo();
        switch (pathInfo) {
            case "/index":
                log.info("/index"); // 로그인 화면으로 이동
                redirectToIndex(request, response);
                break;
            case "/logout":
                log.info("/logout");    // 로그아웃
                handleLogout(request, response);
                break;
            default:
                handleInvalidAccess(response, pathInfo);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doPost()");

        String pathInfo = request.getPathInfo();
        switch (pathInfo) {
            case "/login":
                log.info("/login"); // 로그인
                handleLogin(request, response);
                break;
            case "/register":
                log.info("/register");
                handleRegister(request, response);
                break;
            case "/checkEmail":
                log.info("/checkEmail");
                handleCheckEmail(request, response);
                break;
            default:
                handleInvalidAccess(response, pathInfo);
                break;
        }
    }

    private void redirectToIndex(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("redirectToIndex()");  // 로그인 화면으로 이동

        response.sendRedirect(request.getContextPath() + REDIRECT_PATH);
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("handleLogin()");  // 로그인

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (!authService.login(request, response)) {
            log.error("로그인 실패\nAC: {}, PW: {}", email, password);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{ \"message\": \"Login Failed\" }");
//            request.getRequestDispatcher("/index.html").forward(request, response);   // 인덱스로 이동
        } else {
            log.info("로그인 성공\nemail: {}\npassword: {}", email, password);
            request.getSession().setAttribute("email", email);  // 로그인 세션 저장
//            response.setStatus(HttpServletResponse.SC_OK);
//            response.setHeader("Location", "/WEB-INF/views/home.jsp");
            request.getRequestDispatcher(VIEW_PATH).forward(request, response); // 홈 화면으로 이동
        }
    }

    private void handleLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("handleLogout()"); // 로그아웃

        request.getSession().invalidate();  // 로그인 세션 무효화
        redirectToIndex(request, response);
    }

    private void handleRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("handleRegister");

        if (!authService.insertMember(request, response)) {
            log.error("register fail");
            redirectToIndex(request, response);
        } else {
            log.info("register success");
            redirectToIndex(request, response);
        }
    }

    private void handleCheckEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("handleCheckEmail");

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        ObjectMapper objectMapper = new ObjectMapper();
        boolean ret = authService.checkEmail(request, response);
        log.info("ret: " + ret);
        out.write(objectMapper.writeValueAsString(ret));
        out.flush();
        log.info("check email done");
    }

    private void handleInvalidAccess(HttpServletResponse response, String pathInfo) throws ServletException, IOException {
        log.info("handleInvalidAccess()");  // 잘못된 접근 처리

        log.error("잘못된 접근 : {}", pathInfo);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");
        response.getWriter().write("{ \"message\": \"FORBIDDEN\" }");
//        response.sendError(HttpServletResponse.SC_FORBIDDEN);
    }
}
