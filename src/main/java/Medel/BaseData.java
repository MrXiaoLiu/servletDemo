package Medel;

public class BaseData {

    Object user;

    public BaseData(Object user) {
        if (user==null){
            this.user = "null";
        }else {
            this.user = user;
        }

    }

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }
}
