package bookshop;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;




public class Database {
    
    public void saveBook(Book newBook) throws Exception {
        SqlConnection.updateDB("INSERT INTO book (name,description,cat_id,image) VALUES(?,?,?,?)", (PreparedStatement ps) -> {
            int i = 0;
            ps.setString(++i, newBook.getName());
            ps.setString(++i, newBook.getDescription());
            ps.setInt(++i, newBook.getCategory_id());
            ps.setString(++i, newBook.getImage());
            return ps;
        });
    }

    public ArrayList<Book> getBooks(String where, Injecterble inject) throws Exception {
        ArrayList<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM book WHERE +" + where;
        ResultSet rs = SqlConnection.getData(sql, inject);
        while (rs.next()) {
            Book book = new Book();
            book.setId(rs.getInt("book_id"));
            book.setName(rs.getString("name"));
            book.setDescription(rs.getString("description"));
            book.setCategory_id(rs.getInt("cat_id"));
            book.setImage(rs.getString("image"));
            books.add(book);
        }
        return books;
    }

    public void updateBook(Book book) throws Exception {
        String sql = "UPDATE book SET name=?,description=?,cat_id=?,image=? WHERE book_id=?";
        SqlConnection.updateDB(sql, ps -> {
            int i = 0;
            ps.setString(++i, book.getName());
            ps.setString(++i, book.getDescription());
            ps.setInt(++i, book.getCategory_id());
            ps.setString(++i, book.getImage());
            ps.setInt(++i, book.getId());
            return ps;
        });
    }

    public void saveUser(User user) throws Exception {
        String sql = "INSERT INTO user (nic,username,password,name,address,type,image,reg_date) VALUES (?,?,?,?,?,?,?,?)";
        SqlConnection.updateDB(sql, ps -> {
            int i = 0;
            ps.setString(++i, user.getNic());
            ps.setString(++i, user.getUsername());
            ps.setString(++i, user.getPassword());
            ps.setString(++i, user.getName());
            ps.setString(++i, user.getAddress());
            ps.setString(++i, user.getType().toString());
            ps.setString(++i, user.getImage());
            ps.setString(++i, new SimpleDateFormat("yyyy/MM/dd").format(user.getrDateAndTime()));
            return ps;
        });
    }

    public ArrayList<User> getUsers(String where, Injecterble inject) throws Exception {
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user WHERE " + where;
        ResultSet rs = SqlConnection.getData(sql, inject);
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("user_id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setName(rs.getString("name"));
            user.setImage(rs.getString("image"));
            user.setNic(rs.getString("nic"));
            user.setAddress(rs.getString("address"));
            String type = rs.getString("type");
            if (type.equalsIgnoreCase(UserType.ADMINISTRATOR.toString())) {
                user.setType(UserType.ADMINISTRATOR);
            } else if (type.equalsIgnoreCase(UserType.GUEST.toString())) {
                user.setType(UserType.GUEST);
            } else {
                user.setType(UserType.NORMAL_USER);
            }
            Date date = rs.getDate("reg_date");
            user.setrDateAndTime(date);
            users.add(user);
        }
        return users;
    }

    public void updateUser(User user) throws Exception {
        String sql = "UPDATE user SET name=?,address=?,type=? WHERE user_id=?";
        SqlConnection.updateDB(sql, ps -> {
            int i = 0;
            ps.setString(++i, user.getName());
            ps.setString(++i, user.getAddress());
            ps.setString(++i, user.getType().toString());
            ps.setInt(++i, user.getId());
            return ps;
        }
        );
    }

    public void saveBatch(Batch newBatch) throws Exception {
        String sql = "INSERT INTO batch (buying_price,selling_price,user_id) VALUES (?,?,?)";
        SqlConnection.updateDB(sql, ps -> {
            int i = 0;
            ps.setFloat(++i, newBatch.getBuyingPrice());
            ps.setFloat(++i, newBatch.getSellingPrice());
            ps.setInt(++i, newBatch.getUserId());
            return ps;
        });
    }

