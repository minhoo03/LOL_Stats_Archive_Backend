package com.standard.lolweb.module;

import com.standard.lolweb.model.Sample;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @GetMapping("/api/guide/sampleTemplate")
    public String getSampleTemplateList(@RequestParam("userName") String userName){
        return sampleService.getSampleTemplateList(userName);
    }

    @GetMapping("/api/guide/apiTest")
    public Mono<String> getApiTest(@RequestParam("userName") String userName){

        return sampleService.getApiTest(userName);

    }
}
