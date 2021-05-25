package com.samsung.controllers;


import com.samsung.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rating")
public class PlayerController {

    @Autowired
    private PlayerRepository player;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public int createPerson(@RequestParam String name, String won_rounds, String lost_rounds){
        return player.createPlayer(name, won_rounds, lost_rounds);
    }

    @RequestMapping(value = "/get-top", method = RequestMethod.GET)
    public String getInt(){
        return player.getTop().toString();
    }


}
