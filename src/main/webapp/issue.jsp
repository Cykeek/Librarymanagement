<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="common/header.jsp" %>
<%
    if (se.getAttribute("Admin") == null ) {
        response.sendRedirect("adminloginpage.jsp");
    }
%>
<form action="issue" method='post' class="form-group">
    <input name="studentname" type="text" placeholder="Enter student Name" class="form-control">
    <input name="sid" type="text" placeholder="Enter student id" class="form-control">
    <input name="booktags" type="text" placeholder="Books tags (@example: a,b,c)" class="form-control">
    <input name="returndate" type="date" placeholder="Enter return date" class="form-control">
    <button type="submit" value="submit" class="btn btn-danger">Submit</button>
</form>
<%@ include file="common/footer.jsp" %>