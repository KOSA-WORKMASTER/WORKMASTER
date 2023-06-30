package kr.or.sw.service;

import kr.or.sw.mapper.AuthDAO;
import kr.or.sw.mapper.AuthDAOImpl;
import kr.or.sw.model.MemberDTO;
import kr.or.sw.util.CipherUtil;
import kr.or.sw.util.MyBatisUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)    // Singleton
public class AuthServiceImpl implements AuthService {

    private static final AuthService INSTANCE = new AuthServiceImpl();

    public static AuthService getInstance() {
        return INSTANCE;
    }

    private final AuthDAO authDAO = AuthDAOImpl.getInstance();

    @Override
    public boolean login(HttpServletRequest request, HttpServletResponse response) {
        log.info("login()");

        // 로그인 기능 구현
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setEmail(request.getParameter("email"));
        memberDTO.setPassword(request.getParameter("password"));

        SqlSession sqlSession = MyBatisUtil.getSession();
        int match = authDAO.checkCredentials(sqlSession, memberDTO);
        sqlSession.close();
        return match == 1;
    }

    @Override
    public boolean checkEmail(HttpServletRequest request, HttpServletResponse response) {
        log.info("checkEmail()");
        String email = request.getParameter("email");

        SqlSession sqlSession = MyBatisUtil.getSession();
        int ret = authDAO.checkEmail(sqlSession, email);
        sqlSession.close();
        return ret == 1;
    }

    @Override
    public boolean insertMember(HttpServletRequest request, HttpServletResponse response) {
        log.info("insertMember()");
        CipherUtil cipher = CipherUtil.getInstance();

        String mName = request.getParameter("mName"),
               email = request.getParameter("email"),
               salt = cipher.generateSalt(),
               password = cipher.hashPassword(request.getParameter("password"), salt),
               contact = request.getParameter("contact"),
               question = request.getParameter("question"),
               answer = request.getParameter("answer"),
               birthday = request.getParameter("birthday");

        MemberDTO memberDTO = new MemberDTO(mName, email, password, salt, contact, question, answer, birthday);
        SqlSession sqlSession = MyBatisUtil.getSession();
        int ret = authDAO.insertMember(sqlSession, memberDTO);
        sqlSession.commit();
        sqlSession.close();
        return ret == 1;
    }
}
