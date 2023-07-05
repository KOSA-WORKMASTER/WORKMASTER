package kr.or.sw.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberService {

    void searchAll(HttpServletRequest request, HttpServletResponse response);

    void searchBy(HttpServletRequest request, HttpServletResponse response);

    boolean delete(HttpServletRequest request, HttpServletResponse response);
}
