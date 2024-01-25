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
public class insertbooks extends HttpServlet {
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String instock = request.getParameter("instock");
        String total = request.getParameter("total");
        
        PrintWriter output = response.getWriter();
        
        try {
            
            Connection con = databaseconnection.establish();
           
            PreparedStatement ps = con.prepareStatement("insert into books(name,instock,total) values(?,?,?)");
            ps.setString(1, name);
            ps.setString(2, instock);
            ps.setString(3, total);

            
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