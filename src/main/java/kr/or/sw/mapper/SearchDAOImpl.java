package kr.or.sw.mapper;

import kr.or.sw.model.MemberDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SearchDAOImpl implements SearchDAO {

    private static final SearchDAO INSTANCE = new SearchDAOImpl();

    public static SearchDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public List<MemberDTO> selectAll(SqlSession sqlSession) {
        log.info("searchAll()");
        return sqlSession.selectList("selectAll");
    }

    @Override
    public MemberDTO selectByid(SqlSession sqlSession, int id) {
        log.info("searchById()");
        return null;
    }

    @Override
    public MemberDTO selectByEmail(SqlSession sqlSession, String email) {
        log.info("searchByEmail()");
        return null;
    }
}
