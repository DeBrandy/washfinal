<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP '11.jsp' starting page</title>
    
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
    <button type="button" class="btn btn-default" style="width:200px">收件</button>
    <button type="button" class="btn btn-default" style="width:201px">付件</button>
    <button type="button" class="btn btn-default" style="width:201px">会员管理</button>
    <button type="button" class="btn btn-default" style="width:201px">洗衣用品管理</button>
    <button type="button" class="btn btn-default" style="width:201px">衣物管理</button>
	</div>
	<div id="nav">
	<iframe  src="12.jsp"  width="1000px" height="150px" scrolling="no" frameborder="0"></iframe>
	<iframe  src="13.jsp"  width="1000px" height="520px" scrolling="no" frameborder="0"></iframe>
	
	<hr color="#CCC" size="4px" align="center" width="1000px"/>
	<table class="center-block">
	<tr>
	
	<td><button type="button" class="btn btn-primary center-block" data-toggle="collapse" data-target="#print" data-backdrop="static">结账并打印票据</button>
	<div class="collapse" id="print">
       <table>
       <tr><td></td><td><h3>收  据</h3></td></tr>
       <tr><td>手机号：</td><td><input type="text" class="form-horizontal" id="Cid" readonly></td></tr>
       <tr><td>单据号：</td><td><input type="text" class="form-horizontal" id="Oid" readonly></td></tr>
       <tr><td>衣服数量：</td><td><input type="text" class="form-horizontal" id="Number" readonly></td></tr>
       <tr><td>日期：</td><td><input type="text" class="form-horizontal" id="Time" readonly></td></tr>
       <tr><td>总价：</td><td><input type="text" class="form-horizontal" id="Ccost" readonly></td></tr>
       </table>       
  	</div>
	</td>
	</tr>
	</table>
	</div>
	</div>
	<div id="footer">
	<hr color="#000" size="4px" align="center" width="1000px"/>
	<br/>
	<p>producer:</p>
	</div>
  </body>
</html>