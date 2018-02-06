$(document).ready(
		function() {

			function show() {
				$.get("/empStar/empIndexList.json",{pageIndex:1},callBack);
				function callBack(data) {
					for (var i = 0; i < data.length; i++) {
						$("#employment_details").append("<ul><li><img src="
								+ data[i].picPath + "></li><li><p>"
								+ data[i].content + "</p></li></ul>")
					}
				}
			}
			show();
			
		})