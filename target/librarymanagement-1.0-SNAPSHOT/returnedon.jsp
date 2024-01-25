<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="common/header.jsp" %>
<%    if (se.getAttribute("Admin") == null) {
        response.sendRedirect("adminloginpage.jsp");
    }

    String sid = "";
    if (request.getParameter("id") != null) {
        sid = request.getParameter("id");
    }

%>
<form action="returnedon" method='post' class="form-group">
    <input name="sid" type="text" placeholder="Enter Student ID" class="form-control" value="<% out.println(sid);%>">
    <input name="returnedon" type="date" class="form-control">
    <button type="submit" value="submit" class="btn btn-danger">Submit</button>
</form>
<%@ include file="common/footer.jsp" %>