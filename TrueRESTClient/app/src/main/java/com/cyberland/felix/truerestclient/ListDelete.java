package com.cyberland.felix.truerestclient;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Felix on 31.05.2016.
 */
public class ListDelete extends AsyncTask<String,String,String>
{
    public AsyncResponse delegate = null;
    int responseCode;

    @Override
    protected String doInBackground(String... params)
    {
        HttpURLConnection urlConnection = null;
        BufferedReader bufferedReader = null;
        String jsonStringList;
        String returnJsonString =null;
        String hash;

        try
        {
            URL url = new URL(params[0]);
            hash = params[1];
            jsonStringList = params[2];
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            urlConnection.setRequestProperty("Accept","application/json");
            urlConnection.setRequestProperty("Authorization", "Basic " + hash);
            urlConnection.setConnectTimeout(5000);
            urlConnection.setReadTimeout(10000);
            urlConnection.setRequestMethod("DELETE");
            urlConnection.connect();

            OutputStream outputStream = urlConnection.getOutputStream();
            outputStream.write(jsonStringList.getBytes());
            outputStream.flush();
            outputStream.close();

            responseCode = urlConnection.getResponseCode();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuilder builder = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                builder.append(line).append("\n");
            }

            returnJsonString = builder.toString();


        }
        catch (IOException e)
        {

        }
        return returnJsonString;
    }

    @Override
    protected void onPostExecute(String result)
    {

    }
}
