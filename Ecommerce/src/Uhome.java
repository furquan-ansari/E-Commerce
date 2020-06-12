

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Uhome
 */
@WebServlet("/Uhome")
public class Uhome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Uhome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<h1 align=center>welcome to user home</h1>");
		HttpSession  session=request.getSession();
		String email=(String) session.getAttribute("id");
		out.println("welcome "+email);
		out.println("<a href=Logout>Logout</a>");
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","root");
		String qr="select * from product";
		Statement st=(Statement) con.createStatement();
		ResultSet rs=st.executeQuery(qr);
		if(rs.next())
		{
			do
			{
				String name=rs.getString("name");
				String price=rs.getString("price");
				String category=rs.getString("category");
				String company=rs.getString("company");
			
				
						}while(rs.next());
		}
		}catch(Exception e)
		{
			out.println(e);
		}
	}
		

}
