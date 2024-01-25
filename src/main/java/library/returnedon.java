/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package library;

import code.databaseconnection;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author souma
 */
public class returnedon extends HttpServlet {
    @Override
    protected void doGet(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws jakarta.servlet.ServletException, IOException {
        this.doPost(req, resp);
    }
    
    @Override
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
        String sid = request.getParameter("sid");
        String returnedon = request.getParameter("returnedon");
        
        PrintWriter output = response.getWriter();
        
        try {
            
            Connection con = databaseconnection.establish();
           
            PreparedStatement ps = con.prepareStatement("update issuedbooks set returnedon =? where sid =?");
            ps.setString(1, returnedon);
            ps.setString(2, sid);
            
            int rs = ps.executeUpdate(); 
            if(rs> 0){

                con.close();
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
