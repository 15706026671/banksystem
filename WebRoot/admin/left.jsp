<%@page contentType="text/html;charset=utf-8"
	import="java.sql.*,java.util.*"%>
<%
	if (session.getAttribute("admin") != null) {
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../style/style.css">
<link rel="stylesheet" type="text/css" href="../style/default.css">
</head>
<BODY leftmargin="20" topmargin="0" marginheight="0" marginwidth="0">
	<table height="100%" cellspacing=0 cellpadding=0 width=170
		background="${pageContext.request.contextPath }/images/menu_bg.jpg" border=0>
		<tr>
			<td valign=top align=middle>
				<table cellspacing=0 cellpadding=0 width=150 border=0>
					<tr height=22>
						<td style="padding-left: 30px" background="${pageContext.request.contextPath }/images/menu_bt.jpg"><a
							class=menuparent onclick=expand(1) href="javascript:void(0);">后台管理</a>
						</td>
					</tr>
					<tr height=4>
						<td></td>
					</tr>
				</table>
				<table id=child0 cellspacing=0 cellpadding=0 width=150 border=0>
					<tr height=20>
						<td align=middle width=30><img height=9
							src="/banksystem/images/menu_icon.gif" width=9>
						</td>
						<td height=20><a class=menuchild href=/banksystem/admin/listUsers?status.id=0
							target=right>所有账户</a>
						</td>
					</tr>
					<tr height=20>
						<td align=middle width=30><img height=9
							src="/banksystem/images/menu_icon.gif" width=9>
						</td>
						<td height=20><a href=/banksystem/admin/listUsers?status.id=2
							target=right>已冻结账户</a>
						</td>
					</tr>
					<tr height=20>
						<td align=middle width=30><img height=9
							src="/banksystem/images/menu_icon.gif" width=9>
						</td>
						<td height=20><a href=/banksystem/admin/listUsers?status.id=1
							target=right>已启用账户</a>
						</td>
					</tr>
					<tr height=20>
						<td align=middle width=30><img height=9
							src="/banksystem/images/menu_icon.gif" width=9>
						</td>
						<td height=20><a href=/banksystem/admin/add.jsp target=right>开户</a>
						</td>
					</tr>
					<tr height=20>
						<td align=middle width=30><img height=9
							src="/banksystem/images/menu_icon.gif" width=9>
						</td>
						<td height=20><a href=/banksystem/admin/changepwd.jsp
							target=right>修改个人密码</a>
						</td>
					</tr>
					<tr height=20>
						<td align=middle width=30><img height=9
							src="/banksystem/images/menu_icon.gif" width=9>
						</td>
						<td height=20><a href=/banksystem/admin/logout target=_top>注销</a>
						</td>
					</tr>
				</table>
			</td>
			<td width=1 bgcolor=#d1e6f7></td>
		</tr>
	</table>

	<%
		} else {
			response.sendRedirect("index.jsp");
		}
	%>