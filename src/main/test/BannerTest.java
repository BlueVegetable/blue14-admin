import cn.blue.dao.BannerDao;
import cn.blue.domain.Banner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class BannerTest {

    @Autowired
    private BannerDao bannerDao;

    @Test
    public void test1() {
        System.out.println(bannerDao.bigger(4));
    }

}
