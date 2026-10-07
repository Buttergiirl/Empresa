/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package my.webapp.empleados;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import my.webapp.database.Database;


@WebServlet(name = "EmployeeServlet", urlPatterns = {"/EmployeeServlet"})
public class EmployeeServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
         {
             Database db = new Database();
             Connection conn= db.getConnection();
             PreparedStatement pstat = conn.prepareStatement ("SELECT * FROM empleados;");
             
             ResultSet rs = pstat.executeQuery();
             
             List<Employee> employeeList = new ArrayList<>();
 
            while(rs.next()) {

                employeeList.add(new Employee(rs.getInt("id"),
 
                                          rs.getString("nombre"),
 
                                          rs.getString("departamento"))
                );
 
                           
            }
 
            request.setAttribute("employeeList", employeeList);
 
            request.getRequestDispatcher ("employee.jsp").forward (request, response);
        }
 
        catch (SQLException ex)
        {
            System.getLogger (EmployeeServlet.class.getName()).log (System.Logger. Level. ERROR, (String) null, ex);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    
    @Override
    public String getServletInfo() {
         return "Lista de empleados";
    }// </editor-fold>

}
