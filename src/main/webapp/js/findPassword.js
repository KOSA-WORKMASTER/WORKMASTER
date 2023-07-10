let stage = 0;
let stageLength = $(".find-password-stage").length;
$(".nextstage").each((i, e) => {
    $(e).click(() => {
        stage++;
        $(".find-password-stage-wrapper").css({
            transform: `translateX(${-33.3 * (stage % stageLength)}%)`
        });
    });
});
$(".prevstage").each((i, e) => {
    $(e).click(() => {
        stage--;
        $(".find-password-stage-wrapper").css({
            transform: `translateX(${-33.3 * (stage % stageLength)}%)`
        });
    });
});