$(function() {
	function teacherCheck(){
		var pageIndexStr=document.getElementById("pageIndex").value;
		var pageIndex = parseInt(pageIndexStr);
		$.ajax({
			type:"GET",
			url:"/teacher/teacherJSONList.json",
			data:{"pageIndex":pageIndex},
			dataType:"json",
			success:function(data){
				var teacherList = data["teacherList"];
				var pages = data["pages"];
				var listOne = document.querySelector(".ListOne");
				for (var i = 0; i < teacherList.length; i++) {
					var time = teacherList[i].createTime;
					var date = new Date();
					date.setTime(time);
					var year = date.getFullYear();
					var month = date.getMonth();
					var day = date.getDate();
					var time2 = year + "-" + (month + 1) + "-" + day;
					
					var liEle = document.createElement("li");
					var imgEle = document.createElement("img");
					var divEle = document.createElement("div");
					imgEle.setAttribute("src", teacherList[i].picPath);
					liEle.appendChild(imgEle);
					liEle.appendChild(divEle);
					var h3Ele = document.createElement("h3");
					h3Ele.innerHTML = teacherList[i].title;
					divEle.appendChild(h3Ele);
					var p1Ele = document.createElement("p");
					p1Ele.innerHTML = "<span class=\"TheTime\">时间："+time2+"</span>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>来源：盐城北大青鸟</span>";
					var p2Ele = document.createElement("p");
					p2Ele.innerHTML = teacherList[i].content;
					p2Ele.className = "pThree";
					divEle.appendChild(p1Ele);
					divEle.appendChild(p2Ele);
					listOne.appendChild(liEle);
				}
				var $pagelist=$(".PartTail").empty();
				$pagelist.append("<input type=\"hidden\" name=\"pageIndex\" id=\"pageIndex\" value=\""+pages.currentPageNo+"\"/>");
						if(pages.currentPageNo>1){
							$pagelist.append("&lt;&lt;<a onclick=\"teacherPrePage()\">上一页</a>&gt;&gt;");
						}
						if(pages.currentPageNo<pages.totalPageCount){
							$pagelist.append("&lt;&lt;<a onclick=\"teacherNextPage()\">下一页</a>&gt;&gt;");
						}
			}
		});
	}
	teacherCheck();	
});

function teacherNextPage() {
	function nextPage(){
		var pageIndexStr=document.getElementById("pageIndex").value;
		var pageIndex = parseInt(pageIndexStr);
		$.ajax({
			type:"GET",
			url:"/teacher/teacherJSONList.json",
			data:{"pageIndex":pageIndex+1},
			dataType:"json",
			success:function(data){
				var teacherList = data["teacherList"];
				var pages = data["pages"];
				$(".ListOne").empty();
				var listOne = document.querySelector(".ListOne");
				for (var i = 0; i < teacherList.length; i++) {
					var time = teacherList[i].createTime;
					var date = new Date();
					date.setTime(time);
					var year = date.getFullYear();
					var month = date.getMonth();
					var day = date.getDate();
					var time2 = year + "-" + (month + 1) + "-" + day;
					
					
					var liEle = document.createElement("li");
					var imgEle = document.createElement("img");
					var divEle = document.createElement("div");
					imgEle.setAttribute("src", teacherList[i].picPath);
					liEle.appendChild(imgEle);
					liEle.appendChild(divEle);
					var h3Ele = document.createElement("h3");
					h3Ele.innerHTML = teacherList[i].title;
					divEle.appendChild(h3Ele);
					var p1Ele = document.createElement("p");
					p1Ele.innerHTML = "<span class=\"TheTime\">时间："+time2+"</span>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>来源：盐城北大青鸟</span>";
					var p2Ele = document.createElement("p");
					p2Ele.innerHTML = teacherList[i].content;
					p2Ele.className = "pThree";
					divEle.appendChild(p1Ele);
					divEle.appendChild(p2Ele);
					listOne.appendChild(liEle);
				}
				var $pagelist=$(".PartTail").empty();
				$pagelist.append("<input type=\"hidden\" name=\"pageIndex\" id=\"pageIndex\" value=\""+pages.currentPageNo+"\"/>");
						if(pages.currentPageNo>1){
							$pagelist.append("&lt;&lt;<a onclick=\"teacherPrePage()\">上一页</a>&gt;&gt;");
						}
						if(pages.currentPageNo<pages.totalPageCount){
							$pagelist.append("&lt;&lt;<a onclick=\"teacherNextPage()\">下一页</a>&gt;&gt;");
						}
			}
		});
	}
	nextPage();
}
function teacherPrePage() {
	function prePage(){
		var pageIndexStr=document.getElementById("pageIndex").value;
		var pageIndex = parseInt(pageIndexStr);
		$.ajax({
			type:"GET",
			url:"/teacher/teacherJSONList.json",
			data:{"pageIndex":pageIndex-1},
			dataType:"json",
			success:function(data){
				var teacherList = data["teacherList"];
				var pages = data["pages"];
				$(".ListOne").empty();
				var listOne = document.querySelector(".ListOne");
				for (var i = 0; i < teacherList.length; i++) {
					var time = teacherList[i].createTime;
					var date = new Date();
					date.setTime(time);
					var year = date.getFullYear();
					var month = date.getMonth();
					var day = date.getDate();
					var time2 = year + "-" + (month + 1) + "-" + day;
					
					
					var liEle = document.createElement("li");
					var imgEle = document.createElement("img");
					var divEle = document.createElement("div");
					imgEle.setAttribute("src", teacherList[i].picPath);
					liEle.appendChild(imgEle);
					liEle.appendChild(divEle);
					var h3Ele = document.createElement("h3");
					h3Ele.innerHTML = teacherList[i].title;
					divEle.appendChild(h3Ele);
					var p1Ele = document.createElement("p");
					p1Ele.innerHTML = "<span class=\"TheTime\">时间："+time2+"</span>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>来源：盐城北大青鸟</span>";
					var p2Ele = document.createElement("p");
					p2Ele.innerHTML = teacherList[i].content;
					p2Ele.className = "pThree";
					divEle.appendChild(p1Ele);
					divEle.appendChild(p2Ele);
					listOne.appendChild(liEle);
				}
				var $pagelist=$(".PartTail").empty();
				$pagelist.append("<input type=\"hidden\" name=\"pageIndex\" id=\"pageIndex\" value=\""+pages.currentPageNo+"\"/>");
						if(pages.currentPageNo>1){
							$pagelist.append("&lt;&lt;<a onclick=\"teacherPrePage()\">上一页</a>&gt;&gt;");
						}
						if(pages.currentPageNo<pages.totalPageCount){
							$pagelist.append("&lt;&lt;<a onclick=\"teacherNextPage()\">下一页</a>&gt;&gt;");
						}
			}
		});
	}
	prePage();
}







