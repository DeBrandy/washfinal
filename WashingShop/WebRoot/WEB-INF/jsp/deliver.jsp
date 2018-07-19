<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>付件界面</title>
    
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
  
  	</script>
    <div id="nav">
	
	    <a href="/WashingShop/receive/test"><button type="button" class="btn btn-default" style="width:195px">收件</button></a>
	    <a href="/WashingShop/deliver/test"><button type="button" class="btn btn-default" style="width:195px">付件</button></a>
	    <a href="/WashingShop/Member/test"><button type="button" class="btn btn-default" style="width:195px">会员管理</button></a>
	    <a href="/WashingShop/Tools/test"><button type="button" class="btn btn-default" style="width:195px">洗衣用品管理</button></a>
	    <a href="/WashingShop/Clothes/test"><button type="button" class="btn btn-default" style="width:195px">衣物管理</button></a>
	
	</div>
	<div id="nav">
	<div id="home">
	<div id="block"></div>
	<form role="form" class="form-horizontal"  action="/WashingShop/deliver/do" method="post" id="dfrom">
	<table class="center-block">
	<tr>
	<td><label for="Oid" class="control-label">请输入单据号：</label></td>
	<td style="width:200px"><input type="text" class="form-horizontal" id="Oid" name = "Oid"></td>
	<td><button type="submit" class="btn btn-primary" >确定</button></td>
	</tr>
	</table>
	</form>
	</div>
	</div>
	<div id="footer">
	<hr color="#000" size="4px" align="center" width="1000px"/>
	<br/>
	<p>producer:8000116068 孙月棋 8000116076 张鑫雨 8000116086 黄诗诗 8000116120 王一清 8000116127 张涵</p>
	</div>
  </body>
</html>
