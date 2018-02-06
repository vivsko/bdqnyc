var index =2;
$(function () {
    timer = setInterval(function () {
        $("#campus_environment_roll_img img:eq(0)").appendTo("#campus_environment_roll_img")
        if(index==-1){
            index=2;
        }
        $("#tabs li").eq(index).css("background","#d3d3d3").siblings().css("background","white");
        index--;
    },1000);
    $("#campus_environment_roll_img img").hover(function () {
        clearInterval(timer)
        $(this).css("transform","scale(1.1)");
        var index = $(this).index();
        $("#tabs li").eq(index).css("background","#d3d3d3").siblings().css("background","white");
    },function () {
        $(this).css("transform","scale(1.0)");
        timer = setInterval(function () {
            $("#campus_environment_roll_img img:eq(0)").appendTo("#campus_environment_roll_img")
            if(index==-1){
                index=2;
            }
            $("#tabs li").eq(index).css("background","#d3d3d3").siblings().css("background","white");
            index--;

        },1000);
    });
});

$(document).ready(function(){
	//初始化获取校园环境信息
	function getSchoolLife() {
		$.ajax({
			type:"GET",//请求类型
			url:"/school/getSchoolEnv.json",//请求的url
			data:{},//请求参数
			dataType:"json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				var $school_env_pic=$("#campus_environment_roll_img").empty();
				for(var i = 0; i < data.length; i++){
					$school_env_pic.append("<img src=\""+data[i].picPath+"\"/>");
					if(i==2){
						break;
					}
				}
			}
		});
	}
	getSchoolLife();
});

