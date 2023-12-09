public class User {
    private String user, password;
    private int userid;

    public User(){
        user = "";
        password = "";
    }

    public User(String user_, String password_, int userid_){
        user = user_;
        password = password_;
        userid = userid_;
    }

    void setUser(String user_){
        user = user_;
    }
    void setPassword(String password_){
        password = password_;
    }

    String getUser(){
        return user;
    }

    String getPassword(){
        return password;
    }
}
