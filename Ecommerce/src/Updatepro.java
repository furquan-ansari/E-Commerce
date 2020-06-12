

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Updatepro
 */
@WebServlet("/Updatepro")
public class Updatepro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updatepro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	response.setContentType("text/html");
	String name=request.getParameter("name");
	String price=request.getParameter("price");
	String category=request.getParameter("category");
	String company=request.getParameter("company");
	out.println("<form action=Update >");
	out.println(name);
	out.println("<input type=hidden name=name value="+name+"/><br>");
	out.println("price<input type=text name=price value="+price+"/><br>");
	out.println("category<input type=text name=category value="+category+"/><br>");
	out.println("company<input type=text name=company value="+company+"/><br>");
	out.println("<input type=submit value=Update/>");
	out.println("</form>");
	}

}