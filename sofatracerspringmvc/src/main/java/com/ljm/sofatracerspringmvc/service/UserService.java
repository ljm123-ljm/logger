package com.ljm.sofatracerspringmvc.service;

import com.ljm.sofatracerspringmvc.pojo.User;

public interface UserService {
    /**
     * @param name name
     * @return user
     */
    public User findUserByName(String name);
}
