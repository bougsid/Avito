package com.bougsid.entities;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by ayoub on 11/2/2016.
 */
@Component
@Scope("prototype")
public class AccountVerification {
private Account account;
    private boolean phone;
    private boolean email;
    private boolean picture;
    private boolean cin;
    //    private SocialMedia socialMedia;
    private boolean facebook;
    private int trustedBy; //Buyers

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean getPhone() {
        return phone;
    }

    public void setPhone(boolean phone) {
        this.phone = phone;
    }

    public boolean getEmail() {
        return email;
    }

    public void setEmail(boolean email) {
        this.email = email;
    }

    public boolean getPicture() {
        return picture;
    }

    public void setPicture(boolean picture) {
        this.picture = picture;
    }

    public boolean getCin() {
        return cin;
    }

    public void setCin(boolean cin) {
        this.cin = cin;
    }
//
//    public SocialMedia getSocialMedia() {
//        return socialMedia;
//    }
//
//    public void setSocialMedia(SocialMedia socialMedia) {
//        this.socialMedia = socialMedia;
//    }

    public boolean getFacebook() {
        return facebook;
    }

    public void setFacebook(boolean facebook) {
        this.facebook = facebook;
    }

//    public int getRecomendedBy() {
//        return recomendedBy;
//    }
//
//    public void setRecomendedBy(int recomendedBy) {
//        this.recomendedBy = recomendedBy;
//    }

    public int getTrustedBy() {
        return trustedBy;
    }

    public void setTrustedBy(int trustedBy) {
        this.trustedBy = trustedBy;
    }


}
