<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/header.jsp"%>
<div class="clearfix"></div>
  <div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
      <div class="x_title">
        <h2>查看师资信息 <i class="fa fa-user"></i><small>${devUserSession.devName}</small></h2>
             <div class="clearfix"></div>
      </div>
      <div class="x_content1">
        <form method="post" action="${pageContext.request.contextPath}/teacher/sys/teacherList.html">
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="textarea">主要内容 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">${teacherById.content}</div>
          </div>
		      <div class="form-group">
		        <div class="col-md-6 col-md-offset-3">
		          <input type="submit" class="btn btn-primary" value="返回"/>
		        </div>
		      </div>
        </form>
        </div>		
    <div class="clearfix"></div>
    <br/><br/>
  </div>
</div>
<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
<script src="${pageContext.request.contextPath }/statics/localjs/appinfoview.js"></script>