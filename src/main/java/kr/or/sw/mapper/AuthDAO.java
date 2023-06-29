package kr.or.sw.mapper;

import kr.or.sw.model.UsrDTO;
import org.apache.ibatis.session.SqlSession;

public interface AuthDAO {

    int checkCredentials(SqlSession sqlSession, UsrDTO usrDTO);
}
