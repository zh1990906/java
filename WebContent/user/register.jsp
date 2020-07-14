<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();//获取项目名   ----> /项目名--->/MI_pro
	pageContext.setAttribute("path", path);//将path存放到pageContext对象的作用域中
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <link rel="stylesheet" href="${path}/css/index.css">
   <!--  <script type="text/javascript" src="js/jquery.1.11.1.min.js"></script>
    <script type="text/javascript" src="js/jquery.validate.js"></script>
    <script type="text/javascript" src="js/messages_zh.js"></script> -->
    
    <script type="text/javascript" src="${path}/js/jquery.1.11.1.min.js"></script>
    <script type="text/javascript">
    	$(function(){
    		//用户名重复校验
    		$("#username").blur(function(){
    			$name = $(this).val();
    			$.ajax({
    				url:"<%=request.getContextPath()%>/userServlet",
    				data:{"method":"queryUserByName","username":$name},
    				dataType:"json",
    				type:"post",
    				success:function(obt){
    					if(obt){
							//用户名可注册
							$("#s_username").html("<font style='color:green;font-size:12px;margin-left:10px;'>√</font>");
						}else{
							$("#s_username").html("<font style='color:red;font-size:12px;margin-left:10px;'>×</font>");
						}
    				}
    			});
    		});
    		//给立即注册按钮添加点击事件
    		$("#btn").click(function(){
    			//表单提交
    			$("form").submit();
    		});
    		
    		$(document).ready(function(){
    		    $("form").submit(function(e) {
    		        var ref = $(this).find("[required=required]");
    		        //alert('ref');
    		        $(ref).each(function(){
    		            if ( $(this).val() == '' )
    		            {
    		                alert("请填写全部信息！");
    		                $(this).focus();
    		                e.preventDefault();
    		                return false;
    		            }
    		        });  return true;
    		    });
    		});
    		
    		
    		//手机号格式校验
    		$("#phone_number").blur(function(){
    			$tel = $(this).val();//1.获取文本框中输入的手机号
    			var reg =/^1[34578]\d{9}$/;//2.声明正则表达式
    			if(reg.test($tel)){//匹配-->校验
    				//true-->匹配 发送异步请求,检测手机号是否注册
    				$.ajax({
    					url:"<%=request.getContextPath()%>/userServlet",//请求路径
    					data:{"method":"queryUserByTel","tel":$tel}, //参数
    					dataType:"json",//服务器返回数据的数据格式  json,text,xml,script,html...
    					type:"post",//发送异步请求的方式 get|post
    					success:function(obt){//成功处理异步请求之后的，回调函数  ,obt:服务器返回的数据
    						if(obt){
    							//手机号可注册
    							$("#s_phone_number").html("<font style='color:green;font-size:12px;margin-left:10px;'>√</font>");
    						}else{
    							$("#s_phone_number").html("<font style='color:red;font-size:12px;margin-left:10px;'>×</font>");
    						}
    					}
    				});
    			}else{
    				//false-->不匹配
    				$("#s_phone_number").html("<font style='color:red;font-size:12px;margin-left:10px;'>手机号格式不正确</font>");
    			}
    		});
    		
    		//验证邮箱是否正确
    		$("#email").blur(function(){
        		//alert("132");
        		$("#yzm").val(""); //输入新邮箱时进行清空处理
        		$("#s_yzm").html("<font style='color:red;font-size:12px;margin-left:10px;'>x</font>");
				$("#btn").hide();
        		$mail = $(this).val();
        		var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
        		if(reg.test($mail))
        		{
        			$.ajax({
        				url:"<%=request.getContextPath()%>/userServlet",
        				data:{"method":"queryUserByEmail","email":$mail},
        				dataType:"json",
        				type:"post",
        				success:function(obt){
        					if(obt){
    							//用户名可注册
        						$("#s_email").html("<font style='color:green;font-size:12px;margin-left:10px;'>√</font>");
        	        			$("#fasong").show();
    						}else{
    							$("#s_email").html("<font style='color:red;font-size:12px;margin-left:10px;'>×</font>");
    						}
        				}
        			});	
        		}
        		else
        		{
        			$("#s_email").html("<font style='color:red;font-size:12px;margin-left:10px;'>x</font>");
        			$("#fasong").hide();
        		}
        	});
    		$("#yzm").blur(function(){
    			if(document.getElementById("yzm").value == document.getElementById("sure_yzm").value && document.getElementById("yzm").value!="")
    			{
    				$("#s_yzm").html("<font style='color:green;font-size:12px;margin-left:10px;'>√</font>");
    				$("#btn").show();
    			}
    			else
    			{
    				$("#s_yzm").html("<font style='color:red;font-size:12px;margin-left:10px;'>x</font>");
    				$("#btn").hide();
    			}
    		});
    	})
    	function email() {
				//获取输入的邮箱alert(document.getElementById("email").value);
				if(document.getElementById("email").value)
				{
					var num=Math.floor(Math.random()*1000000+300000);
					document.getElementById("sure_yzm").value = num;
					//alert(document.getElementById("sure_yzm").value);
					
					$mail = document.getElementById("email").value;
					$yz = document.getElementById("sure_yzm").value;
					
					$.ajax({
	    				url:"<%=request.getContextPath()%>/userServlet",
	    				data:{"method":"Mail","mail":$mail,"yz":$yz},
	    				dataType:"json",
	    				type:"post",
	    				success:function(){
	    					alert("验证码已发送");
	    			}});
					
					$("#fasong").hide();
					
					//暂停时间 以毫秒计算
					setTimeout("changeState()", 30000);
			        
				}
				else
				{
					alert("请先填写邮箱！");
				}
			}
    	function changeState(){
    		$("#fasong").show()
    	}
    	
    </script>
