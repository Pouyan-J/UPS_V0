<%@ page import="ir.ac.shahreza.computer.pouyan_jaberi.seller.beans.Seller" %>
<%@ page import="java.util.List" %>
<%@ page import="ir.ac.shahreza.computer.pouyan_jaberi.seller.services.SellerService" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Pouyan
  Date: 31/Aug/2018
  Time: 12:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select Person</title>
</head>
<body>
<%
    List<Seller> list = (List<Seller>) request.getAttribute("list");

    if (list.isEmpty())
        out.print("<h1 style=\"color:red\">NO RESULT FOUND</h1>");

    else {
        out.print("<table border=\"1\" width=\"100%\">\n" +
                "    <tr style=\"background-color:#000000; color:white\">\n" +
                "        <td>ID Number</td>\n" +
                "        <td>First Name</td>\n" +
                "        <td>Last Name</td>\n" +
                "    </tr>");

        for (Seller seller : list) {
            out.print("<tr>");
            out.print("<td>" + seller.getUsername() + "</td>");
            out.print("<td>" + seller.getFirstName() + "</td>");
            out.print("<td>" + seller.getLastName() + "</td>");
            out.print("</tr>");
        }
    }
    %>
</body>
</html>
