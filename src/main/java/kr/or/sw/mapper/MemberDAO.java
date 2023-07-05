package kr.or.sw.mapper;

import kr.or.sw.model.MemberDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public interface MemberDAO {

    List<MemberDTO> selectAllMembers(SqlSession sqlSession);

    List<MemberDTO> selectMemberById(SqlSession sqlSession, int id);

    List<MemberDTO> selectMemberByMName(SqlSession sqlSession, String mName);

    List<MemberDTO> selectMemberByEmail(SqlSession sqlSession, String email);

    List<MemberDTO> selectMemberByContact(SqlSession sqlSession, String contact);

    int deleteMember(SqlSession sqlSession, int memberID);
}
