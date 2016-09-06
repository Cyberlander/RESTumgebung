package com.bachelorrestserver;

import com.google.gson.Gson;

import spark.ResponseTransformer;

/**
 * Created by Felix on 13.05.2016.
 */
public class JsonTransformer implements ResponseTransformer {
    private Gson gson = new Gson();

    public String render(Object model) throws Exception
    {
        return gson.toJson(model);
    }

}
