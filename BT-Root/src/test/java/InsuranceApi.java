import org.testng.annotations.Test;
import sun.misc.BASE64Encoder;
import util.HttpUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * Created by slh on 2019/8/15.
 */
public class InsuranceApi {
    //public String host ="http://openapi.acar168.cn:5516";  //测试环境
    public String host ="http://prepopenapi.bz-ins.com";  //预发布
    // public String host ="http://192.168.131.212:8089";  //邵奇本地地址
    //public String secretKey ="787xunmatong";//测试环境密钥
    public String secretKey ="MD5";//预发布环境密钥
    public String orderNo;

    
    //商户号是唯一的 channelId 1001.  真实环境测试商户号1002
    @Test(enabled = true) //1、承保
        public void accidentInsure() throws Exception {
            long longtime = new Date().getTime();
            String   params = "{\"head\":{\"channelId\":1002,\"orderNo\":\"NO"+longtime+"\",\"time\":"+longtime+",\"version\":\"1.1\"},\"body\":{\"insurantName\":\"石林辉\",\"insurantLicenseNo\":\"330327199104184443\",\"count\":1,\"insurancePeriod\":10,\"fee\":1,\"payerBank\":\"3085840\",\"payerUserName\":\"石林辉\",\"payerCardNumber\":\"6225885747261428\",\"payerMobile\":\"15757136597\",\"insurantMobile\":\"18888888888\",\"payerIdcard\":\"330327199104184443\"}}";
            System.out.println(params);
            orderNo = "NO"+longtime;
            System.out.println(orderNo);
            byte[] md5String = HttpUtil.stringMD5(secretKey+params);

            BASE64Encoder b64Encoder = new BASE64Encoder();
            String encodeStr = b64Encoder.encode(md5String);

            String url =host + "/insurance/accident/insure?sign=" + encodeStr;
            System.out.println(url);
            String response =  HttpUtil.doPost(url,params);
            System.out.println(response);

        }


        @Test(enabled = true)//2、支付
        public void accidentPay() throws Exception {
            long longtime = new Date().getTime();
            System.out.println(longtime);
            String   params ="{\"head\":{\"type\":0,\"channelId\":1002,\"orderNo\":\"NO1566801123045\",\"time\":"+longtime+",\"version\":\"1.1\"},\"body\":{\"code\":\"652550\"}}";
            byte[] md5String = HttpUtil.stringMD5(secretKey+params);

            BASE64Encoder b64Encoder = new BASE64Encoder();
            String encodeStr = b64Encoder.encode(md5String);

            String url =host + "/insurance/accident/pay?sign=" + encodeStr;
            System.out.println(url);


            String response =  HttpUtil.doPost(url,params);
            System.out.println(response);

        }




        @Test(enabled = true)//3、退款
        public void accidentRefund() throws Exception {
            long longtime = new Date().getTime();
            System.out.println(longtime);
            String   params ="{\"head\":{\"type\":0,\"channelId\":1002,\"orderNo\":\"NO1566800852361\",\"time\":"+longtime+",\"version\":\"1.1\"},\"body\":{\"reason\":\"测试退款\",\"notifyUrl\":\"http://129.211.29.61:9050/refundCallback\"}}";
            byte[] md5String = HttpUtil.stringMD5(secretKey+params);

            BASE64Encoder b64Encoder = new BASE64Encoder();
            String encodeStr = b64Encoder.encode(md5String);

            String url =host + "/insurance/accident/refund?sign=" + encodeStr;
            System.out.println(url);

            String response =  HttpUtil.doPost(url,params);
            System.out.println(response);
        }



        @Test(enabled = true)//4、下单
        public void accidentPolicy() throws Exception {
            long longtime = new Date().getTime();
            System.out.println(longtime);
            String   params ="{\"head\":{\"type\":0,\"channelId\":1002,\"orderNo\":\"NO1566801123045\",\"time\":"+longtime+",\"version\":\"1.1\"}}";
            byte[] md5String = HttpUtil.stringMD5(secretKey+params);

            BASE64Encoder b64Encoder = new BASE64Encoder();
            String encodeStr = b64Encoder.encode(md5String);

            String url =host + "/insurance/accident/policy?sign=" + encodeStr;
            System.out.println(url);

            String response =  HttpUtil.doPost(url,params);
            System.out.println(response);
        }


        @Test(enabled = true)//5、承保结果查询
        public void accidentQuery() throws Exception {
            long longtime = new Date().getTime();
            System.out.println(longtime);
            String   params ="{\"head\":{\"channelId\":1002,\"orderNo\":\"NO1566801123045\",\"time\":"+longtime+",\"version\":\"1.1\"}}";
            byte[] md5String = HttpUtil.stringMD5(secretKey+params);

            BASE64Encoder b64Encoder = new BASE64Encoder();
            String encodeStr = b64Encoder.encode(md5String);

            String url =host + "/insurance/accident/query?sign=" + encodeStr;
            System.out.println(url);

            String response =  HttpUtil.doPost(url,params);
            System.out.println(response);
        }


        @Test(enabled = true)//6、查看电子保单
        public void accidentQuote() throws Exception {
            long longtime = new Date().getTime();
            System.out.println(longtime);
            String   params ="{\"head\":{\"type\":0,\"channelId\":1002,\"orderNo\":\"NO1566801123045\",\"time\":"+longtime+",\"version\":\"1.1\"}}";
            byte[] md5String = HttpUtil.stringMD5(secretKey+params);

            BASE64Encoder b64Encoder = new BASE64Encoder();
            String encodeStr = b64Encoder.encode(md5String);

            String url =host + "/insurance/accident/quote?sign=" + encodeStr;
            System.out.println(url);

            String response =  HttpUtil.doPost(url,params);
            System.out.println(response);
        }


        @Test(enabled = true)//7、对账
        public void accidentChecking() throws Exception {
            long longtime = new Date().getTime();
            System.out.println(longtime);
            String   params = "{\"head\":{\"channelId\":1001,\"time\":"+longtime+",\"version\":\"1.1\"},\"body\":{\"startDate\":\"20190821\",\"endDate\":\"20190823\"}}";
            byte[] md5String = HttpUtil.stringMD5(secretKey+params);

            BASE64Encoder b64Encoder = new BASE64Encoder();
            String encodeStr = b64Encoder.encode(md5String);

            String url =host + "/insurance/accident/checking?sign=" + encodeStr;
            System.out.println(url);

            String response =  HttpUtil.doPost(url,params);
            System.out.println(response);
        }

}
