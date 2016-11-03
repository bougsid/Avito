package com.bougsid.TrustService;

import com.bougsid.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ayoub on 11/2/2016.
 */

@RestController
@CrossOrigin(origins = "*")
public class TrustRestController {

    @Autowired
    private ITrustService service;
    @Autowired
    private ApplicationContext context;

    @PostMapping(path = "/announce")
    public AnnounceEvaluation checkAnnounce(@RequestBody Announce announce) {
        AnnounceVerification announceVerification = context.getBean(AnnounceVerification.class);
        announceVerification.setAnnounce(announce);
        return service.verifyAnnounce(announceVerification);
    }
//
//    @PostMapping(path = "/account")
//    public AccountEvaluation checkAccount(@RequestBody AccountVerification account) {
//        return service.verifyAccount(account);
//    }

}
