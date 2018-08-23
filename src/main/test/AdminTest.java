import cn.blue.dao.AdminDao;
import cn.blue.domain.Admin;
import cn.blue.utils.Token;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AdminTest {
    Admin admin=new Admin();

    @Autowired
    private AdminDao adminDao;
    @Test
    public void test1(){
        admin.setId(1);
        admin.setName("蔡荣镔");
        admin.setPassword("123456");
        String token=Token.createToken(admin,"10000");
        System.out.println(token);
    }
    @Test
    public void testDao(){
//        System.out.println(adminDao.getAdminByName("孙"));
//        System.out.println(adminDao.count("孙"));
    }
}
