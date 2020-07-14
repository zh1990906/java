<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%	
	//获取项目名
	String path = request.getContextPath();
	pageContext.setAttribute("path", path);
	//获取tomcat 协议+地址+端口号+ 获取项目名
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	//获取tomcat 协议+地址+端口号
	String imgPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品信息</title>
<link href="<%=basePath %>admin/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>admin/js/jquery.js"></script>

<script type="text/javascript">
//添加商品界面
	function add_goods(){
		location.href="${path}/productServlet?method=addProductUI";
	}
	function batchDelete() {
		//1.获取选中的复选框
    	$obj = $("tbody").find("input:checkbox:checked");// -数组集合
    	//alert("123");
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
        	location.href="${path}/productServlet?method=adminbatchDeleteByid&"+ids;
        	//alert("${path}/productServlet?method=adminbatchDeleteByid&"+ids);
    	}
	}
</script>
</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">商品管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        
        
        <li style="cursor: pointer;" onclick="batchDelete()"><span><img src="${path}/admin/images/t03.png" /></span>批量删除</li>
        </ul>

    </div>
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input type="checkbox" value=""/></th>
        <th>序号<i class="sort"><img src="${path}/admin/images/px.gif" /></i></th>
        <th>商品类别</th>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>简介</th>
       	<th>商品展示图</th>
       	<th>使用程度</th>
       	<th>购买日期</th>
       	<th>上传用户</th>
       	<th>操作</th>
        </tr>
        </thead>
        <tbody>
         	<!-- 商品信息 -->
         	<c:forEach items="${list}" var="p">
         		<tr>
         			<td><input type="checkbox" value="pid=${p.pid}"/></td>
         			<td>${p.pid}</td>
         			<td>${p.category.cname}</td>
         			<td>${p.pname}</td>
         			<td>${p.price}</td>
         			<td>${p.description}</td>
         			<td>
         				<img src="/${p.pic}" height="50px"/>
         			</td>
         			<td>
         				<c:if test="${p.state==0}">全新产品</c:if>
         				<c:if test="${p.state==1}">九成新</c:if>
         				<c:if test="${p.state==2}">八成新</c:if>
         				<c:if test="${p.state==3}">五成新</c:if>
         				<c:if test="${p.state==4}">三成新</c:if>
         			</td>
         			<td>${p.createTime}</td>
         			<td>${p.uid}</td>
         			<td>
         				<a href="${path}/productServlet?method=admindeleteProductByid&pid=${p.pid}" style="color:red;">删除×</a>&nbsp;&nbsp;&nbsp;&nbsp;
	        			<a href="${path}/productServlet?method=updateProductUI&pid=${p.pid}" style="color:blue;">修改★</a>
         			</td>
         		</tr>
         	</c:forEach>
        </tbody>
    </table>
    <!-- 分页信息 -->
    <div class="pagin">
    	<div class="message">共<i class="blue">${pageUtils.rows}</i>条记录，当前显示第&nbsp;<i class="blue">${pageUtils.curPage}&nbsp;</i>页</div>
        <ul class="paginList">
	         <li class="paginItem"><a href="${path}/productServlet?method=queryProductByPage&curPage=1">首页</a></li>
	         <li class="paginItem"><a href="${path}/productServlet?method=queryProductByPage&curPage=${pageUtils.prevPage}">上一页</a></li>
	         <li class="paginItem"><a href="${path}/productServlet?method=queryProductByPage&curPage=${pageUtils.nextPage}">下一页</a></li>
	         <li class="paginItem"><a href="${path}/productServlet?method=queryProductByPage&curPage=${pageUtils.totalPage}">尾页</a></li>
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
