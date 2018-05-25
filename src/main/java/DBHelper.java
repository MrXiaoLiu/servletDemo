import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHelper {
    //创建表的名字
    private static final String url = "jdbc:mysql://localhost:3306/XiaoTaoText?useUnicode=true&characterEncoding=UTF-8";
    //
    private static final String name = "com.mysql.jdbc.Driver";
    //连接数据账号
    private static final String user = "root";
    //连接数据库密码
    private static final String password = "admin123";


    private Connection connection = null;
    public  PreparedStatement preparedStatement;

    public DBHelper(String spl) {
        try {
            //注册数据库驱动
            Class.forName(name);

            connection = DriverManager.getConnection(url, user, password);

             preparedStatement = connection.prepareStatement(spl);


        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }


    public void cl0se(){

        try {
            this.connection.close();
            this.preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
