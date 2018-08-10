import cn.blue.controller.ConsultController;
import cn.blue.utils.RemoteURL;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

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

}
