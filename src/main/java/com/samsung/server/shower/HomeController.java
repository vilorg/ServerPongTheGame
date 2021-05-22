package com.samsung.server.shower;

import com.samsung.server.chat.ChatServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String index() throws InterruptedException {
        new ChatServer(8080).run();
        return "Server has started";
    }
}
