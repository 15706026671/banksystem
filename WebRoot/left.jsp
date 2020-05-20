<%@page contentType="text/html;charset=gb2312"
	import="java.sql.*,java.util.*"%>
<html>
<head>
<title>管理页面</title>
<LINK href="css/admin.css" type="text/css" rel="stylesheet">
</head>
<BODY leftmargin="20" topmargin="0" marginheight="0" marginwidth="0" style="margin: 10px 0 0 0; padding: 0;">
	<table height="100%" cellspacing=0 cellpadding=0 width=170
		background=images/menu_bg.jpg border=0>
		<tr>
			<td valign=top align=middle>
				<table cellspacing=0 cellpadding=0 width=150 border=0>
					<tr height=22>
						<td style="padding-left: 30px" background=images/menu_bt.jpg><a
							class=menuparent onclick=expand(1) href="javascript:void(0);">操作菜单</a>
						</td>
					</tr>
					<tr height=4>
						<td></td>
					</tr>
				</table>
				<table id=child0 cellspacing=0 cellpadding=0 width=150 border=0>
					<tr height=20>
						<td align=middle width=30><img height=9
							src="images/menu_icon.gif" width=9>
						</td>
						<td><a class=menuchild href="/banksystem/deposit.jsp"
							target=main>存款</a>
						</td>
					</tr>
					<tr height=20>
						<td align=middle width=30><img height=9
							src="images/menu_icon.gif" width=9>
						</td>
						<td><a class=menuchild href="/banksystem/withdrawal.jsp"
							target=main>取款</a>
						</td>
					</tr>
					<tr height=20>
						<td align=middle width=30><img height=9
							src="images/menu_icon.gif" width=9>
						</td>
						<td><a class=menuchild href="/banksystem/transfer.jsp"
							target=main>转账</a>
						</td>
					</tr>
					<tr height=20>
						<td align=middle width=30><img height=9
							src="images/menu_icon.gif" width=9>
						</td>
						<td><a class=menuchild
							href="/banksystem/transaction/list?pager.curpage=1" target=main>查询交易记录</a>
						</td>
					</tr>
					<tr height=20>
						<td align=middle width=30><img height=9
							src="images/menu_icon.gif" width=9>
						</td>
						<td><a class=menuchild href="/banksystem/information.jsp"
							target=main>查看信息</a>
						</td>
					</tr>
					<tr height=20>
						<td align=middle width=30><img height=9
							src="images/menu_icon.gif" width=9>
						</td>
						<td><a class=menuchild href="/banksystem/modify.jsp" target=main>修改个人信息</a>
						</td>
					</tr>
					<tr height=20>
						<td align=middle width=30><img height=9
							src="images/menu_icon.gif" width=9>
						</td>
						<td><a class=menuchild href="/banksystem/changepwd.jsp"
							target=main>修改密码</a>
						</td>
					</tr>
					<tr height=20>
						<td align=middle width=30><img height=9
							src="images/menu_icon.gif" width=9>
						</td>
						<td><a class=menuchild onclick="logout()" target=main>注销</a>
						</td>
					</tr>
				</table></td>
			<td width=1 bgcolor=#d1e6f7></td>
		</tr>
	</table>
	<script>
		function logout() {
			window.parent.location.href = '${pageContext.request.contextPath}/user/user_logout';
		}
	</script>