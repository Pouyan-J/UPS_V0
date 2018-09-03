package ir.ac.shahreza.computer.pouyan_jaberi.seller.services;

import ir.ac.shahreza.computer.pouyan_jaberi.seller.beans.Seller;
import ir.ac.shahreza.computer.pouyan_jaberi.seller.dao.SellerDAO;

import java.util.List;

public class SellerService {
    SellerDAO sellerDAO = new SellerDAO();

    public boolean authenticate(Seller seller) {
        sellerDAO.setSeller(seller);
        return sellerDAO.authenticate();
    }

    public Seller getSeller(String username) {
        Seller seller = new Seller();
        seller.setUsername(username);
        sellerDAO.setSeller(seller);
        System.out.println("HERE!!" + sellerDAO.getInfo().getFirstName());
        return sellerDAO.getInfo();
    }

    public static List<Seller> searchSellers
            (String username, String firstName, String lastName) {
        return new SellerDAO().searchSellers(username, firstName, lastName);
    }
}
