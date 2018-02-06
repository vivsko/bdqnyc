<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/header.jsp"%>
<%@taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<%@taglib uri="http://cksource.com/ckfinder" prefix="ckfinder"%>
<div class="clearfix"></div>
<div class="row">
  <div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
      <div class="x_title">
        <h2>新增师资基础信息 <i class="fa fa-user"></i><small><%-- ${devUserSession.devName} --%></small></h2>
             <div class="clearfix"></div>
      </div>
      <div class="x_content">
           <div class="clearfix"></div>
        <form class="form-horizontal form-label-left" action="${pageContext.request.contextPath }/empStar/sys/addEmpStar" method="post" enctype="multipart/form-data">
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">标题<span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="softwareName" class="form-control col-md-7 col-xs-12" 
               data-validate-length-range="20" data-validate-words="1" name="title"  required="required"
               placeholder="请输入标题" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">来源<span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="APKName" class="form-control col-md-7 col-xs-12" 
              	data-validate-length-range="20" data-validate-words="1" name="profile"   required="required"
              	placeholder="请输入就业明星信息" type="text">
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">主要内容 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <!-- <input id="supportROM" class="form-control col-md-7 col-xs-12" name="content" 
              	data-validate-length-range="20" data-validate-words="1"   required="required"
              	placeholder="请输入主要内容" type="text"> -->
    		  <textarea id="content"  rows="8" cols="52" name="content"></textarea>
    		  <ckeditor:replace replace="content" basePath="/statics/ext/ckeditor/"></ckeditor:replace>
    		  <ckfinder:setupCKEditor basePath="/statics/ext/ckfinder/" editor="content"/>
            </div>
          </div>
          <div class="ln_solid"></div>
          <div class="form-group">
            <div class="col-md-6 col-md-offset-3">
              <button id="send" type="submit" class="btn btn-success">保存</button>
              <button type="button" class="btn btn-primary" id="back">返回</button>
              <br/><br/>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
<script src="${pageContext.request.contextPath }/statics/localjs/empStarview.js"></script>
