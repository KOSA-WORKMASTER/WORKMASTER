package kr.or.sw.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsrDTO {

    private String account; // 계정, PK
    private String password;    // 비밀번호
//    private String salt;    // salt
    private boolean admin;    // 관리자 여부
//    private int empNo;   // 사번, FK
}
