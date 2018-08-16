package DAO;

public interface UserDao {


    public boolean login(String phoneId,String pwd);

    public boolean Register(String phoneId,String pwd);

}
