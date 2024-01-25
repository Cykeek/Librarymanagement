/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package library;

public class BookRecord {
    private String id;
    private String studentName;
    private String sid;
    private String bookTags;
    private String issueDate;
    private String returnDate;

    BookRecord(String id, String studentName, String sid, String bookTags, String sueDate, String returnDate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Constructors, getters, and setters

    @Override
    public String toString() {
        return "BookRecord{id=" + id +
               ", studentName='" + studentName + '\'' +
               ", sid=" + sid +
               ", bookTags='" + bookTags + '\'' +
               ", issueDate='" + issueDate + '\'' +
               ", returnDate='" + returnDate + '\'' +
               '}';
    }
}
