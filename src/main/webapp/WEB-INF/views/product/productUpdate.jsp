<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<nav>
    <div class="nav-container">
    </div>
</nav>

<main>
    <h1 class="mt-4">상품 정보 수정</h1>
    <form action="/product/update" method="post">
        <table class="table mt-4">
            <tr>
                <th>
                    <label for="productID">번호</label></th>
                <td>
                    <div class="input-container">
                        <div class="input-group">
                            <input type="text" class="form-control" id="productID" name="productID"
                                   value="${productDTO.getProductID()}"
                                   readonly>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <th>
                    <label for="name">카테고리</label></th>
                <td>
                    <div class="input-container">
                        <div class="input-group">
                            <input type="text" class="form-control" id="category" name="category" value="${productDTO.getCategory()}"
                                   readonly>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <th>
                    <label for="email">상품명</label></th>
                <td>
                    <div class="input-container">
                        <div class="input-group">
                            <input type="text" class="form-control" id="productName" name="productName"
                                   value="${productDTO.getProductName()}" readonly>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <th>
                    <label for="contact">상품가격</label></th>
                <td>
                    <div class="input-container">
                        <div class="input-group">
                            <input type="text" class="form-control" id="price" name="price"
                                   value="${productDTO.getPrice()}">
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <th>
                    <label for="birthDate">재고</label></th>
                <td>
                    <div class="input-container">
                        <div class="input-group">
                            <input type="text" class="form-control" id="stock" name="stock"
                                   value="${productDTO.getStock()}">
                        </div>
                    </div>
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
