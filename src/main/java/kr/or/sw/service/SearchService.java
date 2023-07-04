package kr.or.sw.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SearchService {

    void searchAll(HttpServletRequest request, HttpServletResponse response, int page);
    void searchBy(HttpServletRequest request, HttpServletResponse response, int type, String contact, int page);
}
