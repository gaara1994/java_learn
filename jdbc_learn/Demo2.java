import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//事务管理：了解如何手动或自动控制事务的开始、提交和回滚。
public class Demo2 {
    public static void main(String[] args) {
        //数据库配置
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "admin";
        String password = "MyNewPass4!";

        //获取连接
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("连接成功");
            //关闭自动提交
            conn.setAutoCommit(false);
            insertUser(conn,"李白1",20);
            conn.commit();  //如果注释掉就不会插入记录
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

}

//  javac Demo2.java && java -cp .:lib/mysql-connector-j-8.3.0.jar Demo2