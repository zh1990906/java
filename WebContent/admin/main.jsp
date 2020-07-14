<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
	String path = request.getContextPath();
    pageContext.setAttribute("path", path);
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

	%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>网站后台管理系统</title>
</head>
<c:if test="${user!=null}">
<!-- 将连接的jsp页面都使用绝对路径 -->
	<frameset rows="88,*" cols="*" frameborder="no" border="0" framespacing="0">
	  <frame src="<%=basePath %>admin/top.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" title="topFrame" />
	  <frameset cols="187,*" frameborder="no" border="0" framespacing="0">
	    <frame src="<%=basePath %>admin/left.jsp" name="leftFrame" scrolling="no" noresize="noresize" id="leftFrame" title="leftFrame" />
	    <frame src="<%=basePath %>admin/index.jsp" name="rightFrame" id="rightFrame" title="rightFrame" />
	  </frameset>
	</frameset>
	<noframes>
	</noframes>
</c:if>
<c:if test="${user==null}">
	<jsp:forward page="login.jsp"></jsp:forward>
</c:if>
</html>
