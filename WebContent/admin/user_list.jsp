<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%	
	//获取项目名
	String path = request.getContextPath();
    pageContext.setAttribute("path", path);
	//获取tomcat 协议+地址+端口号+ 获取项目名
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户信息</title>
<link href="<%=basePath %>admin/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>admin/js/jquery.js"></script>

<script type="text/javascript">
     //单个删除
	function del(id){
		if(confirm("确认删除吗?")){
			location.href="${path}/userServlet?method=deleteUserById&uid="+id;
		}
	}
     //批量删除
     function batchDelete(){
    	 //1.获取选中的复选框
    	$obj = $("tbody").find("input:checkbox:checked");// -数组集合
    	 //alert($obj.length);
    	if($obj.length<=1){
    		alert("至少选中2个");
    	}else{
    		var arr = new Array();//声明数组
        	$obj.each(function(i,dom){ //i循环变量(正在被遍历的对象的下标)  dom:正在被遍历的对象
        		//alert($(dom).val());
        		arr[i] = $(dom).val();//将复选框中的值放入数组
        	});
        	var ids = arr.join("&");
        	//alert(ids);
        	//发送批量删除的请求
        	location.href="${path}/userServlet?method=batchDeleteUser&"+ids;
        	//alert("${path}/userServlet?method=batchDeleteUser&"+ids);
    	}
     }
</script>
</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">用户管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        
   
        <li style="cursor: pointer;" onclick="batchDelete()"><span><img src="<%=basePath %>admin/images/t03.png" /></span>批量删除</li>
        </ul>

    </div>
    <table class="tablelist">
    	<thead>
	    	<tr>
		        <th><input  type="checkbox" /></th>
		        <th>序号<i class="sort"><img src="<%=basePath %>admin/images/px.gif" /></i></th>
		        <th>姓名</th>
		        <th>性别</th>
		        <th>电话号码</th>
		        <th>所在地区</th>
		        <th>账号</th>
		       	<th>操作</th>
	        </tr>
	        </thead>
        <tbody>
        	<!-- 显示用户信息 -->
        	<c:forEach items="${list}" var="user" varStatus="obj">
        		<tr>
        			<td><input type="checkbox" value="uid=${user.uid}"/></td>
        			<td>${obj.count}</td>
        			<td>${user.uname}</td>
        			<td>
        				<c:if test="${user.sex==1}">男</c:if>
        				<c:if test="${user.sex==0}">女</c:if>
        			</td>
        			<td>${user.tel}</td>
        			<td>${user.area}</td>
        			<td>${user.username}</td>
        			<td>
        				<a href="#" onclick="del(${user.uid})" style="color:red;">删除×</a>
        			</td>
        		</tr>
        	</c:forEach>
        	
        </tbody>
    </table>
   <!-- 分页信息 -->
    <div class="pagin">
    	<div class="message">共<i class="blue">${pageUtils.rows}</i>条记录，当前显示第&nbsp;<i class="blue">${pageUtils.curPage}&nbsp;</i>页</div>
        <ul class="paginList">
	         <li class="paginItem"><a href="<%=basePath%>userServlet?method=queryUserByPage&curPage=1">首页</a></li>
	         <li class="paginItem"><a href="<%=basePath%>userServlet?method=queryUserByPage&curPage=${pageUtils.prevPage}">上一页</a></li>
	         <li class="paginItem"><a href="<%=basePath%>userServlet?method=queryUserByPage&curPage=${pageUtils.nextPage}">下一页</a></li>
	         <li class="paginItem"><a href="<%=basePath%>userServlet?method=queryUserByPage&curPage=${pageUtils.totalPage}">尾页</a></li>
        </ul>
    </div>
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
