package kr.or.sw.service;

import kr.or.sw.mapper.AuthDAO;
import kr.or.sw.model.UsrDTO;
import kr.or.sw.util.MyBatisUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthServiceImpl implements AuthService {

    private static final AuthService INSTANCE = new AuthServiceImpl();

    public static AuthService getINSTANCE() {
        return INSTANCE;
    }

    private final AuthDAO authDAO = AuthDAO.getINSTANCE();

    @Override
    public boolean login(HttpServletRequest request, HttpServletResponse response) {
        log.info("login()");

        // 로그인 기능 구현: 비밀번호 틀리면 return false
        SqlSession sqlSession = MyBatisUtil.getSession();
        UsrDTO usrDTO = new UsrDTO();
        usrDTO.setAccount(request.getParameter("account"));
        usrDTO.setPassword(request.getParameter("password"));
        boolean match = authDAO.login(sqlSession, usrDTO);
        sqlSession.close();
        return match;
    }
}