package com.chengxiaoxiao.test;

import java.sql.*;

/**
 * @ClassName: JdbcTest
 * @description: Jdbc测试类，复习Jdbc的步骤
 * @author: Cheng XiaoXiao  (🍊 ^_^ ^_^)
 * @Date: 2018-11-02
 */
public class JdbcTest {
    public static void main(String[] args) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis", "root", "123456");
            ps = conn.prepareStatement("SELECT * FROM `user`");
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("username");
                Date birthday = rs.getDate("birthday");

                System.out.println(id + "   " + name + "   " + birthday);
            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }

        }

    }

}
