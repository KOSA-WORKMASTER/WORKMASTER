<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ include file="/WEB-INF/views/side.jsp" %>
<link href="./css/main.css" rel="stylesheet" type="text/css">
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
    <div class="main-container">
        <c:forEach var="number" begin="1" end="60">
            <div class="main-box">
                <b>${ number }</b>
                <p class="box-font">
                    김혁진<br>05:00남음<br>오버워치
                </p>
            </div>
        </c:forEach>
    </div>
    <button class="btn btn-default" data-target="#layerpop"
            data-toggle="modal">상품주문
    </button>
    <br/>
</main>
<div class="modal fade" id="layerpop">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- header -->
            <div class="modal-header">
                <c:forEach begin="1" end="6">
                    <div class="modal-title"></div>
                </c:forEach>
                <!-- 닫기(x) 버튼 -->
                <button type="button" class="close" data-dismiss="modal">×</button>

            </div>
            <!-- body -->
            <div class="modal-body">

                <c:forEach var="number" begin="1" end="12">
                    <div class="modal-box">
                        <img class="modal-img" alt="상품" src="./images/${number}.jpg">
                        <hr class="modal-line">
                        <h5><p class="modal-text">신라면<br><br>5000원</p></h5>
                    </div>
                </c:forEach>
            </div>
            <!-- Footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/footer.jsp" %>