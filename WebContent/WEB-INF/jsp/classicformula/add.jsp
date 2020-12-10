<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<form action="addProc" method="post">
	
		<table>
			<tr>经方</tr>
			<tr>
				<td>经方名</td>
				<td><input type="text" name="name"/></td>
			</tr>
			
			<tr>
				<td>熬制方法</td>
				<td><input type="text" name="usage"/></td>
			</tr>
			<tr>
				<td>注释</td>
				<td><input type="text" name="comment"/></td>
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