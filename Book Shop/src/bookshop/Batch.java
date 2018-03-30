package bookshop;

import java.util.Date;

public class Batch {

    private int id;
    private float sellingPrice;
    private float buyingPrice;
    private int userId;
 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public float getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(float buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }



}
