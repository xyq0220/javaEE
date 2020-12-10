<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>使用心得添加</title>
</head>
<body>
	<%
		String tcmid = (String)request.getAttribute("tcmid");
	%>
    <div align="center">
	<form action="addProc" method="post">
		<input type="hidden" name="tcmid" value="<%=tcmid%>"/>
		<table>
			<tr>
				<td>出处</td>
				<td><input type="text" name="chuchu"/></td>
			</tr>
			<tr>
				<td>内容</td>
				<td><input type="text" name="content"/></td>
			</tr>			
			<tr>
				<td colspan="2">
					<input type="submit" value="保存"/>&nbsp;
					<input type="reset" value="重置"/>
				</td>
			</tr>
		</table>
	</form>
    </div>
</body>
</html>