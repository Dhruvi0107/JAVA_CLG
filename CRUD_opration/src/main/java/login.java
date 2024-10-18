

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		
		String Uname = request.getParameter("uname");
		String Upwd = request.getParameter("upwd");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_clg","root","Deep@1904");
			PreparedStatement pst = con.prepareStatement("select * from Users where Username=? and Password=?;");
			
			pst.setString(1, Uname);
			pst.setString(2, Upwd);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				String LinkUrl = "<a href='add_mobile.jsp'>ADD MOBILE</a>";
				String LinkUrl1 = "<a href='show_mobiles'>SHOW ALL THE MOBILES</a>";
				
				out.println("<h3>Your Login is Succesfully...</h3>");
				out.println("You Are Show All The MOBILES??"+LinkUrl1+"<br>");
				out.println("You Are Add The New MOBILE??"+LinkUrl);
			}
			else
			{
				String LinkUrl2 = "<a href='login.jsp'>LOGIN</a>";
				
				out.println("<h3>Your Login is Invalid Please You Try Again Login....!</h3>");
				out.println(LinkUrl2);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
