<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>First JSP page</title>
</head>
<body>
<h1>This is JSP page.</h1>
<% String s="Hello";%>
<%=s %>
<%! String b="Global Variable"; %>
<h1><%=b %></h1>
</body>
</html>