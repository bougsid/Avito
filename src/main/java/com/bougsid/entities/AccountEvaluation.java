package com.bougsid.entities;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * Created by ayoub on 11/2/2016.
 */
@Component
@Scope("prototype")
public class AccountEvaluation {
    private double facebook;
    private double phone;
    private double email;
    private double picture;
    private double cin;
    private double facebookTrusted;

    private double trustedBy;
//    private double recomendedBy;


    private double trustIndex;

    public double getFacebookTrusted() {
        return facebookTrusted;
    }

    public void setFacebookTrusted(double facebookTrusted) {
        this.facebookTrusted = facebookTrusted;
    }

    public double getFacebook() {
        return facebook;
    }

    public void setFacebook(double facebook) {
        this.facebook = facebook;
    }

    public double getPhone() {
        return phone;
    }

    public void setPhone(double phone) {
        this.phone = phone;
    }

    public double getEmail() {
        return email;
    }

    public void setEmail(double email) {
        this.email = email;
    }

    public double getPicture() {
        return picture;
    }

    public void setPicture(double picture) {
        this.picture = picture;
    }

    public double getCin() {
        return cin;
    }

    public void setCin(double cin) {
        this.cin = cin;
    }

    public double getTrustedBy() {
        return trustedBy;
    }

    public void setTrustedBy(double trustedBy) {
        this.trustedBy = trustedBy;
    }

//    public double getRecomendedBy() {
//        return recomendedBy;
//    }
//
//    public void setRecomendedBy(double recomendedBy) {
//        this.recomendedBy = recomendedBy;
//    }

    public double getTrustIndex() {
        this.calculateTrustIndex();
        return trustIndex;
    }

    private void calculateTrustIndex() {
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.getName().equals("trustIndex")) continue;
            field.setAccessible(true);
            try {
                trustIndex += (double) field.get(this);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
