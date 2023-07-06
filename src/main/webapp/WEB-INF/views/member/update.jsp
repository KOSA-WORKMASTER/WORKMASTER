<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/layouts/header.jsp" %>
<%@ include file="/WEB-INF/views/layouts/side.jsp" %>

<div class="container">
    <h1 class="mt-4">회원 정보 수정</h1>
    <form action="/member/update" method="post">
        <table class="table mt-4">
            <tr>
                <th>
                    <label for="memberID">ID</label></th>
                <td>
                    <input type="text" id="memberID" name="memberID" value="${memberDTO.getMemberID()}" readonly>
                </td>
            </tr>
            <tr>
                <th>
                    <label for="mName">이름</label></th>
                <td>
                    <input type="text" id="mName" name="mName" value="${memberDTO.getMName()}" readonly>
                </td>
            </tr>
            <tr>
                <th>
                    <label for="email">계정(이메일)</label></th>
                <td>
                    <input type="text" id="email" name="email" value="${memberDTO.getEmail()}">
                </td>
            </tr>
            <tr>
                <th>
                    <label for="contact">연락처</label></th>
                <td>
                    <input type="text" id="contact" name="contact" value="${memberDTO.getContact()}">
                </td>
            </tr>
            <tr>
                <th>
                    <label for="birthday">생일</label></th>
                <td>
                    <input type="text" id="birthday" name="birthday" value="${memberDTO.getBirthday()}" readonly>
                </td>
            </tr>
            <tr>
                <th>
                    <label for="regDate">등록일</label></th>
                <td>
                    <input type="text" id="regDate" name="regDate" value="${memberDTO.getRegDate()}" readonly>
                </td>
            </tr>
            <tr>
                <th>
                    <label for="remainTime">잔여시간</label></th>
                <td>
                    <input type="text" id="remainTime" name="remainTime" value="${memberDTO.getRemainTime()}">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" class="btn btn-primary" value="수정">
                    <input type="button" class="btn btn-danger" value="취소" onclick="history.back()">
                </td>
            </tr>
        </table>
    </form>
</div>

<%@ include file="/WEB-INF/views/layouts/footer.jsp" %>