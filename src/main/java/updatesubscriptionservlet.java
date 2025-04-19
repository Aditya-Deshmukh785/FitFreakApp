

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class updatesubscriptionservlet
 */
@WebServlet("/updatesubscriptionservlet")
public class updatesubscriptionservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatesubscriptionservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int selectedPlanId = Integer.parseInt(request.getParameter("plan"));

		    HttpSession session = request.getSession(false);
		    String username = (String) session.getAttribute("uname");

		    if (username != null ) {
		        try {
		        	 String dburl = "jdbc:mysql://localhost:3306/fitfreak";
			            String dbuser = "root";
			            String dbpass = "aditya2004";
                           
			            Class.forName("com.mysql.cj.jdbc.Driver");
			            Connection conn = DriverManager.getConnection(dburl, dbuser, dbpass);

		            String sql = "UPDATE user_data SET subscription_id = ? WHERE uname = ?";
		            PreparedStatement ps = conn.prepareStatement(sql);
		            ps.setInt(1, selectedPlanId);
		            ps.setString(2, username);
		            ps.executeUpdate();
		            response.getWriter().println("Subscription updated successfully!");
		            
		            response.sendRedirect("planconfirmation.html");
		        } catch (Exception e) {
		            e.printStackTrace();
		            response.getWriter().println("msg"+e);
		        }
		    }
	}

}
