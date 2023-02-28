package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    private final UserService userService;
    @Autowired //so constructor will work
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<Users> getUsers(){
        return userService.getUsers();
    }
    @PostMapping
    public void registerNewUser(@RequestBody Users u){ //@RequestBody: get from post's body
        userService.addNewUser(u);
    }

    @DeleteMapping(path = "{uid}")
    public void deleteUser(@PathVariable("uid") Long uid){
        userService.deleteUser(uid);
    }

    @PutMapping(path = "{uid}")
    public void updateUserCoin(
            @PathVariable("uid") Long uid,
            @RequestParam(required = false) Integer coin){
        userService.updateCoinByID(uid, coin);
    }
}
