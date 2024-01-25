/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package library;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import code.databaseconnection;
import jakarta.servlet.ServletException;
import java.sql.SQLException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author souma
 */
public class issue extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentname = request.getParameter("studentname");
        String sid = request.getParameter("sid");
        String booktags = request.getParameter("booktags");
        String returndate = request.getParameter("returndate");

        PrintWriter output = response.getWriter();

        try {

            Connection con = databaseconnection.establish();

            PreparedStatement ps = con.prepareStatement("insert into issuedbooks (studentname,sid,booktags,returndate) values(?,?,?,?)");
            ps.setString(1, studentname);
            ps.setString(2, sid);
            ps.setString(3, booktags);
            ps.setString(4, returndate);

            int rs = ps.executeUpdate();
            if (rs > 0) {
                response.sendRedirect("/librarymanagement");
            }
        } catch (SQLException ex) {
            output.println(ex);
        } catch (ClassNotFoundException ex) {
            output.println(ex);
        } catch (InstantiationException ex) {
            output.println(ex);
        } catch (IllegalAccessException ex) {
            output.println(ex);
        }

    }
}
