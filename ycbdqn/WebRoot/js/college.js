$(document).ready(function(){
	function show(){
		$.get("/empStar/empIndexList.json",{pageIndex:1},callBack);
		function callBack(data){
			for(var i=0;i<data.length;i++){
				$("#empStar").append(
						"<li><img src="+data[i].picPath+"><p>"+data[i].content+"</p></li>")
			}
		}
	}
	show();
	//跳转页面 查看更多
	
})

