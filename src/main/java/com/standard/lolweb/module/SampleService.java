package com.standard.lolweb.module;

import com.standard.lolweb.config.WebClientConfig;
import com.standard.lolweb.model.Sample;
import com.standard.lolweb.util.ApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.http.HttpClient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SampleService {


    @Autowired
    SampleRepo sampleRepo;

    @Autowired
    ApiUtil apiUtil;


    public String getSampleTemplateList(String userName){

        return userName;
    }

    public Mono<String> getApiTest(String userName, String tagLine) {
        return apiUtil.getSummoner(userName, tagLine);
    }
}
