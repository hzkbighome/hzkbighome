package DAO;

import ENTITY.Comment;

import java.util.ArrayList;

public interface CommentDao {
    public ArrayList<Comment> getCommentByShopID(String shopID);
    public boolean insertComment(Comment comment);
}
