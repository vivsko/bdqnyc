<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">
  <div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
      <div class="x_title">
        <h2>查看新闻信息 <i class="fa fa-user"></i><small></small></h2>
             <div class="clearfix"></div>
      </div>
      <div class="x_title">
            <h2>新闻信息</h2>
          <div class="clearfix"></div>
      </div>
      <div class="x_content1">
        <form class="form-horizontal form-alabel-left" >
          <input type="hidden" name="id" value="${empStar.uuid}">
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">新闻标题 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input class="form-control col-md-7 col-xs-12" value="${empStar.title}" 
              type="text" readonly="readonly">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">作者<span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="text" class="form-control col-md-7 col-xs-12" 
              value="${empStar.profile}" readonly="readonly">
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">内容<span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input class="form-control col-md-7 col-xs-12" 
              	value="${empStar.content}" type="text" readonly="readonly">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">图片地址<span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input class="form-control col-md-7 col-xs-12" readonly="readonly"
              	value="${empStar.picPath}" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">创建时间<span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="text" value="${empStar.createTimeView}"
              class="form-control col-md-7 col-xs-12" readonly="readonly">
            </div>
          </div>
           <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">图片 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
			 <c:choose> 
				  <c:when test="${empStar.picPath == null || empStar.picPath == ''}">   
				    	暂无
				  </c:when> 
				  <c:otherwise>   
				    <img src="${empStar.picPath }?m=1" width="100px;"/> 
				  </c:otherwise> 
              </c:choose> 
            </div>
          </div>
        </form>
        </div>
        <div class="clearfix"></div>
        <div class="x_content" style="display: block;">
         <br>
        <div id="datatable-responsive_wrapper"
			class="dataTables_wrapper form-inline dt-bootstrap no-footer">
			<div class="row">
				<div class="col-sm-12">
				</div>
			</div>
      </div>
    </div>
     <div class="form-group">
        <div class="col-md-6 col-md-offset-3">
          <button type="button" class="btn btn-primary" id="back">返回</button>
        </div>
      </div>
    <div class="clearfix"></div>
    <br/><br/>
  </div>
</div>
<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
<script src="${pageContext.request.contextPath }/statics/localjs/empStarview.js"></script>