package com.samsung.repository;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

@Component
public class PlayerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createPlayer(String name, String wonRound, String lostRound){
        return jdbcTemplate.update("INSERT INTO \"RATING\" (\"PARTICIPANT\", \"WON_ROUNDS\", \"LOST_ROUNDS\") VALUES(?, ?, ?)", name, wonRound, lostRound);
    }

    public JSONArray getTop(){
        JSONObject json;
        JSONArray jsonArr = new JSONArray();
        try {
            Connection conn= Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM public.\"RATING\"";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                json = new JSONObject();
                json.put("name", rs.getString("PARTICIPANT"));
                json.put("wonRounds", rs.getString("WON_ROUNDS"));
                json.put("lostRounds", rs.getString("LOST_ROUNDS"));
                jsonArr.put(json);
            }
        } catch (SQLException | JSONException e) {
            e.getLocalizedMessage();
            return null;
        }
        return jsonArr;
    }
}
