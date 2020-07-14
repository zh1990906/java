<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	pageContext.setAttribute("path", path);
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>上端显示</title>
	<link href="${path}/admin/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${path}/admin/js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>


</head>

<body style="background:url(images/topbg.gif) repeat-x;">

    <div class="topleft">
	<h6 style="color:#fff;font-size:25px;margin-top:20px;margin-left:20px">跳蚤市场后台管理系统</h6>
    </div>
        
    <ul class="nav">
    </ul>
            
    <div class="topright">    
    <ul>
    <li><a href="#">${sessionScope.admin_user.name }</a></li>
    <li><span><img src="${path}/admin/images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="${path}/user/index.jsp" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    <span>${sessionScope.session_user.name }</span>
    <i>消息</i>
    <b>0</b>
    </div>    
    
    </div>
</body>
</html>
