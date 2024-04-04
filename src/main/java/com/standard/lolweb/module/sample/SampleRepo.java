package com.standard.lolweb.module.sample;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SampleRepo {

    String getSampleTemplateList(@Param("userName") String userName);

}
