<%@ page import="kr.or.sw.util.SqlSessionFactoryUtil" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/header.jsp" %>

<side>
    <div class="side-container">
        <div class="side-wrapper">
            <dlv class="side-menu">근태</dlv>
        </div>
        <div class="side-wrapper">
            <dlv class="side-menu">출근/퇴근</dlv>
            <dlv class="side-menu">휴가신청</dlv>
            <dlv class="side-menu">휴가관리</dlv>
        </div>
        <div class="side-wrapper">
            <dlv class="side-menu">급여</dlv>
        </div>
        <div class="side-wrapper">
            <dlv class="side-menu">급여조회</dlv>
            <dlv class="side-menu">급여관리</dlv>
            <dlv class="side-menu">급여지급</dlv>
        </div>
        <div class="side-wrapper">
            <dlv class="side-menu">인사</dlv>
        </div>
        <div class="side-wrapper">
            <dlv class="side-menu">직원검색</dlv>
            <dlv class="side-menu">직원관리</dlv>
            <dlv class="side-menu">부서확인</dlv>
            <dlv class="side-menu">부서관리</dlv>
        </div>
    </div>
</side>
<nav>nav</nav>
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
