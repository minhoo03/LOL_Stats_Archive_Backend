package com.standard.lolweb.module;

import com.standard.lolweb.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @GetMapping("/api/guide/sampleTemplate")
    public String getSampleTemplateList(@RequestParam("userName") String userName){
        return sampleService.getSampleTemplateList(userName);
    }

    @GetMapping("/api/guide/apiTest")
    public Mono<Account> getApiTest(@RequestParam("userName") String userName,
                                    @RequestParam("tagLine") String tagLine){
        return sampleService.getApiTest(userName, tagLine);

    }
}
