package com.standard.common.module.user;

import com.standard.common.model.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserRepo {
    User getUser(String userId);

    User getUserTest();
}
