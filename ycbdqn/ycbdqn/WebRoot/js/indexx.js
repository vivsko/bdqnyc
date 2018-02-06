
$(function () {
    $("#logo_right li").hover(function () {
        $(this).find("div").show();

        $(this).css("color","red");
    },function () {
        $(this).find("div").hide();

        $(this).css("color","black");

    })
})

$(function () {
    $("#logo_right li a").hover(function () {
        $(this).css("color","red");
    },function () {
        $(this).css("color","black");
    })
})
