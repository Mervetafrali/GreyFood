package com.mt.greyfood.ui.home;

import com.google.firebase.database.PropertyName;
import com.mt.greyfood.ui.adapter.Categori;

import java.util.List;
import java.util.Map;

public class ImagesList {
    @PropertyName("kategoriler")
    private List<Map<String, Categori>> kategoriler;
    @PropertyName("markalar")
    private List<String> markalar;
    @PropertyName("coksatanlar")
    private List<String> coksatanlar;
    @PropertyName("kampanyalar")
    private List<String> kampanyalar;
    @PropertyName("blog")
    private List<String> blog;

    public ImagesList(List<Map<String, Categori>> kategoriler, List<String> markalar, List<String> coksatanlar, List<String> kampanyalar, List<String> blogs) {
        this.kategoriler = kategoriler;
        this.markalar = markalar;
        this.coksatanlar = coksatanlar;
        this.kampanyalar = kampanyalar;
        this.blog = blogs;
    }

    public ImagesList() {
    }

    public List<String> getBlog() {
        return blog;
    }

    public void setBlog(List<String> blog) {
        this.blog = blog;
    }

    public List<Map<String, Categori>> getKategoriler() {
        return kategoriler;
    }

    public void setKategoriler(List<Map<String, Categori>> kategoriler) {
        this.kategoriler = kategoriler;
    }

    public List<String> getMarkalar() {
        return markalar;
    }

    public void setMarkalar(List<String> markalar) {
        this.markalar = markalar;
    }

    public List<String> getCoksatanlar() {
        return coksatanlar;
    }

    public void setCoksatanlar(List<String> coksatanlar) {
        this.coksatanlar = coksatanlar;
    }

    public List<String> getKampanyalar() {
        return kampanyalar;
    }

    public void setKampanyalar(List<String> kampanyalar) {
        this.kampanyalar = kampanyalar;
    }
}
