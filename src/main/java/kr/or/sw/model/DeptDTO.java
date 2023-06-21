package kr.or.sw.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class DeptDTO {

    private int deptNo; // 부서번호, PK
    private String deptName;    // 부서명
}
