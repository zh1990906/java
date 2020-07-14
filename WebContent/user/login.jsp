<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();//获取项目名   ----> /项目名--->/MI_pro
	pageContext.setAttribute("path", path);//将path存放到pageContext对象的作用域中
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <meta charset="UTF-8">
    <title>登录页面</title>
    <link rel="stylesheet" href="${path}/css/index.css">
    <script src="${path}/js/jquery.1.11.1.min.js"></script>
    <style>

    </style>
	<script type="text/javascript">
		$(function(){
			//点击登录，表单提交
			$("#login_btn").click(function(){
				$("form").submit();
			});
			//给用户名和密码文本框添加获取焦点事件
			$(".c1").focus(function(){
				$("#msg").html("");
			});
		});
		 function changeImg() {
		        document.getElementById("validateCodeImg").src="${pageContext.request.contextPath}/Response03?"+Math.random();
		        //在末尾加Math.random()的作用：<br>如果两次请求地址一样，服务器只会处理第一次请求，第二次请求返回内容和第一次一样。或者说如果地址相同，第一次请求时，将自动缓存，导致第二次不会重复请求了。Math.random()是调用javascript语法中的数学函数，能够产生随机数。<br>末尾加Math.random()使每次请求地址不相同，服务器每次都去做不同的响应。也可以使用new date()时间戳的形式作为参数传递。
		    }
	</script>
</head>
<body background="${path}/img/register1.jpg" style=" background-repeat:no-repeat ; background-size:100% 100%; background-attachment: fixed;">
<div class="register_head_on">

</div>
<div class="register_head">
    <a href="index.html"><img src="${path}/img/logo.jpg" alt=""></a>
    <div class="register_head_right">
        <p class="register_head_right_p1">跳 蚤 市 场</p>
        <p class="register_head_right_p2">你不用的东西交给我</p>
    </div>

</div>

<div class="register">
    <div class="register_boby">
        <div class="register_boby_min">
            <div class="register_boby_no1">
                <div class="register_boby_no1_in">
                    <span style="color: red;">账号登录 </span>
                    
               </div>
            </div>
            <span style="margin-left: 20px;color: red;" id="msg">${msg}</span>
            <form action="${path}/userServlet?method=userLogin" method="post">
	            <div class="register_boby_no2">
	                <input type="text"  class="c1" name="username" placeholder="请输入您的用户名" required="required">
	                <input type="password" class="c1" name="pwd" placeholder="请输入您的密码" required="required">
	                <div class="register_boby_no3">
	                 <form action="${pageContext.request.contextPath}/ResoultServlet" method="post">
    					<input type="text"  class="aaa" name="yan" id="yan" placeholder="请输入验证码" required="required">
    					<img src="${pageContext.request.contextPath}/Response03" alt="换一张" id="validateCodeImg" onclick="changeImg()">
    					<a href="javascript:void(0)" onclick="changeImg()">换一张</a>
					</form> 
					</div>
	                <div class="register_boby_no2_div" style="text-align:center">
	                    <span id="login_btn"  >登录</span>
	                </div>
	            </div>
            </form>
            
            <div class="register_boby_no4">
                <img src="${path}/img/register02.jpg" alt="">
            </div>



        </div>
    </div>
</div>


</body>

</html>