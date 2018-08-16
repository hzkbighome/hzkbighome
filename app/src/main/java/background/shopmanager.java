package background;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class shopmanager {
    private ArrayList shops = new ArrayList<shop>();
    private String phoneID;
    private static Connection conn;
    private int num=0;


    public shopmanager(String phoneID) {
        this.phoneID = phoneID;
        conn = usersystem.getConn();
        try {
            init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void init() throws SQLException {
        String sql="select * from shop";
        Statement stmt=conn.createStatement();
        ResultSet res=stmt.executeQuery(sql);
        shop s;

        while(res.next()){
            String shopID=res.getString(1);
            String phone=res.getString(2);
            String email=res.getString(3);
            String address=res.getString(4);
            String star=res.getString(5);
            String intro=res.getString(6);
            s=new shop(shopID,phone,email,address,star,intro);
            this.shops.add(s);
        }
    }
    public shop getmore() {
        num++;
        return (shop) shops.get(num-1);
    }
}
