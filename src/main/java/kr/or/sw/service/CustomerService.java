package kr.or.sw.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface CustomerService extends Service{
    public void getMenu(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
