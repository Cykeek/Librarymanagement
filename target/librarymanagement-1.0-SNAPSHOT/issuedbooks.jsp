<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page import = "code.databaseconnection"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="common/header.jsp" %>
<%
    if (se.getAttribute("Admin") == null ) {
        response.sendRedirect("adminloginpage.jsp");
    }
%>
<%    Connection con = databaseconnection.establish();

    PreparedStatement ps = con.prepareStatement("select * from issuedbooks where returnedon is null order by id desc");


    ResultSet rs = ps.executeQuery();
    

%>

<table class="table">
    <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">StudentName</th>
            <th scope="col">StudentID</th>
            <th scope="col">Books Issued By ID</th>
            <th scope="col">Issue Date</th>
            <th scope="col">Last Day To return</th>
            <th scope="col">ACTION</th>
        </tr>
    </thead>
    <tbody>
        <%
            while(rs.next()) {
            out.println("<tr>");
            out.println("<td>"+rs.getString("id")+"</td>");        
            out.println("<td>"+rs.getString("studentname")+"</td>");
            out.println("<td>"+rs.getString("sid")+"</td>");
            out.println("<td>"+rs.getString("booktags")+"</td>");
            out.println("<td>"+rs.getString("issuedate")+"</td>");
            out.println("<td>"+rs.getString("returndate")+"</td>");
            out.println("<td><a class='nav-link fs-5' href='returnedon.jsp?id="+rs.getString("sid")+"'>Update</a></td>");
            out.println("</tr>");
    }
    
    rs.close();
    con.close();
%>
    </tbody>
</table>

<%@ include file="common/footer.jsp" %>