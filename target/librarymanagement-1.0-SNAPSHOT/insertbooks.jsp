<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="common/header.jsp" %>
<%
    if (se.getAttribute("Admin") == null ) {
        response.sendRedirect("adminloginpage.jsp");
    }
%>



<form action="insertbooks" method='post' class="form-group">
    <input name="name" type="text" placeholder="Enter Book Name" class="form-control">
    <input name="instock" type="text" placeholder="Enter total in stock value" class="form-control">
    <input name="total" type="text" placeholder="Total stock available" class="form-control">
    <button type="submit" value="submit" class="btn btn-danger">Submit</button>
</form>

<%@ include file="common/footer.jsp" %>