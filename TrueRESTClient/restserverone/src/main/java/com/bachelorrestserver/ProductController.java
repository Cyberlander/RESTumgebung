package com.bachelorrestserver;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Created by Felix on 13.05.2016.
 */
public class ProductController
{
    public ProductController(final ProductService productService)
    {

        Spark.before("/*", (request,response) ->
        {
            String authHeader = request.headers("Authorization");

            if (!AuthHandler.allowAuthentication(authHeader))
            {
                Spark.halt(401, "Unauthorized");
            }

        });
        //leitet die /products Anfrage an den Service weiter und liefert
        //eine Liste der Produktobjekte zurück
        Spark.get("/products", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception
            {
                    return productService.getAllProducts();
            }
        },new JsonTransformer());

        Spark.get("/products/:id", (request,response) ->
        {
            String idString = request.params(":id");
            int id = Integer.parseInt(idString);

            Product p = productService.getProduct(id);

            return (p != null ? p : null);
        }, new JsonTransformer());


    }

}
