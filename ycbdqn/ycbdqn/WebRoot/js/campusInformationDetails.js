$(document).ready(function(){


	
	
	function show(){
		var url = location.search; //获取url中"?"符后的字串  
	    if (url.indexOf("?") != -1) {  //判断是否有参数  
	        var str = url.substr(1); //从第一个字符开始 因为第0个是?号 获取所有除问号的所有符串  
	        strs = str.split("=");  //用等号进行分隔 （因为知道只有一个参数 所以直接用等号进分隔 如果有多个参数 要用&号分隔 再用等号进行分隔）  
	/*        alert(strs[1]); */    //直接弹出第一个参数 （如果有多个参数 还要进行循环的）  
	    }  
		$
		.ajax({
			type:"GET",
			url :"/CampusInformation/viewcampusInformation",
			data : {
				uuid : strs[1]
			},
			dataType : "json",
			success : function(data) {
					$("#detailsPart").append(" <h2>"+data.title
							+"</h2> <div class='editor'><ul><li class='li1'>"
							+ data.createTimeView+"</li> &nbsp;&nbsp;<li class='li2'>北大青鸟盐城思腾</li><li class=li3'> 分享到：</li><li class='fenxiang'><div class='bdsharebuttonbox'><a href='#' class='bds_more' data-cmd='more'></a><a href='#' class='bds_qzone' data-cmd='qzone' title='分享到QQ空间'></a><a href='#' class='bds_tsina' data-cmd='tsina' title='分享到新浪微博'></a> <a href='#' class='bds_tqq' data-cmd='tqq' title='分享到腾讯微博'></a><a href='#' class='bds_renren' data-cmd='renren' title='分享到人人网'></a><a href='#' class='bds_weixin' data-cmd='weixin' title='分享到微信'></a></div><script>window._bd_share_config={'common':{'bdSnsKey':{},'bdText':'','bdMini':'2','bdPic':'','bdStyle':'0','bdSize':'16'},'share':{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script></li></ul></div><div class='description'><img src='"
															+ data.picPath
															+ "'><p>"
							+data.content+"</p> </div>");
				
			}
		})
	}
	 show();

})