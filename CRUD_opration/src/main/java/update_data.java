

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
 * Servlet implementation class update_data
 */
@WebServlet("/update_data")
public class update_data extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update_data() {
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
		
		String mid = request.getParameter("mid");
		String mname = request.getParameter("mname");
		String mprice = request.getParameter("mprice");
		String mram = request.getParameter("mram");
		String mversion = request.getParameter("mversion");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_clg","root","Deep@1904");
			PreparedStatement pst = con.prepareStatement("update Mobiles set Mobile_Name=? , Mobile_Price=? , Mobile_Ram=? , Mobile_Version=? where Mobile_ID=?");
			
			pst.setString(1, mname);
			pst.setString(2, mprice);
			pst.setString(3, mram);
			pst.setString(4, mversion);
			pst.setString(5, mid);
			
			pst.executeUpdate();
			
			String LinkUrl1 = "<a href='show_mobiles'>SHOW ALL THE MOBILES</a>";
			out.println("<h2>Mobile Succesfully Updated...</h2>");
			out.println(LinkUrl1);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
