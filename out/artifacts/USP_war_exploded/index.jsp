<%@ page import="ir.ac.shahreza.computer.pouyan_jaberi.seller.beans.Seller" %>
<%@ page import="ir.ac.shahreza.computer.pouyan_jaberi.seller.services.SellerService" %>
<%@ page import="ir.ac.shahreza.computer.pouyan_jaberi.depot.beans.Product" %>
<%@ page import="ir.ac.shahreza.computer.pouyan_jaberi.depot.services.ProductService" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Pouyan
  Date: 23/Aug/2018
  Time: 02:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <%
        response.sendRedirect("search.html");
        /*List<Seller> list = SellerService.searchSellers("", "", "");

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
        }*/

        /*Seller seller = new Seller("amazon", "123");
        SellerService sellerService = new SellerService();
        String str = sellerService.getSeller(seller.getUsername()).getFirstName();
        boolean b = sellerService.authenticate(seller);
        out.println("<h1>");
        out.println(str + " is " + (b ? "authenticated" : "not authenticated"));
        out.println("</h1>");


        out.println("<br/>");*/

        /*Product product = new Product("1111", "Dust Mask", "A white cone mask for women.", seller, 20000);
        ProductService productService = new ProductService(product);
        productService.add();
        out.println("<h2>");
        out.println("The " + productService.getInfo().getName().toLowerCase() + " has been added.");
        out.println("</h2>");*/

        /*out.println("<br/>");

        Product product2 = new Product();
        product2.setId("1111");
        ProductService productService1 = new ProductService(product2);
        boolean b = productService1.buy(1000000);
        out.println("<h2>");
        if (b)
            out.println("The " + productService1.getInfo().getName().toLowerCase() + "s have been purchased.");
        else
            out.println("Your wife goes out unmasked today.");
        out.println("</h2>");*/
    %>
  </body>
</html>
