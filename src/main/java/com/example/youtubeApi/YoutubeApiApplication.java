package com.example.youtubeApi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class YoutubeApiApplication {

    private final String uriStr =
            "https://www.googleapis.com/youtube/v3/channels?part=statistics&id=UCZf__ehlCEBPop-_sldpBUQ&key=AIzaSyCcafFw0QtFpLugA6mb1XZ4XLa62zMHass";

    @RequestMapping("/home")
    @CrossOrigin
    String hello() {
        String ret;
        try {
            // URLを作成してGET通信を行う
            URL url = new URL(uriStr);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("GET");
            http.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream()));
            ret = reader.readLine();
            String line = "";
            while((line = reader.readLine()) != null)
                ret += line;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return ret;
    }

    public static void main(String[] args) {
        SpringApplication.run(YoutubeApiApplication.class, args);
    }

}
