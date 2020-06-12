import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class AddPro
 */
@WebServlet("/AddPro")
public class AddPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		String category=request.getParameter("category");
		String company=request.getParameter("company");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecommerce","root","root");
			String qr="insert into product values(?,?,?,?)";
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(qr);
			ps.setString(1, name);
			ps.setString(2, price);
			ps.setString(3, category);
			ps.setString(4, company);
			int i=ps.executeUpdate();
			if(i>0)
			{
				out.println("record added");
			}else
			{
				out.println("record not added");
			}
			con.close();
		} catch (Exception e) {
			
			out.println(e);
		}
		}
	}


