import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 引入已存在的User类
//事务管理：了解如何手动或自动控制事务的开始、提交和回滚。
public class BatchProcessingDemo {
    public static void main(String[] args) throws SQLException {
        //数据库配置
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "admin";
        String password = "MyNewPass4!";

        //获取连接
        Connection conn = DriverManager.getConnection(url, username, password);
        // 禁止自动提交事务，开始批处理
        conn.setAutoCommit(false);

        insertUser(conn);

        conn.commit();
    }

    public static void insertUser(Connection conn) throws SQLException{
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            users.add(new User("user" + i,i));
        }
        
        String sql = "INSERT INTO user (name,age) VALUES (?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        for (int i = 0; i < users.size(); i++) {
            pstmt.setString(1,"User" + i);
            pstmt.setInt(2, i);
            pstmt.addBatch();
        }

        // 执行剩余的批处理（如果有的话）
        int[] affectedRows = pstmt.executeBatch();

        // 提交整个事务
        conn.commit();
    }
}

//  javac BatchProcessingDemo.java && java -cp .:lib/mysql-connector-j-8.3.0.jar BatchProcessingDemo.java