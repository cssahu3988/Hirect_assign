package com.example.hirect_assign.pojo;

public class CryptoDetails {
    String shortName, name, price, amount, rank, dominance, marketCap, totalSupply, about;

    public CryptoDetails(String shortName, String name, String price, String amount, String rank, String dominance, String marketCap, String totalSupply, String about) {
        this.shortName = shortName;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.rank = rank;
        this.dominance = dominance;
        this.marketCap = marketCap;
        this.totalSupply = totalSupply;
        this.about = about;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDominance() {
        return dominance;
    }

    public void setDominance(String dominance) {
        this.dominance = dominance;
    }

    public String getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(String marketCap) {
        this.marketCap = marketCap;
    }

    public String getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(String totalSupply) {
        this.totalSupply = totalSupply;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
