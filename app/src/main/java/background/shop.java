package background;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class shop {
    public String shopID;
    public String phone;
    public String email;
    public String address;
    public String star;
    public String intro;
    public ArrayList images = new ArrayList<String>();
    private Connection conn;

    public shop(String shopID,
                String phone,
                String email,
                String address,
                String star,
                String intro) {
        conn = usersystem.getConn();
        this.shopID = shopID;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.star = star;
        this.intro = intro;
        try {
            initimage();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void initimage() throws SQLException {
        String sql = "select image.address from accimg,image where accimg.ID= " + shopID + " and accimg.imgID=image.ID";
        Statement stmt = conn.createStatement();
        ResultSet res = stmt.executeQuery(sql);
        while(res.next()){
            images.add(res.getString(1));
        }
    }
}
