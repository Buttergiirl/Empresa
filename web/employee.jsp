<%@page import="my.webapp.empleados.Employee"%>
 
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            List<Employee> employeeList =
                    (List<Employee>) request.getAttribute("employeeList");
        %>
        <h1>Lista de empleados: </h1>
       <ul>

            <% for (Employee employee : employeeList) { %>

                <li>
                    ID: <%= employee.getId() %>
                    - Nombre: <%= employee.getNombre() %>
                    - Departamento: <%= employee.getDepartamento() %>
                </li>

            <% } %>

        </ul>

    </body>
</html>
