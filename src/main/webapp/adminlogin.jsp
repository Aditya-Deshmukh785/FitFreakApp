<%@ page import="java.io.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String message = "";

    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if (username != null && password != null) {
        if (username.equals("aditya17") && password.equals("2004")) {
            response.sendRedirect("displayappinfo.html");
        } else {
            message = "Invalid admin credentials.";
        }
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Login - FitFreak</title>
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
        <h2>Admin Login</h2>
        <form action="adminlogin.jsp" method="post">
            <input type="text" name="username" placeholder="Enter Admin Username" required>
            <input type="password" name="password" placeholder="Enter Admin Password" required>
            <input type="submit" value="Login">
        </form>

        <% if (!message.equals("")) { %>
            <p style="color: yellow; font-weight: bold;"><%= message %></p>
        <% } %>

       
    </div>

</body>
</html>
