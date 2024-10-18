

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
 * Servlet implementation class show_mobiles
 */
@WebServlet("/show_mobiles")
public class show_mobiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public show_mobiles() {
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
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_clg","root","Deep@1904");
			PreparedStatement pst = con.prepareStatement("select * from Mobiles;");
			
			ResultSet rs = pst.executeQuery();
			
			out.println("<h2>Show All The Books</h2>");
			while(rs.next())
			{
				int mid = rs.getInt(1);
				String mname = rs.getString(2);
				String mprice = rs.getString(3);
				String mram = rs.getString(4);
				String mversion = rs.getString(5);
				
				String LinkUrl = "details?mid="+mid+"&mname="+mname+"&mprice="+mprice+"&mram="+mram+"&mversion="+mversion;
				
				out.println("<a href='"+LinkUrl+"'>"+mname+"</a><br><br>");
			}
			String LinkUrl1 = "<a href='add_mobile.jsp'>ADD MOBILE</a>";
			out.println(LinkUrl1);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
