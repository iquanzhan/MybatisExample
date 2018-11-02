package com.chengxiaoxiao.test;

import com.chengxiaoxiao.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName: UserSelectTest
 * @description:
 * @author: Cheng XiaoXiao  (🍊 ^_^ ^_^)
 * @Date: 2018-11-02
 */
public class UserSelectTest {

    public static void main(String[] args) {

        String resource = "config/SqlMapConfig.xml";

        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);

            SqlSessionFactory sqlBuilder = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession = sqlBuilder.openSession();

            User user = sqlSession.selectOne("test.fingUserById", 1);

            System.out.println(user);

            List<User> list = sqlSession.selectList("test.findUserList", "王");

            System.out.println(list.size());


            sqlSession.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
