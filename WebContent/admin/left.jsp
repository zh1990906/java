<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	
	//获取项目名
	String path = request.getContextPath();
    pageContext.setAttribute("path", path);
	//获取tomcat 协议+地址+端口号+ 获取项目名
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>功能列表</title>
<link href="<%=basePath %>admin/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=basePath %>admin/js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>功能表单</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="<%=basePath %>admin/images/leftico01.png" /></span>跳蚤市场功能
    </div>
    	<ul class="menuson">
        <li class="active"><cite></cite><a href="<%=basePath %>admin/index.jsp" target="rightFrame">欢迎页面</a><i></i></li>
        <li><cite></cite><a href="${path}/userServlet?method=queryUserByPage" target="rightFrame">用户管理</a><i></i></li>
        <li><cite></cite><a href="${path}/categoryServlet?method=queryCategoryByPage" target="rightFrame" id="shop">商品类别管理</a><i></i></li>
        <li><cite></cite><a href="${path}/productServlet?method=queryProductByPage" target="rightFrame">商品管理</a><i></i></li>
        </ul>    
    </dd>
        
</body>
</html>
