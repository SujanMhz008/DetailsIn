package com.sujanmaharjan008.detailsin.model;

public class Details {
    private String name;
    private String gender;
    private String age;
    private int profileImageId;
    private int deleteId;

    public Details(String name, String gender, String age, int imageId, int deleteId) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.profileImageId = imageId;
        this.deleteId = deleteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getImageId() {
        return profileImageId;
    }

    public void setImageId(int imageId) {
        this.profileImageId = imageId;
    }

    public int getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(int deleteId){
        this.deleteId = deleteId;
    }
}
