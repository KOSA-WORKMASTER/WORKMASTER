'use strict'

$("#preview").on("error", () => {
    $("#preview").css("display", "none");
});
$("#image-upload").change(() => {
    var file = $("input[type=file]")[0].files[0];
    var reader = new FileReader();

    reader.onloadend = () => {
        $("#preview").css("display", "block");
        $("#preview").attr("src", reader.result);
    }

    if (file) {
        reader.readAsDataURL(file);
    } else {
        $("#preview").attr("src", "");
    }
});