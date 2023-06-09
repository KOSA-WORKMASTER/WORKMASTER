<%@ page import="kr.or.sw.util.SqlSessionFactoryUtil" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/header.jsp" %>

<main>
    main<br>
    <%
        SqlSessionFactoryUtil.getSession();
        out.print("JDBC Test 성공입니다!");
    %>
    <br>
    <button><a href="home.jsp">home.jsp로 이동</a></button>
    <br>
</main>

<script type="text/javascript" defer>
    console.log("JS Test")
</script>

<%@include file="/WEB-INF/views/footer.jsp" %>
