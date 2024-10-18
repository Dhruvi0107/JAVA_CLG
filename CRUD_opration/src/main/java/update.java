

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String mid = request.getParameter("mid");
		String mname = request.getParameter("mname");
		String mprice = request.getParameter("mprice");
		String mram = request.getParameter("mram");
		String mversion = request.getParameter("mversion");
		
		out.println("<body><center>");
		out.println("<h1>MOBILE Update Form</h1>");
		out.println("<form action='update_data' method='post'>");
		out.println("<input type='hidden' name='mid' value="+mid+"><br><br>");
		out.println("Mobile Name <input type='text' name='mname' value="+mname+"><br><br>");
		out.println("Mobile Price <input type='text' name='mprice' value="+mprice+"><br><br>");
		out.println("Mobile Ram <input type='text' name='mram' value="+mram+"><br><br>");
		out.println("Mobile Version <input type='text' name='mversion' value="+mversion+"><br><br>");
		out.println("<input type='submit' value='EDIT'/>");
		out.println("</form>");
		out.println("</body>");
	}

}
