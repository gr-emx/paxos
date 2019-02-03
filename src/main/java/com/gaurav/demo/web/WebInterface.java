package com.gaurav.demo.web;

import com.gaurav.demo.PaxosApplication;
import com.gaurav.demo.model.DigestResponse;
import com.gaurav.demo.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebInterface {
    @Autowired
    PaxosApplication paxosApplication;

    @PostMapping("/messages")
    public DigestResponse generateHash(@RequestBody Message message) {
        return new DigestResponse(paxosApplication.getHashAndStoreInRepository(message.getMessage()));
    }

    @GetMapping("/messages/{hash}")
    public Message getHash(@PathVariable("hash") String hash) {
        return new Message(paxosApplication.getOriginalMessage(hash));
    }


}
