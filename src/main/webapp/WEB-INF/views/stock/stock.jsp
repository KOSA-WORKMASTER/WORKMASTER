<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/layouts/header.jsp" %>
<%@ include file="/WEB-INF/views/layouts/side.jsp" %>

<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/stock.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js" defer></script>

<side>
    <div class="side-container">
        <div class="side-wrapper">
            <dlv class="side-menu">회원관리</dlv>
        </div>
        <div class="side-wrapper">
            <dlv class="side-menu"><a href="/member/search?page=1">
                회원정보 </a></dlv>
            <dlv class="side-menu">2</dlv>
            <dlv class="side-menu">3</dlv>
        </div>
        <div class="side-wrapper">
            <dlv class="side-menu">메뉴2</dlv>
        </div>
        <div class="side-wrapper">
            <dlv class="side-menu">1</dlv>
            <dlv class="side-menu">2</dlv>
            <dlv class="side-menu">3</dlv>
        </div>
        <div class="side-wrapper">
            <dlv class="side-menu">메뉴3</dlv>
        </div>
        <div class="side-wrapper">
            <dlv class="side-menu">1</dlv>
            <dlv class="side-menu">2</dlv>
            <dlv class="side-menu">3</dlv>
            <dlv class="side-menu">4</dlv>
        </div>
    </div>
</side>

<nav>
    <div class="nav-container">
        <div class="nav-wrapper">
            <div class="nav-menu">
                <a href="/member/search?page=1"> 회원정보 </a>
            </div>
        </div>
        <div class="nav-wrapper">
            <div class="nav-menu">탈퇴회원</div>
        </div>
    </div>
</nav>

