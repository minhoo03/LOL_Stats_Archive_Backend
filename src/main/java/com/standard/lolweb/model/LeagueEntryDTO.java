package com.standard.lolweb.model;

public class LeagueEntryDTO {
    public String leagueId;
    public String summonerId;
    public String queueType;
    public String tier;
    public String rank;
    public int leaguePoints;
    public int wins;
    public int losses;
    public boolean hotStreak;
    public boolean veteran;
    public boolean freshBlood;
    public boolean inactive;
    public MiniSeriesDTO miniSeries;

    public String getLeagueId() {
        return leagueId;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public String getQueueType() {
        return queueType;
    }

    public String getTier() {
        return tier;
    }

    public String getRank() {
        return rank;
    }

    public int getLeaguePoints() {
        return leaguePoints;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public boolean isHotStreak() {
        return hotStreak;
    }

    public boolean isVeteran() {
        return veteran;
    }

    public boolean isFreshBlood() {
        return freshBlood;
    }

    public boolean isInactive() {
        return inactive;
    }

    public MiniSeriesDTO getMiniSeries() {
        return miniSeries;
    }
}
