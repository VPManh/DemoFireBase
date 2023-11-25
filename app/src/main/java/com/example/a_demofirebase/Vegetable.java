package com.example.a_demofirebase;

public class Vegetable {
    private String name;
    private String title;
    private int hinhanh;

    public Vegetable(String name, String title, int hinhanh) {
        this.name = name;
        this.title = title;
        this.hinhanh = hinhanh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }
}
