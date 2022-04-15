package com.example.assignment.model;

public class Model {
    // This is a model class
    // We will declare the n no. of variables according to what we want to show in each row of recyclerview
    String name , subject ,qualification,profileImage;


    public Model(){

    }

    public Model(String name, String subject, String qualification, String profileImage) {
        this.name = name;
        this.subject = subject;
        this.qualification = qualification;
        this.profileImage = profileImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
