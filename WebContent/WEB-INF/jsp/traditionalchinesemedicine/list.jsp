<%@page import="service.TcmrelationService"%>
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
<%
String name = (String)request.getAttribute("name");
String type = (String)request.getAttribute("type");
String num = (String)request.getAttribute("num");
if(num==null||num.equals("")) num="1";
if(name==null) name="";
if(type==null) type="";
%>
<div align="center">
	<form action="list" method="post">
		<input type="text" name="name" value=<%=name %>>
		<select name="type">
		<%if(type.equals("")){ %>
			<option value ="" selected>--请选择归属--</option>
		<%}else{ %>
			<option value ="">--请选择归属--</option>
		<%} %>	
		<%if(type.equals("1")){ %>
			<option value ="1" selected>上经</option>
		<%}else{ %>
			<option value ="1">上经</option>
		<%} %>			
		<%if(type.equals("2")){ %>
			<option value ="2" selected>中经</option>
		<%}else{ %>
			<option value ="2">中经</option>
		<%} %>			  
		<%if(type.equals("3")){ %>
			<option value="3">下经</option>
		<%}else{ %>
			<option value="3">下经</option>
		<%} %>		  
		<%if(type.equals("4")){ %>
			<option value="4">增补</option>
		<%}else{ %>
			<option value="4">增补</option>
		<%} %>		  
		  
		</select>
		页数<input type="text" name="num" value=<%=num %>>
		<input type="submit" name="submit" value="提交">
		<input type="submit" name="submit" value="上一页">
		<input type="submit" name="submit" value="下一页">
	</form>
	<h1><a href="add">添加</a>&nbsp;&nbsp;</h1>
	
	<br/>
	<%
		List<Traditionalchinesemedicine> tcmList = (List<Traditionalchinesemedicine>)request.getAttribute("tcmlist");
		List< List<Tcmrelation> > trLists = (List< List<Tcmrelation> >)request.getAttribute("trlists");
	%>
		<table border="2" width="500px">
	<% 
		for(int i = 0; i<tcmList.size();i++){
			Traditionalchinesemedicine tcm = tcmList.get(i);
			List<Tcmrelation> trList = trLists.get(i);
	%>
			<tr>
			<th>No.<%=tcm.getNumber() %></th>
			</tr>
			<tr>
				<td>中药名</td><td><%=tcm.getName() %></td>
			</tr>
			<tr>
				<td>别名</td><td><%=tcm.getAlias()%></td>
			</tr>
			<tr>
				<td>归属</td><td><%=tcm.getTypeToString()%></td>
			</tr>
			<tr>
				<td>本经原文</td><td><%=tcm.getBjyw()%></td>
			</tr>
			<tr>
				<td>主治</td><td><%=tcm.getZhuzhi()%></td>
			</tr>
			<tr>
				<td>性味</td><td><%=tcm.getXingwei()%></td>
			</tr>
			<tr>
				<td>产地</td><td><%=tcm.getChandi()%></td>
			</tr>
			<tr>
				<td>用量</td><td><%=tcm.getDosage()%></td>
			</tr>
			<tr>
				<td>禁忌</td><td><%=tcm.getTaboo()%></td>				
			</tr>
            <tr>
				<td>炮制</td><td><%=tcm.getProcessing() %></td>
			</tr>
			<tr>
				<td>倪注</td><td><%=tcm.getNote() %></td>
			</tr>
			<%
				for(int j = 0; j<trList.size();j++){
					Tcmrelation tr = trList.get(j);
			%>
			<tr>
				<td><%=tr.getChuchu() %></td><td><%=tr.getContent() %></td>
			</tr>	
			<%} %>
			<tr>
			<td><a href="../tcmrelation/add?tcmid=<%=tcm.getId() %>">新增心得</a></td>
			</tr>
	<%} %>
		</table>
	</div>			

</body>
</html>