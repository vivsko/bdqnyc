$(function () {
    $("#JQ1 img").hover(function () {
        $("#erweima ").css("display","block");
    },function () {
        $("#erweima").css("display","none");
    })
});

$(function () {
    $("#logo_right li").hover(function () {
        $(this).find("div").show();

        $(this).css("color","red");
    },function () {
        $(this).find("div").hide();
        if($(this).index()==0&&$(this).val()==1){
        }else{
            $(this).css("color","black");
        }

    })

})

$(function () {
    $("#logo_right li a").hover(function () {
        $(this).css("color","red");
    },function () {
        $(this).css("color","black");
    })
})
