<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<nav>
    <div class="nav-container">
        <div class="nav-wrapper">
            <div class="nav-menu">
                <a href="/member/search?page=1">
                    회원정보
                </a>
            </div>
        </div>
        <div class="nav-wrapper">
            <div class="nav-menu">탈퇴회원</div>
        </div>
    </div>
</nav>

<main>
    <h1 class="mt-4">회원 정보 수정</h1>
    <form action="/member/update" method="post">
        <table class="table mt-4">
            <tr>
                <th>
                    <label for="memberID">ID</label></th>
                <td>
                    <input type="text" id="memberID" name="memberID" value="${memberDTO.getMemberID()}"
                           readonly>
                </td>
            </tr>
            <tr>
                <th>
                    <label for="name">이름</label></th>
                <td>
                    <input type="text" id="name" name="name" value="${memberDTO.getName()}" readonly>
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
                    <input type="text" id="birthday" name="birthday" value="${memberDTO.getBirthday()}"
                           readonly>
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
                    <label for="remainTime">잔여시간(분)</label></th>
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
</main>
