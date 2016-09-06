package com.cyberland.felix.truerestclient;

import android.net.wifi.WifiConfiguration;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Felix on 31.05.2016.
 */
public class ListUpload extends AsyncTask<String,String,String>
{
    public AsyncResponse delegate = null;
    int responseCode;

    @Override
    protected String doInBackground(String... params)
    {
        HttpURLConnection urlConnection = null;
        String hash;
        String jsonStringList;

        try
        {
            URL url = new URL(params[0]);
            hash = params[1];
            jsonStringList = params[2];
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            urlConnection.setRequestProperty("Accept","application/json");
            urlConnection.setRequestProperty("Authorization","Basic " + hash);
            urlConnection.setConnectTimeout(5000);
            urlConnection.setReadTimeout(10000);
            urlConnection.setRequestMethod("POST");
            urlConnection.connect();

            OutputStream outputStream = urlConnection.getOutputStream();
            outputStream.write(jsonStringList.getBytes());
            outputStream.flush();
            outputStream.close();

            responseCode = urlConnection.getResponseCode();




        }
        catch (ProtocolException e)
        {

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
        }

        return "" + responseCode;
    }

    @Override
    protected void onPostExecute(String result) {

        Log.v("json", result);
        delegate.processFinish(result);
    }

}
