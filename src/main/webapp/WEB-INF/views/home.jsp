<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/header.jsp" %>
<%@include file="/WEB-INF/views/side.jsp" %>
<c:if test='${pageContext.request.getParameter("redirect") == "true"}'>
    <c:redirect url="/home"/>
</c:if>
<%@include file="/WEB-INF/views/search.jsp" %>
<%@include file="/WEB-INF/views/footer.jsp" %>