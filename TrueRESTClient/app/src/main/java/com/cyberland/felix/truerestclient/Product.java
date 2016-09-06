package com.cyberland.felix.truerestclient;

/** systemctl enable mongodb.service
 * Created by Felix on 02.05.2016.
 */
public class Product {
    private long id;
    private String product_name;
    private String marketName;
    private int posX;
    private int posY;

    public Product(long id, String product, String market, int x, int y)
    {
        this.id = id;
        this.product_name = product;
        this.marketName = market;
        this.posX = x;
        this.posY = y;

    }
    //
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return product_name;
    }

    public void setProductName(String product) {
        this.product_name = product;
    }

    public String getMarketName() {return marketName; }

    public void setMarketName(String market) { this.marketName = market;}

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posx) {
        this.posX = posx;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posy) {
        this.posY = posy;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Object && obj != null) {
            Product p = (Product) obj;
            return p.getProductName().equals(getProductName()) &&
                    p.getPosX() == getPosX() &&
                    p.getPosY() == getPosY();
        }
        return false;
    }
}
