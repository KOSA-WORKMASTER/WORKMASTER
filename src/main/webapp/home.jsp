<%@ page import="kr.or.sw.util.SqlSessionFactoryUtil" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/header.jsp" %>

<main>
    main<br>
    <%
        SqlSessionFactoryUtil.getSession();
        out.print("로그인 성공시 보여질 Home 페이지입니다.");
    %>
    <br>
</main>

<%@include file="/WEB-INF/views/footer.jsp" %>