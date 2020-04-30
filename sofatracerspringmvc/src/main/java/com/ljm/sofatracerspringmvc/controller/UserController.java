package com.ljm.sofatracerspringmvc.controller;

import com.ljm.sofatracerspringmvc.pojo.User;
import com.ljm.sofatracerspringmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class UserController {
    private  final AtomicLong counter =new AtomicLong();
    @Autowired
    private UserService userService;
    @GetMapping("/findByUsername/{name}")
    public Map<String,Object> findByName(@PathVariable(value = "name",required = false)String name) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", counter.incrementAndGet());
        if (name != null &&! name.isEmpty()) {
            User user = userService.findUserByName(name);
            if (user != null) {
                map.put("user", user);
            }
        }
        return  map;
    }
}
