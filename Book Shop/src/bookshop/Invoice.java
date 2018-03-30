/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop;

import java.util.Date;

public class Invoice {
    
    private Date DateAndTime;
    private float discount;
    private int user_id;
    private int cus_id;
    
    public Date getDateAndTime() {
        return DateAndTime;
    }

    public void setDateAndTime(Date DateAndTime) {
        this.DateAndTime = DateAndTime;
    }
    
    public void setDiscount(float discount) {
        this.discount = discount;
    }
    
    public float getDiscount() {
        return discount;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    public int getCus_id() {
        return cus_id;
    }

    public void setCus_id(int cus_id) {
        this.cus_id = cus_id;
    }
    
}
