package jp.co.yt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import jp.co.yt.model.Channel;
import jp.co.yt.repository.ChannelRepository;

@Controller
@RequestMapping(path="/home")
public class HomeController {

    @Autowired
    private ChannelRepository channelRepository;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Iterable<Channel> getAllUsers(){
        System.out.println("get all channels");
        return channelRepository.findAll();
    }
}
