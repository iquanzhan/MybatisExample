package com.chengxiaoxiao.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: UserDeleteTest
 * @description: 测试Mybatis的删除
 * @author: Cheng XiaoXiao  (🍊 ^_^ ^_^)
 * @Date: 2018-11-02
 */
public class UserDeleteTest {

    public static void main(String[] args) {
        String resource = "config/SqlMapConfig.xml";

        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlBuilder = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlBuilder.openSession();

            sqlSession.delete("test.delete", 18);
            sqlSession.commit();

            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
