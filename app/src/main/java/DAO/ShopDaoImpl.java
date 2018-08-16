package DAO;


import ENTITY.Shop;
import java.sql.*;


public class ShopDaoImpl implements ShopDao {
    @Override
    public Shop getShopByShopId(String shopID) {
        Shop shop=new Shop(shopID);
        String sqlstr="use hzk select * from shop where shopID='"+shopID+"'";

        DBHelper db= DBHelper.createInstance();
        db.connectDB();

        try{
            ResultSet result=db.executeQuery(sqlstr);
            if(result.next()){
                shop.setPhone(result.getString(2));
                shop.setEmail(result.getString(3));
                shop.setAddress(result.getString(4));
                shop.setStar(result.getString(5));
                shop.setIntro(result.getString(6));

                db.closeDB();
                return shop;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        db.closeDB();
        return null;
    }
}
