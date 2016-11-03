package com.bougsid.entities;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by ayoub on 11/3/2016.
 */
@Component
@Scope("prototype")
public class AnnounceVerification {

    private Announce announce;
    private boolean title;
    private boolean description;
    private boolean price;
    private boolean ctr;

    public Announce getAnnounce() {
        return announce;
    }

    public void setAnnounce(Announce announce) {
        this.announce = announce;
    }

    public boolean isTitle() {
        return title;
    }

    public void setTitle(boolean title) {
        this.title = title;
    }

    public boolean isDescription() {
        return description;
    }

    public void setDescription(boolean description) {
        this.description = description;
    }

    public boolean isPrice() {
        return price;
    }

    public void setPrice(boolean price) {
        this.price = price;
    }

    public boolean isCtr() {
        return ctr;
    }

    public void setCtr(boolean ctr) {
        this.ctr = ctr;
    }
}
