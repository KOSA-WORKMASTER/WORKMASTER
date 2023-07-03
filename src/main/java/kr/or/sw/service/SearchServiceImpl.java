package kr.or.sw.service;

import kr.or.sw.mapper.AuthDAO;
import kr.or.sw.mapper.AuthDAOImpl;
import kr.or.sw.mapper.SearchDAO;
import kr.or.sw.mapper.SearchDAOImpl;
import kr.or.sw.model.MemberDTO;
import kr.or.sw.util.MyBatisUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SearchServiceImpl implements SearchService {
    private static final SearchService INSTANCE = new SearchServiceImpl();

    public static SearchService getInstance() {
        return INSTANCE;
    }

    private final SearchDAO searchDAO = SearchDAOImpl.getInstance();

    @Override
    public void searchAll(HttpServletRequest request, HttpServletResponse response, int page) {
        log.info("searchAll()");

        SqlSession sqlSession = MyBatisUtil.getSession();
        ArrayList<MemberDTO> list = new ArrayList<>(searchDAO.selectAll(sqlSession));
        sqlSession.close();
        request.setAttribute("memberList", list);
        request.setAttribute("page", page);
    }

    @Override
    public boolean searchById(HttpServletRequest request, HttpServletResponse response, int page) {
        log.info("searchById()");
        return false;
    }

    @Override
    public boolean searchByEmail(HttpServletRequest request, HttpServletResponse response, int page) {
        log.info("searchByEmail()");
        return false;
    }
}
