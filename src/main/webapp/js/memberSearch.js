$("#search-form").submit((e) => {
    if (document.forms["searchForm"]["searchOption"].value < 0) {
        alert("검색조건을 선택해주세요");
        return false
    }
    if (document.forms["searchForm"]["searchOption"].value == 1 && !document.forms["searchForm"]["keyword"].value.match(/^[0-9]+$/)) {
        alert("번호는 숫자만 입력이 가능합니다");
        return false
    }
    return true;
})

// jquery에는 forEach 아니고 each인듯
$(".member-data").each((index, element) => {
    $(element).click(() => {
        // console.log(element.getAttribute("id").substring(10));

        // 클릭한 데이터의 인덱스
        let elementIdx = parseInt(element.getAttribute("id").substring(10));

        // 현재 선택한 방식
        // 1:수정 2:삭제
        let type = $('input[name=select-type]:checked').val()

        /*
           두 변수를 적절히 사용하여 수정 혹은 삭제를 진행하는 코드를 작성할 것
         */
    });
})