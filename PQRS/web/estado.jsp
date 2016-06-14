<%-- 
    Document   : personal.js
    Created on : Jun 8, 2016, 8:42:54 PM
    Author     : santiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <%-- start web service invocation --%><hr/>
    <%
    try {
      com.airline.clients.EstadoWS_Service service = new com.airline.clients.EstadoWS_Service();
      com.airline.clients.EstadoWS port = service.getEstadoWSPort();
       // TODO initialize WS operation arguments here
      java.lang.String estado = request.getParameter("estado");
      java.lang.String numeroDocPersonal = request.getParameter("numeroDocPersonal");
      java.lang.String tipoDocPersonal = request.getParameter("tipoDocPersonal");
      java.lang.String descripcion = request.getParameter("descripcion");
      java.lang.String codigoPQRS = request.getParameter("codigoPQRS");
      // TODO process result here
      java.lang.String result = port.ingresarEstado(estado, numeroDocPersonal, tipoDocPersonal, descripcion, codigoPQRS);
      out.println("Result = "+result);
        } catch (Exception ex) {
      // TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
  </body>
</html>
