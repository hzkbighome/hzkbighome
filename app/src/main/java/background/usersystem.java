package background;


import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class usersystem {
    private String phoneID;
    private String nickname;
    private String avatar;
    private String sex;
    private String email;
    private String province;
    private String city;
    private String intro;
    private static Connection conn = null;
    private String IP="192.168.200.28";

    public usersystem(String phone) {
        phoneID = phone;
        final Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {
                String connectionString =
                        "jdbc:mysql://"+IP+":3306/hzk?user=admin&password=123456&useSSL=false&autoReconnect=true&failOverReadOnly=false";
                try {
                    conn = DriverManager.getConnection(connectionString);
                    getdetail();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });
       thread.start();
    }

    public void update(String what, String value) throws SQLException {
        String sql = "update user set " + what + " = ? where phoneID = " + phoneID;
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, value);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public String getPhoneID() {
        return phoneID;

    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) throws SQLException {
        this.nickname = nickname;
        update("phoneID", nickname);
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) throws SQLException {
        this.avatar = avatar;
        update("avatarID", avatar);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) throws SQLException {
        this.sex = sex;
        update("sex", sex);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws SQLException {
        this.email = email;
        update("eamil", email);
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) throws SQLException {
        this.province = province;
        update("province", province);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws SQLException {
        this.city = city;
        update("city", city);
    }

    public String getIntro() {
        return intro;
    }

    public static Connection getConn() {
        return conn;
    }

    public void setIntro(String intro) throws SQLException {
        this.intro = intro;
        update("intro", intro);
    }

    public void getdetail() throws SQLException {
        String sql = "select * from user where phoneID=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, phoneID);
        ResultSet detail = pstmt.executeQuery();
        detail.next();
        phoneID = detail.getString(1);
        nickname = detail.getString(2);
        avatar = detail.getString(3);
        sex = detail.getString(4);
        email = detail.getString(5);
        province = detail.getString(6);
        city = detail.getString(7);
        intro = detail.getString(8);
        pstmt.close();
        sql = "select address from image where ID = " + avatar;
        Statement s = conn.createStatement();
        detail = s.executeQuery(sql);
        detail.next();
        avatar = detail.getString(1);
        detail.close();
        s.close();
    }
    public void close(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
