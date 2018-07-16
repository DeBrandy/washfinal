<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>收件界面</title>
    
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
	  	function initTable() { 
		  //先销毁表格 
		  $('#PTable').bootstrapTable('destroy'); 
		  //初始化表格,动态从服务器加载数据 
		  $("#PTable").bootstrapTable({ 
		   method: "get", //使用get请求到服务器获取数据 
		   url: "<c:url value='/SellServlet?act=ajaxGetSellRecord'/>", //获取数据的Servlet地址 
		   striped: true, //表格显示条纹 
		   pagination: true, //启动分页 
		   pageSize: 5, //每页显示的记录数 
		   pageNumber:1, //当前第几页 
		   pageList: [5, 10, 15, 20, 25], //记录数可选列表 
		   search: false, //是否启用查询 
		   showColumns: false, //显示下拉框勾选要显示的列 
		   showRefresh: false, //显示刷新按钮 
		   showToggle: false,
		   sidePagination: "server", //表示服务端请求 
		   //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder 
		   //设置为limit可以获取limit, offset, search, sort, order 
		   queryParamsType : "undefined", 
		   queryParams: function queryParams(params) { //设置查询参数 
		    var param = { 
		     pageNumber: params.pageNumber, 
		     pageSize: params.pageSize
		    }; 
		    return param;     
		   }, 
		   onLoadSuccess: function(){ //加载成功时执行 
		    layer.msg("加载成功"); 
		   }, 
		   onLoadError: function(){ //加载失败时执行 
		    layer.msg("加载数据失败", {time : 1500, icon : 2}); 
		   } 
		   }); 
		  } 
		  $(document).ready(function () {   
		   //调用函数，初始化表格 
		   initTable(); 
		   //当点击添加按钮的时候执行 
		   $("#addtion").bind("click", initTable); 
		  }); 
		  $table.bootstrapTable(	  
		  formatLoadingMessage: function(){
		    return "请稍等，正在加载中。。。";
		  }
			);
  	</script>
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
	<form role="form" class="form-horizontal"  action="/receiveselect" method="post" id="from1">
	<hr color="#CCC" size="4px" align="center" width="1000px"/>
	<table class="center-block">
	<tr>
	<td><label for="Cid" class="control-label">查询用户：</label></td>
	<td style="width:200px"><input type="text" class="form-horizontal" id="Cid" name="Cid"></td>
	<td><button id="search" type="submit" class="btn btn-primary">确  定</button></td>
	</tr>
	<tr>
	<td style="width:100px"><label for="Cname" class="control-label">姓名：</label></td>
	<td style="width:200px"><input type="text" class="form-horizontal" id="Cname" readonly value="$(requestScope.client.Cname)"></td>
	<td style="width:100px"><label for="Cba" class="control-label">卡内余额：</label></td>
	<td style="width:200px"><input type="text" class="form-horizontal" id="Cba" readonly value="$(requestScope.client.Cba)"></td>
	<td style="width:100px"><label for="Ctype" class="control-label">会员等级：</label></td>
	<td style="width:200px"><input type="text" class="form-horizontal" id="Ctype" readonly vlaue="$(requestScope.client.Ctype)"></td>
	</tr>
	<tr>
	
	<td><label for="Ccost" class="control-label">总消费：</label></td>
	<td><input type="text" class="form-horizontal" id="Ccost" readonly value="$(requestScope.client.Ccost)" ></td>
	<td><label for="Cad" class="control-label">地址：</label></td>
	<td><input type="text" class="form-horizontal" id="Cad" readonly value="$(requestScope.client.Cad)"></td>
	</tr>
	</table>
	</form>
	<hr color="#CCC" size="4px" align="center" width="1000px"/>
	<form action="/receiveinfo" method="post" id="from2">
	<table class="center-block">
	<tr>
	<td><h3><label>收件信息</label></h3></td>
	</tr>
	<tr>
	<td style="width:100px"><label for="Type" class="control-label">服务类型：</label></td>
	<td style="width:200px">
		<div class="input-group" id="type">
            <input type="text" class="form-horizontal" onfocus="onTypeFocus()" onkeydown="onTypeKey()" onchange="onTypeChange()" list="typeInput" 
            class="form-control sel_input" name="Type">
            <datalist id="typeInput">
        </div><!-- /input-group -->
	</td>
	<td style="width:100px"><label for="Clo" class="control-label">服务项目：</label></td>
	<td style="width:200px">
		<div class="input-group" id="clo">
            <input type="text" class="form-horizontal" onfocus="onCloFocus()" onkeydown="onCloKey()" onchange="onCloChange()" list="cloInput" 
            class="form-control sel_input" name="Clo">
            <datalist id="cloInput"></datalist>
        </div><!-- /input-group -->
	</td>
	<td style="width:100px"><label for="Mat" class="control-label">材质：</label></td>
	<td style="width:200px">
		<div class="input-group" id="mat">
			<input type="text" class="form-horizontal" onfocus="onMatFocus()" onkeydown="onMatKey()" onchange="onMatChange()" list="matInput" 
			class="form-control sel_input" name="Mat">
            <datalist id="matInput"></datalist>
        </div><!-- /input-group -->
	</td>
	</tr>
	<tr>
	<td><label for="Color" class="control-label">颜色：</label></td>
	<td>
		<div class="input-group" id="color">
            <input type="text" class="form-horizontal" onfocus="onColorFocus()" onkeydown="onColorKey()" onchange="onColorChange()" list="colorInput" 
            class="form-control sel_input" name="Color">
            <datalist id="colorInput"></datalist>
        </div><!-- /input-group -->
	</td>
	<td><label for="Brand" class="control-label">品牌：</label></td>
	<td>
		<div class="input-group" id="brand">
            <input type="text" class="form-horizontal" onfocus="onBrandFocus()" onkeydown="onBrandKey()" onchange="onBrandChange()" list="brandInput" 
            class="form-control sel_input" name="Brand">
            <datalist id="brandInput"></datalist>
        </div><!-- /input-group -->
	</td>
	<td><label for="Flaw" class="control-label">瑕疵：</label></td>
	<td>
		<div class="input-group" id="flaw">
            <input type="text" class="form-horizontal" onfocus="onFlawFocus()" onkeydown="onFlawKey()" onchange="onFlawChange()" list="flawInput" 
            class="form-control sel_input" name="Flaw">
            <datalist id="flawInput"></datalist>
        </div><!-- /input-group -->
	</td>
	</tr>
	<tr>
	<td><label for="Add" class="control-label">附件：</label></td>
	<td>
		<div class="input-group" id="add">
            <input type="text" class="form-horizontal" onfocus="onAddFocus()" onkeydown="onAddKey()" onchange="onAddChange()" list="addInput" 
            class="form-control sel_input" name="Add">
            <datalist id="addInput"></datalist>
        </div><!-- /input-group -->
	</td>
	<td><label for="Price" class="control-label">价格：</label></td>
	<td>
		<div class="input-group">
            <input type="text" class="form-horizontal" id="Price" name="Price">
        </div><!-- /input-group -->
	</td>
	<td><label for="Id" class="control-label">挂衣号：</label></td>
	<td>
		<div class="input-group">
            <input type="text" class="form-horizontal" id="Id" name="Id">
        </div><!-- /input-group -->
	</td>
	<tr>
	<td></td><td></td><td></td>
	<td><button id="addition" type="submit" class="btn btn-primary">添  加</button></td>
	<td></td>
	</tr>
	</table>
	</form>
	<hr color="#CCC" size="4px" align="center" width="1000px"/>
	<form action="/receiveaccount" method="post" id="from3">
	 <table class="table table-hover center-block" id="PTable" style="width:900px"
	  data-pagination="true"
	  data-show-refresh="true"
	  data-show-toggle="true"
	  data-showColumns="true"> 
	  <thead> 
	   <tr>               
	    <th data-field="Id" data-sortable="true" style="width:300px">挂衣号</th> <!-- 该怎么加入一行数据? -->
	    <th data-field="Price" style="width:300px">价格</th>
	    <th data-field="Dprice" style="width:300px">折后价</th>  
	   </tr> 
	  </thead> 
	  <tbody> 
	  </tbody> 
	</table>
	<hr color="#CCC" size="4px" align="center" width="1000px"/>
	<table class="center-block">
	<tr>
	
	<td><button type="button" class="btn btn-primary center-block" data-toggle="collapse" data-target="#print" data-backdrop="static">结账并打印票据</button>
	<div class="collapse" id="print">
       <table>
       <tr><td></td><td><h3>收  据</h3></td></tr>
       <tr><td>手机号：</td><td><input type="text" class="form-horizontal" id="Cid" readonly vlaue="$(requestScope.client.Cid)"></td></tr>
       <tr><td>单据号：</td><td><input type="text" class="form-horizontal" id="Oid" readonly vlaue="$(requestScope.client.Oid"></td></tr>
       <tr><td>衣服数量：</td><td><input type="text" class="form-horizontal" id="Number" readonly vlaue="$(requestScope.client.Number)"></td></tr>
       <tr><td>日期：</td><td><input type="text" class="form-horizontal" id="Time" readonly vlaue="$(requestScope.client.Time)"></td></tr>
       <tr><td>总价：</td><td><input type="text" class="form-horizontal" id="Ccost" readonly vlaue="$(requestScope.client.Money)"></td></tr>
       </table>       
  	</div>
	</td>
	</tr>
	</table>
	</form>
	</div>
	<div id="footer">
	<hr color="#000" size="4px" align="center" width="1000px"/>
	<br/>
	<p>producer:</p>
	</div>
  </body>
</html>

