<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">
	<div class="col-md-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					就业明星表  <i class="fa fa-user"></i><small>${userSession.userName}
						- 您可以通过搜索或者其他的筛选项对就业明星表的信息进行审核操作。^_^</small>
				</h2>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
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
							<a
								href="${pageContext.request.contextPath }/empStar/sys/empadd"
								class="btn btn-success btn-sm">新增新闻</a>
							<table id="datatable-responsive"
								class="table table-striped table-bordered dt-responsive nowrap dataTable no-footer dtr-inline collapsed"
								cellspacing="0" width="100%" role="grid"
								aria-describedby="datatable-responsive_info"
								style="width: 100%;">
								<thead>
									<tr role="row">
										<th class="sorting_asc" tabindex="0"
											aria-controls="datatable-responsive" rowspan="1" colspan="1"
											aria-label="First name: activate to sort column descending"
											aria-sort="ascending">新闻编号</th>
										<th class="sorting" tabindex="0"
											aria-controls="datatable-responsive" rowspan="1" colspan="1"
											aria-label="Last name: activate to sort column ascending">
											标题</th>
										<th class="sorting" tabindex="0"
											aria-controls="datatable-responsive" rowspan="1" colspan="1"
											aria-label="Last name: activate to sort column ascending">
											来源</th>
										<th class="sorting" tabindex="0"
											aria-controls="datatable-responsive" rowspan="1" colspan="1"
											aria-label="Last name: activate to sort column ascending">
											content</th>
										<th class="sorting" tabindex="0"
											aria-controls="datatable-responsive" rowspan="1" colspan="1"
											aria-label="Last name: activate to sort column ascending">
											创建时间</th>
										<th class="sorting" tabindex="0"
											aria-controls="datatable-responsive" rowspan="1" colspan="1"
											style="width: 124px;"
											aria-label="Last name: activate to sort column ascending">
											操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="list" items="${empList}"
										varStatus="status">
										<tr role="row" class="odd">
											<td><span>${list.uuid }</span></td>
											<td><span>${list.title }</span></td>
											<td><span>${list.profile }</span></td>
											<td><span>${list.content}</span></td>
											<td><span>${list.picPath}</span></td>
											<td><span>${list.createTimeView}</span></td>
											<td>
											<a
												href="${pageContext.request.contextPath }/empStar/sys/viewEmpStar?uuid=${list.uuid}">查看</a>
											
											<a
												href="${pageContext.request.contextPath }/empStar/sys/delemp?uuid=${list.uuid}">删除</a>
											
											
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
								role="status" aria-live="polite">共${totalCount }条记录&nbsp;&nbsp;
								${currentPageNo }/${totalPageCount }页</div>
						</div>
						<div class="col-sm-7">
							<div class="dataTables_paginate paging_simple_numbers"
								id="datatable-responsive_paginate">
								<ul class="pagination">
									<c:if test="${currentPageNo > 1}">
									<li class="paginate_button previous">
									<a href="${pageContext.request.contextPath }/empStar/sys/list?pageIndex=1"
										aria-controls="datatable-responsive" data-dt-idx="0"
										tabindex="0">首页</a>
									</li>
									<li class="paginate_button ">
									<a href="${pageContext.request.contextPath }/empStar/sys/list?pageIndex=${currentPageNo-1}"
										aria-controls="datatable-responsive" data-dt-idx="1"
										tabindex="0">上一页</a>
									</li>
								</c:if>
								<c:if test="${currentPageNo < totalPageCount }">
									<li class="paginate_button ">
										<a href="${pageContext.request.contextPath }/empStar/sys/list?pageIndex=${currentPageNo+1}"
										aria-controls="datatable-responsive" data-dt-idx="1"
										tabindex="0">下一页</a>
									</li>
									<li class="paginate_button next">
									<a href="${pageContext.request.contextPath }/empStar/sys/list?pageIndex=${totalPageCount }"
										aria-controls="datatable-responsive" data-dt-idx="7"
										tabindex="0">最后一页</a>
									</li>
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
<script
	src="${pageContext.request.contextPath }/statics/localjs/rollpage.js"></script>
