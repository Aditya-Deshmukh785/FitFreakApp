<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String message = "";

    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if (username != null && password != null) {
        try {
            String dburl = "jdbc:mysql://localhost:3306/fitfreak";
            String dbuser = "root";
            String dbpass = "aditya2004"; 
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dburl, dbuser, dbpass);
            
            String query = "SELECT * FROM user_data WHERE uname = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                int subscriptionId = rs.getInt("subscription_id");
                
               
                session.setAttribute("username", name);

                  if (subscriptionId == 0) {
                    response.sendRedirect("freeplan.html");
                } else if (subscriptionId == 1) {
                    response.sendRedirect("weightgainplan.html");
                } else if (subscriptionId == 2) {
                    response.sendRedirect("weightlossplan.html");
                } else if (subscriptionId == 3) {
                    response.sendRedirect("Gokuplan.html");
                } else {
                    message = "Invalid subscription ID.";
                }

            } else {
                message = "Invalid username or password.";
            }

            conn.close();
        } catch (Exception e) {
           // message = "Error: " + e.getMessage();
        }
    }
%>

<!-- Optional display if login fails -->


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Login - FitFreak</title>
    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(to right, #232526, #414345);
            color: white;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .login-container {
            background-color: rgba(0, 0, 0, 0.6);
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 8px 16px rgba(0,0,0,0.5);
            width: 350px;
            text-align: center;
        }

        h2 {
            margin-bottom: 20px;
        }

        input[type="text"], input[type="password"] {
            width: 90%;
            padding: 12px;
            margin: 10px 0;
            border: none;
            border-radius: 8px;
        }

        input[type="submit"] {
            width: 95%;
            padding: 12px;
            margin-top: 15px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            font-size: 1em;
        }

        input[type="submit"]:hover {
            background-color: #218838;
        }

        .new-user {
            margin-top: 20px;
        }

        .new-user a {
            color: #00aced;
            text-decoration: none;
        }

        .new-user a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <div class="login-container">
        <h2>User Login</h2>
        <form action="userlogin.jsp" method="post">
            <input type="text" name="username" placeholder="Enter Username" required>
            <input type="password" name="password" placeholder="Enter Password" required>
            <input type="submit" value="Login">
            
        </form>
          <% if (!message.isEmpty()) { %>
        <p style="color: yellow; font-weight: bold;"><%= message %></p>
    <% } %>
        <div class="new-user">
            <p>New User? <a href="newuserlogin.html">Register here</a></p>
        </div>
    </div>

</body>
</html>
