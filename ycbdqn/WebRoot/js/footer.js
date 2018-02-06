$(function () {
    $("[type='submit']").click(function () {
        var u = document.getElementById("userName");
        if(u.validity.valueMissing==true){
            u.setCustomValidity("用户名不能为空字段，重新填写");
        }else if(u.validity.patternMismatch==true){
            u.setCustomValidity("请输入合法的用户名,中文汉字");
        }else{
            u.setCustomValidity("");
        }


        var t = document.getElementById("telephone");
        if (t.validity.valueMissing == true) {
            t.setCustomValidity("此字段为必填项，请勿空白");
        } else if (t.validity.patternMismatch == true) {
            t.setCustomValidity("手机号格式为13.15.17.18开头的11位数");
        } else {
            t.setCustomValidity("");
        }


        var q = document.getElementById("QQ");
        if (q.validity.valueMissing == true) {
            q.setCustomValidity("此字段为必填项，请勿空白");
        } else if (q.validity.patternMismatch == true) {
            q.setCustomValidity("请输入正确的QQ号码");
        } else {
            q.setCustomValidity("");
        }

        var e = document.getElementById("em");
        if (e.validity.valueMissing == true) {
            e.setCustomValidity("此字段为必填项，请勿空白");
        } else if (e.validity.patternMismatch == true) {
            e.setCustomValidity("请输入正确的邮箱格式");
        } else {
            e.setCustomValidity("");
        }
    });
    $("#send").click(function(){
    	var userName = $("#userName").val();
    	var telephone = $("#telephone").val();
    	var QQ = $("#QQ").val();
    	var em = $("#em").val();
    	if(userName != '' && userName != null){
    		$.ajax({
    			type:"POST",//请求类型
    			url:"/CustomerCard/addcustomercard.json",//请求的url
    			data:{name:userName,tele:telephone,qq:QQ,email:em},//请求参数
    			dataType:"json",//ajax接口（请求url）返回的数据类型
    			success:function(data){//data：返回数据（json对象）
    				if(data.resultMsg == "success"){
    					alert("恭喜您，成功添加用户体验卡！！！");
    				}else if(data.resultMsg == "error"){
    					alert("添加用户体验卡失败，请重新添加！！！");
    				}
    			}
    		});
    	}else{
    		alert("姓名不能为空！！");
    	}
    });
})