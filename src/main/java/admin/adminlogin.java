package admin;

import code.databaseconnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class adminlogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        

        PrintWriter output = response.getWriter();

        try {

            try (Connection con = databaseconnection.establish()) {
                PreparedStatement adminUpdate = con.prepareStatement("Select username from admin where email=? and password=?");
                adminUpdate.setString(1, email);
                adminUpdate.setString(2, password);
                ResultSet rs =  adminUpdate.executeQuery();
                if (rs.next() == true) {
                HttpSession session = (HttpSession) request.getSession();
                session.setAttribute("Admin", "admin");
                rs.close();
                con.close();
                response.sendRedirect("../librarymanagement");
                } else {
                    response.sendRedirect("adminloginpage.jsp?invalid=true");
                }
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
