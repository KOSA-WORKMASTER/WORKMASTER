package kr.or.sw.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class MemberDTO {

    private int memberID; // 회원ID, PK
    private String mName;   // 회원명
    private String email;   // 이메일(계정)
    private String password;    // 비밀번호
    private String salt;    // salt
    private String contact; // 연락처
    private String question;   // 본인확인질문
    private String answer;    // 본인확인정답
    private java.sql.Date regDate;  // 등록일
    private int remainTime; // 잔여시간
}
