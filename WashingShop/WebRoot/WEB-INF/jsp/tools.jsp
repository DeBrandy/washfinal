<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>洗衣用品管理</title>
    
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
	<script type="text/javascript">
	/** function set_1(){
	  	List<Client> client =session.getAttribute("six");
	  	session.setAttribute("client_2",client_2);
	};
		 function set_2(){
	  	List<Client> client =null;
	  	client.add(session.getAttribute("seven"));
	  	session.setAttribute("client_2",client_2);
	};*/
	
  	</script>
  </head>
  
  <body>
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	 
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="./bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap-table/1.12.1/bootstrap-table.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap-table/1.12.1/locale/bootstrap-table-zh-CN.js"></script>
  	<script type="text/javascript" src="./own.js"></script>

	<div id="nav">
	
	    <a href="/WashingShop/receive/test"><button type="button" class="btn btn-default" style="width:195px">收件</button></a>
	    <a href="/WashingShop/deliver/test"><button type="button" class="btn btn-default" style="width:195px">付件</button></a>
	    <a href="/WashingShop/Member/test"><button type="button" class="btn btn-default" style="width:195px">会员管理</button></a>
	    <a href="/WashingShop/Tools/test"><button type="button" class="btn btn-default" style="width:195px">洗衣用品管理</button></a>
	    <a href="/WashingShop/Clothes/test"><button type="button" class="btn btn-default" style="width:195px">衣物管理</button></a>
	
	</div>
	<div id="nav">
	<form id="search_Use" role="form" class="form-horizontal" action="/WashingShop/Tools/findOne">
	<table>
	<tr>
	<td><label for="search_Uname" class="control-label">用品名：</label></td>
	<td><input type="text" class="form-horizontal" id="search_Uname" name="Uname" ></td>
	<td style="width:100px"><input type="submit" class="btn btn-primary center-block" value="查询"/></td>
	</tr>
	</table>
	</form>
	<form id="findall" action="/WashingShop/Tools/findAll">
	<button type="submit" class="btn btn-primary ">查看所有的用品</button>
	
	<table class="table table-hover " id="UTable" style="width:1000px;text-align:center">
        		<tr><td style="width:350px">用品名</td><td style="width:350px">数量</td><td>操作</td><td>操作</td></tr>
        		<c:forEach items="${requestScope.client_2}" var="u">
       			<tr>
        		<td>${u.uname} </td>
        		<td>${u.unum}</td>
			    <td><a href="/WashingShop/Tools/delete?uname=${u.uname}"><input type="button" value="删除" class="btn btn-primary center-block"></a></td>
			    <td><input type="button" value="修改" class="btn btn-primary center-block" data-toggle="modal" data-target="#DModal" ></td>
      			</tr>
      		
     		 	</c:forEach>
           
     </table>
	</form>
	<hr color="#CCC" size="4px"  width="1000px"/>
	<button class="btn btn-primary" data-toggle="modal" data-target="#UModal">添加商品</button>
    <!--  定义模态框触发器，此处为按钮触发  -->

    <form method="post" action="/WashingShop/Tools/insert" class="form-horizontal" role="form" id="myForm1" onsubmit="return ">
        <div class="modal fade" id="UModal"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <!--  定义模态框，过渡效果为淡入，id为myModal,tabindex=-1可以禁用使用tab切换，aria-labelledby用于引用模态框的标题，aria-hidden=true保持模态框在触发前窗口不可见  -->
            <div class="modal-dialog">
                <!--  显示模态框对话框模型（若不写下一个div则没有颜色）  -->
                <div class="modal-content">
                    <!--  显示模态框白色背景，所有内容都写在这个div里面  -->
					<div class="modal-body">
                        <!--  模态框内容，我在此处添加一个表单 -->
                        <label><h3>请添加商品</h3></label>
                       
                            <div class="form-group">
                                <label for="Uname" class="col-sm-2 control-label">用品名</label>
                                <div class="col-sm-9">
                                    <input type="text" id="Uname" name="Uname" class="form-control well"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="num" class="col-sm-2 control-label">数量</label>
                                <div class="col-sm-9">
                                    <input type="text" id="num" name="num" class="form-control well"/>
                                </div>
                            </div>
                       
                    </div>

                    <div class="modal-footer">
                        <!--  模态框底部样式，一般是提交或者确定按钮 -->
                        <button type="submit" class="btn btn-primary">确定</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    </div>

                </div><!-- /.modal-content -->
            </div>
        </div> <!-- /.modal -->
    </form>
    
    
     <form method="post" action="/WashingShop/Tools/update" class="form-horizontal" role="form" id="myForm3" onsubmit="return ">
 
        <div class="modal fade" id="DModal"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <!--  定义模态框，过渡效果为淡入，id为myModal,tabindex=-1可以禁用使用tab切换，aria-labelledby用于引用模态框的标题，aria-hidden=true保持模态框在触发前窗口不可见  -->
            <div class="modal-dialog">
                <!--  显示模态框对话框模型（若不写下一个div则没有颜色）  -->
                <div class="modal-content">
                    <!--  显示模态框白色背景，所有内容都写在这个div里面  -->

                    

                    <div class="modal-body">
                        <!--  模态框内容，我在此处添加一个表单 -->
                        <label><h3>修改会员信息</h3></label>
  							<div class="form-group">
                                <label for="Cid" class="col-sm-2 control-label">用品名</label>                     
                                 
                                <div class="col-sm-9">
                                    <input type="text" id="Uname_1" name="Uname_1" class="form-control well"/>
                                </div>
                            </div>                    
                            <div class="form-group">
                                <label for="Cid" class="col-sm-2 control-label">新用品名</label>
                                <div class="col-sm-9">
                                    <input type="text" id="Uname_2" name="Uname_2" class="form-control well"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="Cname" class="col-sm-2 control-label">数量</label>
                                <div class="col-sm-9">
                                    <input type="text" id="num" name="num" class="form-control well"/>
                                </div>
                            </div>
                    </div>

                    <div class="modal-footer">
                        <!--  模态框底部样式，一般是提交或者确定按钮 -->
                        <button type="submit" class="btn btn-primary">确定</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    </div>

                </div><!-- /.modal-content -->
            </div>
        </div> <!-- /.modal -->
    </form>  
	</div>
	<div id="footer">
	<hr color="#000" size="4px" align="left" width="1000px"/>
	<br/>
	<p>producer:8000116068 孙月棋 8000116076 张鑫雨 8000116086 黄诗诗 8000116120 王一清 8000116127 张涵</p>
	</div>
  </body>
</html>
