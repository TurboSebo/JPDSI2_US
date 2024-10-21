<%-- 
    Document   : index
    Created on : 21 paź 2024, 19:59:39
    Author     : sebas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Kalkulator kredytowy</h1>
        <form action="KredytowyKalkulatorServlet" method="post">
        Kwota kredytu: <input type="text" name="kwotakredytu" /><br />
        Stopa procentowa: <input type="text" name="stopakredytu" /><br />
        Okres spłaty Kredytu <input type="number" name="okreskredytu"/>%<br>
        <input type="submit" value="Oblicz" />
  
        
         <!-- Wyświetlenie komunikatu o błędzie, jeśli istnieje -->
    <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
        <p style="color: red;"><%= error %></p>
    <%
        }
    %>
        <!-- Wyświetlenie wyniku, jeśli istnieje -->
    <%
        String obliczonyKredyt = request.getAttribute("obliczonyKredyt") != null ? request.getAttribute("obliczonyKredyt").toString() : null;
        if (obliczonyKredyt != null) {
    %>
        <p><strong>Całkowita kwota kredytu:</strong> <%= obliczonyKredyt %></p>
        <form action="kalkulator.jsp">
            <input type="submit" value="Wyczyść" />
        </form>
    <%
        }
    %>
</form>
    </body>
</html>
