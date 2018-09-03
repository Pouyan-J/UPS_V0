package ir.ac.shahreza.computer.pouyan_jaberi.seller.servlets;

import ir.ac.shahreza.computer.pouyan_jaberi.seller.beans.Seller;
import ir.ac.shahreza.computer.pouyan_jaberi.seller.services.SellerService;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SellerSearchServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("in servlet!!");
        //super.service(req, res);
        SellerService sellerService = new SellerService();
        String usernameString = req.getParameter("username");
        String firstNameString = req.getParameter("firstname");
        String lastNameString = req.getParameter("lastname");


        if (!usernameString.equals(null) && !firstNameString.equals(null)
                && !lastNameString.equals(null)) {
            System.out.println("yes");
            List<Seller> list = sellerService.searchSellers(usernameString,
                    firstNameString, lastNameString);

            req.setAttribute("list", list);
            req.getRequestDispatcher("selectseller.jsp").forward(req, resp);

        } else {
            System.out.println("no");
            resp.sendRedirect("search.html");

        }
    }
}
