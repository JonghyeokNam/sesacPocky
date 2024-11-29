<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Oracle DB Connection Test</title>
</head>
<body>
    <h1>Oracle DB Connection Test</h1>
    <%
        // JDBC 드라이버 로드
        String driver = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521/xe"; // DB 연결 URL
        String username = "C##pocky"; // 사용자명
        String password = "pocky"; // 비밀번호

        try {
            Class.forName(driver); // 드라이버 로드
            java.sql.Connection conn = java.sql.DriverManager.getConnection(url, username, password); // 연결
            if (conn != null) {
                out.println("<p>Database Connection Successful!</p>");
            } else {
                out.println("<p>Database Connection Failed!</p>");
            }
            conn.close(); // 연결 종료
        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    %>
</body>
</html>
