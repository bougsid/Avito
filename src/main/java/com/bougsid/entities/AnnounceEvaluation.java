package com.bougsid.entities;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * Created by ayoub on 11/2/2016.
 */
@Component
@Scope("prototype")
public class AnnounceEvaluation {
    // This class is used to save criteria evaluations
    private double images;
    private double description;
    private double title;
    private double price;
    private double clickThrowRate;//Click Throw Rate
    private double shares;
    private double rates;

    private double trustIndex;

    public double getImages() {
        return images;
    }

    public void setImages(double images) {
        this.images = images;
    }

    public double getDescription() {
        return description;
    }

    public void setDescription(double description) {
        this.description = description;
    }

    public double getTitle() {
        return title;
    }

    public void setTitle(double title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getClickThrowRate() {
        return clickThrowRate;
    }

    public void setClickThrowRate(double clickThrowRate) {
        this.clickThrowRate = clickThrowRate;
    }

    public double getShares() {
        return shares;
    }

    public void setShares(double shares) {
        this.shares = shares;
    }

    public double getRates() {
        return rates;
    }

    public void setRates(double rates) {
        this.rates = rates;
    }

    public double getTrustIndex() {
        calculateTrustIndex();
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
