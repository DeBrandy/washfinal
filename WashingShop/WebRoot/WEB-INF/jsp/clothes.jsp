<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>衣物管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="./bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="./own.css" type="text/css" />
  </head>
  
  <body>
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	 
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="./bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap-table/1.12.1/bootstrap-table.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap-table/1.12.1/locale/bootstrap-table-zh-CN.js"></script>
  	<script type="text/javascript" src="./own.js"></script>
  	<script type="text/javascript">
  	/*  
  	function change(){
  			alert(" 修改状态成功！");
	};*/
  
  	</script>
    <div id="top"></div>
	<div id="nav">
	<div class="btn-group">
    <a href="/WashingShop/receive/test"><button type="button" class="btn btn-default" style="width:200px">收件</button></a>
    <a href="/WashingShop/deliver/test"><button type="button" class="btn btn-default" style="width:201px">付件</button></a>
     <a href="/WashingShop/Member/test"><button type="button" class="btn btn-default" style="width:201px">会员管理</button></a>
    <a href="/WashingShop/Tools/test"><button type="button" class="btn btn-default" style="width:201px">洗衣用品管理</button></a>
    <a href="/WashingShop/Clothes/test"><button type="button" class="btn btn-default" style="width:201px">衣物管理</button></a>
	</div>
	<div id="nav">
	
	<form id="search_Statue" role="form" class="form-horizontal"  action="/WashingShop/Clothes/showStatue" method="post" >
	<table>
	<tr>
	<td><label for="search_statue" class="control-label">衣物状态：</label></td>
	<td><input type="text" class="form-horizontal" id="search_statue" name="Statue" ></td>
	<td style="width:100px"><input type="button" class="btn btn-primary center-block" value="查询" onclick=""/></td>
	</table>
	</form>
	
	<form  id="search_ID" role="form" class="form-horizontal"  action="/WashingShop/Clothes/manage" method="post" >
	<table>
	<tr>
    <td><label for="search_id" class="control-label">挂 衣 号：</label></td>
	<td><input type="text" class="form-horizontal" id="search_id" name="Id" ></td>
	<td style="width:100px"><input type="button" class="btn btn-primary center-block" value="查询" onclick=""/></td>
	</tr>
	</table>
	</form>
	
	
	<div style="width:1000px;overflow-x:auto">
	<table class="table table-hover center-block" id="CloTable" style="width:1000px;text-align:center">
        		<tr><td>挂衣号</td><td>订单号</td><td>服务类型</td><td>服务项目</td><td>材质</td><td>颜色</td><td>品牌</td><td>瑕疵</td><td>备注要求</td><td>状态</td><td>价格</td><td>折后价</td></tr>
        		<c:forEach items="${clothes}" var="cloth">
       			<tr>
        		<td>${cloth.Id} </td>
        		<td>${cloth.Oid}</td>
       		    <td>${cloth.Type}</td>
       		    <td>${cloth.Clo}</td>
       		    <td>${cloth.Mat}</td>
       		    <td>${cloth.Color}</td>
       		    <td>${cloth.Brand}</td>
       		    <td>${cloth.Flaw}</td>
			    <td>${cloth.Add}</td>
       		    <td>${cloth.Statue}</td>
       		    <td>${cloth.Price}</td>
       		    <td>${cloth.Dprice}</td>
       		    
			    <!--<td><input type="button" value="修改状态" class="btn btn-primary center-block" onclick="change()"></td>-->
      			</tr>
     		 	</c:forEach>         
    </table>
	</div>
	</div>
	<div id="footer">
	<hr color="#000" size="4px" align="center" width="1000px"/>
	<br/>
	<p>producer:producer:8000116068 孙月棋 8000116076 张鑫雨 8000116086 黄诗诗 8000116097 钟明 8000116120 王一清 8000116127 张涵</p>
	</div>
  </body>
</html>
