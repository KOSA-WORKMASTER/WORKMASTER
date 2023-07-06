<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/layouts/header.jsp" %>
<%@ include file="/WEB-INF/views/layouts/side.jsp" %>
<link href="./css/order.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="./js/main.js" defer></script>

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
    <c:forEach begin="1" end="30">
        <!-- 주문 화면 박스 -->
        <div class="order-box">
            <!-- 주문 화면 박스 앞에 내용-->
            <div class="box-front">
                <font class="front-number">1</font><br><br>
                <font class="front-font">판매하기</font>
            </div>
        </div>
    </c:forEach>
</main>

<%@ include file="/WEB-INF/views/layouts/footer.jsp" %>