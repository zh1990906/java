<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
    pageContext.setAttribute("path", path);
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录跳蚤市场出售系统</title>
<link href="${path}/admin/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${path}/admin/js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 
<script type="text/javascript" charset="utf-8" src="//g.alicdn.com/sd/ncpc/nc.js?t=2015052012"></script>

</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  
<div class="logintop">    
    <span>欢迎来出售</span>    
    <ul>
    <li><a href="${path}/index.jsp">回首页</a></li>

    </ul>    
    </div>
    <div class="loginbody">
    <span class="systemlogo"></span> 
    <div class="loginbox">
    <form action="${path}/userServlet?method=userLogintwo" method="post">
	    <ul>
	    <span style="margin-left: 20px;color: red;" id="msg">${msg}</span>
		    <li>
			    <font style="color: red">${msg }</font><br/>
			    <input name="username" type="text" class="loginuser"  />
			</li>
		    <li>
	    		<input name="password" type="password" class="loginpwd" />
	   		 </li>
	   		 <div id="your-dom-id" class="nc-container"></div> 
				<!--No-Captcha渲染的位置，其中 class 中必须包含 nc-container-->
	    	<li>
		    	<input type="submit" class="loginbtn" value="登录" />
		    	<label>
		    		<input name="" type="checkbox" value="" checked="checked" />记住密码
		    	</label>
		    	<label><a href="#">忘记密码？</a></label>
	    	</li>
	    </ul>
    </form>
    </div>
    </div>
	<script type="text/javascript" >
		var nc_token = ["CF_APP_1", (new Date()).getTime(), Math.random()].join(':');
		        var NC_Opt = 
		        {
		            renderTo: "#your-dom-id",
		            appkey: "CF_APP_1",
		            scene: "register",
		            token: nc_token,
		            customWidth: 250,
		            trans:{"key1":"code0"},
		            elementID: ["usernameID"],
		            is_Opt: 0,
		            language: "cn",
		            isEnabled: true,
		            timeout: 3000,
		            times:5,
		            apimap: {
		                // 'analyze': '//a.com/nocaptcha/analyze.jsonp',
		                // 'get_captcha': '//b.com/get_captcha/ver3',
		                // 'get_captcha': '//pin3.aliyun.com/get_captcha/ver3'
		                // 'get_img': '//c.com/get_img',
		                // 'checkcode': '//d.com/captcha/checkcode.jsonp',
		                // 'umid_Url': '//e.com/security/umscript/3.2.1/um.js',
		                // 'uab_Url': '//aeu.alicdn.com/js/uac/909.js',
		                // 'umid_serUrl': 'https://g.com/service/um.json'
		            },   
		            callback: function call(data) { 
		                window.console && console.log(nc_token);
		                window.console && console.log(data.csessionid);
		                window.console && console.log(data.sig);
		                 }
		                
		            };
		        var nc = new noCaptcha(NC_Opt);
		        nc.upLang('cn', {
		            _startTEXT: "请按住滑块，拖动到最右边",
		            _yesTEXT: "验证通过",
		            _error300: "哎呀，出错了，点击<a href=\"javascript:__nc.reset()\">刷新</a>再来一次",
		            _errorNetwork: "网络不给力，请<a href=\"javascript:__nc.reset()\">点击刷新</a>",
		        });
	</script>
	
</body>
</html>
