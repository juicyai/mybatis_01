import com.koki.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class myapp {
    public static void main(String[] args) throws IOException {
        //1.定义主配置文件，从类路径开始
        String config="mybatis.xml";
        System.out.println("1.......");
        //2.读取文件
        InputStream is = Resources.getResourceAsStream(config);
        System.out.println("2.......");
        //3.创建builder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        System.out.println("3.......");
        SqlSessionFactory factory = builder.build(is);
        System.out.println("4.......");
        SqlSession sqlSession = factory.openSession();
        System.out.println("5.......");
        String sqlId="com.koki.dao.studentDao.StudentDao"+"."+"selectStudents";
        System.out.println("6.......");
        List<Student> selectList = sqlSession.selectList(sqlId);
        for (Student student : selectList) {
            System.out.println(student);
        }


    }
}
