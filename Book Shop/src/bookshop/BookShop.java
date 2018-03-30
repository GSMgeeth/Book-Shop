package bookshop;

import java.util.ArrayList;

public class BookShop {
    
    //Report Files
    
    //End

    private static BookShop shop;

    private static Infor build(String username, String password) {
        if (shop == null) {
            Infor infor = authUser(username, password);
            if (infor.getStatus()) {
                shop = new BookShop();
            }
            return infor;
        } else {
            return new Infor(false, "");
        }
    }

    public static Infor get(String username, String password) {
        Infor infor = build(username, password);
        infor.setOther(shop);
        return infor;
    }

    private static Infor authUser(String username, String password) {

        return null;
    }

    private BookShop() {

    }

    private User correntUser;
    private final Database DATABASE = new Database();

    private interface Accsessble {
        Infor accses();
    }

    private Infor notForGest(Accsessble access) {
        if (correntUser.getType() != UserType.GUEST) {
            return access.accses();
        } else {
            return new Infor(false, "Access denied for user " + correntUser.getUsername());
        }
    }

    private Infor adminOnly(Accsessble access) {
        if (correntUser.getType() == UserType.ADMINISTRATOR) {
            return access.accses();
        } else {
            return new Infor(false, "Access denied for user " + correntUser.getUsername());
        }
    }

    public Infor addNewBook(Book book) {
        return notForGest(() -> {
            try {
                DATABASE.saveBook(book);
                return new Infor(true, "Book[" + book.getName() + "] Saved in database");
            } catch (Exception ex) {
                return new Infor(false, "Error:" + ex.getMessage(), ex);
            }
        });
    }

    public Infor updateBook(Book book) {
        return notForGest(() -> {
            try {
                DATABASE.updateBook(book);
                return new Infor(true, "Book[" + book.getName() + "] Updated");
            } catch (Exception ex) {
                return new Infor(false, "Error:" + ex.getMessage(), ex);
            }
        });
    }

    public Infor sellBooks(Invoice invoice, boolean needPrint) {
        return notForGest(() -> {
            
            return null;
        });
    }

    public void buyBooks(Grn grn) {

    }

    public void printInvoices(ArrayList<Invoice> invoices) {

    }

    public void printGrns(ArrayList<Grn> grns) {

    }
    
    private void print(String reportFile){
        
    }
    

}
