import ir.ac.shahreza.computer.pouyan_jaberi.seller.beans.Seller;
import ir.ac.shahreza.computer.pouyan_jaberi.seller.dao.SellerDAO;
import ir.ac.shahreza.computer.pouyan_jaberi.seller.services.SellerService;

public class Demo {
    public static void main(String[] args) {
        Seller seller = new Seller("amazon", "123456");
        SellerService sellerService = new SellerService();
        boolean b = sellerService.authenticate(seller);

        System.out.println(b);
    }
}
