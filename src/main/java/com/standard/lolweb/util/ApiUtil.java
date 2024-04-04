package com.standard.lolweb.util;

import com.standard.lolweb.model.Account;
import com.standard.lolweb.model.ChampionMastery;
import com.standard.lolweb.model.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Configuration
public class ApiUtil {
    //api는 여기서 관리할 것 같습니다.
    @Autowired
    WebClient webClient;

    // 내 api키 (하루마다 업뎃해야함ㅠㅠ) + 개발 할 때는 본인 api키를 써도 무관함.
    // 전역으로 등록해서 쓰려면 application.yml에서 global.api.key 찾아서 등록!
    @Value("${global.api.key}")
    String apiKey;


    /**
     *
     * @param userName
     * @param tagLine
     * @return
     */
    public Account getAccount(String userName, String tagLine){
        Account result = webClient.get()
                .uri("https://asia.api.riotgames.com/riot/account/v1/accounts/by-riot-id/"+userName+"/"+tagLine+"?api_key="+apiKey)
                .retrieve()
                .bodyToMono(Account.class)
                .block();

        return result;
    }

    /**
     *
     * @param myEncryptedPUUID
     * @return
     */
    public Summoner getSummoner(String myEncryptedPUUID){
        Summoner result = webClient.get()
                .uri("https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-puuid/"+myEncryptedPUUID+"?api_key="+apiKey)
                .retrieve()
                .bodyToMono(Summoner.class)
                .block();

        return result;
    }

    /**
     *
     * @param myEncryptedPUUID
     * @return
     */
    public List<ChampionMastery> getChampionMastery(String myEncryptedPUUID){
        List<ChampionMastery> result = webClient.get()
                .uri("https://kr.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-puuid/"+myEncryptedPUUID+"/top?api_key="+apiKey)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<ChampionMastery>>() {})//List로 받을때
                .block();

        return result;
    }
}
