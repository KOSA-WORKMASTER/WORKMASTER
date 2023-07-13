var menu;
const showAllMenu = () => {
    let htmls = "";
    menu.forEach((m) => {

        htmls += '<div class="customer-menu">';
        htmls += `<img class="menu-img" alt="상품" src="\\${m.image.uploadPath}">`;
        htmls += '<div class="menu-info-container">';
        htmls += `<div class="menu-name">${m.productName}</div>\n`;
        htmls += `<div class="menu-price">${m.price}원</div>\n`;
        htmls += '</div>\n';
        htmls += '</div>\n';
    })
    $(".customer-menu-body-container").html(htmls);
}
window.onload = () => {
    $.ajax({
        url: "/customer/menu",
        type: "post",
        async: true,
        success: (res) => {
            menu = res;
            showAllMenu();
        },
    });
}