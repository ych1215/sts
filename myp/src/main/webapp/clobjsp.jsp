
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.io.*" %>
<%
    String url = "jdbc:log4jdbc:oracle:thin:234234:ss/rezrs";
    String username = "3asds5r33@@#3";
    String password = "xrsfsd!!";
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    try {
        Class.forName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
        connection = DriverManager.getConnection(url, username, password);

         String sql = "SELECT  REPLACE(REPLACE(REPLACE(BORD_CLOB, CHR(13), ''), CHR(10),   '<br/>'  ), ' ', '&nbsp;') as clob_column  ";
         sql += " FROM YCH_LOGIN_INFO WHERE seq = ( SELECT NVL(MAX(SEQ), 1) FROM YCH_LOGIN_INFO ) "; 
         sql += " and 1 = ? "; 
         
         
        statement = connection.prepareStatement(sql);
         statement.setString(1, "1");
        resultSet = statement.executeQuery();

        if (resultSet.next()) {
            java.sql.Clob clob = resultSet.getClob("clob_column");
            java.io.Reader reader = clob.getCharacterStream();
            
            StringBuilder clobData = new StringBuilder();
            char[] buffer = new char[1024];
            int bytesRead;
            while ((bytesRead = reader.read(buffer)) != -1) {
                clobData.append(buffer, 0, bytesRead);
            }
            reader.close();
            
            String clobString = clobData.toString();
            out.print(clobString);
        }
    } catch (Exception e) {
        e.printStackTrace();
        out.print("Error: " + e.getMessage());
    } finally {
        if (resultSet != null) try { resultSet.close(); } catch (SQLException e) {}
        if (statement != null) try { statement.close(); } catch (SQLException e) {}
        if (connection != null) try { connection.close(); } catch (SQLException e) {}
    }
%>