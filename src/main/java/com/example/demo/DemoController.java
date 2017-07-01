package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * Created by zhaoenwei on 2017/6/29.
 */
@RestController
public class DemoController {
    private static long timeStample=System.currentTimeMillis();
    @Value("${words}") String words;

    @RequestMapping("/")
    public  String getWord() {
        String[] wordArray = words.split(",");
        String address= null;
        try {
            address = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        int i = (int)Math.round(Math.random() * (wordArray.length - 1));
            return wordArray[i]+timeStample+ address;
    }
}
