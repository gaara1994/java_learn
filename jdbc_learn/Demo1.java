// 导入必要的JDBC包

import java.sql.*;
class User {
    private String name;
    private int age;

    // 构造函数、getter和setter省略

    @Override
    public String toString() {
        return "姓名: " + name + ", 年龄: " + age;
    }
}

public class Demo1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "admin";
        String password = "MyNewPass4!";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database successfully.");
            // 这里可以执行SQL查询或其他数据库操作
            //1.增
            insertUser(conn,"张三",28);

            //2.删
            deleteUser(conn,3);

            //3.改
            updateUser(conn,4,"新张三",25);

            //4.查
            queryUser(conn,"张三");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void insertUser(Connection conn,String name,int age) throws SQLException{
        String sql = "INSERT INTO user (name,age) VALUES (?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1,name);
        stmt.setInt(2,age);
        int rows = stmt.executeUpdate();
        if (rows > 0){
            System.out.println("新增成功");
        }else {
            System.out.println("新增失败");
        }
    }

    public static void queryUser(Connection conn,String name) throws SQLException{

        String sql = "SELECT * FROM user WHERE name = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1,name);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String userName = rs.getString("name");
            int userAge = rs.getInt("age");

            System.out.println("---------------------");
            System.out.println("姓名: " + userName);
            System.out.println("年龄: " + userAge);
        }
        // 关闭ResultSet和Statement以释放资源
        rs.close();
        stmt.close();
    }

    public static void updateUser(Connection conn,int id,String name,int age) throws SQLException{
        String sql = "UPDATE user SET name = ?,age = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1,name);
        stmt.setInt(2,age);
        stmt.setInt(3,id);

        int rows = stmt.executeUpdate();
        if (rows > 0){
            System.out.println("更新成功");
        }else {
            System.out.println("更新失败");
        }
    }

    public static void deleteUser(Connection conn,int id) throws SQLException{
        String sql = "DELETE FROM user WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,id);
        int rows = stmt.executeUpdate();
        if (rows > 0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

}
// javac Demo1.java && java -cp .:lib/mysql-connector-j-8.3.0.jar Demo1
