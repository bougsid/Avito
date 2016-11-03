package com.bougsid.TrustService;

import com.bougsid.entities.*;
import org.springframework.stereotype.Service;

/**
 * Created by ayoub on 11/2/2016.
 */
@Service
public interface ITrustService {
    AccountEvaluation verifyAccount(AccountVerification accountVerification);
    AnnounceEvaluation verifyAnnounce(AnnounceVerification announceVerification);
}
