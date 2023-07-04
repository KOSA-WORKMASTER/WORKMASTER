$("#search-form").submit((e) => {
    if (document.forms["searchForm"]["searchOption"].value < 0) {
        alert("검색조건을 선택해주세요");
        return false
    }
    return true;
})