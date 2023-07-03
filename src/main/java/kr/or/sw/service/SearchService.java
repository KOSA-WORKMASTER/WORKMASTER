package kr.or.sw.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SearchService {
    void searchAll(HttpServletRequest request, HttpServletResponse response, int page);
    boolean searchById(HttpServletRequest request, HttpServletResponse response, int page);
    boolean searchByEmail(HttpServletRequest request, HttpServletResponse response, int page);
}
