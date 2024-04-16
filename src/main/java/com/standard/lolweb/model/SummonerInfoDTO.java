package com.standard.lolweb.model;

import java.util.List;
import java.util.Set;

public class SummonerInfoDTO {
    private int icon;
    private String name;
    private String tag;
    private String tier;
    private String rank;
    private int lp;
    private List<Long> mostChampions;
    private List<GameLog> gameLogs;

    public SummonerInfoDTO(Account account, Summoner summoner, List<ChampionMastery> championMasteries, Set<LeagueEntryDTO> leagueEntries) {
        name = account.getGameName();
        tag = account.getTagLine();

        icon = summoner.getProfileIconId();

        mostChampions = championMasteries.stream().map(ChampionMastery::getChampionId).toList();

        for (var entry : leagueEntries) {
            if (entry.getQueueType().equals("RANKED_SOLO_5x5")) {
                tier = entry.getTier();
                rank = entry.getRank();
                lp = entry.getLeaguePoints();
                break;
            }
        }
    }

    public int getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public String getTag() {
        return tag;
    }

    public String getTier() {
        return tier;
    }

    public String getRank() {
        return rank;
    }

    public int getLp() {
        return lp;
    }

    public List<Long> getMostChampions() {
        return mostChampions;
    }

    public List<GameLog> getGameLogs() {
        return gameLogs;
    }
}
