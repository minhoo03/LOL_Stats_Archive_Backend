package com.standard.lolweb.module.sample;

import com.standard.lolweb.model.ChampionMastery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @GetMapping("/api/guide/sampleTemplate")
    public String getSampleTemplateList(@RequestParam("userName") String userName){
        return sampleService.getSampleTemplateList(userName);
    }

    @GetMapping("/api/guide/apiTest")//getMapping 해당 주소로 get요청이 들어올때, 돌아감
    public List<ChampionMastery> getApiTest(@RequestParam("userName") String userName, //RequestParam("받을 rep 이름") 자료형 이름
                                            @RequestParam("tagLine") String tagLine){

        return sampleService.getApiTest(userName, tagLine);//비즈니스 로직에서 받아온걸 넘겨줌. 여기선 userName, tagLine을 넘김

    }
}
