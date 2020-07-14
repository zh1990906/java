<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	    String path = request.getContextPath();
		pageContext.setAttribute("path", path);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>选择登录方式</title>
<script type="text/javascript">
	function gouwu(){
		location.href = "${path}/user/login.jsp";
	}
    
	function chushou(){
		location.href = "${path}/usersell/login.jsp";
	}
 
</script>
</head>
<body bgcolor="#00BFFF">
	<div align="center">
		<img alt="" src="${path }/img/chushou.png" with="200px" height="200px" id="chushou" onclick="chushou()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<img alt="" src="${path }/img/gouwu.png" with="200px" height="200px" onclick="gouwu()">
	</div> 
</body>
</html>