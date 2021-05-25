package com.samsung.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PlayerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createPlayer(String name, String wonRound, String lostRound){
        return jdbcTemplate.update("INSERT INTO \"Rating\" (\"name_winner\", \"won_rounds\", \"lost_rounds\") VALUES(?, ?, ?)", name, wonRound, lostRound);
    }
}
