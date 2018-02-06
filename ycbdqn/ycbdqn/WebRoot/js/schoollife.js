$(document).ready(function() {
	//初始化获取校园生活信息
    function getSchoolLife() {
		$.ajax({
			type:"GET",//请求类型
			url:"/schoollife/getSchoollife.json",//请求的url
			data:{},//请求参数
			dataType:"json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				var $school_life_pic=$("#school_life_pic_ul").empty();
				for(var i = 0; i < data.length; i++){
					$school_life_pic.append("<li><img src=\""+data[i].picPath+"\"></li>");
					if (i==5) {
						break;
					}
				}
			}
		});
	}
    getSchoolLife();
})