<main>
    <div class="search-container">
        <div class="search-input-container">
            <form action="/stockManage/search" method="get" name="searchForm"
                  id="search-form">
                <div class="search-input-wrapper input-group">
                    <select class="custom-select" id="searchOption" name="searchOption">
                        <option value="-1" selected>선택</option>
                        <option value="1">자재구분</option>
                        <option value="2">품목명</option>
                    </select> <input type="text" class="form-control" placeholder="검색어 입력"
                                     id="keyword" name="keyword"> <input type="text" id="page"
                                                                         name="page" value=""> <input
                        class="btn btn-outline-secondary" type="submit" value="검색"
                        id="search-btn">
                </div>
            </form>
            <div class="search-select-type-wrapper btn-group btn-group-toggle"
                 data-toggle="buttons">
                <button class="btn btn-outline-info" data-target="#layerpopAdd"
                        data-toggle="modal">재고 추가
                </button>

                <button class="btn btn-outline-primary"
                        data-target="#layerpopUpdate" data-toggle="modal">재고 수정
                </button>

                <!--    <button class="btn btn-outline-info" data-target="#" data-toggle="">재고 삭제</button> -->


                <!--  				<label class="btn btn-outline-secondary">
                    <input type="radio" name="select-type" id="edit" value="2"> 재고 수정
                </label> 
                <label class="btn btn-outline-secondary">
                    <input type="radio" name="select-type" id="delete" value="3"> 재고 삭제
                </label> -->
            </div>

            <!-- //////////////////////////////재고 추가 모달 시작/////////////////////////////////////////////   -->

            <div class="modal fade" id="layerpopAdd">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <!-- header -->
                        <div class="modal-header">
                            <label> 재고 추가 </label>

                            <button type="button" class="close" data-dismiss="modal">×</button>
                        </div>
                        <!-- body -->
                        <div class="modal-body">

                            <form action="/stockManage/search" method="post"
                                  name="searchForm" id="stockAdd-form">
                                <div class="stock add">
                                    <label>번호</label> <br> <input type="text"
                                                                  class="form-control" placeholder="재고 번호 입력"
                                                                  aria-label="stockNum" aria-describedby="basic-addon1">
                                    <br> <label>자재 구분</label> <br> <select
                                        class="custom-select">
                                    <option value="-1" selected>선택</option>
                                    <option value="1">음료</option>
                                    <option value="2">면류</option>
                                    <option value="3">밥류</option>
                                    <option value="4">스낵</option>
                                    <option value="5">기타</option>
                                </select> <br> <br> <label>품목명</label> <input type="text"
                                                                              class="form-control" placeholder="품목명 입력"
                                                                              aria-label="stockName"
                                                                              aria-describedby="basic-addon1">
                                    <br> <label>적정재고량 (고정)</label> <br> <input
                                        type="text" class="form-control" placeholder="적정재고량 (고정)"
                                        aria-label="stockName" aria-describedby="basic-addon1">
                                    <br> <label>현재고량 (변동)</label> <br> <input type="text"
                                                                              class="form-control"
                                                                              placeholder="현재고량 (변동)"
                                                                              aria-label="stockName"
                                                                              aria-describedby="basic-addon1">
                                    <br> <label>차이 (현재고량 - 적정재고량)</label> <br> <input
                                        type="text" class="form-control"
                                        placeholder="차이 (현재고량 - 적정재고량)" aria-label="stockName"
                                        aria-describedby="basic-addon1"> <br> <label>조치사항</label>
                                    <br> <input type="text" class="form-control"
                                                placeholder="조치사항" aria-label="stockName"
                                                aria-describedby="basic-addon1">
                                </div>

                                <!-- Footer -->
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary">등록</button>
                                    <button type="button" class="btn btn-outline-primary"
                                            data-dismiss="modal">닫기
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <!-- //////////////////////////////재고 추가 모달 끝/////////////////////////////////////////////////////////////////////////////  -->

            <!-- //////////////////////////////재고 수정 모달 시작/////////////////////////////////////////////////////////////////////////////  -->

            <div class="modal fade" id="#layerpopUpdate">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <!-- header -->
                        <div class="modal-header">
                            <label> 재고 추가 </label>

                            <button type="button" class="close" data-dismiss="modal">×</button>
                        </div>
                        <!-- body -->
                        <div class="modal-body">

                            <form action="/stockManage/search" method="post"
                                  name="searchForm" id="stockUpdate-form">
                                <div class="stock update">
                                    <label>번호</label> <br> <input type="text"
                                                                  class="form-control" placeholder="재고 번호 입력"
                                                                  aria-label="stockNum" aria-describedby="basic-addon1">
                                    <br> <label>자재 구분</label> <br> <select
                                        class="custom-select">
                                    <option value="-1" selected>선택</option>
                                    <option value="1">음료</option>
                                    <option value="2">면류</option>
                                    <option value="3">밥류</option>
                                    <option value="4">스낵</option>
                                    <option value="5">기타</option>
                                </select> <br> <br> <label>품목명</label> <input type="text"
                                                                              class="form-control" placeholder="품목명 입력"
                                                                              aria-label="stockName"
                                                                              aria-describedby="basic-addon1">
                                    <br> <label>적정재고량 (고정)</label> <br> <input
                                        type="text" class="form-control" placeholder="적정재고량 (고정)"
                                        aria-label="stockName" aria-describedby="basic-addon1">
                                    <br> <label>현재고량 (변동)</label> <br> <input type="text"
                                                                              class="form-control"
                                                                              placeholder="현재고량 (변동)"
                                                                              aria-label="stockName"
                                                                              aria-describedby="basic-addon1">
                                    <br> <label>차이 (현재고량 - 적정재고량)</label> <br> <input
                                        type="text" class="form-control"
                                        placeholder="차이 (현재고량 - 적정재고량)" aria-label="stockName"
                                        aria-describedby="basic-addon1"> <br> <label>조치사항</label>
                                    <br> <input type="text" class="form-control"
                                                placeholder="조치사항" aria-label="stockName"
                                                aria-describedby="basic-addon1">
                                </div>
                            </form>

                        </div>
                        <!-- Footer -->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary">등록</button>
                            <button type="button" class="btn btn-outline-primary"
                                    data-dismiss="modal">닫기
                            </button>
                        </div>
                    </div>
                </div>
            </div>

            <!-- //////////////////////////////재고 수정 모달 끝/////////////////////////////////////////////////////////////////////////////  -->

            <div class="search-result-into-container">
                ${stockList.size()}개의 상품이 검색되었습니다
                <!-- 재고 리스트 필요함 -->
            </div>
        </div>
        <div class="search-result-container">
            <div class="search-result-wrapper">
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th scope="col">번호</th>
                        <!-- getStockID() -->
                        <th scope="col">자재구분</th>
                        <!-- getStockType() -->
                        <th scope="col">품목명</th>
                        <!-- getStockName() -->
                        <th scope="col">적정재고량 (고정)</th>
                        <!-- getPropStock() -->
                        <th scope="col">현재고량 (변동)</th>
                        <!-- getCurStock() -->
                        <th scope="col">차이 (현재고량 - 적정재고량)</th>
                        <!-- 현재고량값에서 적정재고량을 뺀 값을 넣으면 됨 -->
                        <th scope="col">조치사항</th>
                        <!-- 재고량 상태를 확인하여 조치사항을 출력 (조치사항 명은 아직 못정함 -->
                    </tr>
                    </thead>
                    <tbody>
                    <!-- stockList DB가 필요함. 현재 stock DB 누락으로 데이터 출력 불가능-->
                    <c:if test="${stockList.size() > 0}">
                        <%-- 1페이지에 10개씩, 1페이지면 0번 인덱스부터, 9번 인덱스까지의 데이터를 담게 된다. --%>
                        <%-- n페이지일 경우 (10*(n - 1))번 인덱스부터, (10*(n - 1) + 9)번 인덱스까지의 데이터를 담게 된다. --%>
                        <%-- 단, 데이터가 10개를 모두 채우지 못하고 이전에 끝난다면, 거기까지만 나오게 조절 --%>
                        <c:forEach var="i" begin="${(page - 1) * 10}"
                                   end="${Math.min(stockList.size() - 1, (page - 1) * 10 + 9)}">
                            <tr class="stock-data" id="stockData${i}">
                                <!-- 재고 정보에 따라 db를 가져와서 담게 된다. -->
                                <td>${stockList.get(i).getStockID()}</td>
                                <!-- 번호 -->
                                <td>${stockList.get(i).getStockType()}</td>
                                <!-- 자재구분 -->
                                <td>${stockList.get(i).getStockName()}</td>
                                <!-- 품목명 -->
                                <td>${stockList.get(i).getPropStock()}</td>
                                <!-- 적정재고량 (고정) -->
                                <td>${stockList.get(i).getCurStock()}</td>
                                <!-- 현재고량 (변동) -->
                                <td>
                                    <!-- 현재고량값에서 적정재고량을 뺀 값을 넣으면 됨 -->
                                </td>
                                <!-- 차이 (현재고량 - 적정재고량) -->
                                <td>
                                    <!-- 조치사항 -->
                                </td>
                                <!-- 조치사항 -->
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${stockList.size() == 0}">
                        <td colspan="8">검색결과가 없습니다</td>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="search-page-container">
            <div class="search-page-wrapper">
                <ul class="pagination">
                    <c:if test="${stockList.size() > 0}">
                        <%-- 일단, 이전 버튼은 11페이지 이상부터 나와야 하므로 지금 페이지가 10을 초과하는 경우에만 달아줌 --%>
                        <c:if test="${page > 10}">
                            <li class="page-item">
                                    <%-- 페이지가 1, 11, 21, 31 등에서부터 시작할 수 있게 조절하는 부분 --%> <c:if
                                    test="${keyword != null}">
                                <a class="page-link"
                                   href="/stockManage/search?searchOption=${searchOption}&keyword=${keyword}&page=${page - (page % 10) - (page % 10 == 0 ? 19 : 9)}"
                                   aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                                </a>
                            </c:if> <c:if test="${keyword == null}">
                                <a class="page-link"
                                   href="/stockManage/search?page=${page - (page % 10) - (page % 10 == 0 ? 19 : 9)}"
                                   aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                                </a>
                            </c:if>
                            </li>
                        </c:if>
                        <%-- 이전과 다음 버튼 사이에 들어갈 각 페이지 버튼들, 데이터를 담는 것과 어느정도 비슷한 방식 --%>
                        <c:forEach var="i" begin="${Math.floor((page - 1) / 10) * 10}"
                                   end="${Math.min(Math.floor(stockList.size() / 10), Math.floor((page - 1) / 10) * 10 + 9)}">
                            <c:if test="${page == i + 1}">
                                <c:if test="${keyword != null}">
                                    <li class="page-item"><a class="page-link current-page"
                                                             href="/stockManage/search?searchOption=${searchOption}&keyword=${keyword}&page=${i + 1}">${i + 1}</a>
                                    </li>
                                </c:if>
                                <c:if test="${keyword == null}">
                                    <li class="page-item"><a class="page-link current-page"
                                                             href="/stockManage/search?page=${i + 1}">${i + 1}</a></li>
                                </c:if>
                            </c:if>
                            <c:if test="${page != i + 1}">
                                <c:if test="${keyword != null}">
                                    <li class="page-item"><a class="page-link"
                                                             href="/stockManage/search?searchOption=${searchOption}&keyword=${keyword}&page=${i + 1}">${i + 1}</a>
                                    </li>
                                </c:if>
                                <c:if test="${keyword == null}">
                                    <li class="page-item"><a class="page-link"
                                                             href="/stockManage/search?page=${i + 1}">${i + 1}</a></li>
                                </c:if>
                            </c:if>
                        </c:forEach>
                        <%-- 아까 이전 페이지때처럼, 다음 페이지 버튼은 마지막인 경우에는 추가하지 않는다 --%>
                        <c:if
                                test="${Math.floor((page - 1) / 10) < Math.floor(stockList.size() / 100)}">
                            <li class="page-item">
                                    <%-- 페이지가 1, 11, 21, 31 등에서부터 시작할 수 있게 조절하는 부분 --%> <c:if
                                    test="${keyword != null}">
                                <a class="page-link"
                                   href="/stockManage/search?searchOption=${searchOption}&keyword=${keyword}&page=${page - (page % 10) + (page % 10 == 0 ? 1 : 11)}"
                                   aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                                </a>
                            </c:if> <c:if test="${keyword == null}">
                                <a class="page-link"
                                   href="/stockManage/search?page=${page - (page % 10) + (page % 10 == 0 ? 1 : 11)}"
                                   aria-label="Next"> <span aria-hidden="true">&raquo;</span>
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

<%@ include file="/WEB-INF/views/layouts/footer.jsp" %>
