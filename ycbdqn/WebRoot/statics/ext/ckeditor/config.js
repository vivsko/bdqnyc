/*
Copyright (c) 2003-2013, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function(config) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	config.language = 'zh-cn';
	//上传文件时浏览服务文件夹
	config.filebrowserBrowseUrl = '/statics/ext/ckfinder/ckfinder.html';
	 //上传图片时浏览服务文件夹
	config.filebrowserImageBrowseUrl = '/statics/ext/ckfinder/ckfinder.html?type=Images';
	config.filebrowserFlashBrowseUrl = '/statics/ext/ckfinder/ckfinder.html?type=Flash';
	//上传文件按钮(标签)
	config.filebrowserUploadUrl = '/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files';
	//上传图片按钮(标签)
	config.filebrowserImageUploadUrl = '/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images';
	config.filebrowserFlashUploadUrl = '/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash';
	config.filebrowserWindowWidth = '600';
	config.filebrowserWindowHeight = '600';
	// 编辑器样式，有三种：'kama'（默认）、'office2003'、'v2'
	config.skin = 'v2';
	// 工具栏（基础'Basic'、全能'Full'、自定义）plugins/toolbar/plugin.js
	config.toolbar = 'Full';
	// 用空格替换预览中的英文
	config.image_previewText = ' ';

};
