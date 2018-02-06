var index =2;
$(document).ready(function(){
	function check(){
		var pageIndexStr=document.getElementById("pageIndex").value;
		var pageIndex = parseInt(pageIndexStr);
		$.ajax({
			type:"GET",//请求类型
			url:"/enterprise/enterpriseRecruitmentList",//请求的url
			data:{"pageIndex":pageIndex},//请求参数
			dataType:"json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				var $listOne=$(".ListOne").empty();
				var schoolEnvs = data["schoolEnvs"];
				var pages = data["pages"];
				for(var i = 0; i < schoolEnvs.length; i++){
					$listOne.append("<li><div >"
						+"<h3>"+schoolEnvs[i].title+"</h3>"
						+"<p class=\"pThree\">"+schoolEnvs[i].content+"</p>"
						+"<p class=\"editor\"><span>"+schoolEnvs[i].source+"</span>"
						+"<span>时间："+schoolEnvs[i].createTimeView+"</span></p></div>"
						+"</li>");
				}
				var $pagelist=$(".PartTail").empty();
				$pagelist.append("<input type=\"hidden\" name=\"pageIndex\" id=\"pageIndex\" value=\""+pages.currentPageNo+"\"/>");
						if(pages.currentPageNo>1){
							$pagelist.append("&lt;&lt;<a onclick=\"prePage()\">上一页</a>&gt;&gt;");
						}
						if(pages.currentPageNo<pages.totalPageCount){
							$pagelist.append("&lt;&lt;<a onclick=\"nextPage()\">下一页</a>&gt;&gt;");
						}
			}
		});
	}
	check();
});
function nextPage() {
	function check(){
		var pageIndexStr=document.getElementById("pageIndex").value;
		var pageIndex = parseInt(pageIndexStr);
		$.ajax({
			type:"GET",//请求类型
			url:"/enterprise/enterpriseRecruitmentList",//请求的url
			data:{"pageIndex":pageIndex+1},//请求参数
			dataType:"json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				var $listOne=$(".ListOne").empty();
				var schoolEnvs = data["schoolEnvs"];
				var pages = data["pages"];
				for(var i = 0; i < schoolEnvs.length; i++){
					$listOne.append("<li><div >"
						+"<h3>"+schoolEnvs[i].title+"</h3>"
						+"<p class=\"pThree\">"+schoolEnvs[i].content+"</p>"
						+"<p class=\"editor\"><span>"+schoolEnvs[i].source+"</span>"
						+"<span>时间："+schoolEnvs[i].createTimeView+"</span></p></div>"
						+"</li>");
				}
				var $pagelist=$(".PartTail").empty();
				$pagelist.append("<input type=\"hidden\" name=\"pageIndex\" id=\"pageIndex\" value=\""+pages.currentPageNo+"\"/>");
				if(pages.currentPageNo>1){
					$pagelist.append("&lt;&lt;<a onclick=\"prePage()\">上一页</a>&gt;&gt;");
				}
				if(pages.currentPageNo<pages.totalPageCount){
					$pagelist.append("&lt;&lt;<a onclick=\"nextPage()\">下一页</a>&gt;&gt;");
				}
			}
		});
	}
	check();
}
function prePage() {
	function check(){
		var pageIndexStr=document.getElementById("pageIndex").value;
		var pageIndex = parseInt(pageIndexStr);
		$.ajax({
			type:"GET",//请求类型
			url:"/enterprise/enterpriseRecruitmentList",//请求的url
			data:{"pageIndex":pageIndex-1},//请求参数
			dataType:"json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				var $listOne=$(".ListOne").empty();
				var schoolEnvs = data["schoolEnvs"];
				var pages = data["pages"];
				for(var i = 0; i < schoolEnvs.length; i++){
					$listOne.append("<li><div >"
						+"<h3>"+schoolEnvs[i].title+"</h3>"
						+"<p class=\"pThree\">"+schoolEnvs[i].content+"</p>"
						+"<p class=\"editor\"><span>"+schoolEnvs[i].source+"</span>"
						+"<span>时间："+schoolEnvs[i].createTimeView+"</span></p></div>"
						+"</li>");
				}
				var $pagelist=$(".PartTail").empty();
				$pagelist.append("<input type=\"hidden\" name=\"pageIndex\" id=\"pageIndex\" value=\""+pages.currentPageNo+"\"/>");
				if(pages.currentPageNo>1){
					$pagelist.append("&lt;&lt;<a onclick=\"prePage()\">上一页</a>&gt;&gt;");
				}
				if(pages.currentPageNo<pages.totalPageCount){
					$pagelist.append("&lt;&lt;<a onclick=\"nextPage()\">下一页</a>&gt;&gt;");
				}
			}
		});
	}
	check();
}