    public ArrayList<Batch> getBatchs(String where, Injecterble inject) throws Exception {
        ArrayList<Batch> batches = new ArrayList<>();
        String sql = "SELECT * FROM batch WHERE " + where;
        ResultSet rs = SqlConnection.getData(sql, inject);
        while (rs.next()) {
            Batch batch = new Batch();
            batch.setId(rs.getInt("batch_id"));
            batch.setSellingPrice(rs.getFloat("selling_price"));
            batch.setBuyingPrice(rs.getFloat("buying_price"));
            batch.setUserId(rs.getInt("User_id"));
            batches.add(batch);
        }
        return batches;
    }

    public void updateBatch(Batch batch) throws Exception {
        String sql = "UPDATE batch SET buying_price=?,selling_price=?,user_id=? WHERE batch_id=?";
        SqlConnection.updateDB(sql, ps -> {
            int i = 0;
            ps.setFloat(++i, batch.getBuyingPrice());
            ps.setFloat(++i, batch.getSellingPrice());
            ps.setInt(++i, batch.getUserId());
            ps.setInt(++i, batch.getId());
            return ps;
        });
    }

    public void saveCatogory(Category newCategory) throws Exception {
        String sql = "INSERT INTO category (cat_name) VALUES (?)";
        SqlConnection.updateDB(sql, ps -> {
            int i = 0;
            ps.setString(++i, newCategory.getName());
            return ps;

        });
    }

    public ArrayList<Category> getCategories(String where, Injecterble inject) throws Exception {
        ArrayList<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM  category WHERE +" + where;
        ResultSet rs = SqlConnection.getData(sql, inject);
        while (rs.next()) {
            Category c = new Category();
            
            categories.add(c);
        }
        return categories;
    }

    public void updateCatogory(Category category) throws Exception {
       String sql = "UPDATE category SET cat_name=? WHERE cat_id=?";
        SqlConnection.updateDB(sql, ps -> {
            int i = 0;
            ps.setString(++i, category.getName());
            ps.setInt(++i, category.getId());
            return ps;
        });
    }
    
    public void deleteCategory(Category cat) throws Exception
    {
        String sql = "DELETE FROM category WHERE cat_id=?";
        SqlConnection.updateDB(sql, ps -> {
            int i = 0;
            ps.setInt(++i, cat.getId());
            return ps;
        });
    }
    
    public void deleteBatch(Batch batch) throws Exception
    {
        String sql = "DELETE FROM batch WHERE batch_id=?";
        SqlConnection.updateDB(sql, ps -> {
            int i = 0;
            ps.setInt(++i, batch.getId());
            return ps;
        });
    }
    
    public void saveCopy(Book newBook) throws Exception {
       
    }

    public ArrayList<Book_copy> getCopies(String where, String values) throws Exception {
       ArrayList<Book_copy> copies=new ArrayList<>();
       
       return copies;
    }

    public void updateCopy(Book book) throws Exception {
        
    }

    public void saveGRN(Grn newGrn) throws Exception {
        String sql = "INSERT INTO grn (discount,sup_id,veh_no,date,time,User_id) VALUES (?,?,?,?,?,?)";
        SqlConnection.updateDB(sql, ps -> {
            int i = 0;
            ps.setFloat(++i, newGrn.getDiscount());
            ps.setInt(++i, newGrn.getSup_id());
            ps.setString(++i, newGrn.getVeh_no());
            ps.setString(++i, new SimpleDateFormat("yyyy/MM/dd").format(newGrn.getDateAndTime()));
            ps.setString(++i, new SimpleDateFormat("hh:mm:ss").format(newGrn.getDateAndTime()));
            ps.setInt(++i, newGrn.getUser_id());
            return ps;
        });  
    }
    
    public void saveGRNCopy(Grn_copy newGrnCopy) throws Exception {
        String sql = "INSERT INTO grn_copy (grn_id, book_id, batch_id, quantity) VALUES (?,?,?,?)";
        SqlConnection.updateDB(sql, ps -> {
            int i = 0;
            ps.setInt(++i, newGrnCopy.getGrn_id());
            ps.setInt(++i, newGrnCopy.getBook_id());
            ps.setInt(++i, newGrnCopy.getBatch_id());
            ps.setInt(++i, newGrnCopy.getQty());
            return ps;
        });
    }

