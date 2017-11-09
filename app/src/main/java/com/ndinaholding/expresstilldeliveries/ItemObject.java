package com.ndinaholding.expresstilldeliveries;

public class ItemObject {

    private String content;
    private String imageResource;
    private String price;

    public ItemObject(String content, String imageResource, String price) {
        this.content = content;
        this.imageResource = imageResource;
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageResource() {
        return imageResource;
    }

    public void setImageResource(String imageResource) {
        this.imageResource = imageResource;
    }
}
