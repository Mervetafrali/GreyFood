package com.mt.greyfood.ui.adapter;

public class Categori {
    private String imageUrl;
    private String imageText;

    public Categori() {
    }

    public Categori(String imageUrl, String imageText) {
        this.imageUrl = imageUrl;
        this.imageText = imageText;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageText() {
        return imageText;
    }

    public void setImageText(String imageText) {
        this.imageText = imageText;
    }
}