    public void saveNewBook(int grn_copy_id, int to_add) throws Exception {
        String sql = "INSERT INTO new_book (grn_copy_id, to_add) VALUES (?,?)";
        SqlConnection.updateDB(sql, ps -> {
            int i = 0;
            ps.setInt(++i, grn_copy_id);
            ps.setInt(++i, to_add);
            return ps;
        });
    }
    
    public void updateNewBook(int grn_copy_id, int to_add) throws Exception {
        
        String sql = "UPDATE new_book SET to_add=? WHERE grn_copy_id=?";
        SqlConnection.updateDB(sql, ps -> {
            int i = 0;
            ps.setInt(++i, to_add);
            ps.setInt(++i, grn_copy_id);
            return ps;
        }
        );
        
    }
    
    public void updateISBNAvailability(String isbn) throws Exception {
        
        String sql = "UPDATE book_copy SET availability=? WHERE ISBN=?";
        SqlConnection.updateDB(sql, ps -> {
            int i = 0;
            ps.setInt(++i, 0);
            ps.setString(++i, isbn);
            return ps;
        }
        );
        
    }
    
    public ArrayList<Grn> getGRNs(String where, String values) throws Exception {
        ArrayList<Grn> grns = new ArrayList<>();
        
        return grns;
    }

    public void updateGRN(Grn grn) throws Exception {
        String sql = "UPDATE BOOK SET NAME=?,DATE=?,TIME=?,DESCRIPTION=?,IMAGE=?,USER_ID=?,BOOK_CATOGERY_ID=? WHERE ID=?";
        
    }
    
    public void saveISBN(Book_copy newCopy) throws Exception {
        String sql = "INSERT INTO book_copy (book_id,ISBN,grn_id) VALUES (?,?,?)";
        SqlConnection.updateDB(sql, ps -> {
            int i = 0;
            ps.setInt(++i, newCopy.getBookId());
            ps.setString(++i, newCopy.getIsbn());
            ps.setInt(++i, newCopy.getGrn());
            return ps;
        });  
    }

    public void saveInvoice(Invoice newInvoice) throws Exception {
        String sql = "INSERT INTO invoice (discount,date,time,User_id,cus_id) VALUES (?,?,?,?,?)";
        SqlConnection.updateDB(sql, ps -> {
            int i = 0;
            ps.setFloat(++i, newInvoice.getDiscount());
            ps.setString(++i, new SimpleDateFormat("yyyy/MM/dd").format(newInvoice.getDateAndTime()));
            ps.setString(++i, new SimpleDateFormat("hh:mm:ss").format(newInvoice.getDateAndTime()));
            ps.setInt(++i, newInvoice.getUser_id());
            ps.setInt(++i, newInvoice.getCus_id());
            return ps;
        });
    }
    
    public void saveCreditInv(Credit newCrd) throws Exception
    {
        String sql = "INSERT INTO credit_inv (inv_id,paid) VALUES (?,?)";
        SqlConnection.updateDB(sql, ps -> {
            int i = 0;
            ps.setInt(++i, newCrd.getInv_id());
            ps.setFloat(++i, newCrd.getPaid());
            return ps;
        });
    }
    
    public void updateCreditInv(Credit newCrd) throws Exception
    {
        String sql = "UPDATE credit_inv SET paid=? WHERE inv_id=?";
        SqlConnection.updateDB(sql, ps -> {
            int i = 0;
            ps.setFloat(++i, newCrd.getPaid());
            ps.setInt(++i, newCrd.getInv_id());
            return ps;
        });
    }
    
    public void saveCreditGrn(Credit newCrd) throws Exception
    {
        String sql = "INSERT INTO credit_grn (grn_id,paid) VALUES (?,?)";
        SqlConnection.updateDB(sql, ps -> {
            int i = 0;
            ps.setInt(++i, newCrd.getGrn_id());
            ps.setFloat(++i, newCrd.getPaid());
            return ps;
        });
    }
    
    public void updateCreditGrn(Credit newCrd) throws Exception
    {
        String sql = "UPDATE credit_grn SET paid=? WHERE grn_id=?";
        SqlConnection.updateDB(sql, ps -> {
            int i = 0;
            ps.setFloat(++i, newCrd.getPaid());
            ps.setInt(++i, newCrd.getGrn_id());
            return ps;
        });
    }
    
