<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/header.jsp"%>

<div class="clearfix"></div>
<div class="row">
	<div class="col-md-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					校园生活维护 <i class="fa fa-user"></i><small>${devUserSession.devName}
						- 您可以通过搜索或者其他的筛选项对校园生活的信息进行修改、删除等管理操作。^_^</small>
				</h2>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<form method="post" action="list">
					<input type="hidden" name="pageIndex" value="1" />
			    <ul>
				</ul>
			</form>
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
					<a href="${pageContext.request.contextPath}/schoollife/sys/add.html" class="btn btn-success btn-sm">新增校园生活信息</a>
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
									logo图片</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										创建日期</th>
									
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										style="width: 124px;"
										aria-label="Last name: activate to sort column ascending">
										操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="schoollife" items="${sList }" varStatus="status">
									<tr role="row" class="odd">
										<td tabindex="0" class="sorting_1">${schoollife.uuid}</td>
										<td>${schoollife.title }</td>
										<td>${schoollife.profile }</td>
										<td><a href="${pageContext.servletContext.contextPath}/schoollife/sys/checkSchoolLife.html?uuid=${schoollife.uuid}">查看</a></td>
										<td>${schoollife.picPath }</td>
										<td>${schoollife.createTimeView }</td>
										<td>
										
										<div class="btn-group">
                      <button type="button" class="btn btn-danger">点击操作</button>
                      <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                        <span class="caret"></span>
                        <span class="sr-only">Toggle Dropdown</span>
                      </button>
                      <ul class="dropdown-menu" role="menu">
                        <%-- <li><a href="${pageContext.servletContext.contextPath}/schoollife/"
											data-toggle="tooltip" data-placement="top" title="" data-original-title="修改校园生活信息">修改</a></li>
                        <li><a data-toggle="tooltip" data-placement="top" title="" data-original-title="查看校园生活信息">查看</a></li> --%>
						<li><a href="${pageContext.servletContext.contextPath}/schoollife/sys/delschoollife.html?uuid=${schoollife.uuid}" data-toggle="tooltip" data-placement="top" title="" data-original-title="删除校园生活信息">删除</a></li>
                      </ul>
                    </div>
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
							<input type="hidden" id="pageIndex" name="pageIndex" value="${currentPageNo}"/>
							<p>
								<c:if test="${currentPageNo > 1}">
									<a class="page" href="${pageContext.servletContext.contextPath}/schoollife/sys/schoollifelist.html?pageIndex=1">首页</a>&nbsp;
									<a class="page" href="${pageContext.servletContext.contextPath}/schoollife/sys/schoollifelist.html?pageIndex=${currentPageNo-1}">上一页</a>&nbsp;
								</c:if>
								<c:if test="${currentPageNo < totalPageCount}">
									<a class="page" href="${pageContext.servletContext.contextPath}/schoollife/sys/schoollifelist.html?pageIndex=${currentPageNo+1}">下一页</a>
									<a class="page" href="${pageContext.servletContext.contextPath}/schoollife/sys/schoollifelist.html?pageIndex=${totalPageCount}">末页</a>
								</c:if>
							</p>
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