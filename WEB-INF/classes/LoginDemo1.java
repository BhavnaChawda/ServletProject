import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class LoginDemo1 extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		String s1=request.getParameter("u1");
		String s2=request.getParameter("u2");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql:///regis","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from bhavna where uname='"+s1+"'AND upass='"+s2+"'");
			if(rs.next())
			{
				response.sendRedirect("Menudemo.html");
			}
			else
			{
				out.println("invalid username and password");
			}
			con.close();
		}
		catch(Exception e)
		{
			out.println(e);
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}