<%@page contentType="text/html;charset=utf-8" import="java.util.*"%>
<%@page import="com.banksystem.entity.Admin"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	if (session.getAttribute("admin") == null) {
		response.sendRedirect("login.jsp");

	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"">
<link rel="stylesheet" type="text/css" href="../style/style.css">
<link rel="stylesheet" type="text/css" href="../style/default.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/jquery.pagination.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/style.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/ckform.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.pagination.min.js"></script>
<style>
table input {
	height: 30px !important;
}

table tr td {
	vertical-align: middle !important;
}
</style>
</head>
<body>
	<div>
		<form action="/banksystem/admin/search" method="POST" class="form-inline definewidth m20">
			姓名：<input name="personinfo.realname" class="form-control" placeholder="请输入要查询用户姓名"/> 
			<input name="status.id" type="hidden" value="${status.id}">
			<input type=submit value="提交" class="btn btn-primary"></input>
		</form>
		<table border="0" class="table table-bordered definewidth m10">
			<thead>
				<tr style="font-weight:bold;">
					<td style="text-align:center;">序列</td>
					<td style="text-align:center;">账户</td>
					<td style="text-align:center;">用户名</td>
					<td style="text-align:center;">账户余额</td>
					<td style="text-align:center;">姓名</td>
					<td style="text-align:center;">详细地址</td>
					<td style="text-align:center;">身份证号</td>
					<td style="text-align:center;">电话</td>
					<td style="text-align:center;">状态</td>
					<td style="text-align:center;">操作</td>
				</tr>
			</thead>
			<tbody>
				<!-- 循环显示用户信息部分 -->
				<s:iterator value="#request.users" status="status">
					<tr>
						<td height="20" valign="middle">
							<div id="noWrap" align="center">
								<s:property value="#status.count" />
							</div></td>
						<td valign="middle">
							<div id="noWrap" align="center">
								<s:property value="account.accountid" />
							</div></td>
						<td valign="middle">
							<div id="noWrap" align="center">
								<s:property value="account.username" />
							</div></td>
						<td height="20" valign="middle">
							<div id="noWrap" align="center">
								<s:property value="account.balance" />
							</div>
						</td>
						<td height="20" valign="middle">
							<div id="noWrap" align="center">
								<s:property value="realname" />
							</div>
						</td>
						<td valign="middle">
							<div id="noWrap" align="center">
								<s:property value="address" />
							</div></td>
						<td valign="middle">
							<div id="noWrap" align="center">
								<s:property value="cardid" />
							</div></td>
						<td valign="middle">
							<div id="noWrap" align="center">
								<s:property value="telephone" />
							</div></td>
						<td valign="middle">
							<div id="noWrap" align="center">
								<s:property value="account.status.name" />
							</div></td>
						<td>
							<div id="noWrap" align="center">
								<s:if test="account.status.name=='启用'">
									<input type="button" value="冻结" class="btn btn-info"
										onclick="javascript:location.href='/banksystem/admin/locking?id=${account.accountid}&status.id=${status.id}'">
								</s:if>
								<s:else>
									<input type="button" value="启用" class="btn btn-success"
										onclick="javascript:location.href='/banksystem/admin/enabled?id=${account.accountid}&status.id=${status.id}'">
								</s:else>
								<a href="/banksystem/admin/del?id=${account.accountid}&status.id=${status.id}" style="color:#fff;" class="btn btn-danger">&nbsp;删除&nbsp;</a>
							</div>
						</td>
					</tr>
				</s:iterator>
				<tr>
					<td height="20" colspan="14" valign="middle"></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>
