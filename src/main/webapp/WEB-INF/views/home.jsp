<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/header.jsp" %>
<%@include file="/WEB-INF/views/side.jsp" %>
<c:set var="paths" value="${fn:split(path, '/')}"/>
<c:if test='${pageContext.request.getParameter("redirect") == "true"}'>
    <c:redirect url="/home"/>
</c:if>

<%-- fn 태그의 split은 놀랍게도 제일 앞의 빈 문자열이 없고 그 뒤부터 생겨서 길이가 2짜리로 생김에 주의 --%>
<c:if test="${paths[0] eq 'member'}">
    <c:if test="${paths[1] eq 'search'}">
        <%@include file="/WEB-INF/views/search.jsp" %>
    </c:if>
</c:if>
<%@include file="/WEB-INF/views/footer.jsp" %>
