

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class subscriptionplandetails
 */
@WebServlet("/subscriptionplandetails")
public class subscriptionplandetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public subscriptionplandetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();

	        // HTML Theme Header
	        out.println("<html><head><title>Subscription Data - FitFreak</title>");
	        out.println("<style>");
	        out.println("body { background-color: #121212; color: white; font-family: 'Segoe UI', sans-serif; padding: 20px; }");
	        out.println("h1 { color: #28a745; text-align: center; margin-bottom: 30px; }");
	        out.println("table { width: 80%; margin: auto; border-collapse: collapse; }");
	        out.println("th, td { padding: 12px; border-bottom: 1px solid #444; text-align: center; }");
	        out.println("th { background-color: #1e1e1e; color: #ffa500; }");
	        out.println("tr:hover { background-color: #2a2a2a; }");
	        out.println(".back-btn { margin-top: 30px; text-align: center; }");
	        out.println("button { padding: 10px 20px; background-color: #dc3545; color: white; border: none; border-radius: 8px; cursor: pointer; }");
	        out.println("button:hover { opacity: 0.9; }");
	        out.println("</style></head><body>");

	        out.println("<h1>Subscription Details - FitFreak</h1>");

	        try {
	            String dburl = "jdbc:mysql://localhost:3306/fitfreak";
	            String dbuser = "root";
	            String dbpass = "aditya2004";
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = DriverManager.getConnection(dburl, dbuser, dbpass);

	            String sql = "SELECT * FROM subscription";
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);

	            out.println("<table>");
	            out.println("<tr><th>ID</th><th>Plan Name</th><th>Price</th><th>Duration</th><th>Description</th></tr>");

	            while (rs.next()) {
	                out.println("<tr>");
	                out.println("<td>" + rs.getInt("id") + "</td>");
	                out.println("<td>" + rs.getString("name") + "</td>");
	                out.println("<td>" + rs.getString("price") + "</td>");
	                out.println("<td>" + rs.getString("duration") + "</td>");
	                out.println("<td>" + rs.getString("text") + "</td>");
	                out.println("</tr>");
	            }

	            out.println("</table>");
	            conn.close();
	        } catch (Exception e) {
	            out.println("<p style='color:red; text-align:center;'>Error: " + e.getMessage() + "</p>");
	        }

	        out.println("<div class='back-btn'><button onclick=\"window.location.href='displayappinfo.html'\">Back</button></div>");
	        out.println("</body></html>");
	    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
