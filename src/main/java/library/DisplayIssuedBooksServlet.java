/**
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 
package library;

import code.databaseconnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayIssuedBooksServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BookRecord> issuedBooks = new ArrayList<>();

        try {
            // Establish a database connection
            Connection connection = databaseconnection.establish();

            // Execute SQL query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM issuedbooks");

            // Convert ResultSet to a List of BookRecord objects
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String studentName = resultSet.getString("studentname");
                int sid = resultSet.getInt("sid");
                String bookTags = resultSet.getString("booktags");
                String issueDate = resultSet.getString("issuedate");
                String returnDate = resultSet.getString("returndate");

                issuedBooks.add(new BookRecord(id, studentName, sid, bookTags, issueDate, returnDate));
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Set the list in request scope
        request.setAttribute("issuedBooks", issuedBooks);

        // Forward to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/displayIssuedBooks.jsp");
        dispatcher.forward(request, response);
    }
}**/
