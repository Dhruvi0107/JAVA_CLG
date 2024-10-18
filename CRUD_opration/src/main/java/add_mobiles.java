

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class add_mobiles
 */
@WebServlet("/add_mobiles")
public class add_mobiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add_mobiles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String mname = request.getParameter("mname");
		String mprice = request.getParameter("mprice");
		String mram = request.getParameter("mram");
		String mversion = request.getParameter("mversion");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_clg","root","Deep@1904");
			PreparedStatement pst = con.prepareStatement("insert into Mobiles (Mobile_Name,Mobile_Price,Mobile_Ram,Mobile_Version) values (?,?,?,?);");

			pst.setString(1, mname);
			pst.setString(2, mprice);
			pst.setString(3, mram);
			pst.setString(4, mversion);
			
			pst.executeUpdate();
			
			String LinkUrl = "<a href='show_mobiles'>Show All The Mobiles</a>";
			
			out.println("<h3>Book Successfully Added...</h3>");
			out.println("You Are Show All The MOBILES??"+LinkUrl+"<br>");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
