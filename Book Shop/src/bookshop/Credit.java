
package bookshop;

public class Credit {
    private int inv_id;
    private int grn_id;
    private float paid;
    
    public int getInv_id() {
        return inv_id;
    }

    public void setInv_id(int inv_id) {
        this.inv_id = inv_id;
    }
    
    public int getGrn_id() {
        return grn_id;
    }

    public void setGrn_id(int grn_id) {
        this.grn_id = grn_id;
    }
    
    public float getPaid() {
        return paid;
    }
    
    public void setPaid(float paid) {
        this.paid = paid;
    }
}
