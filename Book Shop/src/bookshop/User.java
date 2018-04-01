package bookshop;

import java.awt.Image;
import java.util.Date;

public class User {

    private int id;
    private String username;
    private String password;
    private String name;
    private String nic;
    private String address;
    private UserType type;
    private Date rDateAndTime;
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public Date getrDateAndTime() {
        return rDateAndTime;
    }

    public void setrDateAndTime(Date rDateAndTime) {
        this.rDateAndTime = rDateAndTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
