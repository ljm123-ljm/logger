package com.ljm.sofatracerspringmvc.service.impl;

import com.ljm.sofatracerspringmvc.pojo.User;
import com.ljm.sofatracerspringmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public User findUserByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        User user = mongoTemplate.findOne(query, User.class);
        if(user!=null){
            return user;
        }
        return null;
    }
}
