package com.standard.lolweb.util;

import com.standard.lolweb.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
public class ApiUtil {
    @Autowired
    WebClient webClient;
    @Value("${global.api.key}") // 내 api키 (하루마다 업뎃해야함ㅠㅠ)
    String apiKey;

    public Mono<Account> getAccount(String userName, String tagLine){
        Mono<Account> result = webClient.get()
                .uri("https://asia.api.riotgames.com/riot/account/v1/accounts/by-riot-id/"+userName+"/"+tagLine+"?api_key="+apiKey)
                .retrieve()
                .bodyToMono(Account.class);

        return result;
    }

    public Mono<String> getSummoner(String myEncryptedPUUID){
        Mono<String> result = webClient.get()
                .uri("https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-puuid/"+myEncryptedPUUID+"?api_key="+apiKey)
                .retrieve()
                .bodyToMono(String.class);

        return result;
    }
}
