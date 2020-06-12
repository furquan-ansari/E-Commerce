<%
String id=request.getParameter("id");
String password=request.getParameter("password");
if(id.equals("admin")&& password.equals("123456"))
{
session.setAttribute("ids",id);	
response.sendRedirect("adminhome.jsp");
}
else
{
out.println("Invalid id and password");	
}
%>