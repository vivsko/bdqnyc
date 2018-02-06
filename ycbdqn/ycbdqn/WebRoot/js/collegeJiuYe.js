$(document)
		.ready(
				function() {
					function show() {
						var url = location.search; // 获取url中"?"符后的字串
						if (url.indexOf("?") != -1) { // 判断是否有参数
							var str = url.substr(1); // 从第一个字符开始 因为第0个是?号
														// 获取所有除问号的所有符串
							strs = str.split("="); // 用等号进行分隔 （因为知道只有一个参数
													// 所以直接用等号进分隔 如果有多个参数 要用&号分隔
													// 再用等号进行分隔）
							/*alert(strs[1]);*/// 直接弹出第一个参数 （如果有多个参数 还要进行循环的）
						}

						$.get("/empStar/empList.json", {
							pageIndex : strs[1]
						}, callBack);
						function callBack(data) {
							var list = data["empList"];
							for (var i = 0; i < list.length; i++) {
								$(".ListOne")
										.append(
												"<li> <img src="
														+ list[i].picPath
														+ ">"
														+ "<div><h3>"
														+ list[i].title
														+ "</h3><p><span class='TheTime'>"
														+ list[i].createTime
														+ "</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>来源：盐城北大青鸟</span></p><p>"
														+ list[i].profile
														+ "</p></li>")

							}
							var pages = data["pages"];
							/*alert(pages.currentPageNo);*/
							/*$("#pages")
									.append(
											"<ul class='ListThird'><c:if test='${pages.currentPageNo > 1}'><li class='paginate_button previous'><a href='/Bdqn/ycbdqn21/jiuyexueyuan.html?pageIndex=1' aria-controls='datatable-responsive' data-dt-idx='0' tabindex=0'>首页</a></li><li class='paginate_button'><a href='/Bdqn/ycbdqn21/jiuyexueyuan.html?pageIndex="
													+ (pages.currentPageNo - 1)
													+ "' aria-controls='datatable-responsive' data-dt-idx='1' tabindex='0'>上一页</a></li></c:if><c:if test='${pages.currentPageNo < pages.totalPageCount }'><li class='paginate_button'><a href='/Bdqn/ycbdqn21/jiuyexueyuan.html?pageIndex="
													+ (pages.currentPageNo + 1)
													+ "' aria-controls='datatable-responsive' data-dt-idx='1' tabindex='0'>下一页</a></li><li class='paginate_button next'><a href='/Bdqn/ycbdqn21/jiuyexueyuan.html?pageIndex="
													+ pages.totalPageCount
													+ "' aria-controls='datatable-responsive' data-dt-idx='7' tabindex='0'>最后一页</a></li></c:if></ul>");*/
							
							if(pages.currentPageNo>1){
								$("#pages")
								.append("&lt;&lt;<a href='/jiuyexueyuan.html?pageIndex="+(pages.currentPageNo-1)+"'>上一页</a>");
							}
							if(pages.currentPageNo<pages.totalPageCount){
								$("#pages")
								.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='/jiuyexueyuan.html?pageIndex="+(pages.currentPageNo+1)+"'>下一页</a>&gt;&gt;");
							}

						}
					}
					show();

				})
