/**
 * 
 */
package com.whh.servlet;
import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
/**描述：
 * @author 王浩浩
 * @Date 2018年10月15日 下午8:53:57
 */
public class UserDao {

    User user = null;
    private String SQL =""; 
    public User login(String username, String password){
        SQL = "select * from tab1 where username = ? and password = ?";
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = DBDao.getConnection();
            pstmt = (PreparedStatement) connection.prepareStatement(SQL);
            //这里的意思将用户名和密码填到SQL语句的问号处
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rSet = (ResultSet) pstmt.executeQuery();//得到数据库的查询结果,一个数据集
            //判断结果集是否有效
            if(rSet.next()){
                user = new User();
                user.setUsername(rSet.getString("username"));
                user.setPassword(rSet.getString("password"));
            }
            connection.close();
            pstmt.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            DBDao.closeConnection(connection);
        }
        return user;
    }

}
