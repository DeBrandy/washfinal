<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主页</title>
    
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
    <div id="top"></div>
	<div id="nav">
	<div class="btn-group">
    <a href="/WashingShop/receive/test"><button type="button" class="btn btn-default" style="width:200px">收件</button></a>
    <a href="/WashingShop/deliver/test"><button type="button" class="btn btn-default" style="width:201px">付件</button></a>
    <a href="/WashingShop/Member/test"><button type="button" class="btn btn-default" style="width:201px">会员管理</button></a>
    <a href="/WashingShop/Tools/test"><button type="button" class="btn btn-default" style="width:201px">洗衣用品管理</button></a>
    <button type="button" class="btn btn-default" style="width:201px">衣物管理</button>
	</div>
	<div id="nav">
	<div id="home">
	<div id="block"></div>
	<div class="text-center">
	<h1>欢迎使用本系统</h1>
	</div>
	</div>
	</div>
	<div id="footer">
	<hr color="#000" size="4px" align="center" width="1000px"/>
	<br/>
	<p>producer:8000116068 孙月棋 8000116076 张鑫雨 8000116086 黄诗诗 8000116097 钟明 8000116120 王一清 8000116127 张涵
	</p>
	</div>
  </body>
</html>
