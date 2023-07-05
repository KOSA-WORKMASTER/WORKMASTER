let stage = 0;
let stageLength = $(".register-stage").length;
let emailChk = true;
const emailRegex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
const checkValidate = (input, reg) => {
  return input.match(reg);
};
const changeInputOutline = (selector, flag) => {
  if (flag) {
    $(selector).removeClass("err");
  } else {
    $(selector).addClass("err");
  }
};

$("#btn-confirm").click((e) => {
  e.preventDefault();
  if ($("#email").val().length == 0) {
    alert("ID를 입력해주세요");
    return false;
  }

  if (!checkValidate($("#email").val(), emailRegex)) {
    alert("이메일 형식이 아닙니다"); // 2
    $("#email").focus();
    return false;
  }

  if (emailChk) {
    $.ajax({
      url: "/auth/checkEmail",
      type: "post",
      data: {
        email: $("#email").val(),
      },
      dataType: "json",
      success: (res) => {
        if (!res) {
          //                       emailChk = false;
          alert("존재하지 않는 ID 입니다");
          return false;
        } else {
          alert("존재하는 ID 입니다");
          location.href = "./passwordSearch2.html";
        }
      },
    });
  } else {
    return false;
  }
});