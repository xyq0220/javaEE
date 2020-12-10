<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="po.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String cfid = (String)request.getAttribute("cfid");
	%>
 <div align="center">
	<form action="addProc" method="post">
	<input type="hidden" name="cfid" value="<%=cfid%>"/>
		<table>
			<tr>
				<td>草药名：</td>
				<td><input type="text" name="tcmid"/></td>
			</tr>
			<tr>
				<td>用量：</td>
				<td><input type="text" name="dosage"/></td>
			</tr>
            <tr>
				<td>用法：</td>
				<td><input type="text" name="usage"/></td>
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