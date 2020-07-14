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
<title>已出售</title>
<link href="<%=basePath %>usersell/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>usersell/js/jquery.js"></script>

</head>
<body>
	 <table class="tablelist">
    	<thead>
    	<tr>
        <th><input type="checkbox" /></th>
        <th>序号<i class="sort"><img src="${path}/admin/images/px.gif" /></i></th>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>简介</th>
       	<th>商品展示图</th>
       	<th>使用程度</th>
       	<th>购买日期</th>
       	<th>操作</th>
        </tr>
        </thead>
        <tbody>
         	<!-- 商品信息 -->
         	<c:forEach items="${list}" var="p" varStatus="obj">
         		<tr>
         			<td><input type="checkbox" value="pid=${p.pid}" name="check"/></td>
         			<td>${obj.count}</td>
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
         			<td>
         				<a href="${path}/usersellServlet?method=userselldeleteProductByid&pic=${p.pic}&uid=${uid}" style="color:red;">删除×</a>&nbsp;&nbsp;&nbsp;&nbsp;
         			</td>
         		</tr>
         	</c:forEach>
        </tbody>
    </table>
    <!-- 分页信息 -->
    <div class="pagin">
    	<div class="message">共<i class="blue">${pageUtils.rows}</i>条记录，当前显示第&nbsp;<i class="blue">${pageUtils.curPage}&nbsp;</i>页</div>
        <ul class="paginList">
	         <li class="paginItem"><a href="${path}/usersellServlet?method=soldByid&curPage=1&uid=${uid}">首页</a></li>
	         <li class="paginItem"><a href="${path}/usersellServlet?method=soldByid&curPage=${pageUtils.prevPage}&uid=${uid}">上一页</a></li>
	         <li class="paginItem"><a href="${path}/usersellServlet?method=soldByid&curPage=${pageUtils.nextPage}&uid=${uid}">下一页</a></li>
	         <li class="paginItem"><a href="${path}/usersellServlet?method=soldByid&curPage=${pageUtils.totalPage}&uid=${uid}">尾页</a></li>
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