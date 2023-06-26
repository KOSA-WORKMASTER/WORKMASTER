package kr.or.sw.mapper;

import kr.or.sw.model.UsrDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)    // Singleton
public class AuthDAOImpl implements AuthDAO {

    private static final AuthDAO INSTANCE = new AuthDAOImpl();

    public static AuthDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public int checkCredentials(SqlSession sqlSession, UsrDTO usrDTO) {
        log.info("checkCredentials()"); // 계정 및 비밀번호 일치 여부 검사

        // 여기에 데이터베이스 작업을 수행하는 쿼리 작성
        // 예시: 사용자명과 비밀번호의 일치여부를 반환하는 쿼리
        // Encode Password by Using kr.or.sw.util.CipherUtil

        return sqlSession.selectOne("checkCredentials", usrDTO);
    }
}
