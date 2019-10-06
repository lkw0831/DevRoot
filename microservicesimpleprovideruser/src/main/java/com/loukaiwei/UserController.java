package com.loukaiwei;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController("用户控制")
@RequestMapping(path = "/level1/level2/level3")
public class UserController {

    @Qualifier("仓库")
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
//        User user = this.userRepository.getOne(id);
        Optional<User> user = this.userRepository.findById(id);
        return user.get();
    }

    @PostMapping("/postAction")
    public User Post(@RequestBody User user) {
        System.out.println("Post doing something");
        return user;
    }
}
