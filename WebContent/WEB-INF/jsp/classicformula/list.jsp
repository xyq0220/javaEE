<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="po.*" %>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<h1>经方</h1>
		<form action="list" method="post">
		<input type="text" name="name">
		<input type="submit" value="提交">
	</form>
	<h2><a href="">经方表</a></h2>

	<%
		List<Classicformula> claList = (List<Classicformula>)request.getAttribute("claList");
	%>
		<table border="2" width="500px">
			<tr>
				<th>编号</th>
				<th>经方名</th>
				<th>熬制方法</th>
				<th>注释</th>
				<th>操作</th>
			</tr>
			
	<%
		for(int i=0;i<claList.size();i++){
			Classicformula cla=claList.get(i);
		
	%>
			<tr>
				<td><%=cla.getId() %></td>
				<td><%=cla.getName() %></td>
				<td><%=cla.getUsage() %></td>
				<td><%=cla.getComment() %></td>
			</tr>
			<tr>
			<td colspan="4"><a href="../cfc/list?cfid=<%=cla.getId()%>">查看经方组成</a></td>
			</tr>
			<%} %>
		</table>
		
	</div>
</body>
</html>