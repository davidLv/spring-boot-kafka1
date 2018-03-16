package com.abin.lee.spring.boot.kafka.api;

import com.abin.lee.spring.boot.kafka.common.util.HttpClientUtil;
import com.abin.lee.spring.boot.kafka.common.util.JsonUtil;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by abin on 2018/1/15 11:36.
 * spring-boot-start2
 * com.abin.lee.spring.boot.mybatis.test
 */
public class KafkaSendTest {

    private static final String httpURL = "http://localhost:8099/kafka/send";
//    private static final String httpURL = "http://172.16.2.132:8080/kafka/send";

    @Test
    public void testKafkaSend() {
        try {
            CloseableHttpClient httpClient = HttpClientUtil.getHttpClient();
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            int id = (int)(Math.random()*10000000L);
            nvps.add(new BasicNameValuePair("topicName",  "kafka-test-topic" ));
            Map<String, String> request = Maps.newHashMap();
            request.put("name", "abin"+id) ;
            request.put("age", ""+id) ;
            nvps.add(new BasicNameValuePair("jsonData", JsonUtil.toJson(request)));


            HttpPost httpPost = new HttpPost(httpURL);
//            httpPost.setHeader("Cookie", getCookie());
//            httpPost.setHeader("Cookie", "JSESSIONID=7588C522A6900BFD581AA18FDA64D347");

            httpPost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
            System.out.println("Executing request: " + httpPost.getRequestLine());
            HttpResponse response = httpClient.execute(httpPost);
            System.out.println("----------------------------------------");
            System.out.println(response.getStatusLine());
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



}
