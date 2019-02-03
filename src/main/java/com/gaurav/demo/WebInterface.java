package com.gaurav.demo;

import com.gaurav.demo.model.MessageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebInterface {

    @PostMapping("/messages")
    public String generateHash(@RequestBody MessageRequest message){
        return "chimbs rocks : " + message.getMessage();
    }

    @GetMapping("/messages/{hash}")
    public String getHash(@PathVariable("hash") String hash){
        return "chimbs rocked " + hash;
    }


}
