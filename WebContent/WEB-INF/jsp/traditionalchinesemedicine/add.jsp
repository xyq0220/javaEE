<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中草药添加</title>
</head>
<body>
    <div align="center">
	<form action="addProc" method="post">
		<table>
			<tr>
				<td>编号</td>
				<td><input type="text" name="number"/></td>
			</tr>
			<tr>
				<td>中草药</td>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td>别名</td>
				<td><input type="text" name="alias"/></td>
			</tr>
            <tr>
				<td>归属类别</td>
				<td>
					<select name="type">
					  <option value ="1">上经</option>
					  <option value ="2">中经</option>
					  <option value="3">下经</option>
					  <option value="4">增补</option>
					</select>
				</td>
			</tr>
            <tr>
				<td>本经原文</td>
				<td><input type="text" name="bjyw"/></td>
			</tr>
            <tr>
				<td>主治</td>
				<td><input type="text" name="zhuzhi"/></td>
			</tr>
            <tr>
				<td>性味</td>
				<td><input type="text" name="xingwei"/></td>
			</tr>
            <tr>
				<td>产地</td>
				<td><input type="text" name="chandi"/></td>
			</tr>
            <tr>
				<td>用量</td>
				<td><input type="text" name="dosage"/></td>
			</tr>
            <tr>
				<td>禁忌</td>
				<td><input type="text" name="taboo"/></td>
			</tr>
            <tr>
				<td>炮制</td>
				<td><input type="text" name="processing"/></td>
			</tr>
			<tr>
				<td>倪注</td>
				<td><input type="text" name="note"/></td>
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