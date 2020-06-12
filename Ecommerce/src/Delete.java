

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","root");
			String qr="delete from product where name=?";
			PreparedStatement ps=(PreparedStatement) con.clientPrepareStatement(qr);
			ps.setString(1,name);
			int i=ps.executeUpdate();
			RequestDispatcher rd=request.getRequestDispatcher("Show");
			if(i>0)
			{
				rd.include(request, response);
				out.println("record deleted");
				}else
				{
					rd.include(request, response);
					out.println("record not deleted");	
				}
			con.close();
		}catch(Exception e)
		{
			out.println(e);
		}
	}

}
