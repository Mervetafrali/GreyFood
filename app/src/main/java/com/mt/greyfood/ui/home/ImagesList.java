package com.mt.greyfood.ui.home;

import com.google.firebase.database.PropertyName;

import java.util.List;

public class ImagesList {
    @PropertyName("kategories")
    private List<String> kategoriler;
    @PropertyName("markalar")
    private List<String> markalar;
    @PropertyName("coksatanlar")
    private List<String> coksatanlar;
    @PropertyName("kampanyalar")
    private List<String> kampanyalar;

    public ImagesList(List<String> kategoriler, List<String> markalar, List<String> coksatanlar, List<String> kampanyalar) {
        this.kategoriler = kategoriler;
        this.markalar = markalar;
        this.coksatanlar = coksatanlar;
        this.kampanyalar = kampanyalar;
    }

    public ImagesList() {
    }

    public List<String> getKategoriler() {
        return kategoriler;
    }

    public void setKategoriler(List<String> kategoriler) {
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
