import Medel.TextModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class XiaoTaoBusiness {


    public List<TextModel> getAllUser() {
        List<TextModel> mList = new ArrayList<>();
        String sql = "select * from user";
        DBHelper dbHelper = new DBHelper(sql);

        ResultSet resultSet;
        try {

            resultSet = dbHelper.preparedStatement.executeQuery();
            while (resultSet.next()) {

                int id = resultSet.getInt(1);

                String name = resultSet.getString(3);
                double tag = resultSet.getDouble(2);
                TextModel textModel = new TextModel(id, tag, name);
                mList.add(textModel);
            }
            resultSet.close();
            dbHelper.cl0se();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mList;
    }


    //根据条件查询某条数据
    public TextModel getUser(String mId) {
        String sql = "select * from user where id=" + mId;
        DBHelper dbHelper = new DBHelper(sql);
        ResultSet resultSet;
        TextModel textModel = null;
        try {
            resultSet = dbHelper.preparedStatement.executeQuery();

            while (resultSet.next()) {

                int id = resultSet.getInt(1);
                double age = resultSet.getDouble(2);
                String name = resultSet.getString(3);

                textModel = new TextModel();
                textModel.setId(id);
                textModel.setAge(age);
                textModel.setName(name);
            }

            resultSet.close();
            dbHelper.cl0se();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return textModel;
    }


    public boolean addUser(TextModel textModel) {
        String sql = "INSERT INTO user(id,age,name) VALUES (" +
                "'" + textModel.getId() + "'," +
                "'" + textModel.getAge() + "'," +
                "'" + textModel.getName() + "'" + ");";
        DBHelper dbHelper = new DBHelper(sql);

        return execute(dbHelper);
    }

    private boolean execute(DBHelper dbHelper) {
        try {
            dbHelper.preparedStatement.execute();
            dbHelper.cl0se();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }


    /**
     * 根据ID  修改名字
     * @param id
     * @param name
     * @return
     */
    public boolean updateUser(String id, String name) {
        String sql = "UPDATE user set name='" + name + "'WHERE id =" + id;
        DBHelper dbHelper = new DBHelper(sql);

        try {
            dbHelper.preparedStatement.executeUpdate();
            dbHelper.cl0se();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteUser(String mId) {
        String sql = "DELETE FROM user WHERE id = " + mId;
        DBHelper dbHelper = new DBHelper(sql);

        return execute(dbHelper);
    }
}
