package com.bougsid.TrustService;

import com.bougsid.entities.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by ayoub on 11/2/2016.
 */
@Service
public class TrustService implements ITrustService {
    @Autowired
    private ApplicationContext context;
    //Account Evaluation
    @Value("${trustedAccount.facecbook}")
    private double facecbook;
    @Value("${trustedAccount.facecbookTrusted}")
    private double facecbookTrusted;
    @Value("${trustedAccount.phone}")
    private double phone;
    @Value("${trustedAccount.email}")
    private double email;
    @Value("${trustedAccount.picture}")
    private double picture;
    @Value("${trustedAccount.cin}")
    private double cin;
    @Value("${trustedAccount.trustedBy}")
    private double trustedBy;
    @Value("${trustedAccount.minTrust}")
    private int minTrust;
    //Announce Evaluation
    @Value("${trustedAnnounce.title}")
    private double title;
    @Value("${trustedAnnounce.description}")
    private double description;
    @Value("${trustedAnnounce.price}")
    private double price;
    @Value("${trustedAnnounce.ctr}")
    private double ctr;
    @Value("${trustedAnnounce.rates}")
    private double rates;
    @Value("${trustedAnnounce.shares}")
    private double shares;

    public AccountEvaluation verifyAccount(AccountVerification accountVerification) {
        Account account = accountVerification.getAccount();
        AccountEvaluation accountEvaluation = context.getBean(AccountEvaluation.class);
        if (accountVerification.getEmail())
            accountEvaluation.setEmail(email);
        if (accountVerification.getPhone())
            accountEvaluation.setPhone(phone);
        if (accountVerification.getPicture())
            accountEvaluation.setPicture(picture);
        if (accountVerification.getCin())
            accountEvaluation.setCin(cin);
        if (accountVerification.getFacebook())
            accountEvaluation.setFacebook(facecbook);
        if (accountVerification.getTrustedBy() > minTrust)
            accountEvaluation.setTrustedBy(trustedBy);
        if (verifyFacebook(account.getFacebook()))
            accountEvaluation.setFacebookTrusted(facecbookTrusted);
        return accountEvaluation;
    }

    public AnnounceEvaluation verifyAnnounce(AnnounceVerification announceVerification) {
        Announce announce = announceVerification.getAnnounce();
        AnnounceEvaluation announceEvaluation = context.getBean(AnnounceEvaluation.class);
        if (verifyTitle(announce.getTitle()))
            announceEvaluation.setTitle(title);
        if (verifyDescription(announce.getDescription()))
            announceEvaluation.setDescription(description);
        if (verifyPrice(announce))
            announceEvaluation.setPrice(price);
        if (calculateCtr(announce.getClicks(), announce.getImpressions()) > 0.6)
            announceEvaluation.setClickThrowRate(ctr);
        if (announce.getRates() > 10)
            announceEvaluation.setRates(rates);
        if (announce.getShares() > 10)
            announceEvaluation.setShares(shares);
        return announceEvaluation;
    }


    private boolean verifyTitle(String title) {
        return false;
    }

    private boolean verifyDescription(String title) {
        return false;
    }

    private boolean verifyPrice(Announce announce) {
        double avgPrice = getAvgPrice(announce);
        double dif = avgPrice - announce.getPrice();
        dif = (dif > 0) ? dif : -dif;
        System.out.println("dif=" + dif);
        return (dif > 1000) ? false : true;
    }

    private double getAvgPrice(Announce announce) {
        double avgPrice = 0;
        try {
            Document doc = Jsoup
                    .connect("https://www.avito.ma/fr/maroc/" + announce.getTitle())
                    .userAgent("Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)")
                    .timeout(5000).get();
            Elements prices = doc.select("span.price_value");
            for (Element price : prices) {
                System.out.println(price);
                try {
                    avgPrice += Double.parseDouble(formatNumber(price.text()));
                } catch (NumberFormatException e) {
//                    e.printStackTrace();
                }
            }
            avgPrice /= prices.size();
            System.out.println("Avg =" + avgPrice);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return avgPrice;
    }

    private String formatNumber(String price) {
        return price.replaceAll("\\s", "");
    }

    private boolean verifyFacebook(String facebook) {
        return true;
    }

    private double calculateCtr(double clicks, double impressions) {
        return clicks / impressions;
    }


}
