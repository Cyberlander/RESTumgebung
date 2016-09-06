package com.bachelorrestserver;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class RestServerOne
{
    public static void main (String[] args)
    {
        new ProductController(new ProductService());

        Spark.get("/", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception
            {
                return "Hello World!";
            }
        });





    }
}
