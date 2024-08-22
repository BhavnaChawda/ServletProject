import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class RegisDemo1 extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		String s1=request.getParameter("un");
		String s2=request.getParameter("up");
		String s3=request.getParameter("uc");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql:///regis","root","root");
			Statement st=con.createStatement();
			st.executeUpdate("insert into bhavna values('"+s1+"','"+s2+"','"+s3+"')");
			con.close();
			response.sendRedirect("login.html");
		    //out.println("<h1>Data Insert</h1>");
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