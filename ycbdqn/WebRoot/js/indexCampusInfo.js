$(document)
		.ready(
				function() {
					/* alert("进入"); */

					function show() {
						$
								.ajax({
									type : "GET",
									url : "/CampusInformation/campusInformationList.json",
									data : {},
									dataType : "json",
									success : function(data) {
										var info=data["campusInformationList"];
										for (var i = 0; i < 3; i++) {
											$("#campus_part_up").append(
													" <ul><li><img src='"
															+ info[i].picPath
															+ "'></li><li><p>"
															+ info[i].title
															+ "</p><p>"
															+ info[i].profile
															+ "</p></li></ul>");
										}
										
										for (var j = 3; j < 6; j++) {
											$("#campusDown").append(
													"<li><p>"+info[j].title+"</p><p>"+info[j].content+"</p></li>");
										}
										
									}
								})
					}
					show();
				})