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
 * Created by Felix on 02.06.2016.
 */
public class ProductsUpload extends AsyncTask<String,String,String>
{
    AsyncResponse delegate = null;
    @Override
    protected String doInBackground(String... params)
    {
        HttpURLConnection urlConnection = null;
        String hash;
        String paramProductsToUploadJsonString;
        String jsonReturnString = null;
        int responseCode;
        BufferedReader bufferedReader = null;

        try {
            URL url = new URL(params[0]);
            hash = params[1];
            paramProductsToUploadJsonString = params[2];
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("Authorization", " Basic " + hash);
            urlConnection.setConnectTimeout(5000);
            urlConnection.setReadTimeout(10000);
            urlConnection.setRequestMethod("POST");
            urlConnection.connect();

            OutputStream outputStream = urlConnection.getOutputStream();
            outputStream.write(paramProductsToUploadJsonString.getBytes());
            outputStream.flush();
            outputStream.close();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuilder builder = new StringBuilder();

            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = bufferedReader.readLine())!=null)
            {
                builder.append(line).append("\n");
            }
            jsonReturnString = builder.toString();
        }
        catch (IOException e)
        {

        }
        finally
        {
            if (urlConnection != null)
            {
                urlConnection.disconnect();
            }

            if (bufferedReader != null)
            {
                try
                {
                    bufferedReader.close();
                }
                catch (IOException e)
                {

                }

            }
        }

        return jsonReturnString;
    }
}
