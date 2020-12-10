<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="po.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>经方组成</title>
</head>
<body>


<div class="main">

	 <%
	 String cfid = (String)request.getAttribute("cfid");
	 String cfname = (String)request.getAttribute("cfname");
	 %>
	 <h1>经方组成</h2>
	 <h4><a href="add?cfid=<%=cfid%>">添加</a>&nbsp;&nbsp;</h4>
	 <%
	 	List<Classicformulacomposition> cfcList = (List<Classicformulacomposition>)request.getAttribute("cfcList");
		List<String> tcnameList = (List<String>)request.getAttribute("tcnameList"); 
	 %>
	 <table border="2" width="500px">
	 	<tr colspan="3">
	 		<th><%=cfname %></th>
	 	</tr>
	 	<tr>
	 		<th>草药</th>
	 		<th>用量</th>
	 		<th>用法</th>
	 	</tr>
		 <%
		 	for(int i=0;i<cfcList.size();i++){
		 		Classicformulacomposition cfc = cfcList.get(i);
		 		String tcname = tcnameList.get(i);
		 %>
	 	<tr>
	 		<th><%=tcname %></th>
	 		<th><%=cfc.getDosage() %></th>
	 		<th><%=cfc.getUsage() %></th>
	 	</tr>
	 	<%} %>
	 </table>
</div>


</body>
</html>