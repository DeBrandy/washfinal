<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录界面</title>
    
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
	<div id="block"></div>
	<div class="text-center">
	<h1 style="font-size: 60px">快落洗衣管理系统</h1>
	</div>
  	<div id="login">
	<form class="form-horizontal" role="form" action="/WashingShop/Login/validLogin" method="get" id="login">
	  <div class="form-group">
	    <label for="username" class="col-sm-2 control-label"><span class="glyphicon glyphicon-user" style="font-size: 20px"></span></label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="username" placeholder="用户名">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="password" class="col-sm-2 control-label"><span class="glyphicon glyphicon-asterisk" style="font-size: 20px"></span></label>
	    <div class="col-sm-10">
	      <input type="password" class="form-control" id="password" placeholder="密码">
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-10">
	      <button type="submit" style="width:280px;" class="btn btn-primary">登 录</button>
	    </div>
	  </div>
	</form>
	</div>
  </body>
</html>
