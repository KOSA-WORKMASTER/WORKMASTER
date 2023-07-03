package kr.or.sw.mapper;

import kr.or.sw.model.MemberDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public interface SearchDAO {

    List<MemberDTO> selectAll(SqlSession sqlSession);

    MemberDTO selectByid(SqlSession sqlSession, int id);

    MemberDTO selectByEmail(SqlSession sqlSession, String email);
}
