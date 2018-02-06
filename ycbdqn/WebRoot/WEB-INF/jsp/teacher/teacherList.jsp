<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">
	<div class="col-md-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					师资信息管理维护 <i class="fa fa-user"></i><small>${devUserSession.devName}
						- 您可以通过搜索或者其他的筛选项对师资的信息进行新增、删除、查看等管理操作。^_^</small>
				</h2>
				<div class="clearfix"></div>
			</div>
	</div>
</div>
<div class="col-md-12 col-sm-12 col-xs-12">
	<div class="x_panel">
		<div class="x_content">
			<p class="text-muted font-13 m-b-30"></p>
			<div id="datatable-responsive_wrapper"
				class="dataTables_wrapper form-inline dt-bootstrap no-footer">
				<div class="row">
					<div class="col-sm-12">
					<a href="${pageContext.request.contextPath}/teacher/sys/addTeacherInfo.html" class="btn btn-success btn-sm">新增基础信息</a>
						<table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap dataTable no-footer dtr-inline collapsed"
							cellspacing="0" width="100%" role="grid" aria-describedby="datatable-responsive_info" style="width: 100%;">
							<thead>
								<tr role="row">
									<th class="sorting_asc" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="First name: activate to sort column descending"
										aria-sort="ascending">编号</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										标题</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										人物简介</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										主要内容</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										LOGO图片</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										创建时间</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="list" items="${teacherList }" varStatus="status">
									<tr role="row" class="odd">
										<td tabindex="0" class="sorting_1">${list.uuid }</td>
										<td>${list.title}</td>
										<td>${list.profile}</td>
										<td><a href="${pageContext.request.contextPath}/teacher/sys/teacherById.html?uuid=${list.uuid}">查看</a></td>
										<td>${list.picPath}</td>
										<td>${list.createTimeView}</td>
										<td>
					<a href="${pageContext.request.contextPath}/teacher/sys/deleteTeacher.html?uuid=${list.uuid}" data-toggle="tooltip" data-placement="top" title="" data-original-title="删除基础信息">删除</a>					
										
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-5">
						<div class="dataTables_info" id="datatable-responsive_info"
							role="status" aria-live="polite">共${totalCount }条记录
							${currentPageNo }/${totalPageCount }页</div>
					</div>
					<div class="col-sm-7">
						<div class="dataTables_paginate paging_simple_numbers"
							id="datatable-responsive_paginate">
							<ul>
								<c:if test="${currentPageNo > 1}">
									<a href="${pageContext.request.contextPath }/teacher/sys/teacherList.html?pageIndex=1">首页</a>
									<a href="${pageContext.request.contextPath }/teacher/sys/teacherList.html?pageIndex=${currentPageNo-1}">上一页</a>
								</c:if>
								<c:if test="${currentPageNo < totalPageCount }">
									<a href="${pageContext.request.contextPath }/teacher/sys/teacherList.html?pageIndex=${currentPageNo+1}">下一页</a>
									<a href="${pageContext.request.contextPath }/teacher/sys/teacherList.html?pageIndex=${totalPageCount }">最后一页</a>
								</c:if>
							</ul>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>
</div>
<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
<script src="${pageContext.request.contextPath }/statics/localjs/rollpage.js"></script>
<script src="${pageContext.request.contextPath }/statics/localjs/appinfolist.js"></script>