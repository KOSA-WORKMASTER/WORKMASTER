<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/header.jsp" %>
<%@include file="/WEB-INF/views/side.jsp" %>
<nav>nav</nav>
<main>
    <c:if test='${pageContext.request.getParameter("redirect") == "true"}'>
        <c:redirect url="/home"/>
    </c:if>
    main<br>
    로그인 성공시 보여질 Home 페이지입니다.<br>
</main>

<%@include file="/WEB-INF/views/footer.jsp" %>