<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP '12.jsp' starting page</title>
    
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
	<form role="form" class="form-horizontal"  action="" method="get" id="from1">
	<hr color="#CCC" size="4px" align="center" width="1000px"/>
	<table class="center-block">
	<tr>
	<td><label for="Cid" class="control-label">查询用户：</label></td>
	<td style="width:200px"><input type="text" class="form-horizontal" id="Cid"></td>
	<td><a id="search" type="submit" class="btn btn-primary">确  定</a></td>
	</tr>
	</table>
	<table class="center-block">
	<tr>
	<td style="width:100px"><label for="Cname" class="control-label">姓名：</label></td>
	<td style="width:200px"><input type="text" class="form-horizontal" id="Cname" readonly></td>
	<td style="width:100px"><label for="Cba" class="control-label">卡内余额：</label></td>
	<td style="width:200px"><input type="text" class="form-horizontal" id="Cba" readonly></td>
	<td style="width:100px"><label for="Ctype" class="control-label">会员等级：</label></td>
	<td style="width:200px"><input type="text" class="form-horizontal" id="Ctype" readonly></td>
	</tr>
	<tr>
	<td><label for="Oid" class="control-label">未取件单号：</label></td>
	<td><input type="text" class="form-horizontal" id="Oid" readonly></td>
	<td><label for="Ccost" class="control-label">总消费：</label></td>
	<td><input type="text" class="form-horizontal" id="Ccost" readonly></td>
	<td><label for="Cad" class="control-label">地址：</label></td>
	<td><input type="text" class="form-horizontal" id="Cad" readonly></td>
	</tr>
	</table>
	</form>
	
  </body>
</html>
	
