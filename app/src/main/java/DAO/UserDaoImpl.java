package DAO;


import java.sql.*;


public class UserDaoImpl implements UserDao {
    public boolean login(String phoneId,String pwd){
        String sqlstr="select * from user where phoneID= '"+phoneId
        +"'and password='"+pwd+"'";
        DBHelper db=DBHelper.createInstance();
        db.connectDB();

        try{
            ResultSet result=db.executeQuery(sqlstr);
            if(result.next()){
                db.closeDB();
                return  true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        db.closeDB();
        return false;

    }

    public boolean Register(String phoneId,String pwd){
        String sqlstr="insert into user valuse('"+phoneId+"','"+pwd+"')";
        DBHelper db=DBHelper.createInstance();
        db.connectDB();


        int result=db.executeUpdate(sqlstr);
        if(result!=0){
            db.closeDB();
            return true;
        }

        db.closeDB();
        return false;

    }
}
