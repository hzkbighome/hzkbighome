package DAO;



import ENTITY.Comment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommentDaoImpl implements CommentDao {

    @Override
    public ArrayList<Comment> getCommentByShopID(String shopID) {
        ArrayList<Comment> comments=new ArrayList<>();
        Comment comment=new Comment(shopID);
        String sqlstr="use hzk select * from comment where shopID='"+shopID+"'";

        DBHelper db= DBHelper.createInstance();
        db.connectDB();

        try{
            ResultSet result=db.executeQuery(sqlstr);
            while(result.next()){
                comment.setUserID(result.getString(1));
                comment.setStar(result.getString(3));
                comment.setComment(result.getString(4));
                comments.add(comment);
            }
            db.closeDB();
            return  comments;
        }catch (SQLException e){
            e.printStackTrace();
        }
        db.closeDB();
        return null;
    }

    @Override
    public boolean insertComment(Comment comment) {
        String sqlstr="use hzk insert into comment values('"+comment.getUserID()+"','"
                +comment.getShopID()+"','"+comment.getStar()+"','"+comment.getComment()+"')";
        DBHelper db= DBHelper.createInstance();
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
