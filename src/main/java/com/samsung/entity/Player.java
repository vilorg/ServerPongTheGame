package com.samsung.entity;

public class Player {
    private Integer id;
    private String name;
    private Integer wonRound;
    private Integer lostRound;

    public Player(Integer id, String name, Integer wonRound, Integer lostRound) {
        this.id = id;
        this.name = name;
        this.wonRound = wonRound;
        this.lostRound = lostRound;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWonRound() {
        return wonRound;
    }

    public void setWonRound(Integer wonRound) {
        this.wonRound = wonRound;
    }

    public Integer getLostRound() {
        return lostRound;
    }

    public void setLostRound(Integer lostRound) {
        this.lostRound = lostRound;
    }
}