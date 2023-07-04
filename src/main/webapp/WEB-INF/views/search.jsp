<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/search.css">
<script src="${pageContext.request.contextPath}/js/memberSearch.js" type="text/javascript" defer></script>
<c:if test="${Math.floor(memberList.size() / 10) + 1 <  page}">
    <c:if test="${keyword != null}">
        <c:redirect url="/member/search?searchOption=${searchOption}&keyword=${keyword}&page=1"/>
    </c:if>
    <c:if test="${keyword == null}">
        <c:redirect url="/member/search?page=1"/>
    </c:if>
</c:if>
<nav>
    <div class="nav-container">
        <div class="nav-wrapper">
            <div class="nav-menu">회원정보</div>
        </div>
        <div class="nav-wrapper">
            <div class="nav-menu">탈퇴회원</div>
        </div>
    </div>
</nav>
<main>
    <div class="search-container">
        <div class="search-input-container">
            <form action="/member/search" method="get" name="searchForm" id="search-form">
                <div class="search-input-wrapper input-group">
                    <select class="custom-select" id="searchOption" name="searchOption">
                        <option value="-1" selected>선택</option>
                        <option value="1">번호</option>
                        <option value="2">이름</option>
                        <option value="3">이메일</option>
                        <option value="4">연락처</option>
                    </select>
                    <input type="text" class="form-control" placeholder="검색어 입력" id="keyword"
                           name="keyword">
                    <input type="text" id="page" name="page" value="1" hidden>
                    <input class="btn btn-outline-secondary" type="submit" value="검색" id="search-btn">
                </div>
            </form>
            <div class="search-select-type-wrapper btn-group btn-group-toggle" data-toggle="buttons">
                <label class="btn btn-outline-secondary active">
                    <input type="radio" name="select-type" id="edit" value="1" checked> 회원수정
                </label>
                <label class="btn btn-outline-secondary">
                    <input type="radio" name="select-type" id="delete" value="2"> 회원삭제
                </label>
            </div>
            <div class="search-result-into-container">
                ${memberList.size()}명 검색되었습니다
            </div>
        </div>
        <div class="search-result-container">
            <div class="search-result-wrapper">
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th scope="col">번호</th>
                        <th scope="col">이름</th>
                        <th scope="col">이메일</th>
                        <th scope="col">연락처</th>
                        <th scope="col">생년월일</th>
                        <th scope="col">가입일</th>
                        <th scope="col">남은시간(분)</th>
                        <th scope="col">최근방문일</th>
                    </tr>
                    </thead>
                    <tbody>
                    <!-- 1페이지에 10개씩 페이징할 것 -->
                    <c:if test="${memberList.size() > 0}">
                        <c:forEach var="i" begin="${(page - 1) * 10}"
                                   end="${Math.min(memberList.size() - 1, (page - 1) * 10 + 9)}">
                            <tr>
                                <td>${memberList.get(i).getMemberID()}</td>
                                <td>${memberList.get(i).getMName()}</td>
                                <td>${memberList.get(i).getEmail()}</td>
                                <td>${memberList.get(i).getContact()}</td>
                                <td>-</td>
                                <td>${memberList.get(i).getRegDate()}</td>
                                <td>${memberList.get(i).getRemainTime()}</td>
                                <td>-</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${memberList.size() == 0}">
                        <td colspan="8">검색결과가 없습니다</td>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="search-page-container">
            <div class="search-page-wrapper">
                <ul class="pagination">
                    <c:if test="${memberList.size() > 0}">
                        <c:if test="${page > 10}">
                            <li class="page-item">
                                <c:if test="${keyword != null}">
                                    <a class="page-link"
                                       href="/member/search?searchOption=${searchOption}&keyword=${keyword}&page=${page - (page % 10) - (page % 10 == 0 ? 19 : 9)}"
                                       aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </c:if>
                                <c:if test="${keyword == null}">
                                    <a class="page-link"
                                       href="/member/search?page=${page - (page % 10) - (page % 10 == 0 ? 19 : 9)}"
                                       aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </c:if>
                            </li>
                        </c:if>
                        <c:forEach var="i" begin="${Math.floor((page - 1) / 10) * 10}"
                                   end="${Math.min(Math.floor(memberList.size() / 10), Math.floor((page - 1) / 10) * 10 + 9)}">
                            <c:if test="${page == i + 1}">
                                <c:if test="${keyword != null}">
                                    <li class="page-item"><a class="page-link current-page"
                                                             href="/member/search?searchOption=${searchOption}&keyword=${keyword}&page=${i + 1}">${i + 1}</a></li>
                                </c:if>
                                <c:if test="${keyword == null}">
                                    <li class="page-item"><a class="page-link current-page"
                                                             href="/member/search?page=${i + 1}">${i + 1}</a></li>
                                </c:if>
                            </c:if>
                            <c:if test="${page != i + 1}">
                                <c:if test="${keyword != null}">
                                    <li class="page-item"><a class="page-link" href="/member/search?searchOption=${searchOption}&keyword=${keyword}&page=${i + 1}">${i + 1}</a>
                                    </li>
                                </c:if>
                                <c:if test="${keyword == null}">
                                    <li class="page-item"><a class="page-link" href="/member/search?page=${i + 1}">${i + 1}</a>
                                    </li>
                                </c:if>
                            </c:if>

                        </c:forEach>
                        <c:if test="${Math.floor((page - 1) / 10) < Math.floor(memberList.size() / 100)}">
                            <li class="page-item">
                                <c:if test="${keyword != null}">
                                    <a class="page-link"
                                       href="/member/search?searchOption=${searchOption}&keyword=${keyword}&page=${page - (page % 10) + (page % 10 == 0 ? 1 : 11)}"
                                       aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </c:if>
                                <c:if test="${keyword == null}">
                                    <a class="page-link"
                                       href="/member/search?page=${page - (page % 10) + (page % 10 == 0 ? 1 : 11)}"
                                       aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </c:if>
                            </li>
                        </c:if>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>
</main>