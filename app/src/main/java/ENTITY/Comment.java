package ENTITY;

public class Comment {
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getShopID() {
        return shopID;
    }

    public void setShopID(String shopID) {
        this.shopID = shopID;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    private  String  userID=null;
    private String shopID=null;
    private String star=null;
    private String comment=null;

    public Comment(){}

    public Comment(String shopID){
        this.shopID=shopID;
    }


}
