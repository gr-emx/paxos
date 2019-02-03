package com.gaurav.demo;

import com.gaurav.demo.featureflag.FeatureFlagManager;
import com.gaurav.demo.repository.HashRepository;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;

@Service
public class PaxosApplication {
    @Autowired
    HashRepository hashRepository;

    @Autowired
    FeatureFlagManager featureFlagManager;

    public String getHashAndStoreInRepository(String message) {
        featureFlagManager.isEnabled(this.getClass());
        String hash = Hashing.sha256()
                .hashString(message, Charset.defaultCharset())
                .toString();
        hashRepository.put(hash,message);
        return hash;
    }

    public String getOriginalMessage(String hash){
        featureFlagManager.isEnabled(this.getClass());
        return hashRepository.get(hash);
    }

}
