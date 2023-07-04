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
    public List<MemberDTO> selectById(SqlSession sqlSession, int id) {
        log.info("searchById()");
        return sqlSession.selectList("selectById", id);
    }
    @Override
    public List<MemberDTO> selectByMName(SqlSession sqlSession, String mName) {
        log.info("searchByMName()");
        return sqlSession.selectList("selectByMName", mName);
    }

    @Override
    public List<MemberDTO> selectByEmail(SqlSession sqlSession, String email) {
        log.info("searchByEmail()");
        return sqlSession.selectList("selectByEmail", email);
    }

    @Override
    public List<MemberDTO> selectByContact(SqlSession sqlSession, String contact) {
        log.info("searchByContact()");
        return sqlSession.selectList("selectByContact", contact);
    }
}
