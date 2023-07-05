package kr.or.sw.mapper;

import kr.or.sw.model.MemberDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberDAOImpl implements MemberDAO {

    private static MemberDAO instance;

    public static synchronized MemberDAO getInstance() {
        if (instance == null) {
            instance = new MemberDAOImpl();
        }
        return instance;
    }

    @Override
    public List<MemberDTO> selectAllMembers(SqlSession sqlSession) {
        log.info("searchAll()");
        return sqlSession.selectList("selectAllMembers");
    }

    @Override
    public List<MemberDTO> selectMemberById(SqlSession sqlSession, int id) {
        log.info("searchById()");
        return sqlSession.selectList("selectMemberById", id);
    }

    @Override
    public List<MemberDTO> selectMemberByMName(SqlSession sqlSession, String mName) {
        log.info("searchByMName()");
        return sqlSession.selectList("selectMemberByMName", mName);
    }

    @Override
    public List<MemberDTO> selectMemberByEmail(SqlSession sqlSession, String email) {
        log.info("searchByEmail()");
        return sqlSession.selectList("selectMemberByEmail", email);
    }

    @Override
    public List<MemberDTO> selectMemberByContact(SqlSession sqlSession, String contact) {
        log.info("searchByContact()");
        return sqlSession.selectList("selectMemberByContact", contact);
    }

    @Override
    public int deleteMember(SqlSession sqlSession, int memberID) {
        log.info("deleteMember(): {}", memberID);
        return sqlSession.delete("deleteMember", memberID);
    }
}
