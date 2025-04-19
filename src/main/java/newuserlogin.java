

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class newuserlogin
 */
@WebServlet("/newuserlogin")
public class newuserlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newuserlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pw = new PrintWriter(response.getWriter());
		//HttpSession session = request.getSession();
		//session.setAttribute("username", uname); 
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter pw = new PrintWriter(response.getWriter());	
		String name = request.getParameter("name");
	    String email = request.getParameter("email");
	    String phonestr = request.getParameter("phone");
	    Double weight = Double.parseDouble(request.getParameter("weight"));
	    String uname = request.getParameter("username");
	    String password = request.getParameter("password");
      
	    HttpSession session = request.getSession();
		session.setAttribute("uname", uname);
	    
	        try {
	        	

	            String dburl = "jdbc:mysql://localhost:3306/fitfreak";
	            String dbuser = "root";
	            String dbpass = "aditya2004";

	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = DriverManager.getConnection(dburl, dbuser, dbpass);

	            String sql = "INSERT INTO user_data (name, email, phone, weight, uname, password,subscription_id) VALUES (?, ?, ?, ?, ?, ?,?)";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, name);
	            ps.setString(2, email);
	            ps.setString(3, phonestr);
	            ps.setDouble(4, weight);
	            ps.setString(5, uname);
	            ps.setString(6, password);
	            ps.setInt(7, 0);
	            ps.executeUpdate();

	            pw.write("Record stored successfully");
	            response.sendRedirect("freebmi.html");

	            conn.close();
	        } catch (Exception e) {
	            pw.write("Database Error: " + e.getMessage());
	        }
	     
	 } 
	}