</head>
<body>
<body>
<div class="sign_background">
    <div class="sign_background_in">
        <div class="sign_background_no1">
            <a href="index.html"><img src="${path}/img/logo.jpg" alt=""></a>
        </div>
        <div class="sign_background_no2">注册交易帐号</div>
        <div class="sign_background_no3">
             ${msg }
            <div class="sign_background_no5">
             	
             	<form id="f4" action="${path}/userServlet?method=userRegister" method="post">
             		<table style="width: 500px;" border="0" cellspacing="10">
             			<tr>
             				<td width="25%" class="_left">姓名：</td>
             				<td><input type="text" name="uname" required="required"><span id="s_name"></span></td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">性别：</td>
             				<td>
             					男<input type="radio" name="sex" checked="checked" value="1">
             				 	女<input type="radio" name="sex" value="0">
							</td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">电话号码：</td>
             				<td><input type="text" id="phone_number" name="tel" required="required"><span id="s_phone_number"></span></td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">所在地区：</td>
             				<td><input type="text" name="area" required="required"></td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">账号：</td>
             				<td><input type="text" id="username" name="username" required="required"><span id="s_username"></span></td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">密码：</td>
             				<td><input type="password" name="password" required="required"><span id="s_password"></span></td>
             			</tr>
             			 <tr>
             				<td width="25%" class="_left">邮箱验证：</td>
             				<td>
             					<input type="email" name="email" required="required" id="email"><span id="s_email"></span>
             					<a href="#" onclick="email()" id="fasong" hidden>发送验证码</a>
             					<input id="sure_yzm" value="" type="hidden"> <!-- 用来保存产生的验证码 -->
             				</td>
             			</tr>
             			<tr>
          					<td width="25%" class="_left">输入验证码：</td>
             				<td><input type="text" name="yzm" required="required" id="yzm"><span id="s_yzm"></span>
             				</td>
             			</tr>
             		</table>
             		<div class="sign_background_no6" id="btn" hidden>立即注册</div>
             	</form>
             	 
            </div>
        </div>
        
    </div>
    
	
</div>

 
</body>
</html>