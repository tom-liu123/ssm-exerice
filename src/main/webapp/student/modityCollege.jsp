<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.js"></script><meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"><link rel="shortcut icon" href="/StudentInfo/utils/image/favicon.ico" type="image/x-icon" />
<meta charset="UTF-8">
<title>阳光健身俱乐部管理系统</title>

<!-- 标题图标、CSS、js、jQ 
<link href="/online/image/favicon.ico" rel="shortcut icon">
<link rel="stylesheet" type="text/css" href="/online/css/main.css">
<script src="/online/js/fun.js" type="text/javascript"></script>-->
<script type="text/javascript" src="/StudentInfo/utils/js/jquery-3.3.1.min.js"></script>

<!-- Loading Bootstrap -->
<link href="/StudentInfo/utils/css/vendor/bootstrap.min.css" rel="stylesheet">
<!-- Loading Flat UI Pro -->
<link href="/StudentInfo/utils/css/flat-ui.css" rel="stylesheet">
<!-- Loading Flat UI JS -->
<script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.min.js"></script>


<script type='text/javascript' src='/StudentInfo/utils/scripts/particles.js'></script>
<link href="/StudentInfo/utils/css/animate.css" rel="stylesheet">
<link href="/StudentInfo/utils/css/buy.css" rel="stylesheet">
</head>

<body><div id="particles-js"><canvas class="particles-js-canvas-el" width="1322" height="774" style="width: 100%; height: 100%;"></canvas></div>
<jsp:include page="studentLeft.jsp" />

<div class="container">
		<div class="row">
			<div class="col-md-12">
			<h5>会员续费</h5>	
			
			<tr>
					<td>结束日期</td>
					<td>${requestScope.college }</td>
					
				</tr>
						
			<c:forEach var="student" items="${requestScope.studentList}">							
			<form method="get">
				<div class="row">					
					<div class="col-md-6" style="display='none'">							    
						
						
						会员截止日期：<p id="p">${student.college }</p>
					</div>						
				</div>
	        </form>
            
			<form
			action="/StudentInfo/StudentHandler/modityCollegestu/${sessionScope.sid }"
			method="get">
			<div class="col-md-3"><input type="submit" class="btn btn-primary btn-wide login-btn" value="确认付款" /></div>				
			    <div id="div"></div>
			    
				<div class="col-md-3"><input  type="text"  style="border: 0" id="input" name="college"class="form-control" value="${requestScope.college }" onkeyup="this.value=this.value.replace(/(^\s+)|(\s+$)/g,'');" maxlength="16"/> </div></br>
				
			
			</form>
</c:forEach>
			</div></div>
			
	
			
			
			
			
			</div>
			
			<div class="container">
		<div class="row">
			<div class="col-md-12">
			<h5>查看公告</h5>
			<form name="investquery" action="/StudentInfo/StudentHandler/checkInvest/1" method="get">

				</form>
			
			</div>
			<div class="col-md-12">
			<div class="row">
			<div class="col-md-12" >
						<div class="margin:0 15px" style="overflow-x: scroll;">
			<table  style="overflow:scroll;" class="table table-striped table-hover animated fadeIn">
			<tr>
				<th>充值编号 </th>
				<th>充值月份</th>
				<th>info</th>
				<th>现价</th>
				<th>原价</th>
				<th>描述</th>
				<th>选择</th>
				

				
				
				
				
				

			</tr>
			<c:forEach var="invest" items="${requestScope.investList}">
				<tr>
					<td>${invest.investid }</td>
					<td>${invest.month }</td>
					<td>${invest.price }</td>
					<td>${invest.oldprice }</td>
					<td>${invest.info }</td>
					<td>${invest.represent }</td>
					<td><a class="btn btn-warning" href="/StudentInfo/StudentHandler/moditystude/${sessionScope.sid }">会员续费 </a></td>

					



					

				</tr>

			</c:forEach>
		</table></div></div></div>
			</div>
	</div>
	
	
	


	
	
	
</div>	
			
		
			
			
			

