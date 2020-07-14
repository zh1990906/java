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
<title>添加商品</title>
<link href="<%=basePath %>admin/css/style.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript" src="<%=basePath %>admin/js/My97DatePicker/WdatePicker.js"></script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">添加商品</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>商品信息</span></div>
    
    <form action="${path}/productServlet?method=addProduct" method="post" enctype="multipart/form-data">
	    <ul class="forminfo">
	    	 <!-- 商品分类信息 -->
	    	 <li>
	    	 	<label>商品分类</label>
	    	 	<select name="cid" class="dfinput">
	    	 		<c:forEach items="${clist}" var="c">
	    	 			<option value="${c.cid}">${c.cname}</option>
	    	 		</c:forEach>
	    	 	</select>
	    	 </li>
		    <li><label>商品名称</label><input name="pname" type="text" class="dfinput" /><i>商品名称不能超过30个字符</i></li>
		    <li><label>单价</label><input name="price" type="text" class="dfinput" /></li>
		    <li><label>简介</label>
		    	<textarea name="description" cols="10" rows="10" class="textinput" style="height: 80px"></textarea>
		    </li>
		    <li><label>商品展示图</label>
		    	<input name="pic" type="file"/>
		    </li>
		    <li><label>商品小类别</label>
			    <cite>
				    <input name="state" type="radio" value="0" checked="checked" />全新产品&nbsp;&nbsp;
				    <input name="state" type="radio" value="1" />九成新&nbsp;&nbsp;
				    <input name="state" type="radio" value="2" />八成新&nbsp;&nbsp;
				    <input name="state" type="radio" value="3" />五成新&nbsp;&nbsp;
				    <input name="state" type="radio" value="4" />三成新
			    </cite>
		    </li>
		    <li><label>购买日期</label>
		    	<input class="Wdate" style="width: 345px;height: 32px;line-height: 32px;" onclick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})" name="createTime" type="text" class="dfinput" value="" />
		    </li>
		    
		    <li><label>&nbsp;</label><input type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    </form>
    </div>
</body>
</html>
