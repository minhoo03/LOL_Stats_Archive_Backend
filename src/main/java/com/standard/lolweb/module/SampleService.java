package com.standard.lolweb.module;

import com.standard.lolweb.model.Account;
import com.standard.lolweb.util.ApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SampleService {


    @Autowired
    SampleRepo sampleRepo;

    @Autowired
    ApiUtil apiUtil;


    public String getSampleTemplateList(String userName){

        return userName;
    }

    public Mono<Account> getApiTest(String userName, String tagLine) {
        Mono<Account> myEncryptedPUUID = apiUtil.getAccount(userName, tagLine);
        System.out.println();
        return myEncryptedPUUID;
    }
}
