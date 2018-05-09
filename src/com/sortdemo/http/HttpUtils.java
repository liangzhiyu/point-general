//
//package com.sortdemo.http;
//
//import com.sun.deploy.util.StringUtils;
//import org.apache.http.HttpEntity;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.util.EntityUtils;
//
//import java.io.*;
//import java.net.URL;
//import java.net.URLConnection;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.List;
//
///**
// * Created by dell on 2017/12/26.
// */
//
//public class HttpUtils {
//    public static void main(String[] args) {
//
//
//
////        Calendar c = Calendar.getInstance();
////        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////        System.out.println(c.get(Calendar.YEAR)+"*******************"+c.getTime()+"  "+sdf.format(c.getTime())+"fffffffffff"+ LocalDateTime.now());
//
//    }
//
//    public static void get(){
//        try {
//            String link =  "http://www.baidu.com";
//            URL url =new URL(link);
//            URLConnection urlConnection = url.openConnection();
//            urlConnection.setRequestProperty("accept", "**");
//            urlConnection.setRequestProperty("connection", "Keep-Alive");
//            urlConnection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            urlConnection.setConnectTimeout(5000);
//            urlConnection.setReadTimeout(5000);
//            urlConnection.connect();
//            InputStream inputStream = urlConnection.getInputStream();
//
//            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
//
//            StringBuffer sb = new StringBuffer();
//            String line;
//            while ((line = in.readLine()) != null) {
//                sb.append(line);
//            }
//            System.out.println(sb);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public static String httpClientGet(){
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        String url = "https://www.baidu.com";
//        HttpGet httpGet = new HttpGet(url);
//        try {
//            CloseableHttpResponse httpResponse =  httpClient.execute(httpGet);
//            HttpEntity httpEntity = httpResponse.getEntity();
//            InputStream inputStream = httpEntity.getContent();
//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            String line =null;
//            StringBuffer sb = new StringBuffer();
//            while ((line=bufferedReader.readLine())!=null) {
//                sb.append(line);
//            }
//            System.out.println(sb);
//            bufferedReader.close();
//            httpClient.close();
//            return sb.toString();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public static void httpClientPost(){
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        String url = "https://hyd.kingworld.com.cn/kingworldws/v2/kingworldb2c/express/callBack";
//        HttpPost httpPost  = new HttpPost(url);
//
//        String param="{\"status\":\"shutdown\",\"billstatus\":\"check\",\"message\":\"\",\"autoCheck\":\"0\",\"comOld\":\"\",\"comNew\":\"\",\"lastResult\":{\"message\":\"ok\",\"nu\":\"3344621372956\",\"ischeck\":\"1\",\"condition\":\"F00\",\"com\":\"shentong\",\"status\":\"200\",\"state\":\"3\",\"data\":[{\"time\":\"2017-11-19 18:55:51\",\"ftime\":\"2017-11-19 18:55:51\",\"context\":\"烟台市 卫生所对面菜鸟-已签收，感谢您选择申通快递，期待再次为您服务。\"},{\"time\":\"2017-11-19 14:22:31\",\"ftime\":\"2017-11-19 14:22:31\",\"context\":\"快件已由烟台只楚小区15号楼店菜鸟驿站代收，请及时取件，如有疑问请联系15965173796\"},{\"time\":\"2017-11-19 10:42:41\",\"ftime\":\"2017-11-19 10:42:41\",\"context\":\"烟台市 山东烟台公司(0535-6649853)-幸福河门面(15005352408)-派件中\"},{\"time\":\"2017-11-19 08:11:00\",\"ftime\":\"2017-11-19 08:11:00\",\"context\":\"烟台市 已到达-山东烟台公司\"},{\"time\":\"2017-11-18 00:18:50\",\"ftime\":\"2017-11-18 00:18:50\",\"context\":\"青岛市 山东胶东中转部-已发往-山东烟台公司\"},{\"time\":\"2017-11-17 00:17:46\",\"ftime\":\"2017-11-17 00:17:46\",\"context\":\"金华市 浙江义乌公司-已发往-山东胶东中转部\"},{\"time\":\"2017-11-16 23:26:15\",\"ftime\":\"2017-11-16 23:26:15\",\"context\":\"金华市 浙江义乌公司-已发往-山东胶东中转部\"},{\"time\":\"2017-11-16 22:38:56\",\"ftime\":\"2017-11-16 22:38:56\",\"context\":\"金华市 浙江义乌公司(4009266666)-菜鸟面单2-已收件\"}]}}";
//        List<NameValuePair> nvpList = new ArrayList<NameValuePair>();
//        nvpList.add(new BasicNameValuePair("param",param));
//
//        try {
//            httpPost.setEntity(new UrlEncodedFormEntity(nvpList,"utf-8"));
//            //设置header信息
//            //指定报文头【Content-type】、【User-Agent】
////            httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
////            httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
//
//            CloseableHttpResponse  httpRespnse =httpClient.execute(httpPost);
//            HttpEntity httpEntity = httpRespnse.getEntity();
//
//            InputStream inputStream = httpEntity.getContent();
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//            String line =null;
//            StringBuffer sb = new StringBuffer();
//            while ((line=bufferedReader.readLine())!=null) {
//                sb.append(line);
//            }
//            System.out.println("fffffffffffffff"+sb);
//            inputStream.close();
//            httpRespnse.close();
//        } catch (UnsupportedEncodingException e) {
//            System.out.println("UUUUUUUUUUUUUU");
//            e.printStackTrace();
//        }
//        catch (IOException e) {
//            System.out.println("IIIIIIIIIIIIIII");
//            e.printStackTrace();
//        }
//    }
//
//    public static String send() throws ParseException, IOException{
//        String body = "";
//        //创建httpclient对象
//        CloseableHttpClient client = HttpClients.createDefault();
//        String url = "http://localhost:9002/kingworldws/v2/kingworldb2c/express/callBack";
//        //创建post方式请求对象
//        HttpPost httpPost = new HttpPost(url);
//
//        //装填参数
//        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//        String param="{\"status\":\"shutdown\",\"billstatus\":\"check\",\"message\":\"\",\"autoCheck\":\"0\",\"comOld\":\"\",\"comNew\":\"\",\"lastResult\":{\"message\":\"ok\",\"nu\":\"3344621372956\",\"ischeck\":\"1\",\"condition\":\"F00\",\"com\":\"shentong\",\"status\":\"200\",\"state\":\"3\",\"data\":[{\"time\":\"2017-11-19 18:55:51\",\"ftime\":\"2017-11-19 18:55:51\",\"context\":\"烟台市 卫生所对面菜鸟-已签收，感谢您选择申通快递，期待再次为您服务。\"},{\"time\":\"2017-11-19 14:22:31\",\"ftime\":\"2017-11-19 14:22:31\",\"context\":\"快件已由烟台只楚小区15号楼店菜鸟驿站代收，请及时取件，如有疑问请联系15965173796\"},{\"time\":\"2017-11-19 10:42:41\",\"ftime\":\"2017-11-19 10:42:41\",\"context\":\"烟台市 山东烟台公司(0535-6649853)-幸福河门面(15005352408)-派件中\"},{\"time\":\"2017-11-19 08:11:00\",\"ftime\":\"2017-11-19 08:11:00\",\"context\":\"烟台市 已到达-山东烟台公司\"},{\"time\":\"2017-11-18 00:18:50\",\"ftime\":\"2017-11-18 00:18:50\",\"context\":\"青岛市 山东胶东中转部-已发往-山东烟台公司\"},{\"time\":\"2017-11-17 00:17:46\",\"ftime\":\"2017-11-17 00:17:46\",\"context\":\"金华市 浙江义乌公司-已发往-山东胶东中转部\"},{\"time\":\"2017-11-16 23:26:15\",\"ftime\":\"2017-11-16 23:26:15\",\"context\":\"金华市 浙江义乌公司-已发往-山东胶东中转部\"},{\"time\":\"2017-11-16 22:38:56\",\"ftime\":\"2017-11-16 22:38:56\",\"context\":\"金华市 浙江义乌公司(4009266666)-菜鸟面单2-已收件\"}]}}";
//        nvps.add(new BasicNameValuePair("param", param));
//
//        //设置参数到请求对象中
//        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
//
//        System.out.println("请求地址："+url);
//        System.out.println("请求参数："+nvps.toString());
//
//        //设置header信息
//        //指定报文头【Content-type】、【User-Agent】
//        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
//        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
//
//        //执行请求操作，并拿到结果（同步阻塞）
//        CloseableHttpResponse response = client.execute(httpPost);
//        //获取结果实体
//        HttpEntity entity = response.getEntity();
//        if (entity != null) {
//            //按指定编码转换结果实体为String类型
//            body = EntityUtils.toString(entity, "utf-8");
//        }
//        EntityUtils.consume(entity);
//        //释放链接
//        response.close();
//        return body;
//    }
//}