    public void saveInvoiceCopy(Invoice_copy newInvCopy) throws Exception {
        String sql = "INSERT INTO invoice_copy (inv_id,ISBN) VALUES (?,?)";
        SqlConnection.updateDB(sql, ps -> {
            int i = 0;
            ps.setInt(++i, newInvCopy.getInv_id());
            ps.setString(++i, newInvCopy.getISBN());
            return ps;
        });
    }

    public ArrayList<Invoice> getInvoices(String where, String values) throws Exception {
        ArrayList<Invoice> invoices = new ArrayList<>();
        
        return invoices;
    }

    public void updateInvoice(Book book) throws Exception {
        String sql = "UPDATE BOOK SET NAME=?,DATE=?,TIME=?,DESCRIPTION=?,IMAGE=?,USER_ID=?,BOOK_CATOGERY_ID=? WHERE ID=?";
       
    }

    public void saveSupplier(Supplier newSup) throws Exception {
        String sql = "INSERT INTO supplier (company,agent_name,telephone,address,email,reg_date,user_id) VALUES (?,?,?,?,?,?,?)";
        SqlConnection.updateDB(sql, ps -> {
            int i = 0;
            ps.setString(++i, newSup.getCompany());
            ps.setString(++i, newSup.getName());
            ps.setString(++i, newSup.getTel());
            ps.setString(++i, newSup.getAddress());
            ps.setString(++i, newSup.getEmail());
            ps.setString(++i, new SimpleDateFormat("yyyy/MM/dd").format(newSup.getDateAndTime()));
            ps.setInt(++i, newSup.getUser_id());
            return ps;
        });
    }
    
    public void saveCustomer(Customer newCus) throws Exception
    {
        String sql = "INSERT INTO customer (company,agent_name,telephone,address,email,reg_date,user_id) VALUES (?,?,?,?,?,?,?)";
        SqlConnection.updateDB(sql, ps -> {
            int i = 0;
            ps.setString(++i, newCus.getCompany());
            ps.setString(++i, newCus.getName());
            ps.setString(++i, newCus.getTel());
            ps.setString(++i, newCus.getAddress());
            ps.setString(++i, newCus.getEmail());
            ps.setString(++i, new SimpleDateFormat("yyyy/MM/dd").format(newCus.getDateAndTime()));
            ps.setInt(++i, newCus.getUser_id());
            return ps;
        });
    }

    public ArrayList<Supplier> getSuppliers(String where, String values) throws Exception {
        ArrayList<Supplier> suppliers = new ArrayList<>();
       
        return suppliers;
    }

    public void updateSupplier(Supplier sup) throws Exception {
        
        String sql = "UPDATE supplier SET agent_name=?,telephone=?,address=?,email=? WHERE sup_id=?";
        SqlConnection.updateDB(sql, ps -> {
            int i = 0;
            ps.setString(++i, sup.getName());
            ps.setString(++i, sup.getTel());
            ps.setString(++i, sup.getAddress());
            ps.setString(++i, sup.getEmail());
            ps.setInt(++i, sup.getId());
            return ps;
        }
        );
        
    }
    
    public void updateCustomer(Customer cus) throws Exception {
        
        String sql = "UPDATE customer SET agent_name=?,telephone=?,address=?,email=? WHERE cus_id=?";
        SqlConnection.updateDB(sql, ps -> {
            int i = 0;
            ps.setString(++i, cus.getName());
            ps.setString(++i, cus.getTel());
            ps.setString(++i, cus.getAddress());
            ps.setString(++i, cus.getEmail());
            ps.setInt(++i, cus.getId());
            return ps;
        }
        );
    }

    public void saveSystemData(Book newBook) throws Exception {
        String sql = "INSERT INTO BOOK( id,name,date,time,description,image,User_id,book_catogery_id) VALUES(?,?,?,?,?,?,?,?)";
        
    }

    public ArrayList<SystemData> getSystemDatas(String where, String values) throws Exception {
        ArrayList<SystemData> systemDatas = new ArrayList<>();
       
        return systemDatas;
    }

    public void updateSystemData(Book book) throws Exception {
        String sql = "UPDATE BOOK SET NAME=?,DATE=?,TIME=?,DESCRIPTION=?,IMAGE=?,USER_ID=?,BOOK_CATOGERY_ID=? WHERE ID=?";
        
    }

}
