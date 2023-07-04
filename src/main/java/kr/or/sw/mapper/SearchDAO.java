package kr.or.sw.mapper;

import kr.or.sw.model.MemberDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public interface SearchDAO {

    List<MemberDTO> selectAll(SqlSession sqlSession);

    List<MemberDTO> selectById(SqlSession sqlSession, int id);
    List<MemberDTO> selectByMName(SqlSession sqlSession, String mName);
    List<MemberDTO> selectByEmail(SqlSession sqlSession, String email);
    List<MemberDTO> selectByContact(SqlSession sqlSession, String contact);
}
