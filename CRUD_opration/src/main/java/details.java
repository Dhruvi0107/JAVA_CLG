

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class details
 */
@WebServlet("/details")
public class details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
		String deleteUrl = "delete?mid="+mid;
		String updateUrl = "update?mid="+mid+"&mname="+mname+"&mprice="+mprice+"&mram="+mram+"&mversion="+mversion;
		
		out.println("<h2>MOBILE DETAILS</h2>");
		out.println("<table border=3>");
		out.println("<tr>");
		out.println("<th>Mobile ID</th>");
		out.println("<th>Mobile Name</th>");
		out.println("<th>Mobile Price</th>");
		out.println("<th>Mobile Ram</th>");
		out.println("<th>Mobile Version</th>");
		out.println("<th>Delete Action</th>");
		out.println("<th>Update Action</th>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>"+mid+"</td>");
		out.println("<td>"+mname+"</td>");
		out.println("<td>"+mprice+"</td>");
		out.println("<td>"+mram+"</td>");
		out.println("<td>"+mversion+"</td>");
		out.println("<td>"+"<a href='"+deleteUrl+"'>"+"DELETE"+"</a>"+"</td>");
		out.println("<td>"+"<a href='"+updateUrl+"'>"+"UPDATE"+"</a>"+"</td>");
		out.println("</tr>");
		
		String LinkUrl1 = "<a href='show_mobiles'>SHOW ALL THE MOBILES</a><br><br>";
		out.println(LinkUrl1);
	}

}
