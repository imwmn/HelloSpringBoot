package com.wmn.HelloSpringBoot.controller;


import com.wmn.HelloSpringBoot.Repository.UserRepository;
import com.wmn.HelloSpringBoot.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserRepository userRepository;

  @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @PostMapping("/person/save")
    public User svae(@RequestParam String name){
          User  user = new User();

          user.setName(name);

          if(userRepository.save(user)){
              System.out.printf("用户保存成功: %s\n",user.toString());

          }
          return  user;
    }
}
