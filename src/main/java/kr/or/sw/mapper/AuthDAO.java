package kr.or.sw.mapper;

import kr.or.sw.model.UsrDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthDAO {

    private static final AuthDAO INSTANCE = new AuthDAO();

    public static AuthDAO getINSTANCE() {
        return INSTANCE;
    }

    public boolean login(SqlSession sqlSession, UsrDTO usrDTO) {
        log.info("login()");

        // 여기에 데이터베이스 작업을 수행하는 쿼리 작성
        // 예시: 사용자명과 암호의 일치여부를 반환하는 쿼리
        return (int) sqlSession.selectOne("login", usrDTO) == 1;
    }
}
