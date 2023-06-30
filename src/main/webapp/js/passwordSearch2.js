/**
 * 
 */let stage = 0;
let stageLength = $(".register-stage").length;
let emailChk = false;
$("#email-chk").click(() => {
    if ($("#email").val().length == 0) {
        alert("이메일을 입력해주세요");
        return;
    }

    if (!emailChk) {
        $.ajax({
            url: "/auth/checkEmail",
            type: "post",
            data: {
                email: $("#email").val()
            },
            dataType: "json",
            success: (res) => {
                if (!res) {
                    $("#email").attr("disabled", "disabled");

                    $("#email-chk").toggleClass("btn-outline-secondary");
                    $("#email-chk").toggleClass("btn-success");
                    emailChk = true;
                    alert("사용 가능한 이메일입니다")
                }
                else {
                    alert("이메일이 중복됩니다");
                    return;
                }
            },
        });


    }
    else {
        if ($("#email").attr("disabled")) $("#email").removeAttr("disabled");

        $("#email-chk").toggleClass("btn-outline-secondary");
        $("#email-chk").toggleClass("btn-success");
        emailChk = false;
    }
});
$("#nextstage").click(() => {
    if (!emailChk) {
        alert("이메일 중복 확인을 해주세요");
        return;
    }
    if ($("#password").val().length == 0) {
        alert("비밀번호를 입력해주세요")
        return;
    }

    if ($("#password").val() !== $("#password-confirm").val()) {
        alert("비밀번호가 일치하지 않습니다");
        return;
    }

    stage++;
    $(".register-stage-wrapper").css({
        transform : `translateX(${-49 * (stage % stageLength)}%)`
    });
});
$("#prevstage").click(() => {
    stage--;
    $(".register-stage-wrapper").css({
        transform : `translateX(${-49 * (stage % stageLength)}%)`
    });
});

$("#register-form").submit((e) => {
    if ($("#name").val().length == 0) {
        alert("이름을 입력해주세요");
        return false;
    }
    if ($("#phone").val().length == 0) {
        alert("연락처를 입력해주세요");
        return false;
    }
    if ($("#birthday").val().length == 0) {
        alert("생년월일을 입력해주세요");
        return false;
    }

    return true;
})