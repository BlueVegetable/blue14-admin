import cn.blue.dao.ConsultDao;
import cn.blue.domain.Consult;
import cn.blue.utils.RemoteURL;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
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

    /**
     * 此常量为获取手机号码的归属地必须传递的参数
     */
    private static final String PARAMETER="appkey=1d447a09ea953c29d4e9141b49c369d3";
    private static final String URL="https://way.jd.com/jisuapi/query4";

    @org.junit.Test
    public void Test2() throws IOException {
        long time1,time2,time3;
        time1=System.currentTimeMillis();
        for(int i=540;i<=14458;i++) {
            Consult consult=consultDao.getConsultById(i);

            Map<String,Object> phoneNumberInfo=new RemoteURL().getPhoneNumberInfo(URL,consult.getPhoneNumber(),PARAMETER);

            //设置Consult中的一个字段attribution
            if(phoneNumberInfo==null||phoneNumberInfo.get("status").equals("202")||phoneNumberInfo.get("result")==null)
                consult.setAttribution("");
            else {
                Map<String,String> values=(Map)phoneNumberInfo.get("result");
                consult.setAttribution(values.get("province")+"省"+values.get("city")+"市");
            }

            consultDao.updateConsult(consult);
        }
        time2=System.currentTimeMillis();
        System.out.println(time2-time1);
    }


//    public void test5() {
//        System.out.println(consultDao.addConsult())
//    }

}
