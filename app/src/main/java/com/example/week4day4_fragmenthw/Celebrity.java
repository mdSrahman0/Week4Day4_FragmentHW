package com.example.week4day4_fragmenthw;

public class Celebrity {

    private String name = "";
    private String profession = "";
    private String details = "";
    private String quote = "";
    private int photo;

    public Celebrity(){}
    public Celebrity(String name, String profession, String details, String quote, int photo) {
        this.name = name;
        this.profession = profession;
        this.details = details;
        this.quote = quote;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public int getPhoto() { return photo; }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
