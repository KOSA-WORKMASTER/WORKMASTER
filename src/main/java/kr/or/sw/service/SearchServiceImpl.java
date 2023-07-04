package kr.or.sw.service;

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
    public void searchBy(HttpServletRequest request, HttpServletResponse response, int type, String keyword, int page) {
        log.info("searchBy()");

        SqlSession sqlSession = MyBatisUtil.getSession();
        List<MemberDTO> result = null;
        if (type >= 2) keyword = "%" + keyword + "%";
        switch (type) {
            case 1:
                result = searchDAO.selectById(sqlSession, Integer.parseInt(keyword));
                break;
            case 2:
                result = searchDAO.selectByMName(sqlSession, keyword);
                break;
            case 3:
                result = searchDAO.selectByEmail(sqlSession, keyword);
                break;
            case 4:
                result = searchDAO.selectByContact(sqlSession, keyword);
                break;
        }
        ArrayList<MemberDTO> list = new ArrayList<>(result);
        log.info("size: {}", list.size());
        sqlSession.close();
        request.setAttribute("memberList", list);
        request.setAttribute("page", page);
        request.setAttribute("searchOption", type);
        request.setAttribute("keyword", keyword);
    }
}
