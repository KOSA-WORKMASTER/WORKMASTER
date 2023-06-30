package kr.or.sw.mapper;

import kr.or.sw.model.MemberDTO;
import org.apache.ibatis.session.SqlSession;

public interface AuthDAO {

    int checkCredentials(SqlSession sqlSession, MemberDTO memberDTO);

    int checkEmail(SqlSession sqlsession, String email);

    int insertMember(SqlSession sqlSession, MemberDTO memberDTO);
}
