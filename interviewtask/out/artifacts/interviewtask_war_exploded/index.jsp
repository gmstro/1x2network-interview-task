<%--
  Created by IntelliJ IDEA.
  User: gstro
  Date: 26/06/2020
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.lang.*" import="javax.sql.*"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>1X2 Network interview task</title>
  </head>
  <body>
    <h1>Search page</h1>
    <form action="search" method="post">
        <select name="filter">
            <option value="clientid">Client ID</option>
            <option value="game">Game</option>
            <option value="date">Date</option>
        </select>
      <input type="text" name="message" width="30"/>
      <input type="submit" value="Search"><br><br>
    </form>
  </body>
</html>
