package com.samsung.controllers;


import com.samsung.repository.PlayerRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rating")
public class PlayerController {

    @Autowired
    private PlayerRepository player;

    @RequestMapping(value = "/create", method = RequestMethod.PUT, consumes = "text/plain")
    public int createPerson(@RequestBody String param){
        String name = null;
        String won_rounds = null;
        String lost_rounds = null;
        try{
            JSONObject json = new JSONObject(param);
            name = json.getString("name_winner");
            won_rounds = json.getString("won_rounds");
            lost_rounds = json.getString("lost_rounds");

        }catch(JSONException e){
            e.getLocalizedMessage();
            return 0;
        }
        System.out.println(name);
        System.out.println(won_rounds);
        System.out.println(lost_rounds);
        return player.createPlayer(name, won_rounds, lost_rounds);
    }


}
