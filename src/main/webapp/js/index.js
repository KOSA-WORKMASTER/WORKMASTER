'use strict'

function switchForm(selectedForm) {
    var memberForm = document.getElementById('client-login');
    var adminForm = document.getElementById('manager-login');
    if (selectedForm === 'member') {
        memberForm.style.display = 'block';
        adminForm.style.display = 'none';
    } else if (selectedForm === 'admin') {
        memberForm.style.display = 'none';
        adminForm.style.display = 'block';
    }
}

const clientLoginForm = document.querySelector("#client-login");

clientLoginForm.addEventListener("submit", function(e) {
    const emailInput = clientLoginForm.querySelector("#email");
    const passwordInput = clientLoginForm.querySelector("#password");

    if (!emailInput.value) {
        alert("아이디를 입력해주세요.");
        e.preventDefault(); // 폼 제출 막기
    }
    else if (!passwordInput.value) {
        alert("비밀번호를 입력해주세요.");
        e.preventDefault(); // 폼 제출 막기
    }
});

const managerLoginForm = document.querySelector("#manager-login");

managerLoginForm.addEventListener("submit", function(e) {
    const adminIdInput = managerLoginForm.querySelector("#adminId");
    const adminPwInput = managerLoginForm.querySelector("#adminPw");

    if (!adminIdInput.value) {
        alert("관리자 아이디를 입력해주세요.");
        e.preventDefault(); // 폼 제출 막기
    }
    else if (!adminPwInput.value) {
        alert("관리자 비밀번호를 입력해주세요.");
        e.preventDefault(); // 폼 제출 막기
    }
});

// 밑에 스크립트는 index 에 적용되게 수정해야됨 

$("#member-login-confirm").click((e) => {


	
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

                    emailChk = true;
//                    alert("아이디 또는 비밀번호가 틀렸습니다.");
                } else {
                    alert("아이디 또는 비밀번호가 틀렸습니다.");
                    return;
                }
            }
        });
    } 
   
});


