<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	String path = request.getContextPath();
	pageContext.setAttribute("path", path);
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改商品</title>
<link href="<%=basePath %>admin/css/style.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript" src="<%=basePath %>admin/js/My97DatePicker/WdatePicker.js"></script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">修改商品</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>商品信息</span></div>
    
    <form action="${path}/productServlet?method=updateProduct" method="post" enctype="multipart/form-data">
	    <ul class="forminfo">
	    	 <input type="hidden"  name="pid" value="${p.pid}"/>
	    	 <!-- 商品分类信息 -->
	    	 <li>
	    	 	<label>商品分类</label>
	    	 	<select name="cid" class="dfinput">
	    	 		<c:forEach items="${clist}" var="c">
	    	 			<option value="${c.cid}" <c:if test="${p.cid==c.cid}">selected</c:if> >${c.cname}</option>
	    	 		</c:forEach>
	    	 	</select>
	    	 </li>
		    <li><label>商品名称</label><input name="pname" value="${p.pname}" type="text" class="dfinput" /><i>商品名称不能超过30个字符</i></li>
		    <li><label>单价</label><input name="price" value="${p.price }" type="text" class="dfinput" /></li>
		    <li><label>简介</label>
		    	<textarea name="description" class="textinput"  cols="10" rows="10">
		    		${p.description }
		    	</textarea>
		    </li>
		    <li><label>商品展示图</label>
		    	<img src="/${p.pic}" height="100px"/><br/>
		    	<input name="pic" type="file"/><font style="color: red">${msg }</font>
		    </li>
		    <li><label>使用程度</label>
			    <cite>
				    <input name="state" type="radio" value="0" <c:if test="${p.state==0}">checked</c:if> />全新产品&nbsp;&nbsp;
				    <input name="state" type="radio" value="1" <c:if test="${p.state==1}">checked</c:if> />九成新&nbsp;&nbsp;
				    <input name="state" type="radio" value="2" <c:if test="${p.state==2}">checked</c:if> />八成新&nbsp;&nbsp;
				    <input name="state" type="radio" value="3" <c:if test="${p.state==3}">checked</c:if> />五成新&nbsp;&nbsp;
				    <input name="state" type="radio" value="4" <c:if test="${p.state==4}">checked</c:if> />三成新
			    </cite>
		    </li>
		    <li><label>购买日期</label>
		    	<input class="Wdate" style="width: 345px;height: 32px;line-height: 32px;" onclick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})" name="createTime" type="text" class="dfinput" value="<fmt:formatDate value="${d}" pattern="yyyy-MM-dd HH:mm:ss" />" />
		    </li>
		    
		    <li><label>&nbsp;</label><input type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    </form>
    </div>
</body>
</html>
