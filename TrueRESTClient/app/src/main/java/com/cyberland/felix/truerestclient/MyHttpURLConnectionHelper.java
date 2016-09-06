package com.cyberland.felix.truerestclient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Felix on 17.05.2016.
 */
public class MyHttpURLConnectionHelper
{
    public MyHttpURLConnectionHelper(URL url, String hash)
    {

    }

    public static HttpURLConnection getConnection(URL url, String hash) throws IOException
    {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty("Accept", "application/json");
        httpURLConnection.setRequestProperty("Authorization", "Basic " + hash);
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();

        return httpURLConnection;

    }
}
