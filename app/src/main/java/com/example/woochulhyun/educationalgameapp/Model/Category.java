package com.example.woochulhyun.educationalgameapp.Model;

/**
 * Created by WOOCHUL HYUN on 2018-01-10.
 */

public class Category {

    private String Nmae;
    private String Image;

    public Category() {
    }

    public Category(String nmae, String image) {
        Nmae = nmae;
        Image = image;

    }

    public String getNmae() {
        return Nmae;
    }

    public void setNmae(String nmae) {
        Nmae = nmae;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
