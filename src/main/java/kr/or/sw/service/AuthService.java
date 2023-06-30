package kr.or.sw.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthService {

    boolean login(HttpServletRequest request, HttpServletResponse response);
    boolean checkEmail(HttpServletRequest request, HttpServletResponse response);
    boolean insertMember(HttpServletRequest request, HttpServletResponse response);
//    boolean logout();

//    boolean register(HttpServletRequest request, HttpServletResponse response);
//    boolean update(HttpServletRequest request, HttpServletResponse response);
//    boolean delete(HttpServletRequest request, HttpServletResponse response);

//    boolean changePassword(HttpServletRequest request, HttpServletResponse response);

//    boolean findAccount(HttpServletRequest request, HttpServletResponse response);
//    boolean resetPassword(HttpServletRequest request, HttpServletResponse response);
}
