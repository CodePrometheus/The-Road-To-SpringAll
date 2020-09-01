package mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class TestMybatis {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);

        User user = new User();
        user.setName("joy");
        user.setAge("22");
        user.setId("6");
        userDAO.save(user);

//        sqlSession.commit();
        sqlSession.close();
    }
}
