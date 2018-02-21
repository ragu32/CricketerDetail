package com.cricket.admin_2.cricketerdetails.player;


public class Player {
    private String playerName;
    private int jerseyNumber;
    private String playerType;
    public Player() {

    }

    public Player(String playerName, int jerseyNumber, String playerType) {
        this.playerName = playerName;
        this.jerseyNumber = jerseyNumber;
        this.playerType = playerType;
    }

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }
}
