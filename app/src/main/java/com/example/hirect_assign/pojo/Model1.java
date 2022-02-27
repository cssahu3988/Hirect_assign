package com.example.hirect_assign.pojo;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class Model1 {
    private String name, percentage, price, amount, colors;
    private Drawable cryptoImage, lines, area, background;
    private int color;

    public Model1(String name, String percentage, String price, String amount, String colors, Drawable cryptoImage, Drawable lines, Drawable area, Drawable background,int color) {
        this.name = name;
        this.percentage = percentage;
        this.price = price;
        this.amount = amount;
        this.cryptoImage = cryptoImage;
        this.lines = lines;
        this.area = area;
        this.color = color;
        this.colors = colors;
        this.background = background;
    }

    public Drawable getBackground() {
        return background;
    }

    public void setBackground(Drawable background) {
        this.background = background;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Drawable getCryptoImage() {
        return cryptoImage;
    }

    public void setCryptoImage(Drawable cryptoImage) {
        this.cryptoImage = cryptoImage;
    }

    public Drawable getLines() {
        return lines;
    }

    public void setLines(Drawable lines) {
        this.lines = lines;
    }

    public Drawable getArea() {
        return area;
    }

    public void setArea(Drawable area) {
        this.area = area;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }
}
