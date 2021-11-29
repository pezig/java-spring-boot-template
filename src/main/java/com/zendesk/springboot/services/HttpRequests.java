package com.zendesk.springboot.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


public class HttpRequests {
    public static String sendGET(String url) throws IOException {

        String result = "";
        HttpGet get = new HttpGet(url);

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(get)){
            result = EntityUtils.toString(response.getEntity());
        }

        return result;
    }

    public static String sendPOST(String url, Map<String, String> params) throws IOException {

        String result = "";
        HttpPost post = new HttpPost(url);

        List<NameValuePair> urlParameters = new ArrayList<>();
        for(Map.Entry<String, String> entry : params.entrySet()){
            urlParameters.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)){
            result = EntityUtils.toString(response.getEntity());
        }

        return result;
    }

}
