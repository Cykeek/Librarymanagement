<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="jakarta.servlet.ServletException" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link href="css/styles.css" rel="stylesheet">
        <title>Library Management</title>
    </head>
    <body data-bs-theme="dark">
        <main class="my-auto">
            <div class="container card p-4  border border-secondary">
                <h2 class="fw-bold display-3 mb-4 ">Library Management</h2>
                <hr class="border border-danger border-1 opacity-50">
                <div class="row ">
                    <div class="col-lg-4">



                        <ul class="list-group">

                            <%
                                HttpSession se = (HttpSession) request.getSession();
                                if (se.getAttribute("Admin") != null && se.getAttribute("Admin") == "admin") {
                            %>
                            <li class="list-group-item py-4" data-category="issue">
                                <a class="nav-link fs-5" href="issue.jsp" >Issue Books</a>
                            </li>
                            <li class="list-group-item py-4" data-category="insertbooks">
                                <a class="nav-link fs-5" href="insertbooks.jsp">Insert Books</a>
                            </li>
                            <li class="list-group-item py-4" data-category="returnedon">
                                <a class="nav-link fs-5" href="returnedon.jsp">Return Books</a>
                            </li>
                            <li class="list-group-item py-4" data-category="issuedbooks">
                                <a class="nav-link fs-5" href="issuedbooks.jsp">Pending Returns</a>
                            </li>

                            <li class="list-group-item py-4">
                                <a href="adminlogout" class="btn btn-danger">Logout</a>
                            </li>
                            <%
                            } else {
                            %>
                            <li class="list-group-item py-4" data-category="adminloginpage">
                                <a class="nav-link fs-5" href="adminloginpage.jsp"  >admin login</a>
                            </li>
                            <%}%>
                        </ul>
                    </div>
                    <div class="col-lg-8">

