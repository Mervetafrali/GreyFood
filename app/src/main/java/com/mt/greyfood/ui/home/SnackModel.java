package com.mt.greyfood.ui.home;

public class SnackModel {
    private String snackImageUrl;
    private String SnackImageText;

    public SnackModel(String imageUrl, String imageText) {
        this.SnackImageText = imageText;
        this.snackImageUrl = imageUrl;
    }

    public String getSnackImageText() {
        return SnackImageText;
    }

    public String getSnackImageUrl() {
        return snackImageUrl;
    }

    public void setSnackImageText(String SnackImageText) {
        this.SnackImageText = SnackImageText;
    }

    public void setSnackImageUrl(String snackImageUrl) {
        this.snackImageUrl = snackImageUrl;
    }
}
