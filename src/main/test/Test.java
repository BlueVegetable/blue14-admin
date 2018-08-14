import cn.blue.dao.ConsultDao;
import cn.blue.domain.Consult;
import cn.blue.service.ConsultService;
import cn.blue.utils.RemoteURL;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Test {
    @org.junit.Test
    public void TestPhoneNumber() throws IOException {
        RemoteURL remoteURL=new RemoteURL();
        String url="https://way.jd.com/jisuapi/query4";
        String parameters="appkey=1d447a09ea953c29d4e9141b49c369d3";
        Map map=remoteURL.getPhoneNumberInfo(url,"15521131057",parameters);
        System.out.println(map);
        System.out.println(map.get("result"));
    }

    @Autowired
    private ConsultDao consultDao;

    @Autowired
    private ConsultService consultService;

}
