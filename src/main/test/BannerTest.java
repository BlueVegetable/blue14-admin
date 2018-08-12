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
    public void addTest() {
        Banner banner=new Banner();
        banner.setPath("柯南");
        banner.setPosition(100);
        banner.setType("图片");
        banner.setVisible(true);
        System.out.println(bannerDao.addBanner(banner));
    }

    @Test
    public void deleteTest() {
        System.out.println(bannerDao.deleteBanner(1));
    }

    @Test
    public void get(){
        System.out.println(bannerDao.getAllCount(true));
    }

    @Test
    public void change(){
        System.out.println(bannerDao.alterVisible(1,false));
    }
}
