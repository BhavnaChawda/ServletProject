import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Showall extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' href='abc.css'/>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div id='mymenu'>");
		out.println("<ul><li>Home</li><li><a href='Insertdemo.html'>Insert</a></li><li><a href='Showall'>Showall</a></li><li><a href='Searchdemo.html'>Search</a></li><li><a href='Updatedemo.html'>Update</a></li><li><a href='Deletedemo.html'>Delete</a></li><li><a href='Login.html'>Logout</a></li><li>about</li><li>contact</li></ul></div>");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql:///insmarks","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from number");
			out.println("<center>");
			out.println("<table cellpadding='12'>");
			out.println("<tr>");
			out.println("<th>urno</th>");
			out.println("<th>uname</th>");
			out.println("<th>uphy</th>");
			out.println("<th>uchem</th>");
			out.println("<th>umath</th>");
			out.println("</tr>");
			while(rs.next())
			{
				out.println("<tr>");
				out.println("<th>"+rs.getString(1)+"</th>");
				out.println("<th>"+rs.getString(2)+"</th>");
				out.println("<th>"+rs.getString(3)+"</th>");
				out.println("<th>"+rs.getString(4)+"</th>");
				out.println("<th>"+rs.getString(5)+"</th>");
				out.println("</tr>");
			}
			out.println("</table>");
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