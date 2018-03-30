/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop;

import java.util.Date;

public class Grn {
    
    private int sup_id;
    private String veh_no;
    private float discount;
    private Date DateAndTime;
    private int user_id;
    
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
    
    public void setSup_id(int sup_id) {
        this.sup_id = sup_id;
    }
    
    public int getSup_id() {
        return sup_id;
    }
    
    public void setVeh_no(String veh_no) {
        this.veh_no = veh_no;
    }
    
    public String getVeh_no() {
        return veh_no;
    }
}
