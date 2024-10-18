

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
 * Servlet implementation class registration
 */
@WebServlet("/registration")
public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registration() {
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
		String Fname = request.getParameter("fname");
		String Lname = request.getParameter("lname");
		String Age = request.getParameter("age");
		String Eid = request.getParameter("eid");
		String Cno = request.getParameter("cno");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_clg","root","Deep@1904");
			PreparedStatement pst = con.prepareStatement("insert into Users (username,Password,Firstname,Lastname,Age,Email_ID,Contact_No) values (?,?,?,?,?,?,?);");

			pst.setString(1, Uname);
			pst.setString(2, Upwd);
			pst.setString(3, Fname);
			pst.setString(4, Lname);
			pst.setString(5, Age);
			pst.setString(6, Eid);
			pst.setString(7, Cno);
			
			pst.executeUpdate();
			
			String LinkUrl = "<a href='login.jsp'>LOGIN</a>";
			
			out.println("<h3>Your register Successfully...</h3>");
			out.println("<h3>Now You Are Login Easyly...</h3>");
			out.println("Your Are Login???"+LinkUrl);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
