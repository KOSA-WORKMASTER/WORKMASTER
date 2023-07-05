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
import java.util.Objects;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SearchServiceImpl implements SearchService {

    private static SearchService instance;

    public static synchronized SearchService getInstance() {
        if (instance == null) {
            instance = new SearchServiceImpl();
        }
        return instance;
    }

    private final SearchDAO searchDAO = SearchDAOImpl.getInstance();

    @Override
    public void searchAll(HttpServletRequest request, HttpServletResponse response) {
        log.info("searchAll()");

        List<MemberDTO> list;
        try (SqlSession sqlSession = MyBatisUtil.getSession()) {
            list = new ArrayList<>(searchDAO.selectAll(sqlSession));
        }

        request.setAttribute("memberList", list);
        request.setAttribute("page", Objects.requireNonNullElse(request.getParameter("page"), 1));
    }

    @Override
    public void searchBy(HttpServletRequest request, HttpServletResponse response) {
        log.info("searchBy()");

        List<MemberDTO> result;
        String keyword = request.getParameter("keyword");
        int searchOption = Integer.parseInt(request.getParameter("searchOption"));
        if (searchOption >= 2) keyword = "%" + keyword + "%";
        // searchOption이 1이면 id(숫자) 검색이므로 불필요
        // 나머지는 문자열 포함 여부 검색이므로 like 연산을 위해 앞뒤에 % 추가

        try (SqlSession sqlSession = MyBatisUtil.getSession()) {
            result = switch (searchOption) {
                case 1 -> searchDAO.selectById(sqlSession, Integer.parseInt(keyword));
                case 2 -> searchDAO.selectByMName(sqlSession, keyword);
                case 3 -> searchDAO.selectByEmail(sqlSession, keyword);
                case 4 -> searchDAO.selectByContact(sqlSession, keyword);
                default -> throw new IllegalStateException("Unexpected value: " + searchOption);
            };
        }
        assert result != null;
        List<MemberDTO> list = new ArrayList<>(result);
        log.info("size: {}", list.size());

        request.setAttribute("memberList", list);
        request.setAttribute("page", Objects.requireNonNullElse(request.getParameter("page"), 1));
        request.setAttribute("searchOption", searchOption);
        request.setAttribute("keyword", keyword);
    }
}
