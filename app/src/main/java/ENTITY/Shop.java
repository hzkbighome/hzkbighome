package ENTITY;

public class Shop {
    private String shopID=null;
    private String phone=null;
    private String email=null;
    private String address=null;
    private String star=null;
    private String intro=null;

    public Shop(){};
    public Shop(String shopID){
        this.shopID=shopID;
    }
    public Shop(String shopID,String phone,String email,String address,String star,String intro){
        this.shopID=shopID;
        this.phone=phone;
        this.email=email;
        this.address=address;
        this.star=star;
        this.intro=intro;
    }

    public String getShopID() {
        return shopID;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getStar() {
        return star;
    }

    public String getIntro() {
        return intro;
    }

    public void setShopID(String shopID) {
        this.shopID = shopID;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