<script>
      var goodsList = [
        {
          id: 1001,
          icon: "1",

          info: "充值立即生效",

          history: "1年历史最低价",
          oldPrice: "993",
          price: " ",

          href: "https://item.jd.com/34622502992.html",
        },
        {
          id: 1002,
          icon: "2",

          info: "充值立即生效",

          history: "49天历史最低价",
          oldPrice: "199",
          price: "65",

          href: "https://item.jd.com/100005009278.html",
        },
        {
          id: 1003,
          icon: "3",

          info: "充值立即生效",

          history: "51天历史最低价",
          oldPrice: "2280",
          price: "1550",

          href: "https://item.jd.com/34622502992.html",
        },
      ];

      init();

      function init() {
        document.addEventListener("add_goods_event", addGoodsHandler);
      //   goodsList.forEach((item) => {
      //     createGoods(item);
      //   });
      // }
        for (var i = 0; i < goodsList.length; i++) {
          createGoods(goodsList[i]);
        }
      }
      function addGoodsHandler(e) {
        console.log(e);
      }

      // 创建元素
      function ce(type, style) {
        var elem = document.createElement(type);
        Object.assign(elem.style, style);
        return elem;
      }

      function createGoods(data) {
        var div = ce("div");
        div.className = "goodsCon";
        var a = ce("a");
        a.target = "_blank";
        div.appendChild(a);
        createIcon(a, data.icon);
        createInfo(a, data.info, data.selfSell);
        createPriceCon(div, data);
        createButton(div, data.href);
        document.body.appendChild(div);
      }

      function createIcon(parent, iconPath) {
        var h4 = ce("h4");
        h4.className = "icon";
        h4.textContent = iconPath + "个月";
        parent.appendChild(h4);
      }

      function createInfo(parent, info, selfSell) {
        var div = ce("div");
        var text = document.createTextNode(info);
        div.appendChild(text);
        div.className = "info";
        parent.appendChild(div);
      }

      function createPriceCon(parent, data) {
        var div = ce("div");
        div.className = "priceCon";
        createHistory(div, data.history);
        createPrice(div, data.price, data.oldPrice);
        parent.appendChild(div);
      }

      function createHistory(parent, history) {
        if (history.trim().length === 0) return;
        var div = ce("div");
        div.textContent = history;
        div.className = "history";
        parent.appendChild(div);
      }
      function createPrice(parent, price, oldPrice) {
        var priceDiv = ce("span");
        priceDiv.textContent = "￥" + price;
        priceDiv.className = "price";
        var oldPriceDiv = ce("span");
        oldPriceDiv.textContent = "￥" + oldPrice;
        oldPriceDiv.className = "oldPrice";
        parent.appendChild(priceDiv);
        parent.appendChild(oldPriceDiv);
      }

      function createButton(parent, href) {
        var a = ce("a");
        a.addEventListener("click", (e) => this.clickHandler(e));
        a.textContent = "选择";
        a.className = "button";
        a.target = "_blank";
        parent.appendChild(a);
      }

      function clickHandler(e) {
        // for (var i = 1; i < goodsList.length; i++) {
        //   var evt = new Event("add_goods_event");
        //   evt.data =goodsList[i];
        //   document.dispatchEvent(evt);
        //   return;
        // }
        // console.log(document.body.children[1].lastElementChild.firstElementChild.firstElementChild.nextElementSibling.firstElementChild.nextElementSibling.lastElementChild.firstChild.nodeValue);
        

        // console.log(e.target.parentNode.firstElementChild.firstElementChild.textContent.substring(0, 1));
        

       var addmouth = Number(e.target.parentNode.firstElementChild.firstElementChild.textContent.substring(0, 1));
       console.log(addmouth);
       var price=Number(e.target.parentNode.firstElementChild.nextElementSibling.firstElementChild.nextElementSibling.textContent.substring(1));
       console.log(price);
       var evt = new Event("add_goods_event");
          evt.data =addmouth;
          document.dispatchEvent(evt);
        var p = document.getElementById("p");
        var date = p.textContent;
        var year = Number(date.substring(0, 4));
        var mouth = Number(date.substring(5, 7));

        var day = Number(date.substring(8, 10));
        var mouth = mouth + addmouth;

        if (mouth > 12) {
          mouth = mouth - 12;

          year = year + 1;

          var mouthlength = String(mouth).length;
          if (mouthlength < 2) {
            mouth = "0" + mouth;
          } else {
            mouth = mouth;
          }

          var daylength = String(day).length;
          if (daylength < 2) {
            day = "0" + day;
          } else {
            day = day;
          }

          date = year + "-" + mouth + "-" + day;
        } else {
          var mouthlength = String(mouth).length;
          if (mouthlength < 2) {
            mouth = "0" + mouth;
          } else {
            mouth = mouth;
          }

          var daylength = String(day).length;
          if (daylength < 2) {
            day = "0" + day;
          } else {
            day = day;
          }

          date = year + "-" + mouth + "-" + day;
        }
        p.textContent = date;
        
        
        var input =document.getElementById("input");
        input.value=date;
        console.log("11"+date);
        var div =document.getElementById("div");
        div.textContent="充值金额为"+price+"元";
        alert("充值成功" + "充值金额为"+price );
        
        // + e.data.price
        // goodsList.forEach(item=>{
        //     createGoods(item);

        // })
          // var evt = new Event("add_goods_event");
          // evt.data = this.data;
          // document.dispatchEvent(evt);
      }
    </script>
<script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.js"></script><script src="/StudentInfo/utils/scripts/bganimation.js"></script></body>
</html>