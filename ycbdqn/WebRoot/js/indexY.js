
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


var index=0;
showtime();
function showtime(){
times =setInterval(function GoUp(){
    $("#tabs li" ).eq(index).css("background","orange").siblings().css("background","white");
    index--;
    if(index<=-3){
        index=0;
    }
    $("#campus_environment_roll").children("a").first().animate({"margin-left":-1},1000,function(){
        $("#campus_environment_roll").css("margin-left",0);
        $("#campus_environment_roll a:first").appendTo("#campus_environment_roll")
    });
},1000)
}
$(function () {


    $("#tabs li" ).hover(function(){
        index=$("#tabs li").index(this);
        $("#tabs li" ).eq(index).css("background","orange").siblings().css("background","white");
        clearInterval(times);
        $("#campus_environment_roll a img").eq(index).css("transform","scale(1.1)");

    },function () {
        showtime();
        $("#campus_environment_roll a img").eq(index).css("transform","scale(1.0)");
    });
});

