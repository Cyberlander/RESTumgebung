package com.bachelorrestserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Felix on 13.05.2016.
 */
public class ProductService
{
    List<Product> liste;
    public ProductService()
    {
         liste = new ArrayList<Product>();

        Product product1 = new Product(0,"Kaese", "BestMarket",5,3);
        Product product2 = new Product(1,"Fleisch","BestMarket",2,7);

        liste.add(product1);
        liste.add(product2);
    }

    public List<Product> getAllProducts()
    {
        return liste;
    }

    public Product getProduct(int id)
    {
        return liste.get(id);
    }

    public Product createProduct(String name, String market, int posX,int posY)
    {
        return null;
    }

    public Product updateProduct(String id,String name, String market, int posX,int posY)
    {
        return null;
    }

}
