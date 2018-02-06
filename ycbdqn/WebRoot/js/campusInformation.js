$(document)
		.ready(
				function() {
					/* alert("进入"); */

					function show() {
						var url = location.search; //获取url中"?"符后的字串  
					    if (url.indexOf("?") != -1) {  //判断是否有参数  
					        var str = url.substr(1); //从第一个字符开始 因为第0个是?号 获取所有除问号的所有符串  
					        strs = str.split("=");  //用等号进行分隔 （因为知道只有一个参数 所以直接用等号进分隔 如果有多个参数 要用&号分隔 再用等号进行分隔）  
					/*        alert(strs[1]); */    //直接弹出第一个参数 （如果有多个参数 还要进行循环的）  
					    } 
						$
								.ajax({
									type : "GET",
									url : "/CampusInformation/campusInformationList.json",
									data : {
										pageIndex : strs[1]
									},
									dataType : "json",
									success : function(data) {
										var info = data["campusInformationList"];
										for (var i = 0; i < info.length; i++) {
											$("#campusInformation")
													.append(
															"<li> <img src='"
																	+ info[i].picPath
																	+ "'><div><h3><a href='details.html?uuid="
																	+ info[i].uuid
																	+ "'>"
																	+ info[i].title
																	+ "</a></h3><p><span class='TheTime'>"
																	+ info[i].createTimeView
																	+ "</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>北大青鸟盐城思腾</span> </p><p class='pThree'>"
																	+ info[i].profile
																	+ " </p></div> </li>");
										}

										var pages = data["pages"];
										/*$("#pages")
												.append(
														"<ul class='ListThird'><c:if test='${"+pages.currentPageNo+" > 1}'><li class='paginate_button previous'><a href='/BdqnSys/ycbdqn21/SchoolInformation.html?pageIndex=1' aria-controls='datatable-responsive' data-dt-idx='0' tabindex='0'>首页</a></li></ul>")*/
															/*	"<li class='paginate_button'><a href='/BdqnSys/ycbdqn21/SchoolInformation.html?pageIndex="+(pages.currentPageNo-1)+"' aria-controls='datatable-responsive' data-dt-idx='1' tabindex='0'>上一页</a></li></c:if><c:if test='${"+pages.currentPageNo+" < "+pages.totalPageCount+" }'><li class='paginate_button'><a href='/BdqnSys/ycbdqn21/SchoolInformation.html?pageIndex="+(pages.currentPageNo+1)+"' aria-controls='datatable-responsive' data-dt-idx='1' tabindex='0'>下一页</a></li>" +*/
													
														if(pages.currentPageNo>1){
															$("#pages")
															.append("&lt;&lt;<a href='/SchoolInformation.html?pageIndex="+(pages.currentPageNo-1)+"'>上一页</a>");
														}
														if(pages.currentPageNo<pages.totalPageCount){
															$("#pages")
															.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='/SchoolInformation.html?pageIndex="+(pages.currentPageNo+1)+"'>下一页</a>&gt;&gt;");
														}
														
														
														/*$("#pages ul")
												.append("<li class='paginate_button next'><a href='/BdqnSys/ycbdqn21/SchoolInformation.html?pageIndex="+pages.totalPageCount+"' aria-controls='datatable-responsive' data-dt-idx='7' tabindex='0'>最后一页</a></li></c:if>");*/

									}
								})
					}
					show();
				})