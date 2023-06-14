package kr.or.sw.model;

import lombok.Data;

@Data
public class EmpDTO {

    private int empNo;   // 사번, PK
    private String empName; // 사원명
    private String deptNo;  // 부서번호, FK
    private String jobNo;   // 직급번호, FK
    private int managerNo;   // 관리자번호
    private String email;   // 이메일
    private String contact;   // 연락처
    private String address; // 주소
    private long salary; // 기본급
//    private double commissionPct;  // 상여금 비율
//    private long bonus;  // 상여금
    private java.sql.Date hireDate; // 고용일
    private java.sql.Date updateDate;   // 변경일
//    private java.sql.Date delDate;    // 퇴사일
//    private boolean isDel;    // 퇴사여부
//    private String delReason; // 퇴사사유
}
