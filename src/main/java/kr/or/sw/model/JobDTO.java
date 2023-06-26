package kr.or.sw.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class JobDTO {

    private int jobNo;  // 직급번호, PK
    private String jobName; // 직급명
}
