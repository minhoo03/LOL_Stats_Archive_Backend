package com.standard.lolweb.module.sample;

import com.standard.lolweb.model.Account;
import com.standard.lolweb.model.ChampionMastery;
import com.standard.lolweb.model.Summoner;
import com.standard.lolweb.model.SummonerInfoDTO;
import com.standard.lolweb.util.ApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleService {


    @Autowired
    SampleRepo sampleRepo;

    @Autowired
    ApiUtil apiUtil; // api들 요청하는 부분은 여기 모아둠.
                     // 현재 있는 것. acoount, summoner, mastery


    public String getSampleTemplateList(String userName){

        return userName;
    }

    public List<ChampionMastery> getApiTest(String userName, String tagLine) {
        Account myEncryptedPUUID = apiUtil.getAccount(userName, tagLine); // PuuId 받아와서
        Summoner mySummonerInfo = apiUtil.getSummoner(myEncryptedPUUID.getPuuid()); // 소환사 정보를 얻은 다음,
        List<ChampionMastery> myChampionMasteryInfo = apiUtil.getChampionMastery(myEncryptedPUUID.getPuuid()); // 숙련도를 가져옴.

        System.out.println(myEncryptedPUUID);//디버그용
        return myChampionMasteryInfo;
    }

    public SummonerInfoDTO getSummonerInfo(String gameName, String tagLine) {
        var account = apiUtil.getAccount(gameName, tagLine);
        var summoner = apiUtil.getSummoner(account.getPuuid());
        var championMasteries = apiUtil.getChampionMastery(account.getPuuid(), 3);
        var leagueEntries = apiUtil.getLeagueEntryDTOSet(summoner.getId());

        return new SummonerInfoDTO(account, summoner, championMasteries, leagueEntries);
    }
}
