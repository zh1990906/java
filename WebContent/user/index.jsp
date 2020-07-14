<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%	
	//获取项目名
	String path = request.getContextPath();
	pageContext.setAttribute("path", path);
	//获取tomcat 协议+地址+端口号+ 获取项目名
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	//获取tomcat 协议+地址+端口号
	String imgPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
	
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>跳蚤市场首页</title>
    <link rel="stylesheet" href="${path}/css/index.css">
    <script src="js/jquery.1.11.1.min.js"></script>
    <style>

    </style>

</head>
<body style="background-color: #fafafa;">
    
    <!-- 头部分 -->
   	<c:if test="${!empty username}">
		<div class="box">
				<div class="inner whiteGL">
		        <div class="left">
		        	<a class="mix" href="">跳蚤市场</a>
		        </div>
		        <div class="right">
					<a class="mix" href="#" value="">欢迎${username}</a>
					<a class="max"  href="${path}/index.jsp">退出</a>
					
		        </div>
		      	</div>
			</div>
			<div class="logo">
			    <div class="logo_left">
			        <div>
			            <a href="javascript:void(0);" title="让闲置不再清闲"><img class="xiaomi" src="${path}/img/logo.jpg"></a>
			        </div>
			    </div>
	  		</div>
	</c:if>
	<c:if test="${empty username}">
		<jsp:include page="header.jsp"></jsp:include>
	</c:if>
    
    <!-- 滚动图片 -->
    <div class="scroll">
        <ul>
            <li><a href=""><img src="${path}/img/111.jpg" alt="" height="650px"></a></li>
        </ul>
        <div class="scroll_arrows">
            <a href="javascript:void(0);"><span class="left scroll_arrows_back">〈</span></a>
            <a href="javascript:void(0);"><span class="right scroll_arrows_back">〉</span></a>
        </div>
        <div class="scroll_left" style="height: 610px;">
            <ul class="scr-ul">
            	<c:forEach items="${clist}" var="c">
            		<li class="scr_li"><a href="">${c.cname}</a><i class="scr_i"></i></li>
            	</c:forEach>
            </ul>
        </div>
        
    </div>
    <div class="bot">
        <div class="bot_max">
            <div class="bot_first">
                <div class="bot_one">
                    
                    <div><a href="${path}/user/index.tell.jsp"><img src="${path}/img/bot_06.jpg">联系我们</a></div>
                </div>

            </div>
            <a href="#"><img src="${path}/img/113.jpg" alt=""></a>
            <a href="#"><img src="${path}/img/114.jpg" alt=""></a>
            <a href="#"><img src="${path}/img/115.jpg" alt=""></a>
        </div>
    </div>
    <div class="time">
        <div class="H">全新产品</div>
        <div class="time_in">
        	    <c:forEach items="${newproducts}" var="p">
		            <div style="background-color: #fff;width: 234px;height:320px;float: left;margin-left: 11px; ">
		            	<a href="${path}/usersellServlet?method=commoditydetails&pid=${p.pid}&uid=${username}" target="_blank">
		            		<img class="time_min" style="width:234px;height: 234px;" src="/${p.pic}" alt="">
		            	</a>
		            	<div style="clear: both;"></div>
		            	
		            	<div style="width: 234px;height: 85px;">
		            		<div style="width: 234px;height: 20px;line-height: 20px;text-align: center;font-size: 14px;font-family: Arial">
		            			${p.pname}
		            		</div>
		            		<div style="width: 234px;height: 30px;line-height: 30px;text-align: center;color: #ff6700;font-size: 14px;font-family: Arial">
		            			 <span style="color: #000"> &nbsp;${p.price} </span>
		            		</div>
		            		<div style="width: 234px;height: 35px;line-height: 35px;text-align: center;color: #000;font-size: 14px;font-family: Arial" title="${p.description}">
		            			<c:if test="${p.description.length() <=12 }">
		            				${p.description}
		            			</c:if>
		            			<c:if test="${p.description.length() > 12 }">
		            				${ fn:substring(p.description ,0,12)}...
		            			</c:if>
		            		</div>
		            	</div>
		            </div>
	          </c:forEach>
        </div>
    </div>
    <div class="time">
         <div class="H">九成新</div>
         <div class="time_in">
           	<c:forEach items="${nineproducts}" var="p">
           		<div style="background-color: #fff;width: 234px;height:320px;float: left;margin-left: 11px; ">
		        	<a href="${path}/usersellServlet?method=commoditydetails&pid=${p.pid}&uid=${username}" target="_blank">
		        		<img class="time_min" style="width:234px;height: 234px;" src="/${p.pic}" alt="">
		        	</a>
		        	<div style="clear: both;"></div>
		        	
		        	<div style="width: 234px;height: 85px;">
		        		<div style="width: 234px;height: 20px;line-height: 20px;text-align: center;font-size: 14px;font-family: Arial">
		        			${p.pname}
		        		</div>
		        		<div style="width: 234px;height: 30px;line-height: 30px;text-align: center;color: #ff6700;font-size: 14px;font-family: Arial">
		        			 <span style="color: #000"> &nbsp;${p.price} </span>
		        		</div>
		        		<div style="width: 234px;height: 35px;line-height: 35px;text-align: center;color: #000;font-size: 14px;font-family: Arial" title="${p.description}">
		        			<c:if test="${p.description.length() <=12 }">
		        				${p.description}
		        			</c:if>
		        			<c:if test="${p.description.length() > 12 }">
		        				${ fn:substring(p.description ,0,12)}...
		        			</c:if>
		        		</div>
		         	</div>
		         </div>
               </c:forEach>	
         </div>
	</div>
    <div class="time">
         <div class="H">八成新</div>
         <div class="time_in">
           	<c:forEach items="${eightproducts}" var="p">
           		<div style="background-color: #fff;width: 234px;height:320px;float: left;margin-left: 11px; ">
		        	<a href="${path}/usersellServlet?method=commoditydetails&pid=${p.pid}&uid=${username}" target="_blank">
		        		<img class="time_min" style="width:234px;height: 234px;" src="/${p.pic}" alt="">
		        	</a>
		        	<div style="clear: both;"></div>
		        	
		        	<div style="width: 234px;height: 85px;">
		        		<div style="width: 234px;height: 20px;line-height: 20px;text-align: center;font-size: 14px;font-family: Arial">
		        			${p.pname}
		        		</div>
		        		<div style="width: 234px;height: 30px;line-height: 30px;text-align: center;color: #ff6700;font-size: 14px;font-family: Arial">
		        			 <span style="color: #000"> &nbsp;${p.price} </span>
		        		</div>
		        		<div style="width: 234px;height: 35px;line-height: 35px;text-align: center;color: #000;font-size: 14px;font-family: Arial" title="${p.description}">
		        			<c:if test="${p.description.length() <=12 }">
		        				${p.description}
		        			</c:if>
		        			<c:if test="${p.description.length() > 12 }">
		        				${ fn:substring(p.description ,0,12)}...
		        			</c:if>
		        		</div>
		         	</div>
		         </div>
               </c:forEach>	
         </div>
	</div>
    <div class="time">
         <div class="H">五成新</div>
         <div class="time_in">
           	<c:forEach items="${five}" var="p">
           		<div style="background-color: #fff;width: 234px;height:320px;float: left;margin-left: 11px; ">
		        	<a href="${path}/usersellServlet?method=commoditydetails&pid=${p.pid}&uid=${username}" target="_blank">
		        		<img class="time_min" style="width:234px;height: 234px;" src="/${p.pic}" alt="">
		        	</a>
		        	<div style="clear: both;"></div>
		        	
		        	<div style="width: 234px;height: 85px;">
		        		<div style="width: 234px;height: 20px;line-height: 20px;text-align: center;font-size: 14px;font-family: Arial">
		        			${p.pname}
		        		</div>
		        		<div style="width: 234px;height: 30px;line-height: 30px;text-align: center;color: #ff6700;font-size: 14px;font-family: Arial">
		        			 <span style="color: #000"> &nbsp;${p.price} </span>
		        		</div>
		        		<div style="width: 234px;height: 35px;line-height: 35px;text-align: center;color: #000;font-size: 14px;font-family: Arial" title="${p.description}">
		        			<c:if test="${p.description.length() <=12 }">
		        				${p.description}
		        			</c:if>
		        			<c:if test="${p.description.length() > 12 }">
		        				${ fn:substring(p.description ,0,12)}...
		        			</c:if>
		        		</div>
		         	</div>
		         </div>
               </c:forEach>	
         </div>
	</div>
    <div class="time">
         <div class="H">三成新</div>
         <div class="time_in">
           	<c:forEach items="${three}" var="p">
           		<div style="background-color: #fff;width: 234px;height:320px;float: left;margin-left: 11px; ">
		        	<a href="${path}/usersellServlet?method=commoditydetails&pid=${p.pid}&uid=${username}" target="_blank">
		        		<img class="time_min" style="width:234px;height: 234px;" src="/${p.pic}" alt="">
		        	</a>
		        	<div style="clear: both;"></div>
		        	
		        	<div style="width: 234px;height: 85px;">
		        		<div style="width: 234px;height: 20px;line-height: 20px;text-align: center;font-size: 14px;font-family: Arial">
		        			${p.pname}
		        		</div>
		        		<div style="width: 234px;height: 30px;line-height: 30px;text-align: center;color: #ff6700;font-size: 14px;font-family: Arial">
		        			 <span style="color: #000"> &nbsp;${p.price} </span>
		        		</div>
		        		<div style="width: 234px;height: 35px;line-height: 35px;text-align: center;color: #000;font-size: 14px;font-family: Arial" title="${p.description}">
		        			<c:if test="${p.description.length() <=12 }">
		        				${p.description}
		        			</c:if>
		        			<c:if test="${p.description.length() > 12 }">
		        				${ fn:substring(p.description ,0,12)}...
		        			</c:if>
		        		</div>
		         	</div>
		         </div>
               </c:forEach>	
         </div>
	</div>
    <div class="content">
        <div class="popular_background">
            <div class="popular_box_top">
                <div class="popular_box_top_al">小推荐</div>

            </div>
            <div class="popu_box">
            
            	
            	<c:forEach items="${goods }" var="goods" varStatus="i">
            		
            		<c:if test="${i.count ==1 }">
            			 <div class="popu cont_border_top1 popu_unleft popu_shadow" style="text-align: center;">
		                    <div class="popu_bottom">
		                        <h4 class="popu_name">${goods.pname }</h4>
		                        <p class="popu_desc"><a href="">${goods.description }</a></p>
		                        <p class="popu_price"><a href="">${goods.price }元</a></p>
		                    </div>
		                    <a href="${path}/usersellServlet?method=commoditydetails&pid=${goods.pid}&uid=${username}" target="_blank"><img width="180px" height="200px" src="/${goods.pic }"></a>
		
		                </div>
            		</c:if>
            		<c:if test="${i.count ==2 }">
            			<div class="popu cont_border_top2 popu_shadow" style="text-align: center;">
	
		                    <div class="popu_bottom">
		                        <h4 class="popu_name">${goods.pname }</h4>
		                        <p class="popu_desc"><a href="">${goods.description }</a></p>
		                        <p class="popu_price"><a href="">${goods.price }元</a></p>
		                    </div>
		                    <a href="${path}/usersellServlet?method=commoditydetails&pid=${goods.pid}&uid=${username}" target="_blank"><img width="180px" height="200px" src="/${goods.pic }"></a>
		                </div>
            		
            		</c:if>
            		<c:if test="${i.count ==3 }">
            			<div class="popu cont_border_top3 popu_shadow " style="text-align: center;">
		                    <div class="popu_bottom">
		                         <h4 class="popu_name">${goods.pname }</h4>
		                        <p class="popu_desc"><a href="">${goods.description }</a></p>
		                        <p class="popu_price"><a href="">${goods.price }元</a></p>
		                    </div>
		                    <a href="${path}/usersellServlet?method=commoditydetails&pid=${goods.pid}&uid=${username}" target="_blank"><img width="180px" height="200px" src="/${goods.pic }"></a>
		                </div>
            		</c:if>
            		<c:if test="${i.count ==4 }">
            			 <div class="popu popu_border_top4 popu_shadow " style="text-align: center;">
		                    <div class="popu_bottom">
		                         <h4 class="popu_name">${goods.pname }</h4>
		                        <p class="popu_desc"><a href="">${goods.description }</a></p>
		                        <p class="popu_price"><a href="">${goods.price }元</a></p>
		                    </div>
		                    <a href="${path}/usersellServlet?method=commoditydetails&pid=${goods.pid}&uid=${username}" target="_blank"><img width="180px" height="200px" src="/${goods.pic }"></a>
		                </div>
            		</c:if>
                
                </c:forEach> 
                
                
                
            </div>


        </div>
    </div>
    
    
    <!-- 底部的包含 -->
	<jsp:include page="footer.jsp"></jsp:include>

    <script>
        var abc = document.getElementsByClassName("script_capa_box_top_ar");
        console.log("abc:"+abc);
        console.log("abc[0]"+abc[0]);
        var box = document.getElementsByClassName("scrip_capa_box");
        console.log("box:"+box);
        console.log("box[0]:"+box[0]);
        for(var i = 0; i<abc.length;i++){
            abc[i].index=i;
            abc[i].onmouseover=function(){
                for(var j = 0 ;j<abc.length;j++){
                    box[j].className="capa_box scrip_capa_box";
                }
                box[this.index].className="capa_box scrip_capa_box scrip_capa_box_on"
                console.log("this.index:"+this.index);
            }
        }
        var n = 0;
        var t = setInterval(fun,1000);
        function  fun() {
            n++;
            if(n > $(".scroll>ul>li").length-1){
                n = 0;
            }
            $(".scroll>ul>li").css("opacity","0").eq(n).css("opacity","1")
            $(".scroll_dot span").eq(n).addClass("scroll_dot_span").siblings().removeClass("scroll_dot_span");
        }
        $(".scroll_arrows .left").click(function() {
            n -= 2;
                    if(n <-1){
                        n=4;
                    }
                    fun()

        } );
        $(".scroll_arrows .right").click(function() {
            fun()
        });
        $(".scroll_dot span").click(function () {
            console.log($(this).index());
            n=$(this).index()-1;
            $(this).siblings().removeClass("scroll_dot_span").end().addClass("scroll_dot_span");
            fun()
        }); $(".scroll").hover(function () {
                    clearInterval(t);
                },
                function () {
                    t = setInterval(fun,1000);
                });

    </script>
</body>
</html>