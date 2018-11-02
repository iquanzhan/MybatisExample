package com.chengxiaoxiao.test;

import com.chengxiaoxiao.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @ClassName: UserInsertTest
 * @description: 测试Mybatis的增加
 * @author: Cheng XiaoXiao  (🍊 ^_^ ^_^)
 * @Date: 2018-11-02
 */
public class UserInsertTest {

    public static void main(String[] args) {
        String resource = "config/SqlMapConfig.xml";

        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlBuilder = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlBuilder.openSession();

            User user = new User();
            user.setBirthday(new Date());
            user.setSex("1");
            user.setUsername("做全栈攻城狮");
            user.setAddress("北京");
            user.setScore(0.0F);

            sqlSession.insert("test.insert", user);

            sqlSession.commit();
            System.out.println(user.getId());
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
