<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>会员管理</title>
    
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
	<form id="search_User" role="form" class="form-horizontal" >
	<table>
	<tr>
	<td><label for="search_id" class="control-label">手机号：</label></td>
	<td><input type="text" class="form-horizontal" id="search_id" name="Cid" ></td>
	<td style="width:100px"><input type="button" class="btn btn-primary center-block" value="查询" onclick=""/></td>
	<td style="width:250px"></td>
	<td style="width:150px"><input type="button" class="btn btn-primary" value="按手机号排序" onclick=""/></td>
	<td style="width:150px"><input type="button" class="btn btn-primary" value="按总消费排序" onclick=""/></td>
	<td><input type="button" class="btn btn-primary" value="按余额排序" onclick=""/></td>
	</tr>
	</table>
	</form>
	<table class="table table-hover center-block" id="MTable" style="width:1000px;text-align:center">
        		<tr><td>手机号</td><td>姓名</td><td>性别</td><td>地址</td><td>会员类型</td><td>卡内余额</td><td>总消费</td><td>折扣</td><td>操作</td><td>操作</td></tr>
        		<c:forEach items="${one}" var="a">
       			<tr>
        		<td>${a.Cid} </td>
        		<td>${a.Cname}</td>
       		    <td>${a.Csex}</td>
       		    <td>${a.Cad}</td>
       		    <td>${a.Ctype}</td>
       		    <td>${a.Cba}</td>
       		    <td>${a.Ccost}</td>
       		    <td>${a.Discount}</td>
			    <td><input type="button" value="删除" class="btn btn-primary center-block"></td>
			    <td><input type="button" value="修改" class="btn btn-primary center-block" data-toggle="modal" data-target="#DModal"></td>
      			</tr>
      		
     		 	</c:forEach>
           
     </table>
	
	<hr color="#CCC" size="4px" align="center" width="1000px"/>
	<button class="btn btn-primary" data-toggle="modal" data-target="#AModal">添加会员</button>
	<button class="btn btn-primary" data-toggle="modal" data-target="#CModal">会员充值</button>
    <!--  定义模态框触发器，此处为按钮触发  -->

    <form method="post" action="#" class="form-horizontal" role="form" id="myForm1" onsubmit="return ">
        <div class="modal fade" id="AModal"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <!--  定义模态框，过渡效果为淡入，id为myModal,tabindex=-1可以禁用使用tab切换，aria-labelledby用于引用模态框的标题，aria-hidden=true保持模态框在触发前窗口不可见  -->
            <div class="modal-dialog">
                <!--  显示模态框对话框模型（若不写下一个div则没有颜色）  -->
                <div class="modal-content">
                    <!--  显示模态框白色背景，所有内容都写在这个div里面  -->

                    

                    <div class="modal-body">
                        <!--  模态框内容，我在此处添加一个表单 -->
                        <label><h3>请添加会员</h3></label>
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="Cid" class="col-sm-2 control-label">手机号</label>
                                <div class="col-sm-9">
                                    <input type="text" id="Cid" name="Cid" class="form-control well"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="Cname" class="col-sm-2 control-label">姓名</label>
                                <div class="col-sm-9">
                                    <input type="text" id="Cname" name="Cname" class="form-control well"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="Csex" class="col-sm-2 control-label">性别</label>
                                <div class="col-sm-4">
                                <input name="Csex" type="radio" value="" checked="checked"/>男
                                </div>
                                <div class="col-sm-4">
                                <input name="Csex" type="radio" value="" />女 
                                <!--  <input type="text" id="Csex" name="Csex" class="form-control well"/>-->
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="Cad" class="col-sm-2 control-label">地址</label>
                                <div class="col-sm-9">
                                    <input type="text" id="Cad" name="Cad" class="form-control well"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="Ccost" class="col-sm-2 control-label">充值金额</label>
                                <div class="col-sm-9">
                                    <input type="text" id="Ccost" name="Ccost" class="form-control well"/>
                                </div>
                            </div>
                        </form>
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
    <form method="post" action="#" class="form-horizontal" role="form" id="myForm2" onsubmit="return ">
        <div class="modal fade" id="CModal"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <!--  定义模态框，过渡效果为淡入，id为myModal,tabindex=-1可以禁用使用tab切换，aria-labelledby用于引用模态框的标题，aria-hidden=true保持模态框在触发前窗口不可见  -->
            <div class="modal-dialog">
                <!--  显示模态框对话框模型（若不写下一个div则没有颜色）  -->
                <div class="modal-content">
                    <!--  显示模态框白色背景，所有内容都写在这个div里面  -->

                    

                    <div class="modal-body">
                        <!--  模态框内容，我在此处添加一个表单 -->
                        <label><h3>会员充值</h3></label>
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="Cid" class="col-sm-2 control-label">手机号</label>
                                <div class="col-sm-9">
                                    <input type="text" id="Cid" name="Cid" class="form-control well"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="Ccost" class="col-sm-2 control-label">充值金额</label>
                                <div class="col-sm-9">
                                    <input type="text" id="Ccost" name="Ccost" class="form-control well"/>
                                </div>
                            </div>
                        </form>
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
    <form method="post" action="#" class="form-horizontal" role="form" id="myForm3" onsubmit="return ">
        <div class="modal fade" id="DModal"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <!--  定义模态框，过渡效果为淡入，id为myModal,tabindex=-1可以禁用使用tab切换，aria-labelledby用于引用模态框的标题，aria-hidden=true保持模态框在触发前窗口不可见  -->
            <div class="modal-dialog">
                <!--  显示模态框对话框模型（若不写下一个div则没有颜色）  -->
                <div class="modal-content">
                    <!--  显示模态框白色背景，所有内容都写在这个div里面  -->

                    

                    <div class="modal-body">
                        <!--  模态框内容，我在此处添加一个表单 -->
                        <label><h3>修改会员信息</h3></label>
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="Cid" class="col-sm-2 control-label">手机号</label>
                                <div class="col-sm-9">
                                    <input type="text" id="Cid" name="Cid" class="form-control well"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="Cname" class="col-sm-2 control-label">姓名</label>
                                <div class="col-sm-9">
                                    <input type="text" id="Cname" name="Cname" class="form-control well"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="Csex" class="col-sm-2 control-label">性别</label>
                                <div class="col-sm-4">
                                <input name="Csex" type="radio" value="" checked="checked"/>男
                                </div>
                                <div class="col-sm-4">
                                <input name="Csex" type="radio" value="" />女 
                                <!--  <input type="text" id="Csex" name="Csex" class="form-control well"/>-->
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="Cad" class="col-sm-2 control-label">地址</label>
                                <div class="col-sm-9">
                                    <input type="text" id="Cad" name="Cad" class="form-control well"/>
                                </div>
                            </div>
                        </form>
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
	<hr color="#000" size="4px" align="center" width="1000px"/>
	<br/>
	<p>producer:</p>
	</div>
  </body>
</html>
