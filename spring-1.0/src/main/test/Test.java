import com.sp.controller.UserController;
import com.sp.dao.UserDao;
import com.sp.pojo.User;
import com.sp.pojo.factory.CarFactory;
import com.sp.pojo.factory.Factory;
import com.sp.pojo.factory.Vehicle;
import com.sp.pojo.invocationHandler.BusinessClassService;
import com.sp.pojo.invocationHandler.BusinessClassServiceImpl;
import com.sp.pojo.invocationHandler.MyLoggerHandler;
import oracle.sql.DATE;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.lang.reflect.Proxy;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:springContext.xml"})
public class Test {
    @Resource
    private UserDao userDao;

    @Before
    public void setUp() throws Exception {

    }





    @org.junit.Test
    public void test01() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        List<User> list = new ArrayList<User>();
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String userName = "zhouliqiong";
        String password = "zlq1108";
        String sql = "select * from is_user";
        Connection conn = DriverManager.getConnection(url,userName,password);

        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            User user = new User();
            user.setUserId(rs.getInt("user_id"));
            user.setUserName(rs.getString("user_name"));
            user.setPassword(rs.getString("password"));
            user.setBirthday(rs.getDate("birthday"));
            user.setGender(rs.getString("gender"));
            user.setCreateDate(rs.getDate("create_date"));
            list.add(user);
        }
        list.forEach(e->{
            System.out.println(e.toString());
        });
    }

    /*测试单例模式*/
    @org.junit.Test
    public void test02(){
        /*Student student1 = Student.getStudent();
        Student student2 = Student.getStudent();
        System.out.println(student1 == student2);*/
    }
    /*测试工厂方法模式*/
    @org.junit.Test
    public void test03(){
        // 获取汽车工厂类
        Factory factory = new CarFactory();
        // 从工厂里面获取具体类
        Vehicle vehicle = factory.produce();
        // 具体类的使用
        vehicle.run();
    }

    /*测试动态代理类*/
    @org.junit.Test
    public void test04(){
        // 首先获取业务类
        BusinessClassService businessClassService = new BusinessClassServiceImpl();
        // 获取日志类
        MyLoggerHandler myLoggerHandler = new MyLoggerHandler(businessClassService);
        /**
         * 获取代理类
         * Proxy.newProxyInstance(ClassLoader,Class[],InvocationHandler)就是代理类
         * 代理类里面的三个参数分别是：
         * ClassLoader：目标对象的类加载器，在程序运行时将生成的代理类加载到JVM中，Object.getClass().getClassLoader()
         * Class[]：目标对象所有的接口信息，让代理类具有目标对象所有的方法,Object.getClass().getInterfaces()
         * InvocationHandler：回调InvocationHandler接口的方法
         */
        BusinessClassService businessClass = (BusinessClassService) Proxy.newProxyInstance(businessClassService.getClass()
        .getClassLoader(),businessClassService.getClass().getInterfaces(),myLoggerHandler);
        businessClass.doSomeThing();
    }

    @org.junit.Test
    public void test05(){
        int id = 2;
        User user = userDao.findUser(id);
        System.err.println(user.toString());
    }

    @org.junit.Test
    public void text06() throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        User user = new User();
        user.setGender("N");
        user.setUserName("李四");
        user.setPassword("123456");
        user.setBirthday(new Date(simpleDateFormat.parse("1993-01-01").getTime()));
        userDao.insertUser(user);
        System.out.println(user.getUserId());

    }
}
