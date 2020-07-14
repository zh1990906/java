<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String path = request.getContextPath();
	pageContext.setAttribute("path", path);
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品分类</title>
<link href="<%=basePath %>admin/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>admin/js/jquery.js"></script>

<script type="text/javascript">
	//单删除
	function del(id){
		if(confirm("确认删除吗?")){
			location.href="${path}/categoryServlet?method=deleteShopById&cid="+id;
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
        		
        		arr[i] = $(dom).val();//将复选框中的值放入数组
        	});
        	var ids = arr.join("&");
        	
        	location.href="${path}/categoryServlet?method=batchDeleteShop&"+ids;
        	
    	}
     }
	//添加
	function add_category(){
		location.href="${path}/category/category_add.jsp";
	}
	
</script>
</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">分类管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
	        <li style="cursor: pointer;" onclick="add_category()" id = "tianjia"><span><img src="<%=basePath %>admin/images/t01.png"  /></span>添加类别</li>
	        <li style="cursor: pointer;" onclick="batchDelete()"><span><img src="<%=basePath %>admin/images/t03.png" /></span>批量删除</li>
        </ul>

    </div>
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input  type="checkbox" /></th>
        <th>序号<i class="sort"><img src="<%=basePath %>admin/images/px.gif" /></i></th>
        <th>类别名称</th>
        <th>启用状态</th>
        <th>排序序号</th>
        <th>创建时间</th>
        <th>描述</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        	<!-- 商品类别信息 -->
        	<c:forEach items="${list}" var="c">
	        	<tr>
	        		<td><input type="checkbox" value="cid=${c.cid}"/></td>
	        		<td>${c.cid}</td>
	        		<td>${c.cname}</td>
	        		<td>
	        			<c:if test="${c.state==1}"><font style="color:green;">启用</font></c:if>
	        			<c:if test="${c.state==0}"><font style="color:red;">禁用</font></c:if>
	        		</td>
	        		<td>${c.sortNum}</td>
	        		<td>${c.createTime}</td>
	        		<td>${c.description}</td>
	        		<td>
	        			<a href="#" onclick="del(${c.cid})" style="color:red;">删除×</a>&nbsp;&nbsp;&nbsp;&nbsp;
	        			<a href="${path}/categoryServlet?method=updateCategoryUI&cid=${c.cid}" style="color:blue;">修改★</a>
	        		</td>
	        	</tr>
        	</c:forEach>
        </tbody>
    </table>
    <!-- 分页信息 -->
    <div class="pagin">
    	<div class="message">共<i class="blue">${pageUtils.rows}</i>条记录，当前显示第&nbsp;<i class="blue">${pageUtils.curPage}&nbsp;</i>页</div>
        <ul class="paginList">
	         <li class="paginItem"><a href="${path}/categoryServlet?method=queryCategoryByPage&curPage=1">首页</a></li>
	         <li class="paginItem"><a href="${path}/categoryServlet?method=queryCategoryByPage&curPage=${pageUtils.prevPage}">上一页</a></li>
	         <li class="paginItem"><a href="${path}/categoryServlet?method=queryCategoryByPage&curPage=${pageUtils.nextPage}">下一页</a></li>
	         <li class="paginItem"><a href="${path}/categoryServlet?method=queryCategoryByPage&curPage=${pageUtils.totalPage}">尾页</a></li>
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
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
