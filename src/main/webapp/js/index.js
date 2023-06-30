/**
 * 
 */let stage = 0;
let stageLength = $(".register-stage").length;


$("#nextstage").click(() => {

    if ($("#id").val().length == 0) {
        alert("ID를 입력해주세요")
        return;
    }    

    if ($("#password").val().length == 0) {
        alert("비밀번호를 입력해주세요")
        return;
    }
});
