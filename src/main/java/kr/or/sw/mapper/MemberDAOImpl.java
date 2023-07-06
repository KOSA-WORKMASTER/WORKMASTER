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
    public List<MemberDTO> selectMemberById(SqlSession sqlSession, int memberID) {
        log.info("searchById(): {}", memberID);
        return sqlSession.selectList("selectMemberById", memberID);
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
    public MemberDTO selectMember(SqlSession sqlSession, int memberID) {
        log.info("selectMember(): {}", memberID);
        return sqlSession.selectOne("selectMember", memberID);
    }

    @Override
    public int updateMember(SqlSession sqlSession, MemberDTO memberDTO) {
        log.info("updateMember(): {}", memberDTO);
        return sqlSession.update("updateMember", memberDTO);
    }

    @Override
    public int deleteMember(SqlSession sqlSession, int memberID) {
        log.info("deleteMember(): {}", memberID);
        return sqlSession.delete("deleteMember", memberID);
    }
}
